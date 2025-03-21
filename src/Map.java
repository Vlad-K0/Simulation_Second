import Entity.Creature;
import Entity.Entity;
import utils.Coordinates;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> creaturesMap = new HashMap<>();
    private final int width;
    private final int height;


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void placeEntity(Coordinates coordinates, Entity entity) {
        creaturesMap.put(coordinates, entity);
    }
    public boolean isCellEmpty(Coordinates coordinates){
        return creaturesMap.containsKey(coordinates);
    }
    public Entity getEntityAtCell(Coordinates coordinates){
        return creaturesMap.get(coordinates);
    }

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Entity getEntityAtCoordinates(Coordinates coordinates) {
        return creaturesMap.get(coordinates);
    }


}
