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

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void transferEnergyToShield(int energy) {
        if (energy < this.energy) {
            this.energy -= energy;
            this.energy += getShield().addEnergy(energy);
        }
    }
}
