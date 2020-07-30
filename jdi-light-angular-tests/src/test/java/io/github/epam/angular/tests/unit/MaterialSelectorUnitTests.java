package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.*;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorUnitTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void expandedTest() {
        basicMatSelect.show();
        basicMatSelect.expand();
        assertTrue(basicMatSelect.isExpanded());
        basicMatSelect.collapse();
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
        multipleSelect.multipleSelect(MUSHROOM, PEPPERONI, SAUSAGE);
        assertEquals(multipleSelect.selected(), MUSHROOM + ", " + PEPPERONI + ", " + SAUSAGE);
        multipleSelect.multipleSelect(MUSHROOM, PEPPERONI, SAUSAGE);
    }

    @Test
    public void multipleSelectByIndexesTest() {
        multipleSelect.show();
        multipleSelect.multipleSelect(2, 4, 6);
        assertEquals(multipleSelect.selected(), MUSHROOM + ", " + PEPPERONI + ", " + TOMATO);
        multipleSelect.multipleSelect(MUSHROOM, PEPPERONI, TOMATO);
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
}
