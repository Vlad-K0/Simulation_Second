package com.Vlad_ko.Simulation.Entity.Item;

import com.Vlad_ko.Simulation.Utils.Coordinates;

import java.util.Random;

public class Obstacle extends Item {
    private static final String[] ANSI_OBSTACLE_ITEM = new String[]{"\uD83E\uDEA8", "\uD83C\uDF33"};

    private static final Random random = new Random();

    public Obstacle(Coordinates position) {
        super(position, ANSI_OBSTACLE_ITEM[random.nextInt(2)]);
    }
}
