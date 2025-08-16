package com.Vlad_ko.Simulation.Action;

import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Creature.Creature;
import com.Vlad_ko.Simulation.Utils.EntityService;

public class ActionCreatureAttackOrEat implements Action {
    private final SimulationSettings settings;

    public ActionCreatureAttackOrEat(SimulationSettings settings){
        this.settings = settings;
    }

    @Override
    public void execute() {
        GameMap map = settings.getMap();
        EntityService entityService = new EntityService();
        for (Creature creature : entityService.getCreatures(settings)){
            if(creature.isTargetInAttackZone()){
                if(creature.refineTarget(settings)){
                    creature.eatOrAttack(map);
                }
            }
        }
    }
}
