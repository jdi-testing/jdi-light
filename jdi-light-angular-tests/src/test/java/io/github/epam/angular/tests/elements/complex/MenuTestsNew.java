package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.menuSection;
import static io.github.com.pages.sections.MenuSectionNew.basicMenu;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class MenuTestsNew extends TestsInit {

    @BeforeTest
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        basicMenu.show();
    }

    @Test
    public void basicMenuTest() {
        basicMenu.is().displayed();
    }

    @Test
    public void checkBasicMenuIsExpandedTest() {
        basicMenu.expandMenu();
        assertTrue(basicMenu.isExpanded());
    }

    @Test
    public void checkBasicMenuIsClosedTest() {
        basicMenu.expandMenu();
        basicMenu.closeMenu();
        assertTrue(basicMenu.isClosed());
    }

    @Test
    public void basicMenuSelectTest() {
        menuSection.basicMenu.select("Item 1");
        menuSection.basicMenuSelectedOption.is().text("Item 1");
    }

    @Test
    public void checkBasicMenuAvailableOptionsTest() {
        menuSection.basicMenu.expandMenu();

    }
}


