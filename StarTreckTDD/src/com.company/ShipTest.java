package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    private Ship ship;

    @Before // = "background" in Gherkin
    public void setUp() {
        ship = new Ship(new Shield());
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

    @Test
    public void transferEnergyToShield() {
        int shipEnergy = 50000;
        int shieldEnergy = ship.getShield().getEnergy();
        int transferEnergy = 1000;
        ship.setEnergy(shipEnergy);
        ship.transferEnergyToShield(transferEnergy);
        Assert.assertEquals(shipEnergy - transferEnergy, ship.getEnergy());
        Assert.assertEquals(shieldEnergy + transferEnergy, ship.getShield().getEnergy());
    }

}
