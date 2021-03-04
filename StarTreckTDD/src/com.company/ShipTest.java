package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    private Shield shield;
    private Ship ship;

    @Before // = "background" in Gherkin
    public void setUp() {
        shield = new Shield();
        ship = new Ship(shield);
    }

    @Test
    public void initializeShip() {
        Assert.assertNotNull(ship.getShield());
        Assert.assertEquals(Ship.initialEnergy, ship.getEnergy());
    }

    @Test
    public void transferMoreEnergyThanShipHas() {
        int initStrength = ship.getShield().getEnergy();
        int initEnergy = 4000;
        ship.setEnergy(initEnergy);
        ship.transferEnergyToShield(initEnergy + 1);
        Assert.assertEquals(initEnergy, ship.getEnergy());
        Assert.assertEquals(initStrength, ship.getShield().getEnergy());
    }

}
