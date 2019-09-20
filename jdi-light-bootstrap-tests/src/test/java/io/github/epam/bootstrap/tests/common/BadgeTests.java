package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.badgeSecondary;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String text = "BADGE";

    @Test
    public void getTextTest() {
        assertEquals(badgeSecondary.getText(), text);
    }

    @Test
    public void simpleVisibilityTest() {
        assertTrue(badgeSecondary.isDisplayed());
    }
}
