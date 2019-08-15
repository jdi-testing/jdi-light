package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JDISteps {
    @Given("^I open \"(.*?)\"$")
    public void iMOpen(String pageName) {
        WebPage page = getElementByName(currentSite, pageName);
        page.open();
    }

    @Then("^I'm on \"(.*?)\"$")
    public void iMOn(String pageName) {
        WebPage page  = getElementByName(currentSite, pageName);
        page.checkOpened();
    }
    @When("^Click on \"([^\"]*)\"$")
    public void iMClickOnButton(String buttonName) {
        UIElement el = getElementByName(buttonName);
        el.click();
    }

    @When("^Click on \"([^\"]*)\" at \"([^\"]*)\"$")
    public void iMClickOnLinkFrom(String fieldName, String containerName) {
        UIElement el = getElementByName(containerName, fieldName);
        el.click();
    }
}
