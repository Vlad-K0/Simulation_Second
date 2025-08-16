package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.PositiveIntegerValidator;

import java.util.Scanner;

public class StartMenuState implements SimulationState{
    private final InputHandler scanner;

    public StartMenuState(InputHandler scanner){
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        System.out.println(ConsoleMessage.START_MESSAGE.getMessage());

        int choice = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.START_MENU);

        switch (choice){
            case 1 -> context.setState(new GenerateMapState(scanner));
            case 2 -> context.setState(new SettingsState(scanner));
            case 3 -> context.setState(new InitializeSimulationState(scanner));
            case 4 -> context.stop();
            default -> System.out.println(ConsoleMessage.WARING_WRONG_INPUT.getMessage());
        }
    }
}
