# encoding: utf-8

module Deepspace

class Dice 
  def initialize
    @NHANGARSPROB  = 0.25
    @NSHIELDSPROB  = 0.25
    @NWEAPONSPROB  = 0.33
    @FIRSTSHOTPROB = 0.5
    @EXTRAEFFICIENCYPROB = 0.8
    @FAULTY = 0.2
    @COMODIN = 0.2
    @TYPEPROB = 0.33
    @generator     = nil 
  end    

  def faults
    @generator = rand

    if @generator <=@FAULTY
      return true
    else
      return false
    end
  end
  
  def type
    @generator = rand

    if @generator <= @TYPEPROB
      return WeaponType::LASER
    else
      return WeaponType::MISSILE
    end
    return WeaponType::PLASMA
  end

  def initWithNHangars
    @generator = rand
    if @generator <= @NHANGARSPROB
        return 0
    else
        return 1
    end
  end

  def initWithNWeapons
    @generator = rand
    prob_caso1 = 1 - 2 * @NWEAPONSPROB
    prob_caso2 = prob_caso1 + ( (1 - prob_caso1) / 2 )

    if @generator <= prob_caso1
      return 3
            
    elsif @generator <= prob_caso2
      return 1
            
    else
      return 2
            
    end
    
  end
    
  def initWithNShields
    @generator = rand

    if @generator <= @NSHIELDSPROB
      return 0
    else
      return 1
    end

  end

  def whoStarts(nPlayers)
    rand(nPlayers)
  end

  def firstShot
    @generator = rand
        
    if @generator <= @FIRSTSHOTPROB
      return GameCharacter::SPACESTATION
    else
      return GameCharacter::ENEMYSTARSHIP
    end
  end

  def receiveComodin
    @generator = rand

    if @generator <= @COMODIN
      return true
    end

    return false
  end
  
  def spaceStationMoves(speed)
    @generator = rand
        
    if @generator <= speed
      return true
    else
      return false
    end

  end

  def to_s
    out = "NHANGARSPROB: " + @NHANGARSPROB.to_s + "\nNSHIELDSPROB: " + @NSHIELDSPROB.to_s + "NWEAPONSPROB: " + @NWEAPONSPROB.to_s + "FIRSTSHOTPROB: " + @FIRSTSHOTPROB.to_s
  
    return out
  end
  
  def extraEfficiency
    @generator = rand

    return (@generator <= @EXTRAEFFICIENCYPROB)
  end
end #class

end #module
