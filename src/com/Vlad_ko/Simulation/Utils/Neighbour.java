package com.Vlad_ko.Simulation.Utils;

import com.Vlad_ko.Simulation.Core.SimulationSettings;

import java.util.ArrayList;

public class Neighbour {
    public static ArrayList<Coordinates> getNeighbourCell(Coordinates coordinates, SimulationSettings settings) {
        ArrayList<Coordinates> neighbours = new ArrayList<>();
        int x = coordinates.getX();
        int y = coordinates.getY();

        if (x + 1 <= settings.getWidthMap()) neighbours.add(new Coordinates(x + 1, y));
        if (y + 1 <= settings.getHeightMap()) neighbours.add(new Coordinates(x, y + 1));
        if (x - 1 >= 0) neighbours.add(new Coordinates(x - 1, y));
        if (y - 1 >= 0) neighbours.add(new Coordinates(x, y - 1));

        return neighbours;
    }

}
