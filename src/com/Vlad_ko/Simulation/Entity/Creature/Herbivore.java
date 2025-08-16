package com.Vlad_ko.Simulation.Entity.Creature;

import com.Vlad_ko.Simulation.Behavior.Eatable;
import com.Vlad_ko.Simulation.Entity.Item.Edible.EdibleItem;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class Herbivore extends Creature implements Eatable {
    private static final String ANSI_HERBIVORE = "\uD83D\uDC14";
    private static final int HERBIVORE_HEALTH_GENERATION = 70;
    public static final int SPEED = 1;
    public static final int ATTACK_RANGE = 1;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, ANSI_HERBIVORE, SPEED, ATTACK_RANGE);
    }


    @Override
    protected Class<? extends Eatable> getTypeFood() {
        return EdibleItem.class;
    }


    @Override
    public void beEaten(GameMap gameMap, Creature eater) {
        gameMap.removeEntity(position);
        eater.healingCreature(HERBIVORE_HEALTH_GENERATION);
    }

    public void takeDamage() {
        HP = HP - Predator.DAMAGE;
    }

}
