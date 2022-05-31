package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.dividerSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DividerUnitTests extends TestsInit {

    public static final String ORIENTATION_ATTRIBUTE = "aria-orientation";
    public static final String HORIZONTAL_VALUE = "horizontal";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayTest() {
        assertEquals(dividerSection.dividers.size(), 2);
        assertTrue(dividerSection.dividers.get(1).isDisplayed());
        assertTrue(dividerSection.dividers.get(2).isDisplayed());
    }

    @Test
    public void orientationTest() {
        assertEquals(dividerSection.dividers.get(1).attr(ORIENTATION_ATTRIBUTE), HORIZONTAL_VALUE);
        assertEquals(dividerSection.dividers.get(2).attr(ORIENTATION_ATTRIBUTE), HORIZONTAL_VALUE);
    }
}
