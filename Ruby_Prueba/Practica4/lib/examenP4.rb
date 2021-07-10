require_relative 'FaultySpecificDamage'
require_relative 'WeaponType'
module Deepspace
  class Examen
    def initialize
      faultydam = FaultySpecificDamage.new([WeaponType::ROCA, WeaponType::ASTEROIDE, WeaponType::ACIDO, WeaponType::ROCA], 10)
      puts faultydam.to_s
      arma1 = Weapon.new("Nombre1", WeaponType::ACIDO, 5)
      arma2 = Weapon.new("Nombre2", WeaponType::ROCA, 6)
      arma3 = Weapon.new("Nombre3", WeaponType::ACIDO, 7)
      faultydam = faultydam.adjust([arma1, arma2, arma3], nil)
      puts faultydam.to_s
    end
  end

  Examen.new
end