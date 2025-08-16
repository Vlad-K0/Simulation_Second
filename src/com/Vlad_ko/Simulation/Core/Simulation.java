package com.Vlad_ko.Simulation.Core;

import com.Vlad_ko.Simulation.Action.Action;
import com.Vlad_ko.Simulation.Utils.EntityService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
    private final SimulationSettings settings;
    private List<Action> initActions = new ArrayList<>();
    private List<Action> turnActions = new ArrayList<>();
    private int counterTurns = 0;

    public void resetCounter(){
        counterTurns = 0;
    }

    public Simulation(SimulationSettings settings) {
        this.settings = settings;
    }

    public void nextTurn() {
        counterTurns++;
        for (Action action : turnActions) {
            action.execute();
        }
    }

    public void addInitActions(Action... actions) {
        initActions.addAll(Arrays.asList(actions));
    }


    public void addTurnActions(Action... actions) {
        turnActions.addAll(Arrays.asList(actions));
    }

    public void initialize() {
        for (Action action : initActions) {
            action.execute();
        }
    }

    public void startSimulation() {
        settings.setInfiniteMode(true);
        while (counterTurns < settings.getInfiniteTurns() && settings.isInfiniteMode()) {
            nextTurn();
        }
        resetCounter();
    }

    public void pauseSimulation() {
        settings.setInfiniteMode(false);
    }
}
