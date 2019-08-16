package com.epam.jdi.bdd.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static io.github.com.pages.HtmlElementsPage.birthDate;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DateSteps {
    @Given("^I see \"([^\"]*)\" input type date on the page$")
    public void iSeeFieldOnThePage(String arg0){
        //UIElement el = getUI(name);
        //baseValidation(partyTime);
    }

    @Given("^I see year \"([^\"]*)\" in input type date$")
    public void iSeeYear(String date){
        assertEquals(birthDate.value(), date);
    }

    @And("^label is \"([^\"]*)\" in input type date$")
    public void labelOfDateFieldIs(String name){
        assertEquals(birthDate.labelText(), name);
    }

    @And("^I get min attribute \"([^\"]*)\" in input type date$")
    public void iGetMinYear(String min_date){
        assertEquals(birthDate.min(), min_date);
    }

    @And("^I get max attribute \"([^\"]*)\" in input type date$")
    public void iGetMaxYear(String max_date){
        assertEquals(birthDate.max(), max_date);
    }

    @And("^I validate year \"([^\"]*)\" in input type date$")
    public void iValidateYear(String date){
        birthDate.is().date(is(date));
        birthDate.is().enabled();
    }

    @And("^I find date label by \"([^\"]*)\" or \"([^\"]*)\" in input type date$")
    public void iFindDateLabelByOr(String label, String part_label){
        assertEquals(birthDate.label().getText(), label);
        birthDate.label().is().text(containsString(part_label));
    }

    @And("^I check that year is \"([^\"]*)\" in input type date$")
    public void iCheckThatYearIs(String date){
        birthDate.assertThat().date(containsString(date));
    }

    @Then("^I set year \"([^\"]*)\" in input type date$")
    public void iSetYear(String date){
        birthDate.setDateTime(date);
        assertEquals(birthDate.value(), date);
    }
}
