package com.Vlad_ko.Simulation.Behavior;

import com.Vlad_ko.Simulation.Entity.Creature.Creature;
import com.Vlad_ko.Simulation.Core.GameMap;

public interface Eatable {
    void beEaten(GameMap gameMap, Creature eater);
}
