package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Creature.Creature;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Utils.EntityService;

import java.util.List;

public class ActionMoveCreatures implements Action{
    private final SimulationSettings settings;

    public ActionMoveCreatures(SimulationSettings settings){
        this.settings = settings;
    }

    @Override
    public void execute() {
        EntityService entityService = new EntityService();
        List<Creature> creatures = entityService.getCreatures(settings);
        for (Creature creature : creatures){
            creature.move(settings);
        }
    }
}
