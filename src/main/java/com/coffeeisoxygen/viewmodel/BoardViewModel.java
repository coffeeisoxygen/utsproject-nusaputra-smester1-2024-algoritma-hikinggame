package com.coffeeisoxygen.viewmodel;

import com.coffeeisoxygen.interfaces.BoardObserver;
import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public class BoardViewModel implements BoardObserver {

    private static final int MAX_WIDTH = 15;
    private static final int MAX_HEIGHT = 10;

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

    public Tile getTile(int x, int y) {
        return board.getTile(x, y);
    }

    public int getBoardWidth() {
        return board.getBoardWidth();
    }

    public int getBoardHeight() {
        return board.getBoardHeight();
    }

    public int getMaxWidth() {
        return MAX_WIDTH;
    }

    public int getMaxHeight() {
        return MAX_HEIGHT;
    }

    public void setBoardObserver(Runnable observer) {
        this.observer = observer;
    }

    public void setTile(int x, int y, TileType tileType) {
        board.setTile(x, y, new Tile(x, y, tileType));
        boardChanged();
    }

    public void resetMapTiles() {
        board.resetTiles();
    }

    public boolean validateBoardDimensions(int width, int height) {
        return width > 0 && width <= MAX_WIDTH && height > 0 && height <= MAX_HEIGHT;
    }

    public void updateBoardDimensions(int width, int height) {
        if (validateBoardDimensions(width, height)) {
            this.board = new Board(width, height);
            board.addObserver(this);
            boardChanged();
        } else {
            if (observer != null) {
                observer.run();
            }
        }
    }

    public void randomizeTiles() {
        board.randomizeTiles();
        if (observer != null) { // ? MARK: just to make sure the observer are running /
            observer.run();
        }
    }

    @Override
    public void boardChanged() {
        if (observer != null) {
            observer.run();
        }
    }
}
