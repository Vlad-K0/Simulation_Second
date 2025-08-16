package com.Vlad_ko.Simulation.UI;

import com.Vlad_ko.Simulation.Action.ActionGenerateMap;
import com.Vlad_ko.Simulation.Action.ActionRenderMap;
import com.Vlad_ko.Simulation.Utils.InputHandler;
import com.Vlad_ko.Simulation.Utils.Validation.YesNoValidator;

public class RecreateMenuState implements SimulationState {
    private final InputHandler scanner;

    public RecreateMenuState(InputHandler scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(SimulationContext context) {
        boolean choice = scanner.validateUserInput(new YesNoValidator(), ConsoleMessage.RECREATE_MAP);
        if(choice){
            ActionGenerateMap generateMap = new ActionGenerateMap(context.getSettings());
            generateMap.execute();
            ActionRenderMap renderMap = new ActionRenderMap(context.getSettings());
            renderMap.execute();
            context.setState(new RecreateMenuState(scanner));
        }else {
            context.setState(new StartMenuState(scanner));
        }
    }
}
