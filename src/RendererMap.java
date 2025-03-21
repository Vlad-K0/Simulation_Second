import Entity.Entity;
import utils.Coordinates;

public class RendererMap {
    private static final String ANSI_BACKGROUND_CELL_COLOR = "\033[48;5;2m";
    private static final String ANSI_RESET = "\033[0m";
    private static final String EMPTY_SQUARE = "\uD83D\uDFE9";


    public void render(Map map) {
        for (int y = 0; y < map.getHeight(); y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < map.getWidth(); x++) {
                Entity entity = map.getEntityAtCoordinates(new Coordinates(x, y));
                line.append(entity != null ?
                        colorizeCellWithEntity(entity.getSprite()) : colorizeEmptyCell());
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
    }

    private String colorizeEmptyCell() {
        return ANSI_BACKGROUND_CELL_COLOR + EMPTY_SQUARE;
    }

    private String colorizeCellWithEntity(String sprite) {
        return ANSI_BACKGROUND_CELL_COLOR + sprite;
    }
}
