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
        Assert.assertEquals(Shield.initStrength, shield.getStrength());
    }

    @Test
    public void addStrength() {
        int expectedStrength = Shield.initStrength + 10;
        shield.addStrength(10);
        Assert.assertEquals(expectedStrength , shield.getStrength());
    }

    @Test
    public void shieldIsNotEnabledWhenThereIsNoBatteryLeft() {
        int currentShieldEnergy = shield.getStrength();
        shield.addStrength( -currentShieldEnergy );

        shield.raise();

        Assert.assertFalse(shield.isRaised());
    }

}
