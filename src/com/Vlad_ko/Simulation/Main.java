package com.Vlad_ko.Simulation;

import com.Vlad_ko.Simulation.Action.*;
import com.Vlad_ko.Simulation.Action.ActionPlace.ActionPlaceEntities;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.Simulation;
import com.Vlad_ko.Simulation.UI.ConsoleMessage;
import com.Vlad_ko.Simulation.UI.SimulationContext;
import com.Vlad_ko.Simulation.UI.SimulationState;
import com.Vlad_ko.Simulation.UI.StartMenuState;
import com.Vlad_ko.Simulation.Utils.InputHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        SimulationContext simulationContext = new SimulationContext(new StartMenuState(inputHandler));
        simulationContext.run();
    }
}