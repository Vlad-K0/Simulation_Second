package com.Vlad_ko.Simulation.Entity.Item.Edible;

import com.Vlad_ko.Simulation.Utils.Coordinates;

public class RiceEars extends EdibleItem {
    private static final String ANSI_RICE_EARS_ITEM = "\uD83C\uDF3E";
    private static final int RICE_EARS_HEALTH_GENERATION = 20;

    public RiceEars(Coordinates position) {
        super(position, ANSI_RICE_EARS_ITEM, RICE_EARS_HEALTH_GENERATION);
    }

    @Override
    protected int getHealthPointFood() {
        return RICE_EARS_HEALTH_GENERATION;
    }
}
