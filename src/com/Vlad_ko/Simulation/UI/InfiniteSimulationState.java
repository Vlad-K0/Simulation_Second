package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Core.Simulation;
import com.Vlad_ko.Simulation.Utils.EntityService;
import com.Vlad_ko.Simulation.Utils.InputHandler;

public class InfiniteSimulationState implements SimulationState {
    private final InputHandler scanner;
    private final EntityService entityService = new EntityService();

    public InfiniteSimulationState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        Simulation simulation = context.getSettings().getSimulation();
        simulation.startSimulation();
        if (entityService.isTheFoodOut(context.getSettings())) {
            context.setState(new AddFoodState(scanner));
        } else {
            context.setState(new SimulationModeSelectionState(scanner));
        }
    }
}

