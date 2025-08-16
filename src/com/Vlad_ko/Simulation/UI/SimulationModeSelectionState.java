package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Core.Simulation;
import com.Vlad_ko.Simulation.Utils.EntityService;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.InfiniteOrStepToStepMode;
import com.Vlad_ko.Simulation.Utils.Validation.YesNoValidator;

public class SimulationModeSelectionState implements SimulationState {
    private final InputHandler scanner;

    public SimulationModeSelectionState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        boolean choice = scanner.validateUserInput(new InfiniteOrStepToStepMode(), ConsoleMessage.SIMULATION_MODE_SELECT);
        if (choice) {
            context.setState(new InfiniteSimulationState(scanner));
        } else {
            context.setState(new StepByStepSimulationState(scanner));
        }

    }
}
