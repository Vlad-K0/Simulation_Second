package com.Vlad_ko.Simulation.Entity.Item.Edible;

import com.Vlad_ko.Simulation.Utils.Coordinates;

public class Tomato extends EdibleItem {
    private static final String ANSI_TOMATO_ITEM = "\uD83C\uDF45";
    private static final int TOMATO_HEALTH_GENERATION = 10;

    public Tomato(Coordinates position) {
        super(position, ANSI_TOMATO_ITEM, TOMATO_HEALTH_GENERATION);
    }

    @Override
    protected int getHealthPointFood() {
        return TOMATO_HEALTH_GENERATION;
    }
}
