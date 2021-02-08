package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.*;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaterialSelectorUnitTests extends TestsInit {
    private final String[] multiOptions = new String[3];

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

    @Test(enabled = false)
    // duplicated. Page should be reload for this test, skip to increase performance
    public void multipleSelectByIndexesTest() {
        multipleSelect.show();
        int[] multiSelect = new int[] {2, 4, 6};
        multipleSelect.multipleSelect(multiSelect);
        assertEquals(multipleSelect.selected(), MUSHROOM + ", " + PEPPERONI + ", " + TOMATO);
    }

    @Test
    public void valuesTest() {
        multipleSelect.show();
        assertEquals(basicMatSelect.values(), asList(STEAK, PIZZA, TACOS));
    }

    @Test
    public void getGroupsTest() {
        optionGroupsMatSelect.show();
        assertEquals(optionGroupsMatSelect.groups(), asList(GRASS, WATER, FIRE, PSYCHIC));
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
            asList("-- None --", BULBASAUR, ODDISH, BELLSPROUT, SQUIRTLE, PSYDUCK, HORSEA, MEW, MEWTWO));
    }

    @Test
    public void listDisabledTest() {
        optionGroupsMatSelect.show();
        assertEquals(optionGroupsMatSelect.listDisabled(), asList(CHARMANDER, VULPIX, FLAREON));
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
