package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.Range;
import cucumber.api.java.en.*;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RangeSteps {
    public static Range range(String name) {
        return getUI(name, Range.class);
    }

    @When("^(?:I |)set \"([^\"]*)\" value to (\\d+)$")
    public void installTo(String name, int value) {
        range(name).setRangeValue(value);
    }

    @Then("^the \"([^\"]*)\" range value less or equal to (\\d+)$")
    public void rangeLessOrEqualTo(String name, int value) {
        range(name).is().value(lessThanOrEqualTo(value));
    }

    @Then("^the \"([^\"]*)\" range value greater or equal to (\\d+)$")
    public void rangeGreaterOrEqualTo(String name, int value) {
        range(name).is().value(greaterThanOrEqualTo(value));
    }
}
