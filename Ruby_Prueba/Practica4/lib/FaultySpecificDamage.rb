# encoding: utf-8

require_relative 'SpecificDamage'
require_relative 'Dice'

module Deepspace
  class FaultySpecificDamage < SpecificDamage
    def initialize(wl,s)
      super
      @dice = Dice.new()
    end

    def adjust(w,s)
      if @dice.faults
        return super([@dice.type], 0)
      end
      return super(w,s)

    end
  end
end