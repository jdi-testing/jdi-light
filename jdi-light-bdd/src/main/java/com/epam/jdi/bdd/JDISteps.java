package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getBaseUIElement;
import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.elements.composite.WebPage.PAGES;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static org.testng.Assert.assertEquals;

public class JDISteps {

    @Given("^I open \"(.*?)\"$")
    public void iMOpen(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.shouldBeOpened();
    }

    @Then("^I'm on \"(.*?)\"$")
    public void iMOn(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.checkOpened();
    }

    @When("^I click on \"([^\"]*)\"$")
    public void iMClickOn(String name) {
        BaseUIElement el = getBaseUIElement(name);
        el.click();
    }

    @When("^I click on \"([^\"]*)\" at \"([^\"]*)\"$")
    public void iMClickOnLinkFrom(String name, String section) {
        UIElement el = getUI(name, section);
        el.click();
    }

    @Then("^\"([^\"]*)\" text is \"([^\"]*)\"$")
    public void textIs(String name, String expectedText) {
        BaseUIElement el = getBaseUIElement(name);
        assertEquals(el.getText(), expectedText);
    }

    @Then("^\"([^\"]*)\" value is \"([^\"]*)\"$")
    public void valueIs(String name, String expectedText) {
        BaseUIElement el = getBaseUIElement(name);
        assertEquals(el.getValue(), expectedText);
    }

    @Then("^\"([^\"]*)\" ref is \"([^\"]*)\"$")
    public void refIs(String name, String expectedText) {
        BaseUIElement el = getBaseUIElement(name);
        try {
            assertEquals(((HtmlElement) el).ref(), expectedText);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Then("^\"([^\"]*)\" url path is \"([^\"]*)\"$")
    public void urlPathIs(String name, String expectedText) {
        BaseUIElement el = getBaseUIElement(name);
        try {
            assertEquals(((HtmlElement) el).url().getPath(), expectedText);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Then("^\"([^\"]*)\" alt is \"([^\"]*)\"$")
    public void altIs(String name, String expectedText) {
        BaseUIElement el = getBaseUIElement(name);
        try {
            assertEquals(((HtmlElement) el).alt(), expectedText);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Then("^Current URL is \"(.*?)\"$")
    public void currentUrlIs(String expectedUrl) {
        assertEquals(getUrl(), expectedUrl);
    }

}
