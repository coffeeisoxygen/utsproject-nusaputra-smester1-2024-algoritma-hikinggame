package com.coffeeisoxygen.model.tiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.coffeeisoxygen.interfaces.BoardObserver;

public class Board {

    private static final int DEFAULT_WIDTH = 5, DEFAULT_HEIGHT = 8;

    private Tile[][] tiles;
    private int boardWidth, boardHeight;
    private List<BoardObserver> observers = new ArrayList<>();

    public Board(int width, int height) {
        this.boardWidth = (width > 0) ? width : DEFAULT_WIDTH;
        this.boardHeight = (height > 0) ? height : DEFAULT_HEIGHT;
        this.tiles = new Tile[boardWidth][boardHeight];
        setDefaultTiles();
        notifyObservers();
    }

    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public static int getDefaultBoardWidth() {
        return DEFAULT_WIDTH;
    }

    public static int getDefaultBoardHeight() {
        return DEFAULT_HEIGHT;
    }

    public Tile getTile(int x, int y) {
        return isValidPosition(x, y) ? tiles[x][y] : null;
    }

    private void setDefaultTiles() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                tiles[i][j] = new Tile(i, j, TileType.ROUTETILE);
            }
        }
        tiles[0][0] = new Tile(0, 0, TileType.FINISHTILE);
        tiles[boardWidth - 1][boardHeight - 1] = new Tile(boardWidth - 1, boardHeight - 1, TileType.STARTTILE);
    }

    public void resetTiles() {
        setDefaultTiles();
        notifyObservers();
    }

    public void setTile(int x, int y, Tile tile) {
        if (isValidPosition(x, y)) {
            tiles[x][y] = tile;
            notifyObservers();
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < boardWidth && y >= 0 && y < boardHeight;
    }

    public boolean validateBoard() {
        int startCount = 0;
        int finishCount = 0;
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                if (tile.getTileType() == TileType.STARTTILE)
                    startCount++;
                if (tile.getTileType() == TileType.FINISHTILE)
                    finishCount++;
            }
        }
        return startCount == 1 && finishCount == 1;
    }

    public void randomizeTiles() {
        Random random = new Random();
        TileType[] tileTypes = { TileType.SAFETILE, TileType.DANGERTILE, TileType.ROUTETILE };

        // Randomize Safe, Danger, and Route Tiles
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                TileType randomTileType = tileTypes[random.nextInt(tileTypes.length)];
                setTile(i, j, new Tile(i, j, randomTileType));
            }
        }

        // Place Start Tile at a specific position (e.g., top-left corner)
        setTile(0, 0, new Tile(0, 0, TileType.FINISHTILE));

        // Place Finish Tile at a specific position (e.g., bottom-right corner)
        setTile(boardWidth - 1, boardHeight - 1, new Tile(boardWidth - 1, boardHeight - 1, TileType.STARTTILE));
    }

    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (BoardObserver observer : observers) {
            observer.boardChanged();
        }
    }

}
