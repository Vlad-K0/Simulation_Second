package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.PositiveIntegerValidator;

import java.util.Scanner;

public class SettingsState implements SimulationState{
    private final InputHandler scanner;

    public SettingsState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        int choice = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTINGS_MENU);
        switch (choice){
            case 1 -> context.setState(new SettingsMapState(scanner));
            case 2 -> context.setState(new SettingsMaxEntityState(scanner));
            case 3 -> context.setState(new StartMenuState(scanner));
            default -> System.out.println(ConsoleMessage.WARING_WRONG_INPUT.getMessage());
        }
    }
}
