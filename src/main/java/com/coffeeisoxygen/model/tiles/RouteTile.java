package com.coffeeisoxygen.model.tiles;

/*
 * Author: A.Hasan Maki
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: RouteTile.java
 * Description: subclass of Tile
 */

import com.coffeeisoxygen.model.player.Player;

public class RouteTile extends Tile {

    public RouteTile(int x, int y) {
        super(x, y, TileType.ROUTETILE);
    }

    @Override
    public void interact(Player player) {
        System.out.println("You are on the route");
    }
}
