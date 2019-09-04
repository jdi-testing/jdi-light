package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static org.hamcrest.Matchers.matchesPattern;

public class JDILocatorSteps {
    @Given("^I logged in$")
    public void iLoggedIn(String pageName) {
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/index.html");
        $("img#user-icon").click();
        $("form #name").sendKeys("Roman");
        $("form #password").sendKeys("Jdi1234");
        $("form [type=submit]").click();
    }

    @When("^(?:I |)Click on \"([^\"]*)\" element$")
    public void click(String locator) {
        WebElement el = $(locator);
        el.click();
    }

    @When("^(?:I |)Click with JS on \"([^\"]*)\" element$")
    public void jsClick(String locator) {
        BaseUIElement el = $(locator);
        el.jsClick();
    }

    @Then("^the \"([^\"]*)\" element text equals to \"([^\"]*)\"$")
    public void textEquals(String locator, String value) {
        JDIBase el = $(locator);
        el.is().text(value);
    }

    @When("^(?:I |)send keys \"([^\"]*)\" to \"([^\"]*)\" element$")
    public void sendKeys(String value, String locator) {
        BaseUIElement el = $(locator);
        el.sendKeys(value);
    }

    @Then("^the \"([^\"]*)\" element text matches to \"([^\"]*)\"$")
    public void textMatchRegex(String locator, String regex) {
        JDIBase el = $(locator);
        el.is().text(matchesPattern(regex));
    }

    @When("^(?:I |)check \"([^\"]*)\" element$")
    public void check(String locator) {
        BaseUIElement el = $(locator);
        el.check();
    }

    @When("^(?:I |)uncheck \"([^\"]*)\" element$")
    public void uncheck(String locator) {
        BaseUIElement el = $(locator);
        el.uncheck();
    }

    @Then("^the \"([^\"]*)\" element is selected$")
    public void isSelected(String locator) {
        JDIBase el = $(locator);
        el.is().selected();
    }

    @Then("^the \"([^\"]*)\" element is deselected$")
    public void isDeselected(String locator) {
        JDIBase el = $(locator);
        el.is().deselected();
    }

    @When("^(?:I |)clear \"([^\"]*)\" element$")
    public void clear(String locator) {
        BaseUIElement el = $(locator);
        el.clear();
    }

    @Then("^the \"([^\"]*)\" element css \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void cssEquals(String locator, String attrName, String cssValue) {
        JDIBase el = $(locator);
        el.is().css(attrName, cssValue);
    }

    @When("^(?:I |)input \"([^\"]*)\" in \"([^\"]*)\" element$")
    public void input(String value, String locator) {
        BaseUIElement el = $(locator);
        el.input(value);
    }

    @Then("^the \"([^\"]*)\" element placeholder equals to \"([^\"]*)\"$")
    public void placeholderEquals(String locator, String placeholder) {
        JDIBase el = $(locator);
        el.is().attr("placeholder", placeholder);
    }

    @Then("^the \"([^\"]*)\" element attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void attributeEquals(String locator, String attrName, String attrValue) {
        JDIBase el = $(locator);
        el.is().attr(attrName, attrValue);
    }

    @Then("^the \"([^\"]*)\" element is enabled$")
    public void isEnabled(String locator) {
        JDIBase el = $(locator);
        el.is().enabled();
    }

    @Then("^the \"([^\"]*)\" element is disabled$")
    public void isDisabled(String locator) {
        JDIBase el = $(locator);
        el.is().disabled();
    }

    @Then("^the \"([^\"]*)\" element is hidden$")
    public void isHidden(String locator) {
        JDIBase el = $(locator);
        el.is().hidden();
    }

    @Then("^the \"([^\"]*)\" element does not appear$")
    public void isNotAppear(String locator) {
        JDIBase el = $(locator);
        el.is().notAppear();
    }

    @Then("^the \"([^\"]*)\" element is displayed$")
    public void isDisplayed(String locator) {
        JDIBase el = $(locator);
        el.is().displayed();
    }

    @When("^(?:I |)set text \"([^\"]*)\" in \"([^\"]*)\" element$")
    public void setText(String value, String locator) {
        JDIBase el = $(locator);
        el.setText(value);
    }

    @When("^(?:I |)select \"([^\"]*)\" field from \"([^\"]*)\" element$")
    public void select(String value, String locator) {
        BaseUIElement el = $(locator);
        el.select(value);
    }
}
