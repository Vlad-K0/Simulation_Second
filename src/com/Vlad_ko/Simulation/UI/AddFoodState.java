package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Action.ActionAddEdibleItem;
import com.Vlad_ko.Simulation.Action.ActionAddHerbivore;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.PositiveIntegerValidator;
import com.Vlad_ko.Simulation.Utils.Validation.YesNoValidator;

public class AddFoodState implements SimulationState {
    private final InputHandler scanner;

    public AddFoodState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        int choice = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.WARING_END_FOOD_MENU);
        switch (choice){
            case 1 -> {
                int howMany = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.HOW_MANY);
                ActionAddHerbivore addHerbivore = new ActionAddHerbivore(howMany, context.getSettings());
                addHerbivore.execute();
                context.setState(new SimulationModeSelectionState(scanner));
            }
            case 2 -> {
                int howMany = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.HOW_MANY);
                ActionAddEdibleItem addEdibleItem = new ActionAddEdibleItem(howMany, context.getSettings());
                addEdibleItem.execute();
                context.setState(new SimulationModeSelectionState(scanner));
            }
            case 3 -> context.setState(new StartMenuState(scanner));
            default -> System.out.println(ConsoleMessage.WARING_WRONG_INPUT.getMessage());
        }

    }
}
