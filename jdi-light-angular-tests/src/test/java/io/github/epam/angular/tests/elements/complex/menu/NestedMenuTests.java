package io.github.epam.angular.tests.elements.complex.menu;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

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
        String[] expectedList = {"[Vertebrates, Invertebrates]",
                "[Fishes, Amphibians, Reptiles, Birds, Mammals]",
                "[Baikal oilfish, Bala shark, Ballan wrasse, Bamboo shark, Banded killifish]",
                "[Sonoran desert toad, Western toad, Arroyo toad, Yosemite toad]",
                "[Banded Day Gecko, Banded Gila Monster, Black Tree Monitor, Blue Spiny Lizard, Velociraptor]",
                "[Insects, Molluscs, Crustaceans, Corals, Arachnids, Velvet worms, Horseshoe crabs]"};
        nestedMenu.expand();
        List<String> actualList = nestedMenu.valuesForNestedMenu();
        for (int i = 0; i < expectedList.length; i++) {
            nestedMenu.is().checkValue(expectedList[i], actualList.get(i));
        }
    }
}
