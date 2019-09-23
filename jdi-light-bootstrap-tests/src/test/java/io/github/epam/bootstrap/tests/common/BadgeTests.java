package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.badgeSecondary;
import static io.github.com.pages.BootstrapPage.badgeSuccess;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String badgeSecondaryText = "BADGE";
    String badgeSuccessText = "Github JDI";

    @Test
    public void getTextTest() {
        assertEquals(badgeSecondary.getText(), badgeSecondaryText);
        assertEquals(badgeSecondary.getValue(), badgeSecondaryText);
        assertEquals(badgeSuccess.getText(), badgeSuccessText);
        assertEquals(badgeSuccess.getValue(), badgeSuccessText);
    }

    @Test
    public void simpleVisibilityTest() {
        assertTrue(badgeSecondary.isDisplayed());
        assertTrue(badgeSuccess.isDisplayed());
    }

    @Test
    public void badgeAsLinkTest() {
        badgeSuccess.is().displayed()
                .and().text(is(badgeSuccessText))
                .text(containsString(badgeSuccessText));
    }
}