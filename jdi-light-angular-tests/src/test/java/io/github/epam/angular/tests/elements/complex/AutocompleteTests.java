package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.autocompleteSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class AutocompleteTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyOnlyOneAutocompleteIsExpandedAtATime() {
        autocompleteSection.autocompleteOverview.click();
        autocompleteSection.autocompleteOverview.is().expanded();
        autocompleteSection.simpleAutocomplete.is().collapsed();
        autocompleteSection.displayValueAutocomplete.is().collapsed();
        autocompleteSection.filterAutocomplete.is().collapsed();
        autocompleteSection.optionGroupsAutocomplete.is().collapsed();
    }

    @Test
    public void verifyAutoCompleteOverview() {
        autocompleteSection.autocompleteOverview.clear();
        autocompleteSection.autocompleteOverview.is().empty();
        autocompleteSection.autocompleteOverview.is().notMandatory();
        autocompleteSection.autocompleteOverview.has().placeholder("State");
        autocompleteSection.autocompleteDisableInput.check();
        autocompleteSection.autocompleteOverview.is().disabled();
        autocompleteSection.autocompleteDisableInput.uncheck();
        autocompleteSection.autocompleteOverview.is().enabled();
        autocompleteSection.autocompleteOverview.setValue("F", "FloridaPopulation: 20.27M");
        autocompleteSection.autocompleteOverview.is().collapsed();
        autocompleteSection.autocompleteOverview.has().text("Florida");
        autocompleteSection.autocompleteOverview.setValue("CaliforniaPopulation: 39.14M");
        autocompleteSection.autocompleteOverview.is().collapsed();
        autocompleteSection.autocompleteOverview.has().text("California");
    }

    @Test
    public void verifySimpleAutocomplete() {
        autocompleteSection.simpleAutocomplete.is().notMandatory();
        autocompleteSection.simpleAutocomplete.is().enabled();
        autocompleteSection.simpleAutocomplete.has().placeholder("Pick one");
        autocompleteSection.simpleAutocomplete.setValue("Two");
        autocompleteSection.simpleAutocomplete.has().text("Two");
        autocompleteSection.simpleAutocomplete.setValue("T", "Three");
        autocompleteSection.simpleAutocomplete.has().text("Three");
        autocompleteSection.simpleAutocomplete.is().valid();
    }

    @Test
    public void verifyDisplayValueAutocomplete() {
        autocompleteSection.displayValueAutocomplete.has().displayValue("Assignee");
        autocompleteSection.displayValueAutocomplete.has().placeholder("");
        autocompleteSection.displayValueAutocomplete.is().enabled();
        autocompleteSection.displayValueAutocomplete.is().notMandatory();
        autocompleteSection.displayValueAutocomplete.is().valid();
        autocompleteSection.displayValueAutocomplete.setValue("Sh", "Shelley");
        autocompleteSection.displayValueAutocomplete.is().collapsed();
        autocompleteSection.displayValueAutocomplete.has().text("Shelley");
        autocompleteSection.displayValueAutocomplete.setValue("Mary");
        autocompleteSection.displayValueAutocomplete.has().text("Mary");
        autocompleteSection.displayValueAutocomplete.is().collapsed();
        autocompleteSection.displayValueAutocomplete.is().valid();
    }

    @Test
    public void verifyFilterAutocomplete() {
        String expectedValuesArray[] = {"One", "Two", "Three"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);

        autocompleteSection.filterAutocomplete.has().displayValue("");
        autocompleteSection.filterAutocomplete.has().placeholder("Pick one");
        autocompleteSection.filterAutocomplete.is().enabled();
        autocompleteSection.filterAutocomplete.is().valid();
        autocompleteSection.filterAutocomplete.is().notMandatory();
        autocompleteSection.filterAutocomplete.click();
        autocompleteSection.filterAutocomplete.has().options(expectedValues);
        autocompleteSection.filterAutocomplete.setValue("n", "One");
        autocompleteSection.filterAutocomplete.has().text("One");
        autocompleteSection.filterAutocomplete.setValue("Three");
        autocompleteSection.filterAutocomplete.has().text("Three");
        autocompleteSection.filterAutocomplete.setValue("o", "Two");
        autocompleteSection.filterAutocomplete.has().text("Two");
        autocompleteSection.filterAutocomplete.is().valid();
    }

    @Test
    public void verifyOptionGroupsAutocomplete() {
        String[] values = {"A", "C", "D", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W"};
        List<String> groupsValues = Arrays.asList(values);

        Map<String, List<String>> groupAndOptionsValues = new HashMap<>();
        String[] options = {"California", "Colorado", "Connecticut"};
        List<String> optionsValues = Arrays.asList(options);
        groupAndOptionsValues.put("C", optionsValues);

        autocompleteSection.optionGroupsAutocomplete.has().placeholder("States Group");
        autocompleteSection.optionGroupsAutocomplete.clear();
        autocompleteSection.optionGroupsAutocomplete.is().mandatory();
        autocompleteSection.optionGroupsAutocomplete.is().invalid();
        autocompleteSection.optionGroupsAutocomplete.click();
        autocompleteSection.optionGroupsAutocomplete.has().groups(groupsValues);
        autocompleteSection.optionGroupsAutocomplete.input("C");
        autocompleteSection.optionGroupsAutocomplete.has().groupsAndOptions(groupAndOptionsValues);
        autocompleteSection.optionGroupsAutocomplete.setValue("C", "California");
        autocompleteSection.optionGroupsAutocomplete.has().text("California");
        autocompleteSection.optionGroupsAutocomplete.is().valid();
        autocompleteSection.optionGroupsAutocomplete.input("C");
        autocompleteSection.optionGroupsAutocomplete.setValue("Colorado");
        autocompleteSection.optionGroupsAutocomplete.has().text("Colorado");
        autocompleteSection.optionGroupsAutocomplete.setValue("New York");
        autocompleteSection.optionGroupsAutocomplete.has().text("New York");
    }

    @Test
    public void verifyAutocompleteFirstOptionHighlighted() {
        autocompleteSection.autocompleteFirstOptionHighlighted.click();
        autocompleteSection.autocompleteFirstOptionHighlighted.has().optionHighlighted("One");
        autocompleteSection.autocompleteFirstOptionHighlighted.has().optionNotHighlighted("Two");
    }

}
