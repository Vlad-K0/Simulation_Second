package com.Vlad_ko.Simulation.Core;

import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMap {
    public HashMap<Coordinates, Entity> entityMap = new HashMap<>();
    private List<Entity> entities;
    private final int width;
    private final int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Entity> getEntities() {
        return List.copyOf(entities);
    }

    public void setEntitiesInList(List<Entity> entities) {
        this.entities = new ArrayList<>(entities);
    }

    public void placeEntity(Coordinates coordinates, Entity entity) {
        entityMap.put(coordinates, entity);
        if (entities != null) {
            entities.add(entity);
        }
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(entityMap.get(coordinates));
        entityMap.remove(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entityMap.containsKey(coordinates);
    }

    public Entity getEntityAtCell(Coordinates coordinates) {
        return entityMap.get(coordinates);
    }

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
