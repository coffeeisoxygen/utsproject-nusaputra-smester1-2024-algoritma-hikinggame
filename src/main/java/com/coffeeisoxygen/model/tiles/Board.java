package com.coffeeisoxygen.model.tiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.coffeeisoxygen.interfaces.BoardObserver;

public class Board {

    private static final int DEFAULT_WIDTH = 5;
    private static final int DEFAULT_HEIGHT = 8;

    private Tile[][] tiles;
    private int boardWidth, boardHeight;
    private List<BoardObserver> observers = new ArrayList<>();

    // Constructor with optional dimensions
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

    // Set default tiles (start, finish, and route tiles)
    private void setDefaultTiles() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                tiles[i][j] = new Tile(i, j, TileType.ROUTETILE);
            }
        }
        tiles[0][0] = new Tile(0, 0, TileType.FINISHTILE);
        tiles[boardWidth - 1][boardHeight - 1] = new Tile(boardWidth - 1, boardHeight - 1, TileType.STARTTILE);
    }

    public void setTile(int x, int y, Tile tile) {
        if (isValidPosition(x, y)) {
            tiles[x][y] = tile;
            notifyObservers();
        }
    }

    public Tile getTile(int x, int y) {
        return isValidPosition(x, y) ? tiles[x][y] : null;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < boardWidth && y >= 0 && y < boardHeight;
    }

    public boolean validateBoard() {
        int startCount = 0;
        int finishCount = 0;
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (tiles[i][j].getTileType() == TileType.STARTTILE)
                    startCount++;
                if (tiles[i][j].getTileType() == TileType.FINISHTILE)
                    finishCount++;
            }
        }
        return startCount == 1 && finishCount == 1;
    }

    public void shuffleTiles(TileType tileType, int count) {
        Random random = new Random();
        int placed = 0;
        while (placed < count) {
            int x = random.nextInt(boardWidth);
            int y = random.nextInt(boardHeight);
            if (tiles[x][y].getTileType() == TileType.ROUTETILE) {
                setTile(x, y, new Tile(x, y, tileType));
                placed++;
            }
        }
    }

    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (BoardObserver observer : observers) {
            observer.boardChanged();
        }
    }

    public int getWidth() {
        return boardWidth;
    }

    public int getHeight() {
        return boardHeight;
    }
}
