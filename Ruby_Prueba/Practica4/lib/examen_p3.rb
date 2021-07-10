# encoding: utf-8
require_relative 'NumericDamage'
require_relative 'SpecificDamage'
require_relative 'WeaponType'
require_relative 'Weapon'
require_relative 'ShieldBooster'

module P3
  class ExamenP3
    @@contador=0


    def principal
      @@contador = @@contador + 1
      danio1 = Deepspace::NumericDamage.new(2,3)
      danio2 = Deepspace::SpecificDamage.new([Deepspace::WeaponType::LASER, Deepspace::WeaponType::LASER, Deepspace::WeaponType::PLASMA], nil)
      
      danioajustado1 = danio1.adjust([Deepspace::Weapon.new("nombre1", Deepspace::WeaponType::PLASMA, 2), Deepspace::Weapon.new("nombre2", Deepspace::WeaponType::PLASMA, 3), Deepspace::Weapon.new("nombre3", Deepspace::WeaponType::LASER, 4), Deepspace::Weapon.new("nombre4", Deepspace::WeaponType::LASER, 5), Deepspace::Weapon.new("nombre5", Deepspace::WeaponType::LASER, 6)],[Deepspace::ShieldBooster.new("nombre11", 2,3), Deepspace::ShieldBooster.new("nombre22", 3,4)])
      danioajustado2 = danio2.adjust([Deepspace::Weapon.new("nombre6", Deepspace::WeaponType::PLASMA, 2), Deepspace::Weapon.new("nombre7", Deepspace::WeaponType::PLASMA, 2), Deepspace::Weapon.new("nombre8", Deepspace::WeaponType::LASER, 2), Deepspace::Weapon.new("nombre9", Deepspace::WeaponType::LASER, 2), Deepspace::Weapon.new("nombre10", Deepspace::WeaponType::MISSILE, 2), Deepspace::Weapon.new("nombre11", Deepspace::WeaponType::MISSILE, 2)],nil)     
      
      puts danioajustado1.to_s
      puts danioajustado2.to_s
    end

    def self.contador
      @@contador
    end
  end
end
puts P3::ExamenP3.contador

P3::ExamenP3.new.principal

puts P3::ExamenP3.contador
P3::ExamenP3.new.principal
puts P3::ExamenP3.contador
