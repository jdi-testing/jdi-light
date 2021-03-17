package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.angular.elements.complex.NestedDropdownMenu.NESTED_MENU_VALUES;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.MenuSection.nestedMenuButton;
import static io.github.com.pages.sections.MenuSection.nestedMenuSelectedOption;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class NestedMenuTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        nestedMenuButton.show();
    }

    @Test
    public void nestedMenuTest() {
        nestedMenuButton.is().displayed();
    }

    @Test
    public void checkNestedMenuIsExpandedTest() {
        nestedMenuButton.expand();
        nestedMenuButton.is().isExpanded();
    }

    @Test
    public void checkNestedMenuIsClosedTest() {
        nestedMenuButton.expand();
        nestedMenuButton.close();
        nestedMenuButton.is().isClosed();
    }

    @Test
    public void nestedMenuFirstNestingLayerSelectTest() {
        nestedMenuButton.expand();
        nestedMenuButton.select("Vertebrates ");
        nestedMenuSelectedOption.is().text("Vertebrates");
    }

    @Test
    public void nestedMenuSecondNestingLayerSelectTest() {
        nestedMenuButton.expand();
        nestedMenuButton.select("Vertebrates ", "Fishes");
        nestedMenuSelectedOption.is().text("Fishes");
    }

    @Test
    public void nestedMenuThirdNestingLayerSelectTest() {
        nestedMenuButton.expand();
        nestedMenuButton.select("Vertebrates ", "Fishes", "Bala shark");
        nestedMenuSelectedOption.is().text("Bala shark");
    }

    @Test
    public void disabledNestedMenuOptionTest() {
        nestedMenuButton.expand();
        nestedMenuButton.is().isDisabledNestedMenuOption("Vertebrates ", "Reptiles", "Velociraptor");
    }

    @Test
    public void checkNestedMenuAvailableOptionsTest() {
        String[] expectedList = NESTED_MENU_VALUES;
        nestedMenuButton.expand();
        List<String> actualList = nestedMenuButton.valuesForNestedMenu();
        for (int i = 0; i < expectedList.length; i++) {
            nestedMenuButton.is().checkValue(expectedList[i], actualList.get(i));
        }
    }
}
