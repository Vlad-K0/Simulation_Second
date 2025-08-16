package com.Vlad_ko.Simulation.Utils;

import com.Vlad_ko.Simulation.Behavior.Eatable;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Creature.Creature;
import com.Vlad_ko.Simulation.Entity.Creature.Herbivore;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Entity.Item.Edible.EdibleItem;
import com.Vlad_ko.Simulation.Entity.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class EntityService {

    private SimulationSettings settings;
    private List<Entity> entities;

    public EntityService() {
    }

    public List<Creature> getCreatures(SimulationSettings settings) {
        List<Creature> creatures = new ArrayList<>();
        entities = settings.getMap().getEntities();
        for (Entity entity : entities) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }
        return creatures;
    }

    public boolean isTheFoodOut(SimulationSettings settings) {
        return !(isAnyEdibleItem(settings) && isAnyLivingHerbivore(settings));
    }

    public boolean isAnyLivingHerbivore(SimulationSettings settings) {
        entities = settings.getMap().getEntities();
        for (Creature creature : getCreatures(settings)) {
            if (creature instanceof Herbivore) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnyEdibleItem(SimulationSettings settings) {
        entities = settings.getMap().getEntities();
        for (Entity entity : entities) {
            if (entity instanceof EdibleItem) {
                return true;
            }
        }
        return false;
    }
}
