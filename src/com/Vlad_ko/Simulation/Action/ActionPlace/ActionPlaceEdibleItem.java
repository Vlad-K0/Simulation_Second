package com.Vlad_ko.Simulation.Action.ActionPlace;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Entity.Item.Edible.EdibleItemFactory;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class ActionPlaceEdibleItem extends ActionPlaceEntity {

    @Override
    protected Entity createEntity(Coordinates coordinates) {
        return EdibleItemFactory.createRandomEdibleItem(coordinates);
    }

    public ActionPlaceEdibleItem(SimulationSettings settings) {
        super(settings);
    }
}
