package com.company;

public class Shield {

    public static final int INIT_ENERGY = 5_000;


    private boolean isRaised = false;
    private int energy = INIT_ENERGY;

    public boolean isRaised() {
        return isRaised;
    }

    public void raise() {
        if (canRaise())
            isRaised = true;
    }

    private boolean canRaise() {
        return this.energy > 0;
    }

    public int getEnergy() {
        return energy;
    }

    public void addStrength(int strength) {
        this.energy += strength;
    }
}
