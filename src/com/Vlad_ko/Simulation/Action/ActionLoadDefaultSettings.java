package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Utils.SettingsLoader.DefaultSettingsLoader;

public class ActionLoadDefaultSettings implements Action{
    private SimulationSettings settings;

    public ActionLoadDefaultSettings(SimulationSettings settings) {
        this.settings = settings;
    }

    @Override
    public void execute() {
        DefaultSettingsLoader loader = new DefaultSettingsLoader();
        settings = loader.loadSettings(settings);
    }
}
