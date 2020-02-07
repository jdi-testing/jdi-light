package com.epam.jdi.bdd.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.mobile.elements.common.Alerts.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class AlertSteps {

	// region Actions
	@When("^(?:I |)accept alert")
	public void accept() {
		acceptAlert();
	}
	@When("^(?:I |)dismiss alert")
	public void dismiss() {
		dismissAlert();
	}
	// endregion

	// region Verification
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
	// endregion
}
