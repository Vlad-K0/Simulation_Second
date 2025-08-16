package com.Vlad_ko.Simulation.Core;

public class SimulationSettings {
    private boolean infiniteMode;
    private int maxHerbivores;
    private int maxPredators;
    private int maxObstacles;
    private int maxEdibleItems;
    private int widthMap;
    private int heightMap;
    private final int infiniteTurns = 15;
    private GameMap map;
    private Simulation simulation;

    public boolean isEmpty(){
        return maxHerbivores == 0 &&
                maxPredators == 0 &&
                maxObstacles == 0 &&
                maxEdibleItems == 0 &&
                widthMap == 0 &&
                heightMap == 0;
    }

    public int getMaxHerbivores() {
        return maxHerbivores;
    }

    public void setMaxHerbivores(int maxHerbivores) {
        this.maxHerbivores = maxHerbivores;
    }

    public int getMaxPredators() {
        return maxPredators;
    }

    public void setMaxPredators(int maxPredators) {
        this.maxPredators = maxPredators;
    }

    public int getMaxObstacles() {
        return maxObstacles;
    }

    public void setMaxObstacles(int maxObstacles) {
        this.maxObstacles = maxObstacles;
    }

    public int getMaxEdibleItems() {
        return maxEdibleItems;
    }

    public void setMaxEdibleItems(int maxEdibleItems) {
        this.maxEdibleItems = maxEdibleItems;
    }

    public int getWidthMap() {
        return widthMap;
    }

    public void setWidthMap(int widthMap) {
        this.widthMap = widthMap;
    }

    public int getHeightMap() {
        return heightMap;
    }

    public void setHeightMap(int heightMap) {
        this.heightMap = heightMap;
    }

    public boolean isInfiniteMode() {
        return infiniteMode;
    }

    public void setInfiniteMode(boolean infiniteMode) {
        this.infiniteMode = infiniteMode;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public int getInfiniteTurns() {
        return infiniteTurns;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

}
