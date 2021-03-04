package com.company;

public class Ship {

    public final static int initialEnergy = 50_000;
    private Shield shield;
    private int energy = initialEnergy;

    public Ship(Shield shield) {
        this.shield = shield;
    }

    public Shield getShield() {
        return this.shield;
    }

    public int getEnergy() {
        return energy;
    }
}
