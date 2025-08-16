package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Action.ActionInitializeSimulation;
import com.Vlad_ko.Simulation.Action.ActionLoadDefaultSettings;
import com.Vlad_ko.Simulation.Core.Simulation;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.YesNoValidator;

public class InitializeSimulationState implements SimulationState {
    private final InputHandler scanner;

    public InitializeSimulationState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        if (context.getSettings().isEmpty()) {
            boolean choice = scanner.validateUserInput(new YesNoValidator(), ConsoleMessage.WARING_START_DEFAULT_SETTINGS);
            if (choice) {
                ActionLoadDefaultSettings loader = new ActionLoadDefaultSettings(context.getSettings());
                loader.execute();
                context.setState(new InitializeSimulationState(scanner));
            } else {
                context.setState(new SettingsState(scanner));
            }
        } else {
            if (context.getSettings().getSimulation() == null) {
                ActionInitializeSimulation createSimulation = new ActionInitializeSimulation(context.getSettings());
                createSimulation.execute();
            }
            context.setState(new SimulationModeSelectionState(scanner));
        }
    }
}
