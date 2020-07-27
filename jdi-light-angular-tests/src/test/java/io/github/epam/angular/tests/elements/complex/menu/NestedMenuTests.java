package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.angular.elements.common.NestedDropdownMenu.NESTED_MENU_VALUES;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class NestedMenuTests extends TestsInit {

    @BeforeTest
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        nestedMenu.show();
    }

    @Test
    public void nestedMenuTest() {
        nestedMenu.is().displayed();
    }

    @Test
    public void checkNestedMenuIsExpandedTest() {
        nestedMenu.expand();
        nestedMenu.is().isExpanded();
    }

    @Test
    public void checkNestedMenuIsClosedTest() {
        nestedMenu.expand();
        nestedMenu.close();
        nestedMenu.is().isClosed();
    }

    @Test
    public void nestedMenuFirstNestingLayerSelectTest() {
        nestedMenu.expand();
        nestedMenu.select("Vertebrates");
        nestedMenuSelectedOption.is().text("Vertebrates");
    }

    @Test
    public void nestedMenuSecondNestingLayerSelectTest() {
        nestedMenu.expand();
        nestedMenu.select("Vertebrates", "Fishes");
        nestedMenuSelectedOption.is().text("Fishes");
    }

    @Test
    public void nestedMenuThirdNestingLayerSelectTest() {
        nestedMenu.expand();
        nestedMenu.select("Vertebrates", "Fishes", "Bala shark");
        nestedMenuSelectedOption.is().text("Bala shark");
    }

    @Test
    public void disabledNestedMenuOptionTest() {
        nestedMenu.expand();
        nestedMenu.is().isDisabledNestedMenuOption("Vertebrates", "Reptiles", "Velociraptor");
    }

    @Test
    public void checkNestedMenuAvailableOptionsTest() {
        String[] expectedList = NESTED_MENU_VALUES;
        nestedMenu.expand();
        List<String> actualList = nestedMenu.valuesForNestedMenu();
        for (int i = 0; i < expectedList.length; i++) {
            nestedMenu.is().checkValue(expectedList[i], actualList.get(i));
        }
    }
}
