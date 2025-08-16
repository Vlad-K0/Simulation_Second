package com.Vlad_ko.Simulation.Utils.SettingsLoader;

import com.Vlad_ko.Simulation.Core.SimulationSettings;

import java.io.*;

public abstract class SettingsLoader {
    protected abstract String getFilePath();

    public SimulationSettings loadSettings(SimulationSettings settings) {
        File defaultSource = new File(getFilePath());
        try(BufferedReader reader = new BufferedReader(new FileReader(defaultSource))) {
            settings.setHeightMap(Integer.parseInt(reader.readLine().replaceAll("[^\\d]", "")));
            settings.setWidthMap(Integer.parseInt(reader.readLine().replaceAll("[^\\d]", "")));
            settings.setMaxObstacles(Integer.parseInt(reader.readLine().replaceAll("[^\\d]", "")));
            settings.setMaxHerbivores(Integer.parseInt(reader.readLine().replaceAll("[^\\d]", "")));
            settings.setMaxEdibleItems(Integer.parseInt(reader.readLine().replaceAll("[^\\d]", "")));
            settings.setMaxPredators(Integer.parseInt(reader.readLine().replaceAll("[^\\d]", "")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return settings;
    }
}
