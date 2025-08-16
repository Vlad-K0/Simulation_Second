package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Action.ActionPlace.ActionPlaceHerbivore;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class ActionAddHerbivore implements Action {

    private final int howManyHerbivore;
    private final SimulationSettings settings;

    public ActionAddHerbivore(int howManyHerbivore, SimulationSettings settings) {
        this.howManyHerbivore = howManyHerbivore;
        this.settings = settings;
    }

    @Override
    public void execute() {
        ActionPlaceHerbivore placeHerbivore = new ActionPlaceHerbivore(settings);
        for (int i = 0; i < howManyHerbivore; i++) {
            placeHerbivore.execute();
        }
    }
}
