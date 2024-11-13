package com.coffeeisoxygen.model.tiles;

/*
 * Author: A.Hasan Maki
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: Tile.java
 * Description: this is a abstract class for the tiles
 * the extended class will be : safeTile, dangerTile, routeTile, startTile, and finishTile
 */

import com.coffeeisoxygen.model.player.Player;

public abstract class Tile {

    protected int tileX;
    protected int tileY;
    protected TileType tileType;

    // constructor
    public Tile(int x, int y, TileType tileType) {
        this.tileX = x;
        this.tileY = y;
        this.tileType = tileType;
    }

    // getters
    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public TileType getTileType() {
        return tileType;
    }

    public String getTilePosition() {
        return "(" + tileX + ", " + tileY + ")";
    }

    public abstract void interact(Player player);

}
