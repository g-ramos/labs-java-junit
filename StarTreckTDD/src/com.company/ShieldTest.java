package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShieldTest {

    private Shield shield;

    @Before // = "background" in Gherkin
    public void setUp() {
        shield = new Shield();
    }

    @Test
    public void shiedDownByDefault() {
        Assert.assertFalse(shield.isRaised());
    }

    @Test
    public void shieldCanBeRaise() {
        shield.raise();
        Assert.assertTrue(shield.isRaised());
    }

    @Test
    public void initialShieldStrength() {
        Assert.assertEquals(Shield.INIT_ENERGY, shield.getEnergy());
    }

    @Test
    public void addStrength() {
        int expectedStrength = Shield.INIT_ENERGY + 10;
        shield.addEnergy(10);
        Assert.assertEquals(expectedStrength , shield.getEnergy());
    }

    @Test
    public void shieldIsNotEnabledWhenThereIsNoBatteryLeft() {
        int currentShieldEnergy = shield.getEnergy();
        shield.addEnergy( -currentShieldEnergy );

        shield.raise();

        Assert.assertFalse(shield.isRaised());
    }

}
