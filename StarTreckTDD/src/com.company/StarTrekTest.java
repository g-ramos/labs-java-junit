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
    public void addStrengthMultipleTimes() {
        int expectedStrength = Shield.initStrength + 23;
        shield.addStrength(10);
        shield.addStrength(8);
        shield.addStrength(5);
        Assert.assertEquals(expectedStrength , shield.getStrength());
    }


}
