package deepspace;

public class SuppliesPackage {
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    SuppliesPackage(float ammoPower, float fuelUnits, float shieldPower){
        this.ammoPower = ammoPower;
        this.fuelUnits = fuelUnits;
        this.shieldPower = shieldPower;
    }

    SuppliesPackage(SuppliesPackage s){
        this (s.ammoPower,s.fuelUnits,s.shieldPower);
    }

    public float getAmmoPower(){ 
        return ammoPower;
    }
        

    public float getFuelUnits(){
        return fuelUnits;
    }

    public float getShieldPower(){
        return shieldPower;
    }
    
    public String toString() {
        String cadena = "AmmoPower: " + getAmmoPower() + "\nFuelUnits: " + getFuelUnits() +
        "\nShieldPower: " + getShieldPower();

        return cadena;
    }
}