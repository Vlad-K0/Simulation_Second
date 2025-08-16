package com.Vlad_ko.Simulation.Utils;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class Random {
    public static Coordinates getRandomEmptyCell(SimulationSettings settings) {
        GameMap map = settings.getMap();
        java.util.Random random = new java.util.Random();
        Coordinates coordinates;
        do {
            coordinates = new Coordinates(random.nextInt(settings.getWidthMap()) + 1, random.nextInt(settings.getHeightMap()) + 1);
        } while (!map.isCellEmpty(coordinates));
        return coordinates;
    }
}
