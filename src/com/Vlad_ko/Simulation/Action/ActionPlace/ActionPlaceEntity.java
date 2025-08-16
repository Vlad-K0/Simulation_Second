package com.Vlad_ko.Simulation.Action.ActionPlace;

import com.Vlad_ko.Simulation.Action.Action;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;
import com.Vlad_ko.Simulation.Utils.Random;

public abstract class ActionPlaceEntity<T extends Entity> implements Action {
    protected final GameMap map;
    private final SimulationSettings settings;
    protected T lastPlacedEntity;

    protected abstract T createEntity(Coordinates coordinates);

    protected ActionPlaceEntity(SimulationSettings settings) {
        this.map = settings.getMap();
        this.settings = settings;
    }
    @Override
    public void execute(){
        Coordinates coordinates = Random.getRandomEmptyCell(settings);
        lastPlacedEntity = createEntity(coordinates);
        map.placeEntity(coordinates, lastPlacedEntity);
    }

    public T getLastPlacedEntity() {
        return lastPlacedEntity;
    }
}
