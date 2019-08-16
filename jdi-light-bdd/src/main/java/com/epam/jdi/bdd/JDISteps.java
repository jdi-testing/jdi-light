package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.elements.composite.WebPage.PAGES;

public class JDISteps {
    @Given("^I open \"(.*?)\"$")
    public void iMOpen(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.open();
    }

    @Then("^I'm on \"(.*?)\"$")
    public void iMOn(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.checkOpened();
    }
    @When("^Click on \"([^\"]*)\"$")
    public void iMClickOnButton(String name) {
        UIElement el = getUI(name);
        el.click();
    }

    @When("^Click on \"([^\"]*)\" at \"([^\"]*)\"$")
    public void iMClickOnLinkFrom(String name, String section) {
        UIElement el = getUI(name, section);
        el.click();
    }

    @Given("^I refresh webpage$")
    public void iRefreshWebpage() {
        WebPage.refresh();
    }
}
