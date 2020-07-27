package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.angular.elements.common.NestedDropdownMenu.*;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
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

    @Test
    public void selectByValueTest() {
        basicMenu.show();
        basicMenu.expand();
        basicMenu.select("Item 1");
        assertEquals(basicMenuSelectedOption.getText(), "Item 1");
    }

    @Test
    public void valuesTestForNestedMenu() {
        nestedMenu.show();
        assertEquals(nestedMenu.valuesForNestedMenu(), Arrays.asList(NESTED_MENU_VALUES));
        nestedMenu.close();
    }

    @Test
    public void valuesForMenuWithIconsTest() {
        menuWithIcons.show();
        assertEquals(menuWithIcons.valuesForMenuWithIcons(), Arrays.asList(MENU_WITH_ICONS_VALUES));
        menuWithIcons.close();
    }

    @Test
    public void valuesTest() {
        basicMenu.show();
        assertEquals(basicMenu.values(), Arrays.asList(BASIC_MENU_VALUES));
        basicMenu.close();
    }
}
