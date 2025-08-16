package com.Vlad_ko.Simulation.Utils.SettingsLoader;

import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class DefaultSettingsLoader extends SettingsLoader {

    @Override
    protected String getFilePath() {
        return "./resource/DefaultSettings.txt";
    }
}
