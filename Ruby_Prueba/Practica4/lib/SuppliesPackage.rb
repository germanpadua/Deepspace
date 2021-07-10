# encoding: utf-8

require_relative 'Dice'
module Deepspace

class SuppliesPackage

  def initialize(amP, flUn, shP)
    @ammoPower   = amP
    @fuelUnits   = flUn
    @shieldPower = shP
    dice = Dice.new

    if dice.receiveComodin
      @comodin = true
    else
      @comodin = false
    end
    
  end

  def self.newCopy(s)
    new(s.ammoPower,s.fuelUnits,s.shieldPower)
  end

  def ammoPower
    return @ammoPower
  end

  def fuelUnits
    return @fuelUnits
  end
  
  def shieldPower
    return @shieldPower
  end

  def comodin
    return @comodin
  end

  def to_s
    out = "AmmoPower: " + ammoPower().to_s + "\nFuelUnits: " + fuelUnits().to_s + "\nShieldPower: " + shieldPower().to_s 

  end

end #class

end #module