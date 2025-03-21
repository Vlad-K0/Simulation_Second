package Entity;

import utils.Coordinates;

public abstract class Creature extends Entity {

    protected Creature(Coordinates coordinates, String sprite) {
        super(coordinates, sprite);
    }
}
