package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class MenuWithIconsTests extends TestsInit {

    @BeforeTest
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
    public void checkBasicMenuIsExpandedTest() {
        menuWithIcons.expandMenu();
        menuWithIcons.is().isExpanded();
    }

    @Test
    public void checkBasicMenuIsClosedTest() {
        menuWithIcons.expandMenu();
        menuWithIcons.closeMenu();
        menuWithIcons.is().isClosed();
    }

    @Test
    public void menuWithIconsSelectTest() {
        menuWithIcons.expandMenu();
        menuWithIcons.selectForMenuWithIcons("Redial");
        iconsMenuSelectedOption.is().text("Redial");
    }

    @Test
    public void disabledMenuWithIconsOptionTest() {
        menuWithIcons.expandMenu();
        menuWithIcons.is().isDisabledMenuWithIconsOption("Check voice mail");
    }

    @Test
    public void checkBasicMenuAvailableOptionsTest() {
        String[] expectedList = {"Redial", "Check voice mail", "Disable alerts"};
        List<String> actualList = menuWithIcons.valuesForMenuWithIcons();
        menuWithIcons.expandMenu();
        for (int i = 0; i < expectedList.length; i++) {
            menuWithIcons.checkValue(expectedList[i], actualList.get(i));
        }
    }
}
