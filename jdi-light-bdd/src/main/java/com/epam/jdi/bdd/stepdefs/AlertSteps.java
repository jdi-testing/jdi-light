package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.base.Alerts.dismissAlert;
import static com.epam.jdi.light.elements.base.Alerts.validateAlert;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertSteps {
	
	@When("^(?:I |)Accept alert")
	public void accept() {
		acceptAlert();
	}
	
	@When("^(?:I |)Dismiss alert")
	public void dismiss() {
		dismissAlert();
	}
	
	@Then("^Alert text equals to \"([^\"]*)\"$")
    public void alertTextEquals(String alertText) {
		validateAlert(is(alertText));
    }
	
	@Then("^Alert text contains \"([^\"]*)\"$")
    public void alertTextContains(String alertText) {
    	validateAlert(containsString(alertText));
    }
	
	@Then("^Alert text match to \"([^\"]*)\"$")
    public void alertTextMatches(String alertText) {
    	validateAlert(matchesPattern(alertText));
    }
}
