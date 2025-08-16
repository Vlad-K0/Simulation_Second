package com.Vlad_ko.Simulation.Action.ActionPlace;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Entity.Item.Obstacle;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class ActionPlaceObstacle extends ActionPlaceEntity {
    @Override
    protected Entity createEntity(Coordinates coordinates) {
        return new Obstacle(coordinates);
    }

    public ActionPlaceObstacle(SimulationSettings settings){
        super(settings);
    }

}
