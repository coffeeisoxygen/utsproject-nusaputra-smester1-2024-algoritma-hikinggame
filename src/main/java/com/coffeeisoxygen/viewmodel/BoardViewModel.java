package com.coffeeisoxygen.viewmodel;

import com.coffeeisoxygen.interfaces.BoardObserver;
import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public class BoardViewModel implements BoardObserver {

    private Board board;
    private Runnable observer;

    // Private constructor to prevent direct instantiation
    private BoardViewModel(Board board) {
        this.board = board;
    }

    // Factory method to create an instance and set up the observer
    public static BoardViewModel create(int width, int height) {
        Board board = new Board(width, height);
        BoardViewModel viewModel = new BoardViewModel(board);
        board.addObserver(viewModel);
        return viewModel;
    }

    // Factory method to create an instance with default dimensions
    public static BoardViewModel create() {
        Board board = new Board();
        BoardViewModel viewModel = new BoardViewModel(board);
        board.addObserver(viewModel);
        return viewModel;
    }

    public void setBoardObserver(Runnable observer) {
        this.observer = observer;
    }

    public Tile getTile(int x, int y) {
        return board.getTile(x, y);
    }

    public void setTile(int x, int y, TileType tileType) {
        board.setTile(x, y, new Tile(x, y, tileType));
    }

    public void updateBoardDimensions(int width, int height) {
        this.board = new Board(width, height);
        board.addObserver(this);
        boardChanged();
    }

    @Override
    public void boardChanged() {
        if (observer != null) {
            observer.run();
        }
    }

    public int getBoardWidth() {
        return board.getWidth();
    }

    public int getBoardHeight() {
        return board.getHeight();
    }
}
