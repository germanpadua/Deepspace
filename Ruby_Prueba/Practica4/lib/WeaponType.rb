
module Deepspace

  module WeaponType
    class Type
      attr_reader :power, :text
      def initialize (p,t)
        @power=p
        @text=t
      end
      
      def to_s
        return @text
      end
    end
    
    LASER       =Type.new(2.0,"LASER")
    MISSILE     =Type.new(3.0,"MISSILE")
    PLASMA      =Type.new(4.0,"PLASMA")
    FLECHA      =Type.new(4.1,"FLECHA")
    SAETA       =Type.new(4.2,"SAETA")
    BALA        =Type.new(4.3,"BALA")
    BALIN       =Type.new(4.4,"BALIN")
    PIEDRA      =Type.new(4.5,"PIEDRA")
    ROCA        =Type.new(4.6,"ROCA")
    TIRACHINAS  =Type.new(4.7,"TIRACHINAS")
    GAS         =Type.new(4.8,"GAS")
    ACIDO       =Type.new(4.9,"ACIDO")
    ASTEROIDE   =Type.new(5.0,"ASTEROIDE")
    DARDO       =Type.new(5.1,"DARDO")
    LANZA       =Type.new(5.2,"LANZA")
    ESPADA      =Type.new(5.3,"ESPADA")
    SABLE       =Type.new(5.4,"SABLE")
    ESTOQUE     =Type.new(5.5,"ESTOQUE")
    ALFILER     =Type.new(5.6,"ALFILER")
    AGUJA       =Type.new(5.7,"AGUJA")
    TOCHO       =Type.new(5.8,"TOCHO")
    PERDIGON    =Type.new(5.9,"PERDIGON")
    VIRUS    	=Type.new(6.0,"VIRUS")
    BOMBA       =Type.new(10.0,"BOMBA")
    
  end # module WeaponType
end # module Deepspace

if $0 == __FILE__ then
  puts Deepspace::WeaponType::LASER.to_s + " : " + Deepspace::WeaponType::LASER.power.to_s
  puts Deepspace::WeaponType::MISSILE.to_s + " : " + Deepspace::WeaponType::MISSILE.power.to_s
  puts Deepspace::WeaponType::PLASMA.to_s + " : " + Deepspace::WeaponType::PLASMA.power.to_s
end