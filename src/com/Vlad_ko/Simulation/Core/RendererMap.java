package com.Vlad_ko.Simulation.Core;

import com.Vlad_ko.Simulation.Entity.Entity;
import com.Vlad_ko.Simulation.Utils.Coordinates;

public class RendererMap {
    private static final String ANSI_BACKGROUND_CELL_COLOR = "\033[48;5;2m";
    private static final String ANSI_RESET = "\033[0m";
    private static final String EMPTY_SQUARE = "\uD83D\uDFE9";
    private final GameMap gameMap;

    public RendererMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void render() {
        for (int y = 1; y <= gameMap.getHeight(); y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 1; x <= gameMap.getWidth(); x++) {
                Entity entity = gameMap.getEntityAtCell(new Coordinates(x, y));
                line.append(entity != null ?
                        colorizeCellWithEntity(entity.getSprite()) : colorizeEmptyCell());
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
        System.out.println();
    }

    private String colorizeEmptyCell() {
        return ANSI_BACKGROUND_CELL_COLOR + EMPTY_SQUARE;
    }

    private String colorizeCellWithEntity(String sprite) {
        return ANSI_BACKGROUND_CELL_COLOR + sprite;
    }
}
