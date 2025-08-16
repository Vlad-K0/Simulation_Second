package com.Vlad_ko.Simulation.Entity.Item.Edible;

import com.Vlad_ko.Simulation.Utils.Coordinates;

import java.util.Random;

public class EdibleItemFactory {
    private static final Random RANDOM = new Random();

    public static EdibleItem createEdibleItem(EdibleItemType type, Coordinates coordinates){
        EdibleItem item = null;
        switch (type){
            case TOMATO -> item = new Tomato(coordinates);
            case CORN_COB -> item = new CornCob(coordinates);
            case RICE_EARS -> item = new RiceEars(coordinates);
        }
        return item;
    }
    public static EdibleItem createRandomEdibleItem(Coordinates coordinates) {
        EdibleItemType[] types = EdibleItemType.values();
        EdibleItemType randomType = types[RANDOM.nextInt(types.length)];
        return createEdibleItem(randomType, coordinates);
    }
}
