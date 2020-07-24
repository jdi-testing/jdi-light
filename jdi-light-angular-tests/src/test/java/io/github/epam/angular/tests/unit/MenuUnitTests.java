package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.basicMenu;
import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class MenuUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedTest() {
        basicMenu.show();
        assertTrue(basicMenu.isDisplayed());
    }

    @Test
    public void expandTest() {
        basicMenu.show();
        basicMenu.expand();
        assertTrue(basicMenu.isExpanded());
        basicMenu.close();
    }

    @Test
    public void closedTest() {
        basicMenu.show();
        basicMenu.expand();
        basicMenu.close();
        assertTrue(basicMenu.isClosed());
    }
}
