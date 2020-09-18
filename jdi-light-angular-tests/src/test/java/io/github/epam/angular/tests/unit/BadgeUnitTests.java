package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BadgeSection.textWithBadge;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class BadgeUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void badgeTest() {
        assertTrue(textWithBadge.badge().isDisplayed());
    }

    @Test
    public void colorTest() {
        assertTrue(textWithBadge.color("Violet"));
    }
}
