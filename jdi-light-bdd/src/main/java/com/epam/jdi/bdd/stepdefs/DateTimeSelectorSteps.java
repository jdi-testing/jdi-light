package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.ui.html.common.DateTimeSelector;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DateTimeSelectorSteps {

    @Then("^\"([^\"]*)\" attribute min equals to \"([^\"]*)\"$")
    public void attributeMinEquals(String name, String date) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector)getUI(name);
      //  DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(dateTimeSelector.min(), date);
    }

    @Then("^\"([^\"]*)\" attribute max equals to \"([^\"]*)\"$")
    public void attributeMaxEquals(String name, String date) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector)getUI(name);
       // DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        assertEquals(dateTimeSelector.max(), date);
    }

    @Then("^(?:I |)Set date \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSetDate(String date, String name) {
        DateTimeSelector dateTimeSelector = (DateTimeSelector)getUI(name);
       // DateTimeSelector dateTimeSelector = (DateTimeSelector) ELEMENTS.get(element_name).get(0);
        dateTimeSelector.setDateTime(date);
    }

}
