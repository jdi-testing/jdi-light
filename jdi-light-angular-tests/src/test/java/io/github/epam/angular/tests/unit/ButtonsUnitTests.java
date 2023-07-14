package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.basicBasicButton;
import static io.github.com.pages.ButtonsPage.raisedPrimaryButton;
import static io.github.com.pages.ButtonsPage.flatWarnButton;
import static io.github.com.pages.ButtonsPage.fabLinkButton;
import static io.github.com.pages.ButtonsPage.basicDisabledButton;
import static io.github.com.pages.ButtonsPage.iconPrimaryButton;
import static io.github.com.pages.ButtonsPage.miniFabHeartButton;
import static io.github.com.pages.ButtonsPage.strokedAccentButton;
import static org.testng.Assert.assertTrue;

public class ButtonsUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test
    public void isDisplayed() {
        assertTrue(basicBasicButton.isDisplayed());
        assertTrue(basicDisabledButton.isDisplayed());
        assertTrue(raisedPrimaryButton.isDisplayed());
        assertTrue(strokedAccentButton.isDisplayed());
        assertTrue(flatWarnButton.isDisplayed());
        assertTrue(iconPrimaryButton.isDisplayed());
        assertTrue(fabLinkButton.isDisplayed());
        assertTrue(miniFabHeartButton.isDisplayed());
    }

    @Test
    public void isVisible() {
        assertTrue(basicBasicButton.isVisible());
        assertTrue(basicDisabledButton.isVisible());
        assertTrue(raisedPrimaryButton.isVisible());
        assertTrue(strokedAccentButton.isVisible());
        assertTrue(flatWarnButton.isVisible());
        assertTrue(iconPrimaryButton.isVisible());
        assertTrue(fabLinkButton.isVisible());
        assertTrue(miniFabHeartButton.isVisible());
    }

    @Test
    public void isClickable() {

    }
}
