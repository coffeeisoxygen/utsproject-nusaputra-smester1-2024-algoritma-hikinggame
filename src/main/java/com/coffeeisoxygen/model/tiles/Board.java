package com.coffeeisoxygen.model.tiles;

import java.util.ArrayList;
import java.util.List;

import com.coffeeisoxygen.interfaces.BoardObserver;

public class Board {
    private Tile[][] tiles;
    private int boardWidth, boardHeight;
    private List<BoardObserver> observers = new ArrayList<>();

    // Constructor
    public Board(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.tiles = new Tile[width][height];
    }

    // Getters and Setters
    public Tile[][] getTiles() {
        return tiles;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight) {
            return tiles[x][y];
        }
        return null;
    }

    public void setTile(int x, int y, Tile tile) {
        if (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight) {
            tiles[x][y] = tile;
            notifyObservers();
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