package com.Vlad_ko.Simulation.Utils;

import com.Vlad_ko.Simulation.Behavior.Eatable;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

import java.util.*;
import java.util.Map;

public class Pathfinding {

    public <T extends Eatable> List<Coordinates> BFS(SimulationSettings settings, Coordinates start, Class<T> targetType) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Map<Coordinates, Coordinates> cameFrom = new HashMap<>();
        GameMap map = settings.getMap();

        queue.add(start);
        visited.add(start);
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            Coordinates point = queue.poll();

            for (Coordinates neighbor : Neighbour.getNeighbourCell(point, settings)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                if (!map.isCellEmpty(neighbor) && targetType.isInstance(map.getEntityAtCell(neighbor))) {
                    cameFrom.put(neighbor, point);
                    return reconstructPath(cameFrom, start, neighbor);
                }
                if (map.isCellEmpty(neighbor)) {
                    visited.add(neighbor);
                    cameFrom.put(neighbor, point);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Coordinates> reconstructPath(Map<Coordinates, Coordinates> cameFrom, Coordinates start, Coordinates end) {
        List<Coordinates> path = new ArrayList<>();

        Coordinates at = end;
        while (at != null && !at.equals(start)) {
            path.add(at);
            at = cameFrom.get(at);
        }
        return path;
    }
}

