# encoding: utf-8

require_relative 'SpaceCity'

module Deepspace
  class TrickySpaceCity < SpaceCity
    def protection
        p = super
        perder = rand(collaborators.size+1)
        
        for i in 1..perder do
          collaborators.delete_at(rand(collaborators.size))    
        end

        return p 
    end
  end
end