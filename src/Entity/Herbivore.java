package Entity;

import utils.Coordinates;

public class Herbivore extends Creature{
    private static final String ANSI_HERBIVORE = "\uD83D\uDC37";
    public Herbivore(Coordinates coordinates) {
        super(coordinates, ANSI_HERBIVORE);
    }
}
