package com.coffeeisoxygen.model.tiles;

/*
 * Author: A.Hasan Maki
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: SafeTile.java
 * Description: subclass of Tile
 */

import com.coffeeisoxygen.model.player.Player;

public class SafeTile extends Tile {

    public SafeTile(int x, int y) {
        super(x, y, TileType.SAFETILE);
    }

    @Override
    public void interact(Player player) {
        System.out.println("You are safe");
    }
}
