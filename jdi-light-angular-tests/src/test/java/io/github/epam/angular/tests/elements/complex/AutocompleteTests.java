package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.*;

// TODO Move to the new page
public class AutocompleteTests extends TestsInit {

    @BeforeClass
    public void before() {
        autocompletePage.open();
        waitCondition(() -> autocompletePage.isOpened());
        autocompletePage.checkOpened();
    }


    @Test
    public void verifyOnlyOneAutocompleteIsExpandedAtATime() {
        autocompletePage.autocompleteOverview.click();
        autocompletePage.autocompleteOverview.is().expanded();
        autocompletePage.simpleAutocomplete.is().collapsed();
        autocompletePage.displayValueAutocomplete.is().collapsed();
        autocompletePage.filterAutocomplete.is().collapsed();
        autocompletePage.optionGroupsAutocomplete.is().collapsed();
    }

    @Test
    public void verifyAutoCompleteOverview() {
        autocompletePage.autocompleteOverview.clear();
        autocompletePage.autocompleteOverview.is().empty();
        autocompletePage.autocompleteOverview.is().notMandatory();
        autocompletePage.autocompleteOverview.has().placeholder("State");
        autocompletePage.autocompleteDisableInput.check();
        autocompletePage.autocompleteOverview.is().disabled();
        autocompletePage.autocompleteDisableInput.uncheck();
        autocompletePage.autocompleteOverview.is().enabled();
        autocompletePage.autocompleteOverview.setValue("F", "FloridaPopulation: 20.27M");
        autocompletePage.autocompleteOverview.is().collapsed();
        autocompletePage.autocompleteOverview.has().text("Florida");
        autocompletePage.autocompleteOverview.setValue("CaliforniaPopulation: 39.14M");
        autocompletePage.autocompleteOverview.is().collapsed();
        autocompletePage.autocompleteOverview.has().text("California");
    }

    @Test
    public void verifySimpleAutocomplete() {
        autocompletePage.simpleAutocomplete.is().notMandatory();
        autocompletePage.simpleAutocomplete.is().enabled();
        autocompletePage.simpleAutocomplete.has().placeholder("Pick one");
        autocompletePage.simpleAutocomplete.setValue("Two");
        autocompletePage.simpleAutocomplete.has().text("Two");
        autocompletePage.simpleAutocomplete.setValue("T", "Three");
        autocompletePage.simpleAutocomplete.has().text("Three");
        autocompletePage.simpleAutocomplete.is().valid();
    }

    @Test
    public void verifyDisplayValueAutocomplete() {
        autocompletePage.displayValueAutocomplete.has().displayValue("Assignee");
        autocompletePage.displayValueAutocomplete.has().placeholder("");
        autocompletePage.displayValueAutocomplete.is().enabled();
        autocompletePage.displayValueAutocomplete.is().notMandatory();
        autocompletePage.displayValueAutocomplete.is().valid();
        autocompletePage.displayValueAutocomplete.setValue("Sh", "Shelley");
        autocompletePage.displayValueAutocomplete.is().collapsed();
        autocompletePage.displayValueAutocomplete.has().text("Shelley");
        autocompletePage.displayValueAutocomplete.setValue("Mary");
        autocompletePage.displayValueAutocomplete.has().text("Mary");
        autocompletePage.displayValueAutocomplete.is().collapsed();
        autocompletePage.displayValueAutocomplete.is().valid();
    }

    @Test
    public void verifyFilterAutocomplete() {
        String[] expectedValuesArray = {"One", "Two", "Three"};
        List<String> expectedValues = Arrays.asList(expectedValuesArray);

        autocompletePage.filterAutocomplete.has().displayValue("");
        autocompletePage.filterAutocomplete.has().placeholder("Pick one");
        autocompletePage.filterAutocomplete.is().enabled();
        autocompletePage.filterAutocomplete.is().valid();
        autocompletePage.filterAutocomplete.is().notMandatory();
        autocompletePage.filterAutocomplete.click();
        autocompletePage.filterAutocomplete.has().options(expectedValues);
        autocompletePage.filterAutocomplete.setValue("n", "One");
        autocompletePage.filterAutocomplete.has().text("One");
        autocompletePage.filterAutocomplete.setValue("Three");
        autocompletePage.filterAutocomplete.has().text("Three");
        autocompletePage.filterAutocomplete.setValue("o", "Two");
        autocompletePage.filterAutocomplete.has().text("Two");
        autocompletePage.filterAutocomplete.is().valid();
    }

    @Test
    public void verifyOptionGroupsAutocomplete() {
        String[] values = {"A", "C", "D", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W"};
        List<String> groupsValues = Arrays.asList(values);

        Map<String, List<String>> groupAndOptionsValues = new HashMap<>();
        String[] options = {"California", "Colorado", "Connecticut"};
        List<String> optionsValues = Arrays.asList(options);
        groupAndOptionsValues.put("C", optionsValues);

        autocompletePage.optionGroupsAutocomplete.has().placeholder("States Group");
        autocompletePage.optionGroupsAutocomplete.clear();
        autocompletePage.optionGroupsAutocomplete.is().mandatory();
        autocompletePage.optionGroupsAutocomplete.is().invalid();
        autocompletePage.optionGroupsAutocomplete.click();
        autocompletePage.optionGroupsAutocomplete.has().groups(groupsValues);
        autocompletePage.optionGroupsAutocomplete.input("C");
        autocompletePage.optionGroupsAutocomplete.has().groupsAndOptions(groupAndOptionsValues);
        autocompletePage.optionGroupsAutocomplete.setValue("C", "California");
        autocompletePage.optionGroupsAutocomplete.has().text("California");
        autocompletePage.optionGroupsAutocomplete.is().valid();
        autocompletePage.optionGroupsAutocomplete.input("C");
        autocompletePage.optionGroupsAutocomplete.setValue("Colorado");
        autocompletePage.optionGroupsAutocomplete.has().text("Colorado");
        autocompletePage.optionGroupsAutocomplete.setValue("New York");
        autocompletePage.optionGroupsAutocomplete.has().text("New York");
    }

    @Test
    public void verifyAutocompleteFirstOptionHighlighted() {
        autocompletePage.autocompleteFirstOptionHighlighted.click();
        autocompletePage.autocompleteFirstOptionHighlighted.has().optionHighlighted("One");
        autocompletePage.autocompleteFirstOptionHighlighted.has().optionNotHighlighted("Two");
    }

}
