package com.coffeeisoxygen.model.tiles;

/*
 * Author: 
 * 
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: StartTile.java
 * Description: subclass of Tile
 */
import com.coffeeisoxygen.model.player.Player;

public class StartTile extends Tile {

    public StartTile(int x, int y) {
        super(x, y, TileType.STARTTILE);
    }

    @Override
    public void interact(Player player) {
        System.out.println("You are at the start");
    }
}
