package com.epam.jdi.bdd.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.base.Alerts.getAlertText;
import static org.testng.Assert.assertEquals;

public class AlertSteps {
    @Then("^alert text is equal to \"([^\"]*)\"$")
    public void checkAlertTextIs(String text) {
        assertEquals(getAlertText(), text);
    }
    @Then("^accept Alert$")
    public void acceptAlertAtScreen() {
        acceptAlert();
    }
}
