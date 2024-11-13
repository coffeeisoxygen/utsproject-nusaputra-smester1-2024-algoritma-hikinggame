package com.coffeeisoxygen.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.coffeeisoxygen.implementations.BoardManager;
import com.coffeeisoxygen.interfaces.BoardObserver;
import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public class BoardViewModel implements BoardObserver {
    private Board board;
    private BoardManager boardManager;
    private List<Runnable> observers = new ArrayList<>();

    public BoardViewModel(Board board) {
        this.board = board;
        this.boardManager = new BoardManager(board);
    }

    public void registerObserver() {
        this.board.addObserver(this);
    }

    public void initializeBoard(int width, int height) {
        board.initialize(width, height);
        boardManager.setTile(width - 1, height - 1, TileType.STARTTILE);
        boardManager.setTile(0, 0, TileType.FINISHTILE);
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