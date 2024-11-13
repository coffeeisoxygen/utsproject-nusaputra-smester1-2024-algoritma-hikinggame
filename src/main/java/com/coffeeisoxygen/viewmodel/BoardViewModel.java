package com.coffeeisoxygen.viewmodel;

import com.coffeeisoxygen.implementations.BoardManager;
import com.coffeeisoxygen.interfaces.BoardObserver;
import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;

public class BoardViewModel implements BoardObserver {
    private Board board;
    private BoardManager boardManager;

    public BoardViewModel(Board board, BoardManager boardManager) {
        this.board = board;
        this.boardManager = boardManager;
        registerObserver();
    }

    public void registerObserver() {
        this.board.addObserver(this);
    }

    public void initializeBoard(int width, int height) {
        boardManager.initializeBoard(width, height);
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
        // Update the UI or perform other actions when the board changes
        System.out.println("Board has changed!");
    }
}