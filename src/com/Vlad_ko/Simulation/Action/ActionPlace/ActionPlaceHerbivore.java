package com.Vlad_ko.Simulation.Action.ActionPlace;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Creature.Herbivore;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class ActionPlaceHerbivore extends ActionPlaceEntity{
    @Override
    protected Entity createEntity(Coordinates coordinates) {
        return new Herbivore(coordinates);
    }

    public ActionPlaceHerbivore(SimulationSettings settings){
        super(settings);
    }
}
