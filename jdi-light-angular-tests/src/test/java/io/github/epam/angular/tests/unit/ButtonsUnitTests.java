package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;

import static io.github.com.pages.ButtonsPage.defaultColorButton;

import static org.testng.Assert.assertTrue;

public class ButtonsUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test
    public void hasDefaultColor() {
        assertTrue(defaultColorButton.defaultColor());
    }

    @Test
    public void isClickable() {

    }

    @Test
    public void isDisabled() {

    }

    @Test
    public void isDisplayed() {

    }

    @Test
    public void isVisible() {

    }
}
