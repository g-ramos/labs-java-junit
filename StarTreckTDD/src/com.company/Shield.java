package com.company;

public class Shield {

    public final static int initStrength = 5_000;


    private boolean isRaised = false;
    private int strength = initStrength;

    public boolean isRaised() {
        return isRaised;
    }

    public void raise() {
        isRaised = true;
    }

    public int getStrength() {
        return strength;
    }

    public void addStrength(int strength) {
        this.strength += strength;
    }
}
