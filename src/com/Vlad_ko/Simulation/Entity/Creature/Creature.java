package com.Vlad_ko.Simulation.Entity.Creature;

import com.Vlad_ko.Simulation.Action.ActionMoveCreatures;
import com.Vlad_ko.Simulation.Action.ActionMoveEntity;
import com.Vlad_ko.Simulation.Behavior.Eatable;
import com.Vlad_ko.Simulation.Behavior.Movable;
import com.Vlad_ko.Simulation.Core.SimulationSettings;
import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Core.GameMap;
import com.Vlad_ko.Simulation.Utils.Pathfinding;
import com.Vlad_ko.Simulation.Utils.Coordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Creature extends Entity implements Movable {
    private List<Coordinates> path = new ArrayList<>();
    protected Coordinates target;
    private int DEFAULT_HP = 100;
    protected int HP = DEFAULT_HP;
    protected int speed;
    protected int attackRange;

    protected Creature(Coordinates coordinates, String sprite, int speed, int attackRange) {
        super(coordinates, sprite);
        this.speed = speed;
        this.attackRange = attackRange;
    }

    public void healingCreature(int healingPoint) {
        if (HP + healingPoint > 100) {
            HP = DEFAULT_HP;
        } else {
            HP += healingPoint;
        }
    }

    public boolean isTargetInAttackZone() {
        if (target == null) return false;

        int x = this.position.getX();
        int y = this.position.getY();
        int tx = target.getX();
        int ty = target.getY();

        return (tx >= x - attackRange && tx <= x + attackRange) &&
                (ty >= y - attackRange && ty <= y + attackRange);
    }

    public boolean refineTarget(SimulationSettings settings) {
        path = findClosestFood(settings);
        if (path.isEmpty()) {
            return false;
        }
        target = path.getFirst();
        path.removeFirst();
        return true;
    }

    public void move(SimulationSettings settings) {
        GameMap map = settings.getMap();
        if (refineTarget(settings)) {
            if (!path.isEmpty()) {
                Coordinates nextStep = path.getLast();
                ActionMoveEntity actionMove = new ActionMoveEntity(settings, this, nextStep);
                actionMove.execute();
                path.remove(path.getLast());
            }
            if (path.isEmpty() || map.isCellEmpty(target)) {
                if (findClosestFood(settings) != null) {
                    path = findClosestFood(settings);
                    target = path.getFirst();
                    path.removeFirst();
                } else {
                    path.clear();
                }
            }
        }
    }

    public void eatOrAttack(GameMap map) {
        Entity entity = map.getEntityAtCell(target);
        if (entity instanceof Herbivore prey && this instanceof Predator) {
            prey.takeDamage();
            if (prey.isDead(prey)) {
                System.out.println("Объект съеден");
                prey.beEaten(map, this);
            }
        } else {
            System.out.println("Объект съеден");
            ((Eatable) entity).beEaten(map, this);
        }
    }

    protected boolean isDead(Creature creature) {
        return creature.HP <= 0;
    }

    protected abstract Class<? extends Eatable> getTypeFood();

    protected List<Coordinates> findClosestFood(SimulationSettings settings) {
        Pathfinding pathfinding = new Pathfinding();
        return pathfinding.BFS(settings, position, getTypeFood());
    }
}
