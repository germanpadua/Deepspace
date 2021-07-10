require_relative 'CardDealer'
require_relative 'SpaceStation'
require_relative 'PowerEfficientSpaceStation'

module Deepspace
  class ExamenP4
      def initialize
          
      end

      def principal
        dealer = CardDealer.instance
        
        supplies = dealer.nextSuppliesPackage

        station = SpaceStation.new("nombre", supplies)
        stations = []
        for i in 0..19
          supplies = dealer.nextSuppliesPackage
          stations.push(SpaceStation.new("nombre", supplies))
        end

        for i in 0..19
          puts stations[i].fire
        end

        stations[1] = PowerEfficientSpaceStation.new(stations[1])

        for i in 0..19
            puts stations[i].fire
          end
      end
  end
  ExamenP4.new.principal
end