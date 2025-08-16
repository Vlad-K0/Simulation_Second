package com.Vlad_ko.Simulation.Entity.Item;

import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public abstract class Item extends Entity {
    public Item(Coordinates position, String sprite) {
        super(position, sprite);
    }
}
