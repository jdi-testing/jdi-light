package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.element;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class JDILocatorSteps {

    @Given("^(?:I |)open page by url \"([^\"]*)\"$")
    public void openPageByUrl(String url) {
        WebPage.openUrl(url);
    }

    @When("^(?:I |)click on \"([^\"]*)\" element$")
    public void click(String locator) {
        element(locator).click();
    }

    @When("^(?:I |)click with JS on \"([^\"]*)\" element$")
    public void jsClick(String locator) {
        element(locator).jsClick();
    }

    @Then("^the \"([^\"]*)\" element text equals to \"([^\"]*)\"$")
    public void textEquals(String locator, String value) {
        element(locator).is().text(value);
    }

    @Then("^the \"([^\"]*)\" element label text equals to \"([^\"]*)\"$")
    public void labelTextEquals(String locator, String value) {
        element(locator).label().has().text(equalTo(value));
    }

    @When("^(?:I |)send keys \"([^\"]*)\" to \"([^\"]*)\" element$")
    public void sendKeys(String value, String locator) {
        element(locator).sendKeys(value);
    }

    @Then("^the \"([^\"]*)\" element text matches to \"([^\"]*)\"$")
    public void textMatchRegex(String locator, String regex) {
        element(locator).is().text(matchesPattern(regex));
    }

    @When("^(?:I |)check \"([^\"]*)\" element$")
    public void check(String locator) {
        element(locator).check();
    }

    @When("^(?:I |)uncheck \"([^\"]*)\" element$")
    public void uncheck(String locator) {
        element(locator).uncheck();
    }

    @Then("^the \"([^\"]*)\" element is selected$")
    public void isSelected(String locator) {
        element(locator).is().selected();
    }

    @Then("^the \"([^\"]*)\" element is deselected$")
    public void isDeselected(String locator) {
        element(locator).is().deselected();
    }

    @When("^(?:I |)clear \"([^\"]*)\" element$")
    public void clear(String locator) {
        element(locator).clear();
    }

    @Then("^the \"([^\"]*)\" element css \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void cssEquals(String locator, String attrName, String cssValue) {
        element(locator).is().css(attrName, cssValue);
    }

    @When("^(?:I |)input \"([^\"]*)\" in \"([^\"]*)\" element$")
    public void input(String value, String locator) {
        element(locator).input(value);
    }

    @Then("^the \"([^\"]*)\" element placeholder equals to \"([^\"]*)\"$")
    public void placeholderEquals(String locator, String placeholder) {
        element(locator).is().attr("placeholder", placeholder);
    }

    @Then("^the \"([^\"]*)\" element attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void attributeEquals(String locator, String attrName, String attrValue) {
        element(locator).is().attr(attrName, attrValue);
    }

    @Then("^the \"([^\"]*)\" element is enabled$")
    public void isEnabled(String locator) {
        element(locator).is().enabled();
    }

    @Then("^the \"([^\"]*)\" element is disabled$")
    public void isDisabled(String locator) {
        element(locator).is().disabled();
    }

    @Then("^the \"([^\"]*)\" element is hidden$")
    public void isHidden(String locator) {
        element(locator).is().hidden();
    }

    @Then("^the \"([^\"]*)\" element does not appear$")
    public void isNotAppear(String locator) {
        element(locator).is().notAppear();
    }

    @Then("^the \"([^\"]*)\" element is displayed$")
    public void isDisplayed(String locator) {
        element(locator).is().displayed();
    }

    @When("^(?:I |)set text \"([^\"]*)\" in \"([^\"]*)\" element$")
    public void setText(String value, String locator) {
        element(locator).setText(value);
    }

    @When("^(?:I |)select \"([^\"]*)\" field from \"([^\"]*)\" element$")
    public void select(String value, String locator) {
        element(locator).select(value);
    }
}
