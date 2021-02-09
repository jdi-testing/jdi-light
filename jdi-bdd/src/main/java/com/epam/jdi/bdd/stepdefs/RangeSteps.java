package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.Range;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RangeSteps {
    public static Range range(String name) {
        return getUI(name, Range.class);
    }

    @When("I set {string} value to {int}")
    @When("set {string} value to {int}")
    public void installTo(String name, double value) {
        range(name).setupValue(value);
    }

    @Then("the {string} range value less or equal to {int}")
    public void rangeLessOrEqualTo(String name, double value) {
        range(name).is().value(lessThanOrEqualTo(value));
    }

    @Then("the {string} range value greater or equal to {int}")
    public void rangeGreaterOrEqualTo(String name, double value) {
        range(name).is().value(greaterThanOrEqualTo(value));
    }
}
