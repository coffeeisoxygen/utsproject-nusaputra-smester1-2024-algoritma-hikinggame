package com.coffeeisoxygen.model.tiles;

import com.coffeeisoxygen.model.player.Player;

public class Tile {
    private int x;
    private int y;
    private TileType tileType;

    public Tile(int x, int y, TileType tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileType getTileType() {
        return tileType;
    }

    public String getPosition() {
        return "(" + x + ", " + y + ")";
    }

    public void interact(Player player) {
        switch (tileType) {
            case SAFETILE -> System.out.println("You are safe");
            case DANGERTILE -> System.out.println("You are in danger");
            case ROUTETILE -> System.out.println("You are on the route");
            case STARTTILE -> System.out.println("You are at the start");
            case FINISHTILE -> System.out.println("You are at the finish");
        }
    }
}