package com.Vlad_ko.Simulation.Entity.Item.Edible;

import com.Vlad_ko.Simulation.Utils.Coordinates;

public class CornCob extends EdibleItem {
    private static final String ANSI_RICE_EARS_ITEM = "\uD83C\uDF3D";
    private static final int CORN_COB_HEALTH_GENERATION = 15;

    public CornCob(Coordinates position) {
        super(position, ANSI_RICE_EARS_ITEM, CORN_COB_HEALTH_GENERATION);
    }

    @Override
    protected int getHealthPointFood() {
        return CORN_COB_HEALTH_GENERATION;
    }
}
