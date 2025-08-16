package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Action.ActionPlace.ActionPlaceEntities;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.PositiveIntegerValidator;

import java.util.Scanner;

public class SettingsMaxEntityState implements SimulationState {
    private final InputHandler scanner;

    public SettingsMaxEntityState(InputHandler scanner) {
        this.scanner = scanner;
    }


    @Override
    public void handle(SimulationContext context) {
        System.out.println(ConsoleMessage.SETTINGS_MAX_ENTITY.getMessage());
        SimulationSettings settings = context.getSettings();

        //set edible item
        int maxCountEdibleItem = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTING_MAX_EATABLE_ITEM);
        settings.setMaxEdibleItems(maxCountEdibleItem);
        //set obstacle
        int maxCountObstacle = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTING_MAX_OBSTACLE);
        settings.setMaxObstacles(maxCountObstacle);
        //set herbivore
        int maxCountHerbivore = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTING_MAX_HERBIVORE);
        settings.setMaxHerbivores(maxCountHerbivore);
        //set predator
        int maxCountPredator = scanner.validateUserInput(new PositiveIntegerValidator(), ConsoleMessage.SETTING_MAX_PREDATOR);
        settings.setMaxPredators(maxCountPredator);

        context.setState(new SettingsState(scanner));
    }
}
