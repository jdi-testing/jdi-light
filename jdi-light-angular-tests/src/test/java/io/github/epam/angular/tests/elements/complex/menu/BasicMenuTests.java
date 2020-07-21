package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.basicMenu;
import static io.github.com.pages.sections.MenuSection.basicMenuSelectedOption;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BasicMenuTests extends TestsInit {

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
        basicMenu.is().isExpanded();
    }

    @Test
    public void checkBasicMenuIsClosedTest() {
        basicMenu.expandMenu();
        basicMenu.closeMenu();
        basicMenu.is().isClosed();
    }

    @Test
    public void basicMenuSelectTest() {
        basicMenu.select("Item 1");
        basicMenuSelectedOption.is().text("Item 1");
    }

    @Test
    public void checkBasicMenuAvailableOptionsTest() {
        String[] expectedList = {"Item 1", "Item 2"};
        basicMenu.expandMenu();
        List<String> actualList = basicMenu.values();
        for (int i = 0; i < expectedList.length; i++) {
            basicMenu.is().checkValue(expectedList[i], (actualList.get(i)));
        }
    }
}


