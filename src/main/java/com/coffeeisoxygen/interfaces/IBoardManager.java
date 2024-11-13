package com.coffeeisoxygen.interfaces;

import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public interface IBoardManager {
    void initializeBoard(int width, int height); // Initialize board with default configuration

    void initializeTiles(int width, int height); // Initialize tiles with default configuration

    void setTile(int x, int y, TileType tileType); // Set a specific tile type at a position

    Tile getTile(int x, int y); // Get the tile at a specific position

    boolean validateBoard(); // Check board validity (1 start, 1 finish)

    void shuffleTiles(TileType tileType, int count); // Shuffle placement of special tiles like DangerTile

    void printBoard(); // Display board in text for debugging

    Tile createTile(int x, int y, TileType tileType); // Create a tile of a specific type at a position
}