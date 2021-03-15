package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.rippleContainer;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class RippleUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        rippleContainer.show();
    }

    @Test
    public void displayedTest() {
        assertTrue(rippleContainer.isDisplayed());
    }

    @Test
    public void disabledTest() {
        rippleContainer.disable();
        assertTrue(rippleContainer.isDisabled());
        rippleContainer.enable();
        assertTrue(rippleContainer.isEnabled());
    }

    @Test
    public void unboundedTest() {
        rippleContainer.unbound();
        assertTrue(rippleContainer.isUnbounded());
    }

    @Test
    public void centeredTest() {
        rippleContainer.center();
        assertTrue(rippleContainer.isCentered());
    }

    @Test
    public void rippleActionTest() {
        rippleContainer.ripple();
        assertTrue(rippleContainer.isActive());
    }

    @Test
    public void radiusTest() {
        int expectedRadius = 200;
        rippleContainer.setRadius(expectedRadius);
        assertTrue(rippleContainer.isRadius(expectedRadius));
    }

    @Test
    public void rippleRadiusTest() {
        int expectedRadius = 195;
        rippleContainer.setRadius(expectedRadius);
        assertEquals(rippleContainer.radius(), expectedRadius, "The radius has an incorrect value");
    }

    @Test
    public void rippleCorrectRadiusTest() {
        rippleContainer.setRadius(0);
        assertTrue(rippleContainer.isCorrectRadius());
    }

    @Test
    public void rippleNotCorrectRadiusTest() {
        rippleContainer.setRadius(-1);
        assertFalse(rippleContainer.isCorrectRadius());
    }

    @Test
    public void colorTest() {
        String expectedColor = "Green";
        rippleContainer.setColor(expectedColor);
        assertTrue(rippleContainer.isColor(expectedColor.toLowerCase()));
    }

    @Test
    public void rippleCorrectColorTest() {
        rippleContainer.setColor("rgba(0, 0, 0)");
        assertTrue(rippleContainer.isCorrectColor());
    }

    @Test
    public void rippleNotCorrectColorTest() {
        rippleContainer.setColor("custom color");
        assertFalse(rippleContainer.isCorrectColor());
    }

    @Test
    public void rippleColorTest() {
        String expectedColor = "AqUaMaRiNe";
        rippleContainer.setColor(expectedColor);
        assertEquals(rippleContainer.color(), expectedColor.toLowerCase(), "The color has an incorrect value");
    }

    @Test
    public void rippleRgbaColorTest() {
        String expectedColor = "rgba(200, 100, 50, 0.5)";
        rippleContainer.setColor(expectedColor);
        assertEquals(rippleContainer.color(), expectedColor, "The color has an incorrect value");
    }

    @Test
    public void mouseClickCenteredTest() {
        refresh();
        rippleContainer.center();
        int x = 179;
        int y = 243;
        rippleContainer.ripple(x, y);
        assertTrue(rippleContainer.isCentered());
    }

    @Test(enabled = false)
    public void randomMouseClickTest() {
        refresh();
        rippleContainer.show();
        rippleContainer.center();
        int x = RandomUtils.nextInt(0, 299);
        int y = RandomUtils.nextInt(0, 299);
        rippleContainer.ripple(x, y);
        assertTrue(rippleContainer.isRippleCenter(x, y));
    }
}
