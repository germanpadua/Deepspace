require_relative 'Hangar'
module Padua
  class German
    def self.principal
      puts German.newEdad(20).inspect
      puts German.new("Hola", 10).inspect
      hangar1 = Hangar.new(4)
      hangar2 = Hangar.new(5)
      hangar3 = Hangar.new(6)
    end

    def initialize(n, e)
        @nombre = n
        @edad = e

    end

    def self.newEdad(e)
      new("anonimo", e)
    end
  end
  German.principal
end
