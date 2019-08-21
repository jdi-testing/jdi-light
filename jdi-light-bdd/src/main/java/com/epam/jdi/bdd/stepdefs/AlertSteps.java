package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.base.Alerts.getAlertText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertSteps {
	@When("^Accept alert")
	public void acceptOpenedAlert() {
		acceptAlert();
	}

	@Then("^Alert text equals to \"([^\"]*)\"$")
    public void alertTextEquals(String alertText) {
    	assertEquals(alertText, getAlertText());
    }
	
	@Then("^Alert text contains \"([^\"]*)\"$")
    public void alertTextContains(String alertText) {
    	assertTrue(getAlertText().contains(alertText));
    }
}
