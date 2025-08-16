package com.Vlad_ko.Simulation.UI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class SimulationContext {
    private static final Logger log = LogManager.getLogger(SimulationContext.class);
    private SimulationState state;
    private boolean isRunning = true;
    private SimulationSettings settings = new SimulationSettings();

    public SimulationSettings getSettings() {
        return settings;
    }

    public void setSettings(SimulationSettings settings) {
        this.settings = settings;
    }

    public SimulationContext(SimulationState initialState) {
        this.state = initialState;
    }

    public void setState(SimulationState state) {
        this.state = state;
    }

    public void stop() {
        isRunning = false;
    }

    public void run() {
        while (isRunning) {
            state.handle(this);
        }
    }
}
