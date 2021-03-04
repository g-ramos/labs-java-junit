package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StarTrekTest {

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

}
