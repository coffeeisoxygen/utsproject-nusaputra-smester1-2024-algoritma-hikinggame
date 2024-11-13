package com.coffeeisoxygen.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.coffeeisoxygen.interfaces.BoardObserver;
import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public class BoardViewModel implements BoardObserver {
    private Board board;
    private List<Runnable> observers = new ArrayList<>();

    public BoardViewModel(int width, int height) {
        this.board = new Board(width, height);
        this.board.addObserver(this);
    }

    public void initializeBoard(int width, int height) {
        board.initialize(width, height);
        notifyObservers();
    }

    public Tile[][] getTiles() {
        return board.getTiles();
    }

    public int getBoardWidth() {
        return board.getBoardWidth();
    }

    public int getBoardHeight() {
        return board.getBoardHeight();
    }

    public Tile getTile(int x, int y) {
        return board.getTile(x, y);
    }

    public void setTile(int x, int y, TileType tileType) {
        board.setTile(x, y, new Tile(x, y, tileType));
        notifyObservers();
    }

    public boolean validateBoard() {
        return board.validateBoard();
    }

    public void shuffleTiles(TileType tileType, int count) {
        board.shuffleTiles(tileType, count);
        notifyObservers();
    }

    public void printBoard() {
        board.printBoard();
    }

    @Override
    public void boardChanged() {
        notifyObservers();
    }

    public void addObserver(Runnable observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Runnable observer : observers) {
            observer.run();
        }
    }
}