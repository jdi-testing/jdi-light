package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.angular.elements.complex.NestedDropdownMenu.*;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedTest() {
        basicMenuButton.show();
        assertTrue(basicMenuButton.isDisplayed());
    }

    @Test
    public void expandTest() {
        basicMenuButton.show();
        basicMenuButton.expand();
        assertTrue(basicMenuButton.isExpanded());
    }

    @Test
    public void closedTest() {
        basicMenuButton.show();
        basicMenuButton.expand();
        basicMenuButton.close();
        assertTrue(basicMenuButton.isClosed());
    }

    @Test
    public void selectByValueTest() {
        basicMenuButton.show();
        basicMenuButton.expand();
        basicMenuButton.select("Item 1");
        assertEquals(basicMenuSelectedOption.getText(), "Item 1");
    }

    @Test
    public void valuesTestForNestedMenu() {
        nestedMenuButton.show();
        assertEquals(nestedMenuButton.valuesForNestedMenu(), Arrays.asList(NESTED_MENU_VALUES));
    }

    @Test
    public void valuesForMenuWithIconsTest() {
        menuWithIconsButton.show();
        assertEquals(menuWithIconsButton.valuesForMenuWithIcons(), Arrays.asList(MENU_WITH_ICONS_VALUES));
    }

    @Test
    public void valuesTest() {
        basicMenuButton.show();
        assertEquals(basicMenuButton.values(), Arrays.asList(BASIC_MENU_VALUES));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (basicMenuButton.isExpanded()) {
            basicMenuButton.close();
        }
        if (menuWithIconsButton.isExpanded()) {
            menuWithIconsButton.close();
        }
        if (nestedMenuButton.isExpanded()) {
            nestedMenuButton.close();
        }
    }
}
