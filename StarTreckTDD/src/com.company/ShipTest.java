package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    private Ship ship;

    @Before // = "background" in Gherkin
    public void setUp() {
        ship = new Ship(new Shield()); // todo can hang on to shield
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
        Assert.assertEquals(shipEnergy - transferEnergy, ship.getEnergy()); // todo can do math yourself
        Assert.assertEquals(shieldEnergy + transferEnergy, ship.getShield().getEnergy());
    }

    @Test
    public void transferExcessEnergy() {
        // initialize state for test
        int initialShipEnergy = 10000;
        ship.setEnergy(initialShipEnergy);
        ship.getShield().addEnergy(3000); // shield initially at 5000 + 3000 = 8000 initial energy

        // shield can have maximum of 10000 energy so transferring 5000 to a shield with 8000 will result in leftover
        int energyRequestedToTransfer = 5000;
        ship.transferEnergyToShield(energyRequestedToTransfer); // shield should be at 10000 (max) and ship should have 8000

        int energyOverCapacity = 3000; // = current shield + energy transferred - max shield

        Assert.assertEquals(Shield.MAX_ENERGY, ship.getShield().getEnergy());
        Assert.assertEquals(initialShipEnergy - energyRequestedToTransfer + energyOverCapacity, ship.getEnergy());
    }

    @Test
    public void transferEnergyFromShieldToShip() {
        ship.setEnergy(50_000);
        ship.transferEnergyToShield(-1000);
        int expectedShieldEnergy = Shield.INIT_ENERGY - 1000;
        int expectedShipEnergy = 50_000 + 1000;
        Assert.assertEquals(expectedShieldEnergy, ship.getShield().getEnergy());
        Assert.assertEquals(expectedShipEnergy, ship.getEnergy());
    }


}
