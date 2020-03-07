package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.NumberSelector;
import cucumber.api.java.en.*;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NumberSelectorSteps {
    public static NumberSelector numberSelector(String name) {
        return getUI(name, NumberSelector.class);
    }

    @When("^(?:I |)set number \"([^\"]*)\" in \"([^\"]*)\"$")
    public void setNumber(String value, String name) {
        numberSelector(name).setNumber(value);
    }

    @Then("^the \"([^\"]*)\" number selector value equals to \"([^\"]*)\"$")
    public void getValue(String name, String value) {
        numberSelector(name).has().number(is(Double.valueOf((value))));
    }

    @Then("^the \"([^\"]*)\" number selector min is \"([^\"]*)\"$")
    public void getMin(String name, String value) {
        numberSelector(name).has().min(is(Double.valueOf((value))));
    }

    @Then("^the \"([^\"]*)\" number selector max is \"([^\"]*)\"$")
    public void getMax(String name, String value) {
        numberSelector(name).has().max(is(Double.valueOf((value))));
    }

    @Then("^the \"([^\"]*)\" number selector step is \"([^\"]*)\"$")
    public void getStep(String name, String value) {
        numberSelector(name).has().step(is(Double.valueOf((value))));
    }

    @Then("^the \"([^\"]*)\" number selector value is greater or equal to \"([^\"]*)\"$")
    public void numberIsGreaterOrEqual(String name, String value) {
        numberSelector(name).is().number(greaterThanOrEqualTo(Double.valueOf(value)));
    }

    @Then("^the \"([^\"]*)\" number selector value less or equal to \"([^\"]*)\"$")
    public void numberLessThanOrEqual(String name, String value) {
        numberSelector(name).is().number(lessThanOrEqualTo(Double.valueOf(value)));
    }

    @Then("^the \"([^\"]*)\" number selector value is greater than \"([^\"]*)\"$")
    public void numberIsGreaterThan(String name, String value) {
        numberSelector(name).is().number(greaterThan(Double.valueOf(value)));
    }

    @Then("^the \"([^\"]*)\" number selector value less than \"([^\"]*)\"$")
    public void numberLessThan(String name, String value) {
        numberSelector(name).is().number(lessThan(Double.valueOf(value)));
    }
}
