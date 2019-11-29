package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.Range;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RangeSteps {
    public static Range range(String name) { return getUI(name, Range.class); }

    @When("^(?:I |)set \"([^\"]*)\" value to (\\d+)$")
    public void installTo(String name, double value) {
        range(name).setValue(value);
    }
    @Then("^the \"([^\"]*)\" range volume less or equal to (\\d+)$")
    public void rangeLessOrEqualTo(String name, double value) {
        range(name).is().value(lessThanOrEqualTo(value));
    }
    @Then("^the \"([^\"]*)\" range volume greater or equal to (\\d+)$")
    public void rangeGreaterOrEqualTo(String name, double value) {
        range(name).is().value(greaterThanOrEqualTo(value));
    }
}
