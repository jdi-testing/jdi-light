package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class JDISteps {

    @Given("^I open \"([^\"]*)\"(?: page|)$")
    public void iMOpen(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.shouldBeOpened();
    }

    //#region When
    @When("^Refresh webpage$")
    public void refreshWebpage() {
        WebPage.refresh();
    }

    /*BaseUIElement methods*/
    @When("^(?:I |)Click on \"([^\"]*)\"$")
    public void click(String name) {
        BaseUIElement el = getUI(name);
        el.click();
    }

    @When("^(?:I |)Send keys \"([^\"]*)\" to \"([^\"]*)\"$")
    public void sendKeys(String value, String name) {
        BaseUIElement el = getUI(name);
        el.sendKeys(value);
    }

    @When("^(?:I |)Check \"([^\"]*)\"$")
    public void check(String name) {
        BaseUIElement el = getUI(name);
        el.check();
    }

    @When("^(?:I |)Uncheck \"([^\"]*)\"$")
    public void uncheck(String name) {
        BaseUIElement el = getUI(name);
        el.uncheck();
    }

    @When("^(?:I |)Clear \"([^\"]*)\"$")
    public void clear(String name) {
        BaseUIElement el = getUI(name);
        el.clear();
    }

    @When("^(?:I |)Click with JS on \"([^\"]*)\"$")
    public void jsClick(String name) {
        BaseUIElement el = getUI(name);
        el.jsClick();
    }

    @When("^(?:I |)Input \"([^\"]*)\" in \"([^\"]*)\"$")
    public void input(String value, String name) {
        BaseUIElement el = getUI(name);
        el.input(value);
    }

    @When("^(?:I |)Select \"([^\"]*)\" field from \"([^\"]*)\"$")
    public void select(String value, String name) {
        BaseUIElement el = getUI(name);
        el.select(value);
    }

    @When("^(?:I |)Select \"([^\"]*)\" fields from \"([^\"]*)\"$")
    public void multiSelect(String values, String name) {
        BaseUIElement el = getUI(name);
        el.select(values.split(";"));
    }

    @When("^(?:I |)Focus on \"([^\"]*)\"$")
    public void focusOn(String name) {
        BaseUIElement el = getUI(name);
        el.focus();
    }

    @When("^(?:I |)Set text \"([^\"]*)\" in \"([^\"]*)\"$")
    public void setText(String value, String name) {
        BaseUIElement el = getUI(name);
        el.setText(value);
    }

    @When("^(?:I |)Double click on \"([^\"]*)\"$")
    public void doubleClick(String name) {
        BaseUIElement el = getUI(name);
        el.doubleClick();
    }

    @When("^(?:I |)Right click on \"([^\"]*)\"$")
    public void rightClick(String name) {
        BaseUIElement el = getUI(name);
        el.rightClick();
    }

    @When("^(?:I |)Highlight \"([^\"]*)\"$")
    public void highlight(String name) {
        BaseUIElement el = getUI(name);
        el.highlight();
    }

    @When("^(?:I |)Show \"([^\"]*)\"$")
    public void show(String name) {
        BaseUIElement el = getUI(name);
        el.show();
    }

    @When("^(?:I |)Set \"([^\"]*)\" attribute \"([^\"]*)\" with vlaue \"([^\"]*)\" element$")
    public void setAttribute(String name, String attrName, String attrValue) {
        BaseUIElement el = getUI(name);
        el.setAttribute(attrName, attrValue);
    }
    //#endregion
    //#region Then

    @Then("^\"([^\"]*)\" (?:page |)is opened$")
    public void iMOn(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.shouldBeOpened();
    }

    @Then("^\"([^\"]*)\" (?:page |)is opened with params \"([^\"]*)\"$")
    public void pageOpenedParams(String pageName, Object params) {
        WebPage page = PAGES.get(pageName);
        page.shouldBeOpened(params);
    }

    @Then("^\"([^\"]*)\" label text equals to \"([^\"]*)\"$")
    public void labelTextEquals(String name, String value) {
        BaseUIElement el = getUI(name);
        el.label().has().text(equalTo(value));
    }

    @Then("^\"([^\"]*)\" label text contains \"([^\"]*)\"$")
    public void labelTextContains(String name, String value) {
        BaseUIElement el = getUI(name);
        el.label().has().text(containsString(value));
    }

    @Then("^\"([^\"]*)\" label text match to \"([^\"]*)\"$")
    public void labelTextMatchRegex(String name, String regex) {
        BaseUIElement el = getUI(name);
        el.label().has().text(matchesPattern(regex));
    }

    @Then("\"([^\"]*)\" is selected$")
    public void isSelected(String name) {
        BaseUIElement el = getUI(name);
        el.is().selected();
    }

    @Then("^\"([^\"]*)\" is deselected$")
    public void isDeselected(String name) {
        BaseUIElement el = getUI(name);
        el.is().deselected();
    }

    @Then("^\"([^\"]*)\" placeholder equals to \"([^\"]*)\"$")
    public void placeholderEquals(String name, String placeholder) {
        BaseUIElement el = getUI(name);
        el.is().attr("placeholder", placeholder);
    }

    @Then("^\"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
    public void placeholderContains(String name, String placeholder) {
        BaseUIElement el = getUI(name);
        el.is().attr("placeholder", containsString(placeholder));
    }

    @Then("^\"([^\"]*)\" placeholder match to \"([^\"]*)\"$")
    public void placeholderMatchRegex(String name, String regex) {
        BaseUIElement el = getUI(name);
        el.is().attr("placeholder", matchesPattern(regex));
    }

    @Then("^\"([^\"]*)\" text equals to \"([^\"]*)\"$")
    public void textEquals(String name, String value) {
        BaseUIElement el = getUI(name);
        el.is().text(value);
    }

    @Then("^\"([^\"]*)\" text contains \"([^\"]*)\"$")
    public void textContains(String name, String value) {
        BaseUIElement el = getUI(name);
        el.is().text(containsString(value));
    }

    @Then("^\"([^\"]*)\" text match to \"([^\"]*)\"$")
    public void textMatchRegex(String name, String regex) {
        BaseUIElement el = getUI(name);
        el.is().text(matchesPattern(regex));
    }

    @Then("^\"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void attributeEquals(String name, String attrName, String attrValue) {
        BaseUIElement el = getUI(name);
        el.is().attr(attrName, attrValue);
    }

    @Then("^\"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void attributeContains(String name, String attrName, String attrValue) {
        BaseUIElement el = getUI(name);
        el.is().attr(attrName, containsString(attrValue));
    }

    @Then("^\"([^\"]*)\" attribute \"([^\"]*)\" match to \"([^\"]*)\"$")
    public void attributeMatchRegex(String name, String attrName, String regex) {
        BaseUIElement el = getUI(name);
        el.is().attr(attrName, matchesPattern(regex));
    }

    @Then("^\"([^\"]*)\" css \"([^\"]*)\" equals to \"([^\"]*)\"$")
    public void cssEquals(String name, String attrName, String cssValue) {
        BaseUIElement el = getUI(name);
        el.is().css(attrName, cssValue);
    }

    @Then("^\"([^\"]*)\" css \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void cssContains(String name, String css, String cssValue) {
        BaseUIElement el = getUI(name);
        el.is().css(css, containsString(cssValue));
    }

    @Then("^\"([^\"]*)\" css \"([^\"]*)\" match to \"([^\"]*)\"$")
    public void cssMatchRegex(String name, String css, String regex) {
        BaseUIElement el = getUI(name);
        el.is().css(css, matchesPattern(regex));
    }

    @Then("\"([^\"]*)\" is enabled$")
    public void isEnabled(String name) {
        BaseUIElement el = getUI(name);
        el.is().enabled();
    }

    @Then("^\"([^\"]*)\" is disabled$")
    public void isDisabled(String name) {
        BaseUIElement el = getUI(name);
        el.is().disabled();
    }

    @Then("^\"([^\"]*)\" is displayed$")
    public void isDisplayed(String name) {
        BaseUIElement el = getUI(name);
        el.is().displayed();
    }

    @Then("^\"([^\"]*)\" is hidden$")
    public void isHidden(String name) {
        BaseUIElement el = getUI(name);
        el.is().hidden();
    }

    @Then("^\"([^\"]*)\" disappear$")
    public void isDisappear(String name) {
        BaseUIElement el = getUI(name);
        el.is().disappear();
    }

    @Then("^\"([^\"]*)\" is not appear$")
    public void isNotAppear(String name) {
        BaseUIElement el = getUI(name);
        el.is().notAppear();
    }

    @Then("^\"([^\"]*)\" is not appear during \"([^\"]*)\"$")
    public void isNotAppear(String name, int seconds) {
        BaseUIElement el = getUI(name);
        el.is().notAppear(seconds);
    }
    //#endregion

    @Then("^Current URL is \"(.*?)\"$")
    public void currentUrlIs(String expectedUrl) {
        assertEquals(getUrl(), expectedUrl);
    }

    @Then("^Current page Title is \"(.*?)\"$")
    public void titleIs(String expectedUrl) {
        assertEquals(getTitle(), expectedUrl);
    }

}
