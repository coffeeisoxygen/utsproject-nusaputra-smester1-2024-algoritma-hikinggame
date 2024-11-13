package com.coffeeisoxygen.implementations;

import java.util.Random;

import com.coffeeisoxygen.interfaces.IBoardManager;
import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public class BoardManager implements IBoardManager {
    private Board board;

    public BoardManager(Board board) {
        this.board = board;
    }

    @Override
    public void setTile(int x, int y, TileType tileType) {
        board.setTile(x, y, createTile(x, y, tileType));
    }

    @Override
    public Tile getTile(int x, int y) {
        return board.getTile(x, y);
    }

    @Override
    public boolean validateBoard() {
        int startCount = 0;
        int finishCount = 0;
        for (int i = 0; i < board.getBoardWidth(); i++) {
            for (int j = 0; j < board.getBoardHeight(); j++) {
                if (board.getTile(i, j).getTileType() == TileType.STARTTILE)
                    startCount++;
                if (board.getTile(i, j).getTileType() == TileType.FINISHTILE)
                    finishCount++;
            }
        }
        return startCount == 1 && finishCount == 1;
    }

    @Override
    public void shuffleTiles(TileType tileType, int count) {
        Random random = new Random();
        int placed = 0;
        while (placed < count) {
            int x = random.nextInt(board.getBoardWidth());
            int y = random.nextInt(board.getBoardHeight());
            if (board.getTile(x, y).getTileType() == TileType.ROUTETILE) {
                setTile(x, y, tileType);
                placed++;
            }
        }
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < board.getBoardWidth(); i++) {
            for (int j = 0; j < board.getBoardHeight(); j++) {
                System.out.print(board.getTile(i, j).getTileType().name().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Tile createTile(int x, int y, TileType tileType) {
        return new Tile(x, y, tileType);
    }
}