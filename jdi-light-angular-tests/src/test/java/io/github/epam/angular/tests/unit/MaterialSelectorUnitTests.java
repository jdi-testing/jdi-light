package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static io.github.com.pages.sections.SelectSection.customPanelStylingSelect;
import static io.github.com.pages.sections.SelectSection.matErrorStateMatcherSelect;
import static io.github.com.pages.sections.SelectSection.multipleSelect;
import static io.github.com.pages.sections.SelectSection.optionGroupsMatSelect;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.BELLSPROUT;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.BULBASAUR;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.CHARMANDER;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.FIRE;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.FLAREON;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.GRASS;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.HORSEA;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.INVALID_OPTION;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.INVALID_SELECTION;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MEW;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MEWTWO;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MUSHROOM;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.ODDISH;
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
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.VALID_OPTION;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.VULPIX;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.WATER;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.getPokemonsMap;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorUnitTests extends TestsInit {
    private String[] multiOptions = new String[3];
    private int[] multiSelect = new int[3];

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void expandedTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertTrue(basicMatSelect.isExpanded());
    }

    @Test
    public void collapsedTest() {
        basicMatSelect.show();
        basicMatSelect.collapse();
        assertTrue(basicMatSelect.isCollapsed());
    }

    @Test
    public void selectByValueTest() {
        basicMatSelect.show();
        basicMatSelect.select(PIZZA);
        assertEquals(basicMatSelect.selected(), PIZZA);
    }

    @Test
    public void selectByIndexTest() {
        basicMatSelect.show();
        basicMatSelect.select(TACOS);
        assertTrue(basicMatSelect.selected(TACOS));
    }

    @Test
    public void multipleSelectByValuesTest() {
        multipleSelect.show();
        multiOptions[0] = MUSHROOM;
        multiOptions[1] = PEPPERONI;
        multiOptions[2] = SAUSAGE;
        multipleSelect.multipleSelect(multiOptions);
        assertEquals(multipleSelect.selected(), multiOptions[0] + ", " + multiOptions[1] + ", " + multiOptions[2]);
    }

    @Test
    public void multipleSelectByIndexesTest() {
        multipleSelect.show();
        multiSelect = new int[] {2, 4, 6};
        multipleSelect.multipleSelect(multiSelect);
        assertEquals(multipleSelect.selected(), MUSHROOM + ", " + PEPPERONI + ", " + TOMATO);
    }

    @Test
    public void valuesTest() {
        multipleSelect.show();
        assertEquals(basicMatSelect.values(), Arrays.asList(STEAK, PIZZA, TACOS));
    }

    @Test
    public void getGroupsTest() {
        optionGroupsMatSelect.show();
        assertEquals(optionGroupsMatSelect.groups(), Arrays.asList(GRASS, WATER, FIRE, PSYCHIC));
    }

    @Test
    public void getGroupsAndOptionsTest() {
        optionGroupsMatSelect.show();
        assertEquals(optionGroupsMatSelect.groupsAndOptions(), getPokemonsMap());
    }

    @Test
    public void listEnabledTest() {
        optionGroupsMatSelect.show();
        assertEquals(optionGroupsMatSelect.listEnabled(),
                     Arrays.asList("-- None --", BULBASAUR, ODDISH, BELLSPROUT, SQUIRTLE, PSYDUCK, HORSEA, MEW,
                                   MEWTWO));
    }

    @Test
    public void listDisabledTest() {
        optionGroupsMatSelect.show();
        assertEquals(optionGroupsMatSelect.listDisabled(), Arrays.asList(CHARMANDER, VULPIX, FLAREON));
    }

    @Test
    public void colorTest() {
        customPanelStylingSelect.show();
        customPanelStylingSelect.select(RED);
        assertTrue(customPanelStylingSelect.color(255, 0, 0, 0.5));
    }

    @Test
    public void hintTest() {
        matErrorStateMatcherSelect.show();
        matErrorStateMatcherSelect.select(VALID_OPTION);
        assertEquals(matErrorStateMatcherSelect.hint().text(), "Errors appear instantly!");
    }

    @Test
    public void errorTest() {
        matErrorStateMatcherSelect.show();
        matErrorStateMatcherSelect.select(INVALID_OPTION);
        assertEquals(matErrorStateMatcherSelect.error().text(), INVALID_SELECTION);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (basicMatSelect.isExpanded()) {
            basicMatSelect.collapse();
        }
        if (multiSelect[0] != 0) {
            multipleSelect.multipleSelect(multiSelect);
            multiSelect = new int[3];
        }
        if (multiOptions[0] != null) {
            multipleSelect.multipleSelect(multiOptions);
            multiOptions[0] = null;
            multiOptions[1] = null;
            multiOptions[2] = null;
        }
    }
}
