require_relative 'TrickySpaceCity'
require_relative 'SpaceStation'
require_relative 'Hangar'
require_relative 'Weapon'
require_relative 'WeaponType'

module Deepspace
  class Examen
    def initialize
        dealer = CardDealer.instance
        supplies1 = dealer.nextSuppliesPackage
        supplies2 = dealer.nextSuppliesPackage
        supplies3 = dealer.nextSuppliesPackage
        station1 = SpaceStation.new("Nombre", supplies1)
        station2 = SpaceStation.new("Nombre2", supplies2)
        station3 = SpaceStation.new("Nombre3", supplies3)

        hangar1 = Hangar.new(5)
        hangar2 = Hangar.new(5)
        hangar3 = Hangar.new(5)

        hangar1.addWeapon(Weapon.new("nombre", WeaponType::LASER, 10))
        hangar2.addWeapon(Weapon.new("nombre", WeaponType::LASER, 10))
        hangar3.addWeapon(Weapon.new("nombre", WeaponType::LASER, 10))
        hangar1.addWeapon(Weapon.new("nombre2", WeaponType::PLASMA, 10))
        hangar2.addWeapon(Weapon.new("nombre2", WeaponType::PLASMA, 10))
        hangar3.addWeapon(Weapon.new("nombre2", WeaponType::PLASMA, 10))

        station1.receiveHangar(hangar1)
        station2.receiveHangar(hangar2)
        station3.receiveHangar(hangar3)

        station1.mountWeapon(0)
        station1.mountWeapon(0)
        station2.mountWeapon(0)
        station2.mountWeapon(0)
        station3.mountWeapon(0)
        station3.mountWeapon(0)
        ciudad = TrickySpaceCity.new(station1, [station2, station3])
        puts ciudad.collaborators[0].inspect
        puts ciudad.collaborators[1].inspect
        puts ciudad.protection
        puts ciudad.collaborators[0].inspect
        puts ciudad.collaborators[1].inspect
    end
  end

  Examen.new
end
