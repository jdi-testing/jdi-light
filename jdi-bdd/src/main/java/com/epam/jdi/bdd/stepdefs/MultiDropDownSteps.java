package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.BDDUtils.getListFromData;
import static com.epam.jdi.bdd.BDDUtils.selectAssert;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.LinqUtils.toIntArray;
import static com.epam.jdi.tools.LinqUtils.toStringArray;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.hamcrest.core.IsIterableContaining.hasItems;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MultiDropDownSteps {
    public static MultiSelector multiDropDown(String name) {
        return getUI(name, MultiSelector.class);
    }

    @When("I check in the {string} values:")
    @When("check in the {string} values:")
    public void iCheckInTheValues(String name, List<List<String>> values) {
        multiDropDown(name).check(toStringArray(getListFromData(values)));
    }

    @Then("the {string} selected values:")
    public void theSelectedValues(String name, List<List<String>> values) {
        multiDropDown(name).is().checked(getListFromData(values));
    }

    @When("I check in the {string} values by number:")
    @When("check in the {string} values by number:")
    public void iCheckInTheValuesByNumber(String name, List<List<Integer>> values) {
        multiDropDown(name).check(toIntArray(getListFromData(values)));
    }

    @When("I check value {string} in the {string}")
    @When("check value {string} in the {string}")
    public void iCheckValueInThe(String value, String name) {
        multiDropDown(name).check(value);
    }

    @Then("the {string} selected value is {string}")
    public void theSelectedValueIs(String name, String value) {
        selectAssert(name).selected(value);
    }

    @Then("the {string} values has item {string}")
    public void theValuesHasItem(String name, String value) {
        selectAssert(name).values(hasItem(value));
    }

    @Then("the {string} has disabled item {string}")
    public void theHasDisabledItem(String name, String value) {
        selectAssert(name).disabled(hasItem(value));
    }

    @Then("the {string} has no enabled item {string}")
    public void theHasNotEnabledItem(String name, String value) {
        selectAssert(name).enabled(not(hasItem(value)));
    }

    @Then("the {string} has enabled items:")
    public void theHasEnabledItems(String name, List<List<String>> values) {
        selectAssert(name).enabled(hasItems(toStringArray(getListFromData(values))));
    }

    @Then("the {string} contains items:")
    public void theContainsItems(String name, List<List<String>> values) {
        selectAssert(name).values(containsInAnyOrder(toStringArray(getListFromData(values))));
    }
}
