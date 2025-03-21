package Entity;

import utils.Coordinates;

public abstract class Entity {
    private final Coordinates position;
    private final String sprite;

    protected Entity(Coordinates position, String sprite) {
        this.position = position;
        this.sprite = sprite;
    }

    public String getSprite(){
        return sprite;
    };
}
