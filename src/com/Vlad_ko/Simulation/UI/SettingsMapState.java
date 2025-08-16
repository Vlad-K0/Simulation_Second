package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.PositiveIntegerValidator;

public class SettingsMapState implements SimulationState {
    private final InputHandler scanner;

    public SettingsMapState(InputHandler scanner){
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        System.out.println(ConsoleMessage.SETTINGS_MAP_SIZE.getMessage());
        SimulationSettings settings = context.getSettings();

        //set height
        int width = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTINGS_MAP_WIDTH);
        settings.setWidthMap(width);

        //set width
        int height = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTINGS_MAP_HEIGHT);
        settings.setHeightMap(height);

        context.setState(new SettingsState(scanner));
    }
}
