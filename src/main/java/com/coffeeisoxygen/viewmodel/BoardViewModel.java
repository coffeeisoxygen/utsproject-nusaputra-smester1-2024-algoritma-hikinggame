package com.coffeeisoxygen.viewmodel;

import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;

public class BoardViewModel {
    private Board board;

    public BoardViewModel(Board board) {
        this.board = board;
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

    public Board getBoard() {
        return board;
    }
}
