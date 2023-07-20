package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.badgePage;
import static io.github.com.pages.BadgePage.textWithBadge;
import static org.testng.Assert.assertTrue;

public class BadgeUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        badgePage.open();
        waitCondition(() -> badgePage.isOpened());
        badgePage.checkOpened();
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
