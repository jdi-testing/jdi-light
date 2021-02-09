package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.NumberSelector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NumberSelectorSteps {
    public static NumberSelector numberSelector(String name) {
        return getUI(name, NumberSelector.class);
    }

    @When("I set number {string} in {string}")
    @When("set number {string} in {string}")
    public void setNumber(String value, String name) {
        numberSelector(name).setNumber(value);
    }

    @Then("the {string} number selector value equals to {string}")
    public void getValue(String name, String value) {
        numberSelector(name).has().number(is(Double.valueOf((value))));
    }

    @Then("the {string} number selector min is {string}")
    public void getMin(String name, String value) {
        numberSelector(name).has().min(is(Double.valueOf((value))));
    }

    @Then("the {string} number selector max is {string}")
    public void getMax(String name, String value) {
        numberSelector(name).has().max(is(Double.valueOf((value))));
    }

    @Then("the {string} number selector step is {string}")
    public void getStep(String name, String value) {
        numberSelector(name).has().step(is(Double.valueOf((value))));
    }

    @Then("the {string} number selector value is greater or equal to {string}")
    public void numberIsGreaterOrEqual(String name, String value) {
        numberSelector(name).is().number(greaterThanOrEqualTo(Double.valueOf(value)));
    }

    @Then("the {string} number selector value less or equal to {string}")
    public void numberLessThanOrEqual(String name, String value) {
        numberSelector(name).is().number(lessThanOrEqualTo(Double.valueOf(value)));
    }

    @Then("the {string} number selector value is greater than {string}")
    public void numberIsGreaterThan(String name, String value) {
        numberSelector(name).is().number(greaterThan(Double.valueOf(value)));
    }

    @Then("the {string} number selector value less than {string}")
    public void numberLessThan(String name, String value) {
        numberSelector(name).is().number(lessThan(Double.valueOf(value)));
    }
}
