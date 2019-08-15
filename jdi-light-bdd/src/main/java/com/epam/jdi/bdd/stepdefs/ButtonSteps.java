package com.epam.jdi.bdd.stepdefs;

import cucumber.api.java.en.When;

public class ButtonSteps {

    @When("^I click on \"([^\"]*)\"(?:(?: button|link)$|$)")
    public void iMClickOnButton(String buttonName) {
/*        IClickable cl = getElementByName(buttonName);
        cl.click();*/
    }

    @When("^I click on \"([^\"]*)\" (?:(?: button|link)) from \"([^\"]*)\"$")
    public void iMClickOnLinkFrom(String fieldName, String containerName) {
/*        IClickable cl = getElementByName(containerName, fieldName);
        cl.click();*/
    }
}
