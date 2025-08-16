package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class ActionMoveEntity implements Action {
    private final SimulationSettings settings;
    private final Entity current;
    private final Coordinates target;

    public ActionMoveEntity(SimulationSettings settings, Entity current, Coordinates target) {
        this.settings = settings;
        this.current = current;
        this.target = target;
    }

    private void moveEntity(Entity current, Coordinates target) {
        GameMap map = settings.getMap();
        Entity currentEntity = map.getEntityAtCell(current.getPosition());
        map.removeEntity(current.getPosition());
        map.placeEntity(target, currentEntity);
        current.setPosition(target);
    }

    @Override
    public void execute() {
        moveEntity(current, target);
    }
}
