package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jdiai.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.autocompleteSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.*;

public class AutocompleteUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void getPlaceHolderValueTest() {
        assertEquals(autocompleteSection.
                autocompleteOverview.placeholder(), "State");
        autocompleteSection.autocompleteDisableInput.check();
        assertEquals(autocompleteSection.
                autocompleteOverview.placeholder(), "State");
        autocompleteSection.autocompleteDisableInput.uncheck();
        assertEquals(autocompleteSection.
                simpleAutocomplete.placeholder(), "Pick one");
    }

    @Test
    public void getDisplayValueTest() {
        assertEquals(autocompleteSection.
                displayValueAutocomplete.displayValue(), "Assignee");
        autocompleteSection.displayValueAutocomplete.setUniqueAutoCompleteAttribute("_ngcontent");
        autocompleteSection.
                displayValueAutocomplete.setValue("Mar", "Mary");
        assertEquals(autocompleteSection.
                displayValueAutocomplete.displayValue(), "Assignee");
        autocompleteSection.displayValueAutocomplete.clear();
    }

    @Test
    public void inputOverviewSelectTest() {
        autocompleteSection.autocompleteOverview.
                setValue("Ark",
                        "ArkansasPopulation: 2.978M");
        assertEquals(autocompleteSection.autocompleteOverview.getValue(), "Arkansas");
    }

    @Test
    public void clickOverviewSelectTest() {
        autocompleteSection.autocompleteOverview.
                setValue("TexasPopulation: 27.47M");
        assertEquals(autocompleteSection.autocompleteOverview.getValue(), "Texas");
    }

    @Test
    public void simpleAutocompleteGetItemsValuesTest() {
        String expectedValuesArray[] = {"One", "Two", "Three"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        assertEquals(autocompleteSection.
                        simpleAutocomplete.
                options(),
                expectedValues);
    }

    @Test
    public void optionGroupsAutocompleteGetItemsValuesTest() {
        String expectedValuesArray[] = {"California", "Colorado", "Connecticut"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        assertEquals(autocompleteSection.
                        optionGroupsAutocomplete.
                options("C"),
                expectedValues);
    }

    @Test
    public void disabledInputThrowsExceptionUponInputTest() {
        autocompleteSection.autocompleteOverview.clear();
        autocompleteSection.autocompleteDisableInput.check();
        autocompleteSection.autocompleteOverview.waitFor(2);
        try {
            autocompleteSection.
                    autocompleteOverview.
                    setValue("Ark",
                            "ArkansasPopulation: 2.978M");
        } catch (Exception e) {
            assertThat(safeException(e), containsString("Element is not currently interactable"));
        }
        autocompleteSection.autocompleteDisableInput.uncheck();
    }

    @Test
    public void getGroupsValuesTest() {
        autocompleteSection.autocompleteOverview.clear();
        autocompleteSection.autocompleteOverview.click();
        assertEquals(autocompleteSection.
            autocompleteOverview.groups(), Collections.emptyList());
        autocompleteSection.optionGroupsAutocomplete.clear();
        autocompleteSection.optionGroupsAutocomplete.click();
        String[] values = {"A", "C", "D", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W"};
        List<String> groupsValues = Arrays.asList(values);
        assertEquals(autocompleteSection.
                optionGroupsAutocomplete.groups(), groupsValues);
        autocompleteSection.optionGroupsAutocomplete.input("C");
        assertEquals(autocompleteSection.
                optionGroupsAutocomplete.groups(), Arrays.asList(new String[]{"C"}));
    }

    @Test
    public void getGroupsAndOptionsValuesTest() {
        Map<String, List<String>> emptyGroupAndOptionsValues = new HashMap<>();
        emptyGroupAndOptionsValues.put("", Collections.emptyList());
        autocompleteSection.optionGroupsAutocomplete.input("B");
        assertEquals(autocompleteSection.
            optionGroupsAutocomplete.groupsAndOptionsValues(), emptyGroupAndOptionsValues);
        autocompleteSection.optionGroupsAutocomplete.input("C");
        Map<String, List<String>> groupAndOptionsValues = new HashMap<>();
        String[] options = {"California", "Colorado", "Connecticut"};
        List<String> optionsValues = Arrays.asList(options);
        groupAndOptionsValues.put("C", optionsValues);
        assertEquals(autocompleteSection.
                optionGroupsAutocomplete.groupsAndOptionsValues(), groupAndOptionsValues);
    }

    @Test
    public void clearTest() {
        autocompleteSection.simpleAutocomplete.setValue("Two");
        autocompleteSection.simpleAutocomplete.clear();
        assertEquals(autocompleteSection.simpleAutocomplete.getValue(), "");
    }

    @Test
    public void isMandatoryTest() {
        assertFalse(autocompleteSection.autocompleteOverview.isMandatory());
        assertFalse(autocompleteSection.simpleAutocomplete.isMandatory());
        assertTrue(autocompleteSection.optionGroupsAutocomplete.isMandatory());
    }

    @Test
    public void isInvalidatedTest() {
        autocompleteSection.autocompleteOverview.click();
        assertFalse(autocompleteSection.autocompleteOverview.isInvalidated());
        autocompleteSection.optionGroupsAutocomplete.setValue("Florida");
        autocompleteSection.optionGroupsAutocomplete.clear();
        assertTrue(autocompleteSection.optionGroupsAutocomplete.isInvalidated());
    }

    @Test
    public void isEnabledTest() {
        assertTrue(autocompleteSection.autocompleteOverview.isEnabled());
        assertTrue(autocompleteSection.simpleAutocomplete.isEnabled());
        assertTrue(autocompleteSection.displayValueAutocomplete.isEnabled());
        assertTrue(autocompleteSection.filterAutocomplete.isEnabled());
        assertTrue(autocompleteSection.optionGroupsAutocomplete.isEnabled());
        assertTrue(autocompleteSection.autocompleteFirstOptionHighlighted.isEnabled());
    }

    @Test
    public void isDisabledTest() {
        autocompleteSection.autocompleteDisableInput.check();
        assertTrue(autocompleteSection.autocompleteOverview.isDisabled());
        autocompleteSection.autocompleteDisableInput.uncheck();
    }

    @Test
    public void isExpandedTest() {
        autocompleteSection.autocompleteOverview.click();
        assertTrue(autocompleteSection.autocompleteOverview.expanded());
        autocompleteSection.simpleAutocomplete.click();
        assertTrue(autocompleteSection.simpleAutocomplete.expanded());
        autocompleteSection.displayValueAutocomplete.click();
        assertTrue(autocompleteSection.displayValueAutocomplete.expanded());
        autocompleteSection.filterAutocomplete.click();
        assertTrue(autocompleteSection.filterAutocomplete.expanded());
        autocompleteSection.optionGroupsAutocomplete.click();
        assertTrue(autocompleteSection.optionGroupsAutocomplete.expanded());
        autocompleteSection.autocompleteFirstOptionHighlighted.click();
        assertTrue(autocompleteSection.autocompleteFirstOptionHighlighted.expanded());
    }

    @Test
    public void isCollapsedTest() {
        assertTrue(autocompleteSection.autocompleteOverview.collapsed());
        assertTrue(autocompleteSection.simpleAutocomplete.collapsed());
        assertTrue(autocompleteSection.displayValueAutocomplete.collapsed());
        assertTrue(autocompleteSection.filterAutocomplete.collapsed());
        assertTrue(autocompleteSection.optionGroupsAutocomplete.collapsed());
        assertTrue(autocompleteSection.autocompleteFirstOptionHighlighted.collapsed());
    }
}
