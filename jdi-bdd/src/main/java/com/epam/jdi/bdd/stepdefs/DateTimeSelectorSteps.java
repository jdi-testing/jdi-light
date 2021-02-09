package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.DateTimeSelector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DateTimeSelectorSteps {
    public static DateTimeSelector dateTimeSelector(String name) {
        return getUI(name, DateTimeSelector.class);
    }

    @Then("the {string} min equals to {string}")
    public void attributeMinEquals(String name, String date) {
        dateTimeSelector(name).is().min(date);
    }

    @Then("the {string} max equals to {string}")
    public void attributeMaxEquals(String name, String date) {
        dateTimeSelector(name).is().max(date);
    }

    @When("I set date {string} in the {string}")
    @When("set date {string} in the {string}")
    public void iSetDate(String date, String name) {
        dateTimeSelector(name).setDateTime(date);
    }
}
