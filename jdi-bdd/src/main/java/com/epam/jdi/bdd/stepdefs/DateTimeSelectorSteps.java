package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.DateTimeSelector;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DateTimeSelectorSteps {
    public static DateTimeSelector dateTimeSelector(String name) {
        return getUI(name, DateTimeSelector.class);
    }

    @Then("^the \"([^\"]*)\" min equals to \"([^\"]*)\"$")
    public void attributeMinEquals(String name, String date) {
        dateTimeSelector(name).is().min(date);
    }

    @Then("^the \"([^\"]*)\" max equals to \"([^\"]*)\"$")
    public void attributeMaxEquals(String name, String date) {
        dateTimeSelector(name).is().max(date);
    }

    @When("^(?:I |)set date \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void iSetDate(String date, String name) {
        dateTimeSelector(name).setDateTime(date);
    }
}
