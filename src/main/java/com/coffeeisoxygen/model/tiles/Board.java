package com.coffeeisoxygen.model.tiles;

/*
 * Author: A.Hasan Maki
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: Board.java
 * Description: Board class that contains the tiles
 */
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

    // Method to print the board (for debugging or UI purposes)
    public void printBoard() {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                System.out.print(tiles[i][j].getTileType());
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
