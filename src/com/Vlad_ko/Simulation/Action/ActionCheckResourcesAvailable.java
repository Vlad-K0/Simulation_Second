package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.Simulation;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Utils.EntityService;

public class ActionCheckResourcesAvailable implements Action {
    private final SimulationSettings settings;
    private final Simulation simulation;

    public ActionCheckResourcesAvailable(SimulationSettings settings) {
        this.settings = settings;
        this.simulation = settings.getSimulation();
    }

    @Override
    public void execute() {
        EntityService entityService = new EntityService();
        if (entityService.isTheFoodOut(settings)) {
            simulation.pauseSimulation();
        }
    }
}
