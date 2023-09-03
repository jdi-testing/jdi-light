package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.StaticSite.autocompletesPage;
import static io.github.com.pages.AngularPage.autocompleteSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

// TODO Move to the new page
@Ignore
public class AutocompleteTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyOnlyOneAutocompleteIsExpandedAtATime() {
        autocompletesPage.autocompleteOverview.click();
        autocompletesPage.autocompleteOverview.is().expanded();
        autocompletesPage.simpleAutocomplete.is().collapsed();
        autocompletesPage.displayValueAutocomplete.is().collapsed();
        autocompletesPage.filterAutocomplete.is().collapsed();
        autocompletesPage.optionGroupsAutocomplete.is().collapsed();
    }

    @Test
    public void verifyAutoCompleteOverview() {
        autocompletesPage.autocompleteOverview.clear();
        autocompletesPage.autocompleteOverview.is().empty();
        autocompletesPage.autocompleteOverview.is().notMandatory();
        autocompletesPage.autocompleteOverview.has().placeholder("State");
        autocompletesPage.autocompleteDisableInput.check();
        autocompletesPage.autocompleteOverview.is().disabled();
        autocompletesPage.autocompleteDisableInput.uncheck();
        autocompletesPage.autocompleteOverview.is().enabled();
        autocompletesPage.autocompleteOverview.setValue("F", "FloridaPopulation: 20.27M");
        autocompletesPage.autocompleteOverview.is().collapsed();
        autocompletesPage.autocompleteOverview.has().text("Florida");
        autocompletesPage.autocompleteOverview.setValue("CaliforniaPopulation: 39.14M");
        autocompletesPage.autocompleteOverview.is().collapsed();
        autocompletesPage.autocompleteOverview.has().text("California");
    }

    @Test
    public void verifySimpleAutocomplete() {
        autocompletesPage.simpleAutocomplete.is().notMandatory();
        autocompletesPage.simpleAutocomplete.is().enabled();
        autocompletesPage.simpleAutocomplete.has().placeholder("Pick one");
        autocompletesPage.simpleAutocomplete.setValue("Two");
        autocompletesPage.simpleAutocomplete.has().text("Two");
        autocompletesPage.simpleAutocomplete.setValue("T", "Three");
        autocompletesPage.simpleAutocomplete.has().text("Three");
        autocompletesPage.simpleAutocomplete.is().valid();
    }

    @Test
    public void verifyDisplayValueAutocomplete() {
        autocompletesPage.displayValueAutocomplete.has().displayValue("Assignee");
        autocompletesPage.displayValueAutocomplete.has().placeholder("");
        autocompletesPage.displayValueAutocomplete.is().enabled();
        autocompletesPage.displayValueAutocomplete.is().notMandatory();
        autocompletesPage.displayValueAutocomplete.is().valid();
        autocompletesPage.displayValueAutocomplete.setValue("Sh", "Shelley");
        autocompletesPage.displayValueAutocomplete.is().collapsed();
        autocompletesPage.displayValueAutocomplete.has().text("Shelley");
        autocompletesPage.displayValueAutocomplete.setValue("Mary");
        autocompletesPage.displayValueAutocomplete.has().text("Mary");
        autocompletesPage.displayValueAutocomplete.is().collapsed();
        autocompletesPage.displayValueAutocomplete.is().valid();
    }

    @Test
    public void verifyFilterAutocomplete() {
        String[] expectedValuesArray = {"One", "Two", "Three"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);

        autocompletesPage.filterAutocomplete.has().displayValue("");
        autocompletesPage.filterAutocomplete.has().placeholder("Pick one");
        autocompletesPage.filterAutocomplete.is().enabled();
        autocompletesPage.filterAutocomplete.is().valid();
        autocompletesPage.filterAutocomplete.is().notMandatory();
        autocompletesPage.filterAutocomplete.click();
        autocompletesPage.filterAutocomplete.has().options(expectedValues);
        autocompletesPage.filterAutocomplete.setValue("n", "One");
        autocompletesPage.filterAutocomplete.has().text("One");
        autocompletesPage.filterAutocomplete.setValue("Three");
        autocompletesPage.filterAutocomplete.has().text("Three");
        autocompletesPage.filterAutocomplete.setValue("o", "Two");
        autocompletesPage.filterAutocomplete.has().text("Two");
        autocompletesPage.filterAutocomplete.is().valid();
    }

    @Test
    public void verifyOptionGroupsAutocomplete() {
        String[] values = {"A", "C", "D", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W"};
        List<String> groupsValues = Arrays.asList(values);

        Map<String, List<String>> groupAndOptionsValues = new HashMap<>();
        String[] options = {"California", "Colorado", "Connecticut"};
        List<String> optionsValues = Arrays.asList(options);
        groupAndOptionsValues.put("C", optionsValues);

        autocompletesPage.optionGroupsAutocomplete.has().placeholder("States Group");
        autocompletesPage.optionGroupsAutocomplete.clear();
        autocompletesPage.optionGroupsAutocomplete.is().mandatory();
        autocompletesPage.optionGroupsAutocomplete.is().invalid();
        autocompletesPage.optionGroupsAutocomplete.click();
        autocompletesPage.optionGroupsAutocomplete.has().groups(groupsValues);
        autocompletesPage.optionGroupsAutocomplete.input("C");
        autocompletesPage.optionGroupsAutocomplete.has().groupsAndOptions(groupAndOptionsValues);
        autocompletesPage.optionGroupsAutocomplete.setValue("C", "California");
        autocompletesPage.optionGroupsAutocomplete.has().text("California");
        autocompletesPage.optionGroupsAutocomplete.is().valid();
        autocompletesPage.optionGroupsAutocomplete.input("C");
        autocompletesPage.optionGroupsAutocomplete.setValue("Colorado");
        autocompletesPage.optionGroupsAutocomplete.has().text("Colorado");
        autocompletesPage.optionGroupsAutocomplete.setValue("New York");
        autocompletesPage.optionGroupsAutocomplete.has().text("New York");
    }

    @Test
    public void verifyAutocompleteFirstOptionHighlighted() {
        autocompletesPage.autocompleteFirstOptionHighlighted.click();
        autocompletesPage.autocompleteFirstOptionHighlighted.has().optionHighlighted("One");
        autocompletesPage.autocompleteFirstOptionHighlighted.has().optionNotHighlighted("Two");
    }

}
