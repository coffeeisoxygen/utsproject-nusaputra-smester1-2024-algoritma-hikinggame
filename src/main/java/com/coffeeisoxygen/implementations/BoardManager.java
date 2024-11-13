package com.coffeeisoxygen.implementations;

import java.util.Random;

import com.coffeeisoxygen.interfaces.IBoardManager;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public class BoardManager implements IBoardManager {

    private Tile[][] board;
    private int width, height;
    private IBoardManager tileFactory;

    public BoardManager(IBoardManager tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public void initializeBoard(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Tile[width][height];

        // Inisialisasi dengan RouteTile di semua posisi, lalu tempatkan Start dan
        // Finish
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = tileFactory.createTile(i, j, TileType.ROUTETILE);
            }
        }
        setTile(0, 0, TileType.FINISHTILE);
        setTile(width - 1, height - 1, TileType.STARTTILE);
    }

    @Override
    public void initializeTiles(int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = tileFactory.createTile(i, j, TileType.ROUTETILE);
            }
        }
    }

    @Override
    public void setTile(int x, int y, TileType tileType) {
        board[x][y] = tileFactory.createTile(x, y, tileType);
    }

    @Override
    public Tile getTile(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return board[x][y];
        }
        return null; // Return null jika di luar board
    }

    @Override
    public boolean validateBoard() {
        int startCount = 0;
        int finishCount = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j].getTileType() == TileType.STARTTILE)
                    startCount++;
                if (board[i][j].getTileType() == TileType.FINISHTILE)
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
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            if (board[x][y].getTileType() == TileType.ROUTETILE) { // Hanya ganti RouteTile
                setTile(x, y, tileType);
                placed++;
            }
        }
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(board[i][j].getTileType().name().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Tile createTile(int x, int y, TileType tileType) {
        return tileFactory.createTile(x, y, tileType);
    }
}