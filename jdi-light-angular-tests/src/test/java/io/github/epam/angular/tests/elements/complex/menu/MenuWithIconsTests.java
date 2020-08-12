package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.angular.elements.common.NestedDropdownMenu.MENU_WITH_ICONS_VALUES;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class MenuWithIconsTests extends TestsInit {

    @BeforeMethod (alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        menuWithIcons.show();
    }

    @Test
    public void menuWithIconsTest() {
        menuWithIcons.is().displayed();
    }

    @Test
    public void checkMenuWithIconsIsExpandedTest() {
        menuWithIcons.expand();
        menuWithIcons.is().isExpanded();
    }

    @Test
    public void checkMenuWithIconsIsClosedTest() {
        menuWithIcons.expand();
        menuWithIcons.close();
        menuWithIcons.is().isClosed();
    }

    @Test
    public void menuWithIconsSelectTest() {
        menuWithIcons.expand();
        menuWithIcons.selectForMenuWithIcons("Redial");
        iconsMenuSelectedOption.is().text("Redial");
    }

    @Test
    public void disabledMenuWithIconsOptionTest() {
        menuWithIcons.expand();
        menuWithIcons.is().isDisabledMenuWithIconsOption("Check voice mail");
    }

    @Test
    public void checkMenuWithIconsAvailableOptionsTest() {
        String[] expectedList = MENU_WITH_ICONS_VALUES;
        List<String> actualList = menuWithIcons.valuesForMenuWithIcons();
        menuWithIcons.expand();
        for (int i = 0; i < expectedList.length; i++) {
            menuWithIcons.checkValue(expectedList[i], actualList.get(i));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (menuWithIcons.isExpanded()){
            menuWithIcons.close();
        }
    }
}
