package com.coffeeisoxygen.model.tiles;

/*
 * Author: A.Hasan Maki
 * GitHub: @coffeisoxygen
 * Date: 2024-11-12
 * File: DangerTile.java
 * Description: subclass of Tile
 */
import com.coffeeisoxygen.model.player.Player;

public class DangerTile extends Tile {

    public DangerTile(int x, int y) {
        super(x, y, TileType.DANGERTILE);
    }

    @Override
    public void interact(Player player) {
        System.out.println("You are in danger");
    }

}
