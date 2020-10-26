package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.angular.elements.complex.NestedDropdownMenu.MENU_WITH_ICONS_VALUES;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.iconsMenuSelectedOption;
import static io.github.com.pages.sections.MenuSection.menuWithIconsButton;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class MenuWithIconsTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.open();
        menuWithIconsButton.show();
    }

    @Test
    public void menuWithIconsTest() {
        menuWithIconsButton.is().displayed();
    }

    @Test
    public void checkMenuWithIconsIsExpandedTest() {
        menuWithIconsButton.expand();
        menuWithIconsButton.is().isExpanded();
    }

    @Test
    public void checkMenuWithIconsIsClosedTest() {
        menuWithIconsButton.expand();
        menuWithIconsButton.close();
        menuWithIconsButton.is().isClosed();
    }

    @Test
    public void menuWithIconsSelectTest() {
        menuWithIconsButton.expand();
        menuWithIconsButton.selectForMenuWithIcons("Redial");
        iconsMenuSelectedOption.is().text("Redial");
    }

    @Test
    public void disabledMenuWithIconsOptionTest() {
        menuWithIconsButton.expand();
        menuWithIconsButton.is().isDisabledMenuWithIconsOption("Check voice mail");
    }

    @Test
    public void checkMenuWithIconsAvailableOptionsTest() {
        String[] expectedList = MENU_WITH_ICONS_VALUES;
        List<String> actualList = menuWithIconsButton.valuesForMenuWithIcons();
        menuWithIconsButton.expand();
        for (int i = 0; i < expectedList.length; i++) {
            menuWithIconsButton.checkValue(expectedList[i], actualList.get(i));
        }
    }
}
