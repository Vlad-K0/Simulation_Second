package com.Vlad_ko.Simulation.Utils;

import com.Vlad_ko.Simulation.UI.ConsoleMessage;
import com.Vlad_ko.Simulation.Utils.Validation.InputValidator;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> T validateUserInput(InputValidator<T> validator, ConsoleMessage message) {
        while (true) {
            System.out.print(message.getMessage());
            String input = scanner.nextLine();

            if (validator.isValid(input)) {
                return validator.parse(input);
            }

            System.out.println(ConsoleMessage.WARING_WRONG_INPUT.getMessage());
        }
    }
}
