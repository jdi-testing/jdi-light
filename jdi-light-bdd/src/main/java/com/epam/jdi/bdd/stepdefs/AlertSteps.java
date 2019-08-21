package com.epam.jdi.bdd.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.base.Alerts.getAlertText;
import static com.epam.jdi.light.elements.base.Alerts.validateAlert;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlertSteps {
	@Then("^Alert text equals to \"([^\"]*)\"$")
    public void alertTextEquals(String alertText) {
		validateAlert(is(alertText));
    }
	
	@Then("^Alert text contains \"([^\"]*)\"$")
    public void alertTextContains(String alertText) {
    	assertTrue(getAlertText().contains(alertText));
    }
	
	@When("^Accept alert")
	public void iAcceptAlert() {
		acceptAlert();
	}
}
