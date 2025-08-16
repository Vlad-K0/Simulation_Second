package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Action.ActionGenerateMap;
import com.Vlad_ko.Simulation.Action.ActionLoadDefaultSettings;
import com.Vlad_ko.Simulation.Action.ActionRenderMap;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.YesNoValidator;

public class GenerateMapState implements SimulationState {
    private InputHandler scanner;

    public GenerateMapState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        if (context.getSettings().isEmpty()) {
            boolean choice = scanner.validateUserInput(new YesNoValidator(), ConsoleMessage.WARING_GENERATE_DEFAULT_SETTINGS);
            if (choice) {
                ActionLoadDefaultSettings loader = new ActionLoadDefaultSettings(context.getSettings());
                loader.execute();
                context.setState(new GenerateMapState(scanner));
            } else {
                context.setState(new SettingsState(scanner));
            }
        } else {
            ActionGenerateMap generateMap = new ActionGenerateMap(context.getSettings());
            generateMap.execute();
            ActionRenderMap renderMap = new ActionRenderMap(context.getSettings());
            renderMap.execute();
            context.setState(new RecreateMenuState(scanner));
        }


    }
}
