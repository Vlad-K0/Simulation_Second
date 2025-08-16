package com.Vlad_ko.Simulation.Action;

public class ActionSleepSimulation implements Action{
    @Override
    public void execute() {
        try {
            int TIME_SLEEP = 500;
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
