package com.epam.jdi.bdd;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;

import static com.epam.jdi.bdd.BDDUtils.*;
import static com.epam.jdi.light.common.ElementArea.JS;
import static com.epam.jdi.light.driver.WebDriverByUtils.byText;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getPage;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.light.settings.WebSettings.getDomain;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JDISteps {
    @Given("I open application")
    public void iMOpenSite() {
        openUrl(getDomain());
    }

    @Given("I open {string} page")
    @Given("I open {string}")
    public void iOpen(String pageName) {
        if (pageName.startsWith("http")) {
            WebPage.openUrl(pageName);
            return;
        }
        getPage(pageName).shouldBeOpened();
    }

    @Given("I'm on {string} page")
    @Given("I'm on {string}")
    public void iMOpen(String pageName) {
        iOpen(pageName);
    }

    @Given("I open {string} page with params {string}")
    @Given("I open {string} with params {string}")
    public void iMOpenParams(String pageName, Object params) {
        getPage(pageName).shouldBeOpened(params);
    }

    //#region When
    @When("I refresh webpage")
    @When("refresh webpage")
    public void refreshWebpage() {
        WebPage.refresh();
    }

    @When("I click on {string}")
    @When("click on {string}")
    public void click(String name) {
        getUI(name, IClickable.class).click();
    }

    @When("I send keys {string} to {string}")
    @When("send keys {string} to {string}")
    public void sendKeys(String value, String name) {
        input(name).sendKeys(value);
    }

    @When("I check {string}")
    @When("check {string}")
    public void check(String name) {
        getUI(name, HasCheck.class).check();
    }

    @When("I uncheck {string}")
    @When("uncheck {string}")
    public void uncheck(String name) {
        getUI(name, HasCheck.class).uncheck();
    }

    @When("I clear {string}")
    @When("clear {string}")
    public void clear(String name) {
        input(name).clear();
    }

    @When("I click with JS on {string}")
    @When("click with JS on {string}")
    public void jsClick(String name) {
        getUI(name, HasClick.class).click(JS);
    }

    @When("I input {string} in {string}")
    @When("input {string} in {string}")
    public void inputText(String value, String name) {
        input(name).input(value);
    }

    @When("I select {string} field from {string}")
    @When("select {string} field from {string}")
    public void select(String value, String name) {
        getUI(name, ISelector.class).select(value);
    }

    @When("I focus on {string}")
    @When("focus on {string}")
    public void focusOn(String name) {
        input(name).focus();
    }

    @When("I set text {string} in {string}")
    @When("set text {string} in {string}")
    public void setText(String value, String name) {
        input(name).setText(value);
    }

    @When("I double click on {string}")
    @When("double click on {string}")
    public void doubleClick(String name) {
        getUI(name, HasClick.class).doubleClick();
    }

    @When("I right click on {string}")
    @When("right click on {string}")
    public void rightClick(String name) {
        getUI(name, HasClick.class).rightClick();
    }

    @When("I highlight {string}")
    @When("highlight {string}")
    public void highlight(String name) {
        getUI(name).highlight();
    }

    @When("I show {string}")
    @When("show {string}")
    public void show(String name) {
        getUI(name).show();
    }

    @When("I set {string} attribute {string} with value {string} element")
    @When("set {string} attribute {string} with value {string} element")
    public void setAttribute(String name, String attrName, String attrValue) {
        core(name).setAttribute(attrName, attrValue);
    }

    @When("I go forward")
    @When("go forward")
    public void goForward() {
        WebPage.forward();
    }

    @When("I go back")
    @When("go back")
    public void goBack() {
        WebPage.back();
    }

    @When("I set browser size to {int}(px) width and {int}(px) height")
    @When("set browser size to {int}(px) width and {int}(px) height")
    public void setBrowserSize(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        WebDriverFactory.getDriver().manage().window().setSize(dimension);
    }

    @Given("Page with url {string} opened")
    @When("I open url {string}")
    @When("open url {string}")
    public void iOpenUrl(String url) {
        openUrl(url);
    }

    //#endregion
    //#region Then
    @Then("the {string} page is opened")
    @Then("the {string} is opened")
    public void iMOn(String pageName) {
        getPage(pageName).shouldBeOpened();
    }

    @Then("the {string} page is opened with params {string}")
    @Then("the {string} is opened with params {string}")
    public void pageOpenedParams(String pageName, Object params) {
        getPage(pageName).shouldBeOpened(params);
    }

    @Then("the {string} label text equals to {string}")
    public void labelTextEquals(String name, String value) {
        getUI(name, HasLabel.class).label().has().text(equalTo(value));
    }

    @Then("the {string} label text contains {string}")
    public void labelTextContains(String name, String value) {
        label(name).has().text(containsString(value));
    }

    @Then("the {string} label text matches to {string}")
    public void labelTextMatchRegex(String name, String regex) {
        label(name).has().text(matchesPattern(regex));
    }

    @Then("the {string} is selected")
    public void isSelected(String name) {
        selectedAssert(name).selected();
    }

    @Then("the {string} is deselected")
    public void isDeselected(String name) {
        selectedAssert(name).deselected();
    }

    @Then("the {string} placeholder equals to {string}")
    public void placeholderEquals(String name, String placeholder) {
        isAssert(name).attr("placeholder", placeholder);
    }

    @Then("the {string} placeholder contains {string}")
    public void placeholderContains(String name, String placeholder) {
        isAssert(name).attr("placeholder", containsString(placeholder));
    }

    @Then("the {string} placeholder matches to {string}")
    public void placeholderMatchRegex(String name, String regex) {
        isAssert(name).attr("placeholder", matchesPattern(regex));
    }

    @Then("the {string} text equals to {string}")
    public void textEquals(String name, String value) {
        textAssert(name).text(value);
    }

    @Then("the {string} text contains {string}")
    public void textContains(String name, String value) {
        textAssert(name).text(containsString(value));
    }

    @Then("the {string} text matches to {string}")
    public void textMatchRegex(String name, String regex) {
        textAssert(name).text(matchesPattern(regex));
    }

    @Then("the {string} attribute {string} equals to {string}")
    public void attributeEquals(String name, String attrName, String attrValue) {
        isAssert(name).attr(attrName, attrValue);
    }

    @Then("the {string} attribute {string} contains {string}")
    public void attributeContains(String name, String attrName, String attrValue) {
        isAssert(name).attr(attrName, containsString(attrValue));
    }

    @Then("the {string} attribute {string} matches to {string}")
    public void attributeMatchRegex(String name, String attrName, String regex) {
        isAssert(name).attr(attrName, matchesPattern(regex));
    }

    @Then("the {string} css {string} equals to {string}")
    public void cssEquals(String name, String attrName, String cssValue) {
        isAssert(name).css(attrName, cssValue);
    }

    @Then("the {string} css {string} contains {string}")
    public void cssContains(String name, String css, String cssValue) {
        isAssert(name).css(css, containsString(cssValue));
    }

    @Then("the {string} css {string} matches to {string}")
    public void cssMatchRegex(String name, String css, String regex) {
        isAssert(name).css(css, matchesPattern(regex));
    }

    @Then("the {string} is enabled")
    public void isEnabled(String name) {
        uiAssert(name).enabled();
    }

    @Then("the {string} is disabled")
    public void isDisabled(String name) {
        uiAssert(name).disabled();
    }

    @Then("the {string} is displayed")
    public void isDisplayed(String name) {
        uiAssert(name).displayed();
    }

    @Then("the {string} is hidden")
    public void isHidden(String name) {
        uiAssert(name).hidden();
    }

    @Then("the {string} disappear")
    public void isDisappear(String name) {
        uiAssert(name).disappear();
    }

    @Then("the {string} does not appear")
    public void isNotAppear(String name) {
        uiAssert(name).notAppear();
    }

    @Then("the {string} does not appear during {int}")
    @Then("the {string} does not appear during {int} seconds")
    public void isNotAppear(String name, int seconds) {
        uiAssert(name).notAppear(seconds);
    }

    @Then("the {string} text is on the page")
    @Then("the {string} text is on page")
    public void textOnPage(String text) {
        $(byText(text)).is().displayed();
    }

    @Then("the current page url is {string}")
    public void urlIs(String expectedUrl) {
        assertThat(expectedUrl, is(getUrl()));
    }

    @Then("the current page title is {string}")
    public void titleIs(String expectedUrl) {
        assertThat(expectedUrl, is(getTitle()));
    }
    //#endregion

}
