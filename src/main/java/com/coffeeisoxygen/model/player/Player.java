package com.coffeeisoxygen.model.player;

import java.awt.image.BufferedImage;

public class Player {

    private String plName;
    private int plEnergy;
    private BufferedImage image;

    // Constructor
    public Player(String plName, int plEnergy, BufferedImage image) {
        this.plName = plName;
        this.plEnergy = plEnergy;
        this.image = image;
    }

    // Getters
    public String getPlName() {
        return plName;
    }

    public int getPlEnergy() {
        return plEnergy;
    }

    public BufferedImage getImage() {
        return image;
    }

    // Setters
    public void setPlName(String plName) {
        this.plName = plName;
    }

    public void setPlEnergy(int plEnergy) {
        this.plEnergy = plEnergy;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
