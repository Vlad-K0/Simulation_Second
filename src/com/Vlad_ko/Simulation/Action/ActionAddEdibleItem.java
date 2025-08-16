package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Action.ActionPlace.ActionPlaceEdibleItem;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Utils.EntityService;

public class ActionAddEdibleItem implements Action {
    private final SimulationSettings settings;
    private final int howManyEdibleItem;

    public ActionAddEdibleItem(int howManyEdibleItem, SimulationSettings settings) {
        this.settings = settings;
        this.howManyEdibleItem = howManyEdibleItem;
    }

    @Override
    public void execute() {
        ActionPlaceEdibleItem placeEdibleItem = new ActionPlaceEdibleItem(settings);
        for (int i = 0; i < howManyEdibleItem; i++) {
            placeEdibleItem.execute();
        }
    }
}
