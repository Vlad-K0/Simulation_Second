package com.Vlad_ko.Simulation.Entity.Creature;

import com.Vlad_ko.Simulation.Behavior.Eatable;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class Predator extends Creature {
    private static final String ANSI_HERBIVORE = "\uD83E\uDD81";
    public static final int DAMAGE = 50;
    public static final int SPEED = 1;
    public static final int ATTACK_RANGE = 2;

    public Predator(Coordinates coordinates) {
        super(coordinates, ANSI_HERBIVORE, SPEED, ATTACK_RANGE);
    }

    @Override
    protected Class<? extends Eatable> getTypeFood() {
        return Herbivore.class;
    }

}
