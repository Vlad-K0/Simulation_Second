package com.Vlad_ko.Simulation.Entity;

import com.Vlad_ko.Simulation.Utils.Coordinates;

public abstract class Entity {
    protected Coordinates position;
    protected final String sprite;

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }

    protected Entity(Coordinates position, String sprite) {
        this.position = position;
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }
}
