package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static io.github.com.pages.sections.SelectSection.customPanelStylingSelect;
import static io.github.com.pages.sections.SelectSection.multipleSelect;
import static io.github.com.pages.sections.SelectSection.optionGroupsMatSelect;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.BELLSPROUT;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.BULBASAUR;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.CHARMANDER;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.EXTRA_CHEESE;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.FIRE;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.FLAREON;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.GRASS;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.HORSEA;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MEW;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MEWTWO;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MUSHROOM;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.ODDISH;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.ONION;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.PEPPERONI;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.PIZZA;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.PSYCHIC;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.PSYDUCK;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.RED;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.SAUSAGE;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.SQUIRTLE;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.STEAK;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.TACOS;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.TOMATO;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.VULPIX;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.WATER;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.getPokemonsMap;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorContainerUnitTests extends TestsInit {
    private MaterialSelectorContainer container;
    private String[] multiOptions = new String[3];
    private int[] multiSelect = new int[3];

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        container = new MaterialSelectorContainer();
    }

    @Test
    public void displayedTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertTrue(container.isDisplayed());
        container.collapsePanel();
    }

    @Test
    public void hiddenTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        container.collapsePanel();
        assertTrue(container.isHidden());
    }

    @Test
    public void listSizeTest() {
        assertEquals(container.list().size(), new WebList(By.cssSelector("mat-option span")).size());
    }

    @Test
    public void listHtmlTest() {
        WebList webList = new WebList(By.cssSelector("mat-option span"));
        for (int i = 1; i <= container.list().size(); i++) {
            assertEquals(container.list().get(i).printHtml(), webList.get(i).printHtml());
        }
    }

    @Test
    public void selectByValueTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        container.select(TACOS);
        assertTrue(basicMatSelect.selected(TACOS));
    }

    @Test
    public void selectByIndexTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        container.select(1);
        assertTrue(basicMatSelect.selected(STEAK));
    }

    @Test
    public void multipleSelectByValuesTest() {
        multipleSelect.show();
        multipleSelect.expand();
        multiOptions[0] = MUSHROOM;
        multiOptions[1] = PEPPERONI;
        multiOptions[2] = TOMATO;
        container.multipleSelect(multiOptions);
        assertTrue(multipleSelect.selected(multiOptions[0] + ", " + multiOptions[1] + ", " + multiOptions[2]));
    }

    @Test
    public void multipleSelectByIndexesTest() {
        multipleSelect.show();
        multipleSelect.expand();
        multiSelect = new int[] {1, 3, 5};
        container.multipleSelect(multiSelect);
        assertTrue(multipleSelect.selected(EXTRA_CHEESE + ", " + ONION + ", " + SAUSAGE));
    }

    @Test
    public void valuesTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertEquals(container.values(), Arrays.asList(STEAK, PIZZA, TACOS));
    }

    @Test
    public void getGroupsTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.getGroups(), Arrays.asList(GRASS, WATER, FIRE, PSYCHIC));
    }

    @Test
    public void getMapGroupsAndOptionsTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.getMapGroupsAndOptions(), getPokemonsMap());
    }

    @Test
    public void listEnabledTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.listEnabled(),
                     Arrays.asList("-- None --", BULBASAUR, ODDISH, BELLSPROUT, SQUIRTLE, PSYDUCK, HORSEA, MEW,
                                   MEWTWO));
    }

    @Test
    public void listDisabledTest() {
        optionGroupsMatSelect.show();
        optionGroupsMatSelect.expand();
        assertEquals(container.listDisabled(), Arrays.asList(CHARMANDER, VULPIX, FLAREON));
    }

    @Test
    public void colorTest() {
        customPanelStylingSelect.show();
        customPanelStylingSelect.select(RED);
        customPanelStylingSelect.expand();
        assertTrue(container.color(255, 0, 0, 0.5));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (multiSelect[0] != 0) {
            multipleSelect.expand();
            container.multipleSelect(multiSelect);
            multiSelect = new int[3];
        }
        if (multiOptions[0] != null) {
            multipleSelect.expand();
            container.multipleSelect(multiOptions);
            multiOptions[0] = null;
            multiOptions[1] = null;
            multiOptions[2] = null;
        }
    }
}
