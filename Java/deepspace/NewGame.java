/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author germanpadua
 */
public class NewGame {
    private ArrayList<SpaceFighter> spaceFighters;
    private Dice dice;
    
    
    public NewGame(){
        spaceFighters = new ArrayList<>();
        dice = new Dice();
    }
    public void addSpaceFighter(String name){
        SpaceFighter sp;
        CardDealer dealer = CardDealer.getInstance();
        if(dice.isSpaceStation()){
            SuppliesPackage supplies = dealer.nextSuppliesPackage();
            sp = new SpaceStation(name, supplies);
            spaceFighters.add(sp);
           
        }else
            spaceFighters.add(dealer.nextEnemy());
    }
    
    public int stationsSize(){
        return spaceFighters.size();
    }
    
    public ArrayList<SpaceFighter> getArray(){
        return spaceFighters;
    }
    
    public void deleteSpaceFighter(int i){
        if(i>= 0 && i< spaceFighters.size())
            spaceFighters.remove(i);
    }
}
