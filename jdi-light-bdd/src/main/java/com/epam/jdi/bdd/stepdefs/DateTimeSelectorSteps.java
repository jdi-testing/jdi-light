package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.DateTimeSelector;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.testng.Assert.assertEquals;

public class DateTimeSelectorSteps {

    @Then("^\"([^\"]*)\" min equals to \"([^\"]*)\"$")
    public void attributeMinEquals(String name, String date) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector)getUI(name);
        assertEquals(dateTimeSelector.min(), date);
    }

    @Then("^\"([^\"]*)\" max equals to \"([^\"]*)\"$")
    public void attributeMaxEquals(String name, String date) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector)getUI(name);
        assertEquals(dateTimeSelector.max(), date);
    }

    @When("^(?:I |)Set date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSetDate(String date, String name) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector)getUI(name);
        dateTimeSelector.setDateTime(date);
    }

}
