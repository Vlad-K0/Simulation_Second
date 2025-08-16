package com.Vlad_ko.Simulation.Action.ActionPlace;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Creature.Predator;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class ActionPlacePredator extends ActionPlaceEntity{
    @Override
    protected Entity createEntity(Coordinates coordinates) {
        return new Predator(coordinates);
    }

    public ActionPlacePredator(SimulationSettings settings){
        super(settings);
    }
}
