package com.coffeeisoxygen.model.tiles;

/*
 * Author: A.Hasan Maki
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: FinishTile.java
 * Description: subclass of Tile
 */

import com.coffeeisoxygen.model.player.Player;

public class FinishTile extends Tile {

    public FinishTile(int x, int y) {
        super(x, y, TileType.FINISHTILE);
    }

    @Override
    public void interact(Player player) {
        System.out.println("You are at the finish");
    }

}
