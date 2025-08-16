package com.Vlad_ko.Simulation.Entity.Item.Edible;

import com.Vlad_ko.Simulation.Behavior.Eatable;
import com.Vlad_ko.Simulation.Entity.Creature.Creature;
import com.Vlad_ko.Simulation.Entity.Item.Item;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public abstract class EdibleItem extends Item implements Eatable {
    public EdibleItem(Coordinates position, String sprite, int healthPointGeneration) {
        super(position, sprite);
    }
    protected abstract int getHealthPointFood();

    @Override
    public void beEaten(GameMap gameMap, Creature eater){
        gameMap.removeEntity(position);
        eater.healingCreature(getHealthPointFood());
    }
}
