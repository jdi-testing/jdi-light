package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.angular.elements.complex.NestedDropdownMenu.BASIC_MENU_VALUES;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.basicMenuButton;
import static io.github.com.pages.sections.MenuSection.basicMenuSelectedOption;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BasicMenuTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        basicMenuButton.show();
    }

    @Test
    public void basicMenuTest() {
        basicMenuButton.is().displayed();
    }

    @Test
    public void checkBasicMenuIsExpandedTest() {
        basicMenuButton.expand();
        basicMenuButton.is().isExpanded();
    }

    @Test
    public void checkBasicMenuIsClosedTest() {
        basicMenuButton.expand();
        basicMenuButton.close();
        basicMenuButton.is().isClosed();
    }

    @Test
    public void basicMenuSelectTest() {
        basicMenuButton.select("Item 1");
        basicMenuSelectedOption.is().text("Item 1");
    }

    @Test
    public void checkBasicMenuAvailableOptionsTest() {
        String[] expectedList = BASIC_MENU_VALUES;
        basicMenuButton.expand();
        List<String> actualList = basicMenuButton.values();
        for (int i = 0; i < expectedList.length; i++) {
            basicMenuButton.is().checkValue(expectedList[i], (actualList.get(i)));
        }
    }
}
