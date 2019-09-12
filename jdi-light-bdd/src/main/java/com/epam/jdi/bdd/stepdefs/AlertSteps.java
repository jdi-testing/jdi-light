package com.epam.jdi.bdd.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.common.Alerts.*;
import static org.hamcrest.Matchers.*;

public class AlertSteps {
	
	@When("^(?:I |)accept alert")
	public void accept() {
		acceptAlert();
	}
	
	@When("^(?:I |)dismiss alert")
	public void dismiss() {
		dismissAlert();
	}
	
	@Then("^the Alert text equals to \"([^\"]*)\"$")
    public void alertTextEquals(String alertText) {
		validateAlert(is(alertText));
    }
	
	@Then("^the Alert text contains \"([^\"]*)\"$")
    public void alertTextContains(String alertText) {
    	validateAlert(containsString(alertText));
    }

	@Then("^the Alert text matches to \"([^\"]*)\"$")
    public void alertTextMatches(String alertText) {
    	validateAlert(matchesPattern(alertText));
    }
}
