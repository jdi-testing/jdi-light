package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.DateTimeSelector;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.testng.Assert.assertEquals;

public class DateTimeSelectorSteps {
    private DateTimeSelector dateTime(String name) {
        return getUI(name, DateTimeSelector.class);
    }

    @Then("^\"([^\"]*)\" min equals to \"([^\"]*)\"$")
    public void attributeMinEquals(String name, String date) {
        assertEquals(dateTime(name).min(), date);
    }
    @Then("^\"([^\"]*)\" max equals to \"([^\"]*)\"$")
    public void attributeMaxEquals(String name, String date) {
        assertEquals(dateTime(name).max(), date);
    }
    @When("^(?:I |)Set date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSetDate(String date, String name) {
        dateTime(name).setDateTime(date);
    }

}
