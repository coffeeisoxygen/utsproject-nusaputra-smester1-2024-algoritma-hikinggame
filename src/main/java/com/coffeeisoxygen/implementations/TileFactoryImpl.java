package com.coffeeisoxygen.implementations;

import com.coffeeisoxygen.interfaces.IBoardManager;
import com.coffeeisoxygen.model.tiles.DangerTile;
import com.coffeeisoxygen.model.tiles.FinishTile;
import com.coffeeisoxygen.model.tiles.RouteTile;
import com.coffeeisoxygen.model.tiles.SafeTile;
import com.coffeeisoxygen.model.tiles.StartTile;
import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;

public abstract class TileFactoryImpl implements IBoardManager {

    @Override
    public Tile createTile(int x, int y, TileType tileType) {
        switch (tileType) {
        case STARTTILE -> {
            return new StartTile(x, y);
        }
        case FINISHTILE -> {
            return new FinishTile(x, y);
        }
        case SAFETILE -> {
            return new SafeTile(x, y);
        }
        case DANGERTILE -> {
            return new DangerTile(x, y);
        }
        case ROUTETILE -> {
            return new RouteTile(x, y);
        }
        default -> throw new IllegalArgumentException("Unknown tile type: " + tileType);
        }
    }

    // Implement other methods from IBoardManager or leave them abstract
}
