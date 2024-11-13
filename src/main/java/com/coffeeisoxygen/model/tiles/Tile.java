package com.coffeeisoxygen.model.tiles;

import java.awt.image.BufferedImage;

import com.coffeeisoxygen.model.player.Player;

public class Tile {
    private int tileX;
    private int tileY;
    private TileType tileType;
    private BufferedImage tileImage;

    public Tile(int x, int y, TileType tileType) {
        this.tileX = x;
        this.tileY = y;
        this.tileType = tileType;
    }

    public Tile(int x, int y, TileType tileType, BufferedImage tileImage) {
        this.tileX = x;
        this.tileY = y;
        this.tileType = tileType;
        this.tileImage = tileImage;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public TileType getTileType() {
        return tileType;
    }

    public BufferedImage getImage() {
        return tileImage;
    }

    public void setImage(BufferedImage image) {
        this.tileImage = image;
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