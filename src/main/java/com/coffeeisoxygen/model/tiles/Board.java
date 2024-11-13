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

    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Board(int width, int height) {
        initialize(width, height);
    }

    public void initialize(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                setTile(i, j, new Tile(i, j, TileType.ROUTETILE));
            }
        }
        setTile(0, 0, new Tile(0, 0, TileType.FINISHTILE));
        setTile(width - 1, height - 1, new Tile(width - 1, height - 1, TileType.STARTTILE));
        notifyObservers();
    }

    public void resetBoard() {
        initialize(boardWidth, boardHeight);
    }

    public void setTile(int x, int y, Tile tile) {
        if (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight) {
            tiles[x][y] = tile;
            notifyObservers();
        }
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight) {
            return tiles[x][y];
        }
        return null;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
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

    public void printBoard() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                System.out.print(tiles[i][j].getTileType().name().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BoardObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (BoardObserver observer : observers) {
            observer.boardChanged();
        }
    }
}