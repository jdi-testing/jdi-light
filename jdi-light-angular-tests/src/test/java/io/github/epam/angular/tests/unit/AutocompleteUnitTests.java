package io.github.epam.angular.tests.unit;

import io.github.com.pages.AngularPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.*;

import static com.jdiai.tools.LinqUtils.safeException;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.autocompletePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.*;

// TODO Move to the new page

public class AutocompleteUnitTests extends TestsInit {

    @BeforeClass
    public void before() {
        autocompletePage.open();
        waitCondition(() -> autocompletePage.isOpened());
        autocompletePage.checkOpened();
    }

    @Test
    public void getPlaceHolderValueTest() {
        assertEquals(AngularPage.autocompletePage.
                autocompleteOverview.placeholder(), "State");
        AngularPage.autocompletePage.autocompleteDisableInput.check();
        assertEquals(AngularPage.autocompletePage.
                autocompleteOverview.placeholder(), "State");
        AngularPage.autocompletePage.autocompleteDisableInput.uncheck();
        assertEquals(AngularPage.autocompletePage.
                simpleAutocomplete.placeholder(), "Pick one");
    }

    @Test
    public void getDisplayValueTest() {
        assertEquals(AngularPage.autocompletePage.
                displayValueAutocomplete.displayValue(), "Assignee");
        AngularPage.autocompletePage.displayValueAutocomplete.setUniqueAutoCompleteAttribute("_ngcontent");
        AngularPage.autocompletePage.
                displayValueAutocomplete.setValue("Mar", "Mary");
        assertEquals(AngularPage.autocompletePage.
                displayValueAutocomplete.displayValue(), "Assignee");
        AngularPage.autocompletePage.displayValueAutocomplete.clear();
    }

    @Test
    public void inputOverviewSelectTest() {
        AngularPage.autocompletePage.autocompleteOverview.
                setValue("Ark",
                        "ArkansasPopulation: 2.978M");
        assertEquals(AngularPage.autocompletePage.autocompleteOverview.getValue(), "Arkansas");
    }

    @Test
    public void clickOverviewSelectTest() {
        AngularPage.autocompletePage.autocompleteOverview.
                setValue("TexasPopulation: 27.47M");
        assertEquals(AngularPage.autocompletePage.autocompleteOverview.getValue(), "Texas");
    }

    @Test
    public void simpleAutocompleteGetItemsValuesTest() {
        String expectedValuesArray[] = {"One", "Two", "Three"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        assertEquals(AngularPage.autocompletePage.
                        simpleAutocomplete.
                        options(),
                expectedValues);
    }

    @Test
    public void optionGroupsAutocompleteGetItemsValuesTest() {
        String expectedValuesArray[] = {"California", "Colorado", "Connecticut"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);
        assertEquals(AngularPage.autocompletePage.
                        optionGroupsAutocomplete.
                        options("C"),
                expectedValues);
    }

    @Test
    public void disabledInputThrowsExceptionUponInputTest() {
        AngularPage.autocompletePage.autocompleteOverview.clear();
        AngularPage.autocompletePage.autocompleteDisableInput.check();
        AngularPage.autocompletePage.autocompleteOverview.waitFor(2);
        try {
            AngularPage.autocompletePage.
                    autocompleteOverview.
                    setValue("Ark",
                            "ArkansasPopulation: 2.978M");
        } catch (Exception e) {
            assertThat(safeException(e), containsString("Element is not currently interactable"));
        }
        AngularPage.autocompletePage.autocompleteDisableInput.uncheck();
    }

    @Test
    public void getGroupsValuesTest() {
        AngularPage.autocompletePage.autocompleteOverview.clear();
        AngularPage.autocompletePage.autocompleteOverview.click();
        assertEquals(AngularPage.autocompletePage.
                autocompleteOverview.groups(), Collections.emptyList());
        AngularPage.autocompletePage.optionGroupsAutocomplete.clear();
        AngularPage.autocompletePage.optionGroupsAutocomplete.click();
        String[] values = {"A", "C", "D", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W"};
        List<String> groupsValues = Arrays.asList(values);
        assertEquals(AngularPage.autocompletePage.
                optionGroupsAutocomplete.groups(), groupsValues);
        AngularPage.autocompletePage.optionGroupsAutocomplete.input("C");
        assertEquals(AngularPage.autocompletePage.
                optionGroupsAutocomplete.groups(), Arrays.asList(new String[]{"C"}));
    }

    @Test
    public void getGroupsAndOptionsValuesTest() {
        Map<String, List<String>> emptyGroupAndOptionsValues = new HashMap<>();
        emptyGroupAndOptionsValues.put("", Collections.emptyList());
        AngularPage.autocompletePage.optionGroupsAutocomplete.input("B");
        assertEquals(AngularPage.autocompletePage.
                optionGroupsAutocomplete.groupsAndOptionsValues(), emptyGroupAndOptionsValues);
        AngularPage.autocompletePage.optionGroupsAutocomplete.input("C");
        Map<String, List<String>> groupAndOptionsValues = new HashMap<>();
        String[] options = {"California", "Colorado", "Connecticut"};
        List<String> optionsValues = Arrays.asList(options);
        groupAndOptionsValues.put("C", optionsValues);
        assertEquals(AngularPage.autocompletePage.
                optionGroupsAutocomplete.groupsAndOptionsValues(), groupAndOptionsValues);
    }

    @Test
    public void clearTest() {
        AngularPage.autocompletePage.simpleAutocomplete.setValue("Two");
        AngularPage.autocompletePage.simpleAutocomplete.clear();
        assertEquals(AngularPage.autocompletePage.simpleAutocomplete.getValue(), "");
    }

    @Test
    public void isMandatoryTest() {
        assertFalse(AngularPage.autocompletePage.autocompleteOverview.isMandatory());
        assertFalse(AngularPage.autocompletePage.simpleAutocomplete.isMandatory());
        assertTrue(AngularPage.autocompletePage.optionGroupsAutocomplete.isMandatory());
    }

    @Test
    public void isInvalidatedTest() {
        AngularPage.autocompletePage.autocompleteOverview.click();
        assertFalse(AngularPage.autocompletePage.autocompleteOverview.isInvalidated());
        AngularPage.autocompletePage.optionGroupsAutocomplete.setValue("Florida");
        AngularPage.autocompletePage.optionGroupsAutocomplete.clear();
        assertTrue(AngularPage.autocompletePage.optionGroupsAutocomplete.isInvalidated());
    }

    @Test
    public void isEnabledTest() {
        assertTrue(AngularPage.autocompletePage.autocompleteOverview.isEnabled());
        assertTrue(AngularPage.autocompletePage.simpleAutocomplete.isEnabled());
        assertTrue(AngularPage.autocompletePage.displayValueAutocomplete.isEnabled());
        assertTrue(AngularPage.autocompletePage.filterAutocomplete.isEnabled());
        assertTrue(AngularPage.autocompletePage.optionGroupsAutocomplete.isEnabled());
        assertTrue(AngularPage.autocompletePage.autocompleteFirstOptionHighlighted.isEnabled());
    }

    @Test
    public void isDisabledTest() {
        AngularPage.autocompletePage.autocompleteDisableInput.check();
        assertTrue(AngularPage.autocompletePage.autocompleteOverview.isDisabled());
        AngularPage.autocompletePage.autocompleteDisableInput.uncheck();
    }

    @Test
    public void isExpandedTest() {
        AngularPage.autocompletePage.autocompleteOverview.click();
        assertTrue(AngularPage.autocompletePage.autocompleteOverview.expanded());
        AngularPage.autocompletePage.simpleAutocomplete.click();
        assertTrue(AngularPage.autocompletePage.simpleAutocomplete.expanded());
        AngularPage.autocompletePage.displayValueAutocomplete.click();
        assertTrue(AngularPage.autocompletePage.displayValueAutocomplete.expanded());
        AngularPage.autocompletePage.filterAutocomplete.click();
        assertTrue(AngularPage.autocompletePage.filterAutocomplete.expanded());
        AngularPage.autocompletePage.optionGroupsAutocomplete.click();
        assertTrue(AngularPage.autocompletePage.optionGroupsAutocomplete.expanded());
        AngularPage.autocompletePage.autocompleteFirstOptionHighlighted.click();
        assertTrue(AngularPage.autocompletePage.autocompleteFirstOptionHighlighted.expanded());
    }

    @Test
    public void isCollapsedTest() {
        assertTrue(AngularPage.autocompletePage.autocompleteOverview.collapsed());
        assertTrue(AngularPage.autocompletePage.simpleAutocomplete.collapsed());
        assertTrue(AngularPage.autocompletePage.displayValueAutocomplete.collapsed());
        assertTrue(AngularPage.autocompletePage.filterAutocomplete.collapsed());
        assertTrue(AngularPage.autocompletePage.optionGroupsAutocomplete.collapsed());
        assertTrue(AngularPage.autocompletePage.autocompleteFirstOptionHighlighted.collapsed());
    }
}
