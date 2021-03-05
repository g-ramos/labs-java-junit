package com.company;

public class Shield {

    public static final int INIT_ENERGY = 5_000;
    public static final int MAX_ENERGY = 10_000;

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

    public int addEnergy(int strength) {
        this.energy += strength;
        if(this.energy > MAX_ENERGY)
        {
            int extraEnergy = this.energy - MAX_ENERGY;
            this.energy = MAX_ENERGY;

            return extraEnergy;
        } else if (this.energy < 0) {
            int tempEnergy = this.energy;
            this.energy = 0;
            return tempEnergy;
        }

        return 0;
    }
}
