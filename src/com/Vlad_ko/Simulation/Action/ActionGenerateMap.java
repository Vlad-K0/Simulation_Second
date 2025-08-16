package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Action.ActionPlace.ActionPlaceEntities;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.RendererMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;

public class ActionGenerateMap implements Action{
    private final SimulationSettings settings;

    public ActionGenerateMap(SimulationSettings settings) {
        this.settings = settings;
    }

    @Override
    public void execute() {
        int width = settings.getWidthMap();
        int height = settings.getHeightMap();
        GameMap map = new GameMap(width,height);
        settings.setMap(map);
        ActionPlaceEntities placeEntities = new ActionPlaceEntities(settings);
        placeEntities.execute();
    }
}
