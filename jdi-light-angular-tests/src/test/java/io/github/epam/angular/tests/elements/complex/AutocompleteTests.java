package io.github.epam.angular.tests.elements.complex;

import io.github.epam.*;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.*;
import static org.testng.Assert.*;

public class AutocompleteTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyAutoCompleteOverview() {
        autocompleteSection.autocompleteOverview.setValue("F", "FloridaPopulation: 20.27M");
        assertEquals(autocompleteSection.autocompleteOverview.getValue(), "Florida");
        autocompleteSection.autocompleteOverview.setValue("CaliforniaPopulation: 39.14M");
        assertEquals(autocompleteSection.autocompleteOverview.getValue(), "California");
    }

    @Test
    public void verifySimpleAutocomplete() {
        autocompleteSection.simpleAutocomplete.setValue("Two");
        assertEquals(autocompleteSection.simpleAutocomplete.getValue(), "Two");
    }

    @Test
    public void verifyDisplayValueAutocomplete() {
        autocompleteSection.displayValueAutocomplete.setValue("Sh", "Shelley");
        assertEquals(autocompleteSection.displayValueAutocomplete.getValue(), "Shelley");
        autocompleteSection.displayValueAutocomplete.setValue("Mary");
        assertEquals(autocompleteSection.displayValueAutocomplete.getValue(), "Mary");
    }

    @Test
    public void verifyFilterAutocomplete() {
        autocompleteSection.filterAutocomplete.setValue("n", "One");
        assertEquals(autocompleteSection.filterAutocomplete.getValue(), "One");
        autocompleteSection.filterAutocomplete.setValue("Three");
        assertEquals(autocompleteSection.filterAutocomplete.getValue(), "Three");
        autocompleteSection.filterAutocomplete.setValue("o", "Two");
        assertEquals(autocompleteSection.filterAutocomplete.getValue(), "Two");
    }

    @Test
    public void verifyOptionGroupsAutocomplete() {
        autocompleteSection.optionGroupsAutocomplete.setValue("C", "California");
        assertEquals(autocompleteSection.optionGroupsAutocomplete.getValue(), "California");
        autocompleteSection.optionGroupsAutocomplete.input("C");
        autocompleteSection.optionGroupsAutocomplete.setValue("Colorado");
        assertEquals(autocompleteSection.optionGroupsAutocomplete.getValue(), "Colorado");
        autocompleteSection.optionGroupsAutocomplete.setValue("New York");
        assertEquals(autocompleteSection.optionGroupsAutocomplete.getValue(), "New York");
    }

    @Test
    public void verifyAutocompleteFirstOptionHighlighted() {
        autocompleteSection.autocompleteFirstOptionHighlighted.click();
        autocompleteSection.autocompleteFirstOptionHighlighted.isOptionHighlighted("One");
    }

}
