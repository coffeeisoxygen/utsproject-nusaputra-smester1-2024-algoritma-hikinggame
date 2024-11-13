package com.coffeeisoxygen.model.tiles;

import java.util.ArrayList;
import java.util.List;

import com.coffeeisoxygen.interfaces.BoardObserver;

public class Board {
    private static final int DEFAULT_WIDTH = 5;
    private static final int DEFAULT_HEIGHT = 8;

    private Tile[][] tiles;
    private int boardWidth, boardHeight;
    private List<BoardObserver> observers = new ArrayList<>();

    // Default constructor with default dimensions
    public Board() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    // Constructor with specified dimensions
    public Board(int width, int height) {
        initialize(width, height);
    }

    public void initialize(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.tiles = new Tile[width][height];
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