package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.BDDUtils.*;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MultiDropDownSteps {
    public static MultiSelector multiDropDown(String name) {
        return getUI(name, MultiSelector.class);
    }

    @When("^(?:I |)check in the \"([^\"]*)\" values:$")
    public void iCheckInTheValues(String name, List<String> values) {
        multiDropDown(name).check(values.toArray(new String[0]));
    }

    @Then("^the \"([^\"]*)\" selected values:$")
    public void theSelectedValues(String name, List<String> values) {
        assertEquals(multiDropDown(name).checked(), values);
    }

    @When("^(?:I |)check in the \"([^\"]*)\" values by number:$")
    public void iCheckInTheValuesByNumber(String name, List<Integer> values) {
        multiDropDown(name).check(toIntArray(values));
    }

    @When("^(?:I |)check value \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void iCheckValueInThe(String value, String name) {
        multiDropDown(name).check(value);
    }

    @Then("^the \"([^\"]*)\" selected value is \"([^\"]*)\"$")
    public void theSelectedValueIs(String name, String value) {
        selectAssert(name).selected(value);
    }

    @Then("^the \"([^\"]*)\" values has item \"([^\"]*)\"$")
    public void theValuesHasItem(String name, String value) {
        selectAssert(name).values(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" has disabled item \"([^\"]*)\"$")
    public void theHasDisabledItem(String name, String value) {
        selectAssert(name).disabled(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" has no enabled item \"([^\"]*)\"$")
    public void theHasNotEnabledItem(String name, String value) {
        selectAssert(name).enabled(not(hasItem(value)));
    }

    @Then("^the \"([^\"]*)\" has enabled items:$")
    public void theHasEnabledItems(String name, List<String> values) {
        selectAssert(name).enabled(hasItems(values.toArray(new String[0])));
    }

    @Then("^the \"([^\"]*)\" contains items:$")
    public void theContainsItems(String name, List<String> values) {
        selectAssert(name).values(containsInAnyOrder(values.toArray(new String[0])));
    }
}
