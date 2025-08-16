package com.Vlad_ko.Simulation.Action.ActionPlace;

import com.Vlad_ko.Simulation.Action.Action;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ActionPlaceEntities implements Action {
    private final GameMap map;
    private final List<Entity> entities = new ArrayList<>();
    private final Random random = new Random();
    private final SimulationSettings settings;

    public ActionPlaceEntities(SimulationSettings settings) {
        this.map = settings.getMap();
        this.settings = settings;
    }

    private void placeEntities() {
        placeEntities(new ActionPlaceEdibleItem(settings), settings.getMaxEdibleItems());
        placeEntities(new ActionPlaceHerbivore(settings), settings.getMaxHerbivores());
        placeEntities(new ActionPlacePredator(settings), settings.getMaxPredators());
        placeEntities(new ActionPlaceObstacle(settings), settings.getMaxObstacles());
    }

    private void placeEntities(ActionPlaceEntity<? extends Entity> action, int maxCount) {
        boolean atLeastOnePlaced = false;

        for (int i = 0; i < maxCount; i++) {
            if (random.nextBoolean()) {
                action.execute();
                entities.add(action.getLastPlacedEntity());
                atLeastOnePlaced = true;
            }
        }

        if (!atLeastOnePlaced && maxCount > 0) {
            action.execute();
            entities.add(action.getLastPlacedEntity());
        }

        map.setEntitiesInList(getEntities());
    }

    private List<Entity> getEntities() {
        return entities;
    }

    @Override
    public void execute() {
        placeEntities();
    }
}
