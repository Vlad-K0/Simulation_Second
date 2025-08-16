package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.RendererMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class ActionRenderMap implements Action {
    private final SimulationSettings settings;
    public ActionRenderMap(SimulationSettings settings) {
        this.settings = settings;
    }

    @Override
    public void execute() {
        RendererMap rendererMap = new RendererMap(settings.getMap());
        rendererMap.render();
    }
}
