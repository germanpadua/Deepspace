package deepspace;

import java.util.ArrayList;

public class GameUniverse {
    private final int WIN = 10;

    private int turns;
    private int currentStationIndex;
    private Dice dice;
    private SpaceStation currentStation;
    private EnemyStarShip currentEnemy;
    private ArrayList<SpaceStation> spaceStations;
    private GameStateController gameState;
    private boolean haveSpaceCity;


    public GameUniverse(){
        turns = 0;
        dice = new Dice();
        gameState = new GameStateController();
        currentStationIndex = 0;
        haveSpaceCity = false;
    }
    
    public CombatResult combat(){
        GameState state = gameState.getState();

        if(state == GameState.BEFORECOMBAT || state == GameState.INIT){
            return combat(currentStation, currentEnemy); 
        }else{
            return CombatResult.NOCOMBAT;
        }
    
    }

    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        GameState state = gameState.getState();
        GameCharacter ch = this.dice.firstShot();
        Damage damage;
        float fire, s;
        ShotResult result;
        boolean enemyWins = false, moves = false;
        Loot aLoot;
        CombatResult combatResult = CombatResult.NOCOMBAT;
        Transformation transformation;

        if(state == GameState.BEFORECOMBAT || state == GameState.INIT){
            if (ch==GameCharacter.ENEMYSTARSHIP){
                fire = enemy.fire();
                result = station.receiveShot(fire);
    
                if (result == ShotResult.RESIST){
                    fire = station.fire();
                    result = enemy.receiveShot(fire);
    
                    enemyWins = (result == ShotResult.RESIST);
    
                }else{
                    enemyWins = true;
                }
            }else{
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST);
            }
    
            if (enemyWins){
                s = station.getSpeed();
                moves = dice.spaceStationMoves(s);
                
                if (!moves){
                    damage = enemy.getDamage();
                    station.setPendingDamage(damage);
                    combatResult = CombatResult.ENEMYWINS;
                }else{
                    station.move();
                    combatResult = CombatResult.STATIONESCAPES;
                }
            }else{
                aLoot = enemy.getLoot();
                transformation = station.setLoot(aLoot);
                
                if(transformation == Transformation.GETEFFICIENT){
                    combatResult = CombatResult.STATIONWINSANDCONVERTS;
                    makeStationEfficient();
                }else if(transformation == Transformation.NOTRANSFORM){
                    combatResult = CombatResult.STATIONWINS;
                }else{
                    if(!haveSpaceCity)
                        combatResult = CombatResult.STATIONWINSANDCONVERTS;
                    else
                        combatResult = CombatResult.STATIONWINS;
                    createSpaceCity();
                }
            }
    
            this.gameState.next(this.turns, this.spaceStations.size());
        }else{
            combatResult = CombatResult.NOCOMBAT;
        }
        

        return combatResult;
    }

    public void discardHangar(){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.discardHangar();
    }

    public void discardShieldBooster(int i){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }

    public void discardShieldBoosterInHangar(int i){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    public void discardWeapon(int i){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.discardWeapon(i);
    }

    public void discardWeaponInHangar(int i){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    public GameState getState(){
        return gameState.getState();
    }


    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }

    public boolean haveAWinner(){
        if(currentStation.getNMedals() >= WIN)
            return true;
        else
            return false;
    }


    public void init(ArrayList<String> names){
        GameState state = gameState.getState();

        if(state == GameState.CANNOTPLAY){
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i = 0; i < names.size(); i++){
                SuppliesPackage supplies = dealer.nextSuppliesPackage();

                SpaceStation station = new SpaceStation(names.get(i), supplies);

                int nh = dice.initWithNHangar();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();

                Loot lo = new Loot(0, nw, ns, nh, 0);

                station.setLoot(lo);

                if (spaceStations == null)
                    spaceStations = new ArrayList<>();

                spaceStations.add(station);
            }

            currentStationIndex = dice.whoStarts(names.size());
            
            currentStation = spaceStations.get(currentStationIndex);

            currentEnemy = dealer.nextEnemy();

            gameState.next(turns, spaceStations.size());
        }
    }

    public void mountShieldBooster(int i){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.mountShieldBooster(i);
    }

    public void mountWeapon(int i){
        if (getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT)
            currentStation.mountWeapon(i);
    }
    
    public boolean nextTurn(){
        GameState state = gameState.getState();

        if(state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();

            if(stationState){
                currentStationIndex = (currentStationIndex + 1)%spaceStations.size();
                turns ++; 

                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();

                CardDealer dealer = CardDealer.getInstance();

                currentEnemy = dealer.nextEnemy();

                gameState.next(turns, spaceStations.size());

                return true;
            }else{
                return false;
            }

            
        }else
            return false;
    }

    private void createSpaceCity(){
        if(haveSpaceCity == false){
            ArrayList <SpaceStation> collaborators = new ArrayList<>();

            for(int i=0; i<spaceStations.size(); i++){
                if(i != currentStationIndex)
                    collaborators.add(spaceStations.get(i));
            } 
            currentStation = new SpaceCity(currentStation, collaborators);
            haveSpaceCity = true;

            spaceStations.remove(currentStationIndex);
            spaceStations.add(currentStationIndex, currentStation);
        }
    }

    private void makeStationEfficient(){
        if(dice.extraEfficiency()){
            currentStation = new BetaPowerEfficientSpaceStation(currentStation);
        }else{
            currentStation = new PowerEfficientSpaceStation(currentStation);
        }
        
        spaceStations.remove(currentStationIndex);
        spaceStations.add(currentStationIndex, currentStation);
    }

    public String toString(){
        String cadena = "CurrentSpaceStation: ";
        if(currentStation != null)
            cadena += currentStation.toString();
        cadena += "\nCurrentSpaceStationIndex: " + currentStationIndex;
        cadena += "\nTurns: " + turns;
        cadena += "\nCurrentEnemy: ";
        if(currentEnemy != null)
            cadena += currentEnemy.toString();
        cadena += "\nDice: " + dice.toString();
        cadena += "\nGameStateController: " + gameState.toString();
        cadena += "\nArray de SpaceStation: ";

        if (spaceStations != null)
            for (int i = 0; i < spaceStations.size(); i++){
                cadena += ("\nSpaceStation " + (i+1) + ": " + spaceStations.get(i).toString());
            }

        return cadena;
    }

}