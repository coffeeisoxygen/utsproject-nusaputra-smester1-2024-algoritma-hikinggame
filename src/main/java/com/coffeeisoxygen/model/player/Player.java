package com.coffeeisoxygen.model.player;

public class Player {

    private String plName;
    private int plEnergy;

    // Constructor
    public Player(String plName, int plEnergy) {
        this.plName = plName;
        this.plEnergy = plEnergy;
    }

    // Getters
    public String getPlName() {
        return plName;
    }

    public int getPlEnergy() {
        return plEnergy;
    }

    // Setters
    public void setPlName(String plName) {
        this.plName = plName;
    }

    public void setPlEnergy(int plEnergy) {
        this.plEnergy = plEnergy;
    }

    

}
