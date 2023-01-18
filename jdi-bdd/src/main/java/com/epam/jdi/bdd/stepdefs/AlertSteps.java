package com.epam.jdi.bdd.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.jdi.light.elements.common.Alerts.*;
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
        validateAndAcceptAlert(is(alertText));
    }

    @Then("^the Alert text contains \"([^\"]*)\"$")
    public void alertTextContains(String alertText) {
        validateAndAcceptAlert(containsString(alertText));
    }

    @Then("^the Alert text matches to \"([^\"]*)\"$")
    public void alertTextMatches(String alertText) {
        validateAndAcceptAlert(matchesPattern(alertText));
    }
    // endregion
}
