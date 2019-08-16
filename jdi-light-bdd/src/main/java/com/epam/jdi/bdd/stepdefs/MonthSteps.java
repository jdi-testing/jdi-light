package com.epam.jdi.bdd.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static io.github.com.pages.HtmlElementsPage.monthDate;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertEquals;

public class MonthSteps {
    @Given("^I see input type week on the page$")
    public void iSeeInputTypeWeekOnThePage() {


    }

    @Given("^I see date in input type week \"([^\"]*)\"$")
    public void iSeeDateInInputTypeWeek(String date){
        assertEquals(monthDate.value(), date);
    }

    @And("^label of input type week is \"([^\"]*)\"$")
    public void labelOfInputTypeWeekIs(String label){
        assertEquals(monthDate.labelText(), label);
    }

    @And("^I get min attribute of input type week \"([^\"]*)\"$")
    public void iGetMinAttributeOfInputTypeWeek(String date){
        assertEquals(monthDate.min(), date);
    }

    @And("^I get max attribute of input type week \"([^\"]*)\"$")
    public void iGetMaxAttributeOfInputTypeWeek(String date){
        assertEquals(monthDate.max(), date);
    }

    @And("^I validate date \"([^\"]*)\" in input type week$")
    public void iValidateDateInInputTypeWeek(String month){
        monthDate.is().month(containsString(month));
        monthDate.is().enabled();
    }

    @And("^I find label by \"([^\"]*)\" or \"([^\"]*)\" for input type week$")
    public void iFindLabelByOrForInputTypeWeek(String label, String lower_case_label){
        monthDate.label().is().text(containsString(label));
        monthDate.label().is().text(equalToIgnoringCase(lower_case_label));
    }

    @And("^I check that date is \"([^\"]*)\" in input type week$")
    public void iCheckThatDateIsInInputTypeWeek(String date){
        monthDate.assertThat().date(containsString(date));
    }

    @Then("^I set date \"([^\"]*)\" in input type week$")
    public void iSetDateInInputTypeWeek(String date){
        monthDate.setDateTime(date);
        monthDate.show();
        assertEquals(monthDate.value(), date);
    }
}
