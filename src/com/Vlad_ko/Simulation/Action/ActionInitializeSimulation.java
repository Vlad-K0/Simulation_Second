package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.Simulation;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class ActionInitializeSimulation implements Action {

    private final SimulationSettings settings;

    public ActionInitializeSimulation(SimulationSettings settings) {
        this.settings = settings;
    }

    @Override
    public void execute() {
        settings.setSimulation(new Simulation(settings));
        Simulation simulation = settings.getSimulation();

        if (settings.getMap() == null) {
            simulation.addInitActions(new ActionGenerateMap(settings));
        }

        simulation.addTurnActions(new ActionCheckResourcesAvailable(settings),
                new ActionMoveCreatures(settings), new ActionCreatureAttackOrEat(settings),
                new ActionRenderMap(settings), new ActionSleepSimulation());

        simulation.initialize();
    }
}
