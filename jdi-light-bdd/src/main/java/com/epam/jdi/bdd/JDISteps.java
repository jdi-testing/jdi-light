package com.epam.jdi.bdd;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.PAGES;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class JDISteps {

	@Given("^I open \"([^\"]*)\"(?: page|)$")
    public void iMOpen(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.shouldBeOpened();
    }
	@Given("^I open \"([^\"]*)\"(?: page|) with params \"([^\"]*)\"$")
	public void iMOpenParams(String pageName, Object params) {
		WebPage page = PAGES.get(pageName);
		page.shouldBeOpened(params);
	}

	//#region When
    @When("^Refresh webpage$")
    public void refreshWebpage() {
        WebPage.refresh();
    }
	@When("^(?:I |)Click on \"([^\"]*)\"$")
    public void click(String name) {
		getUI(name).click();
    }
	@When("^(?:I |)Send keys \"([^\"]*)\" to \"([^\"]*)\"$")
	public void sendKeys(String value, String name) {
		getUI(name).sendKeys(value);
	}
	@When("^(?:I |)Check \"([^\"]*)\"$")
	public void check(String name) {
		getUI(name).check();
	}
	@When("^(?:I |)Uncheck \"([^\"]*)\"$")
	public void uncheck(String name) {
		getUI(name).uncheck();
	}
	@When("^(?:I |)Clear \"([^\"]*)\"$")
	public void clear(String name) {
		getUI(name).clear();
	}
	@When("^(?:I |)Click with JS on \"([^\"]*)\"$")
	public void jsClick(String name) {
		getUI(name).jsClick();
	}
	@When("^(?:I |)Input \"([^\"]*)\" in \"([^\"]*)\"$")
	public void input(String value, String name) {
		getUI(name).input(value);
	}
	@When("^(?:I |)Select \"([^\"]*)\" field from \"([^\"]*)\"$")
    public void select(String value, String name) {
        getUI(name).select(value);
    }
	@When("^(?:I |)Select \"([^\"]*)\" fields from \"([^\"]*)\"$")
    public void multiSelect(String values, String name) {
        getUI(name).select(values.split(";"));
    }
	@When("^(?:I |)Focus on \"([^\"]*)\"$")
	public void focusOn(String name) {
		getUI(name).focus();
	}
	@When("^(?:I |)Set text \"([^\"]*)\" in \"([^\"]*)\"$")
	public void setText(String value, String name) {
		getUI(name).setText(value);
	}
	@When("^(?:I |)Double click on \"([^\"]*)\"$")
	public void doubleClick(String name) {
		getUI(name).doubleClick();
	}
	@When("^(?:I |)Right click on \"([^\"]*)\"$")
	public void rightClick(String name) {
		getUI(name).rightClick();
	}
	@When("^(?:I |)Highlight \"([^\"]*)\"$")
	public void highlight(String name) {
		getUI(name).highlight();
	}
	@When("^(?:I |)Show \"([^\"]*)\"$")
	public void show(String name) {
		getUI(name).show();
	}
    @When("^(?:I |)Set \"([^\"]*)\" attribute \"([^\"]*)\" with value \"([^\"]*)\" element$")
	public void setAttribute(String name, String attrName, String attrValue) {
		getUI(name).setAttribute(attrName, attrValue);
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
		getUI(name).label().has().text(equalTo(value));
	}
	@Then("^\"([^\"]*)\" label text contains \"([^\"]*)\"$")
	public void labelTextContains(String name, String value) {
		getUI(name).label().has().text(containsString(value));
	}
	@Then("^\"([^\"]*)\" label text match to \"([^\"]*)\"$")
	public void labelTextMatchRegex(String name, String regex) {
		getUI(name).label().has().text(matchesPattern(regex));
	}
	@Then("\"([^\"]*)\" is selected$")
	public void isSelected(String name) {
		getUI(name).is().selected();
	}
	@Then("^\"([^\"]*)\" is deselected$")
	public void isDeselected(String name) {
		getUI(name).is().deselected();
	}
	@Then("^\"([^\"]*)\" placeholder equals to \"([^\"]*)\"$")
	public void placeholderEquals(String name, String placeholder) {
		getUI(name).is().attr("placeholder", placeholder);
	}
	@Then("^\"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
	public void placeholderContains(String name, String placeholder) {
		getUI(name).is().attr("placeholder", containsString(placeholder));
	}
	@Then("^\"([^\"]*)\" placeholder match to \"([^\"]*)\"$")
	public void placeholderMatchRegex(String name, String regex) {
		getUI(name).is().attr("placeholder", matchesPattern(regex));
	}
	@Then("^\"([^\"]*)\" text equals to \"([^\"]*)\"$")
	public void textEquals(String name, String value) {
		getUI(name).is().text(value);
	}
	@Then("^\"([^\"]*)\" text contains \"([^\"]*)\"$")
	public void textContains(String name, String value) {
		getUI(name).is().text(containsString(value));
	}
	@Then("^\"([^\"]*)\" text match to \"([^\"]*)\"$")
	public void textMatchRegex(String name, String regex) {
		getUI(name).is().text(matchesPattern(regex));
	}
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void attributeEquals(String name, String attrName, String attrValue) {
		getUI(name).is().attr(attrName, attrValue);
	}
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		getUI(name).is().attr(attrName, containsString(attrValue));
	}
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" match to \"([^\"]*)\"$")
	public void attributeMatchRegex(String name, String attrName, String regex) {
		getUI(name).is().attr(attrName, matchesPattern(regex));
	}
	@Then("^\"([^\"]*)\" css \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void cssEquals(String name, String attrName, String cssValue) {
		getUI(name).is().css(attrName, cssValue);
	}
	@Then("^\"([^\"]*)\" css \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void cssContains(String name, String css, String cssValue) {
		getUI(name).is().css(css, containsString(cssValue));
	}
	@Then("^\"([^\"]*)\" css \"([^\"]*)\" match to \"([^\"]*)\"$")
	public void cssMatchRegex(String name, String css, String regex) {
		getUI(name).is().css(css, matchesPattern(regex));
	}
	@Then("\"([^\"]*)\" is enabled$")
	public void isEnabled(String name) {
		getUI(name).is().enabled();
	}
	@Then("^\"([^\"]*)\" is disabled$")
	public void isDisabled(String name) {
		getUI(name).is().disabled();
	}
	@Then("^\"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		getUI(name).is().displayed();
	}
	@Then("^\"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		getUI(name).is().hidden();
	}
	@Then("^\"([^\"]*)\" disappear$")
	public void isDisappear(String name) {
		getUI(name).is().disappear();
	}
	@Then("^\"([^\"]*)\" is not appear$")
	public void isNotAppear(String name) {
		getUI(name).is().notAppear();
	}
	@Then("^\"([^\"]*)\" is not appear during \"([^\"]*)\"$")
	public void isNotAppear(String name, int seconds) {
		getUI(name).is().notAppear(seconds);
	}
	//#endregion

    @Then("^Current page URL is \"(.*?)\"$")
    public void urlIs(String expectedUrl) {
        assertEquals(getUrl(), expectedUrl);
    }
	@Then("^Current page Title is \"(.*?)\"$")
	public void titleIs(String expectedUrl) {
		assertEquals(getTitle(), expectedUrl);
	}
}
