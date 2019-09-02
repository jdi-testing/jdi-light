package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.MultiSelector;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.tools.LinqUtils.toIntArray;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.testng.Assert.assertEquals;

public class MultiDropDownSteps {

    @When("^(?:I |)check in the \"([^\"]*)\" values:$")
    public void iCheckInTheValues(String name, List<String> values) {
        MultiSelector multiDropdown = getUI(name, MultiSelector.class);
        multiDropdown.check(values.toArray(new String[0]));
    }

    @Then("^the \"([^\"]*)\" selected values:$")
    public void theSelectedValues(String name, List<String> values) {
        MultiSelector multiDropdown = getUI(name, MultiSelector.class);
        assertEquals(multiDropdown.checked(), values);
    }

    @When("^(?:I |)check in the \"([^\"]*)\" values by number:$")
    public void iCheckInTheValuesByNumber(String name, List<Integer> values) {
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        multiDropdown.check(toIntArray(values));
    }

    @When("^(?:I |)check value \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void iCheckValueInThe(String value, String name) {
        MultiSelector multiDropdown = getUI(name, MultiSelector.class);
        multiDropdown.check(value);
    }

    @Then("^the \"([^\"]*)\" selected value is \"([^\"]*)\"$")
    public void theSelectedValueIs(String name, String value) {
        MultiSelector multiDropdown = getUI(name, MultiSelector.class);
        assertEquals(multiDropdown.selected(), value);
    }

    @Then("^the \"([^\"]*)\" values has item \"([^\"]*)\"$")
    public void theValuesHasItem(String name, String value) {
        MultiSelector multiDropdown = getUI(name, MultiSelector.class);
        multiDropdown.is().values(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" has disabled item \"([^\"]*)\"$")
    public void theHasDisabledItem(String name, String value) {
        MultiSelector multiDropdown = getUI(name, MultiSelector.class);
        multiDropdown.is().disabled(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" has not enabled item \"([^\"]*)\"$")
    public void theHasNotEnabledItem(String name, String value) {
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        multiDropdown.is().enabled(not(hasItem(value)));
    }

    @Then("^the \"([^\"]*)\" has enabled items:$")
    public void theHasEnabledItems(String name, List<String> values) {
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        multiDropdown.is().enabled(hasItems(values.toArray(new String[0])));
    }

    @Then("^the \"([^\"]*)\" contains items:$")
    public void theContainsItems(String name, List<String> values) {
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        multiDropdown.assertThat().values(containsInAnyOrder(values.toArray(new String[0])));
    }
}
