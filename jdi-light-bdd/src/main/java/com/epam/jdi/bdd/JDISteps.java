package com.epam.jdi.bdd;

import static com.epam.jdi.light.elements.composite.WebPage.PAGES;
import static org.hamcrest.Matchers.*;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.composite.WebPage;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.elements.composite.WebPage.*;

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
/*
    @Then("^the \"([^\"]*)\" selected value is \"([^\"]*)\"$")
    public void valueSelected(String name, String value) {
        BaseUIElement el = getUI(name);
        assertEquals(el.getValue(), value);
    }
*/
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

    @When("^(?:I |)Set \"([^\"]*)\" attribute \"([^\"]*)\" with value \"([^\"]*)\" element$")
	public void setAttribute(String name, String attrName, String attrValue) {
		BaseUIElement el = getUI(name);
		el.setAttribute(attrName, attrValue);
	}
	//#endregion
	//#region Then
	@Then("^the \"([^\"]*)\" (?:page |)is opened$")
	public void iMOn(String pageName) {
		WebPage page = PAGES.get(pageName);
		page.shouldBeOpened();
	}
	@Then("^the \"([^\"]*)\" (?:page |)is opened with params \"([^\"]*)\"$")
	public void pageOpenedParams(String pageName, Object params) {
		WebPage page = PAGES.get(pageName);
		page.shouldBeOpened(params);
	}
	@Then("^the \"([^\"]*)\" label text equals to \"([^\"]*)\"$")
	public void labelTextEquals(String name, String value) {
		BaseUIElement el = getUI(name);
		el.label().has().text(equalTo(value));
	}

	@Then("^the \"([^\"]*)\" label text contains \"([^\"]*)\"$")
	public void labelTextContains(String name, String value) {
		BaseUIElement el = getUI(name);
		el.label().has().text(containsString(value));
	}

	@Then("^the \"([^\"]*)\" label text matches to \"([^\"]*)\"$")
	public void labelTextMatchRegex(String name, String regex) {
		BaseUIElement el = getUI(name);
		el.label().has().text(matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" is selected$")
	public void isSelected(String name) {
		BaseUIElement el = getUI(name);
		el.is().selected();
	}

	@Then("^the \"([^\"]*)\" is deselected$")
	public void isDeselected(String name) {
		BaseUIElement el = getUI(name);
		el.is().deselected();
	}

	@Then("^the \"([^\"]*)\" placeholder equals to \"([^\"]*)\"$")
	public void placeholderEquals(String name, String placeholder) {
		BaseUIElement el = getUI(name);
		el.is().attr("placeholder", placeholder);
	}

	@Then("^the \"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
	public void placeholderContains(String name, String placeholder) {
		BaseUIElement el = getUI(name);
		el.is().attr("placeholder", containsString(placeholder));
	}

	@Then("^the \"([^\"]*)\" placeholder matches to \"([^\"]*)\"$")
	public void placeholderMatchRegex(String name, String regex) {
		BaseUIElement el = getUI(name);
		el.is().attr("placeholder", matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" text equals to \"([^\"]*)\"$")
	public void textEquals(String name, String value) {
		BaseUIElement el = getUI(name);
		el.is().text(value);
	}

	@Then("^the \"([^\"]*)\" text contains \"([^\"]*)\"$")
	public void textContains(String name, String value) {
		BaseUIElement el = getUI(name);
		el.is().text(containsString(value));
	}

	@Then("^the \"([^\"]*)\" text matches to \"([^\"]*)\"$")
	public void textMatchRegex(String name, String regex) {
		BaseUIElement el = getUI(name);
		el.is().text(matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void attributeEquals(String name, String attrName, String attrValue) {
		BaseUIElement el = getUI(name);
		el.is().attr(attrName, attrValue);
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		BaseUIElement el = getUI(name);
		el.is().attr(attrName, containsString(attrValue));
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" matches to \"([^\"]*)\"$")
	public void attributeMatchRegex(String name, String attrName, String regex) {
		BaseUIElement el = getUI(name);
		el.is().attr(attrName, matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void cssEquals(String name, String attrName, String cssValue) {
		BaseUIElement el = getUI(name);
		el.is().css(attrName, cssValue);
	}
	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void cssContains(String name, String css, String cssValue) {
		BaseUIElement el = getUI(name);
		el.is().css(css, containsString(cssValue));
	}

	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" matches to \"([^\"]*)\"$")
	public void cssMatchRegex(String name, String css, String regex) {
		BaseUIElement el = getUI(name);
		el.is().css(css, matchesPattern(regex));
	}
	@Then("^the \"([^\"]*)\" is enabled$")
	public void isEnabled(String name) {
		BaseUIElement el = getUI(name);
		el.is().enabled();
	}

	@Then("^the \"([^\"]*)\" is disabled$")
	public void isDisabled(String name) {
		BaseUIElement el = getUI(name);
		el.is().disabled();
	}

	@Then("^the \"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		BaseUIElement el = getUI(name);
		el.is().displayed();
	}

	@Then("^the \"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		BaseUIElement el = getUI(name);
		el.is().hidden();
	}
	@Then("^the \"([^\"]*)\" disappear$")
	public void isDisappear(String name) {
		BaseUIElement el = getUI(name);
		el.is().disappear();
	}
	@Then("^the \"([^\"]*)\" does not appear$")
	public void isNotAppear(String name) {
		BaseUIElement el = getUI(name);
		el.is().notAppear();
	}

	@Then("^the \"([^\"]*)\" does not appear during \"([^\"]*)\"$")
	public void isNotAppear(String name, int seconds) {
		BaseUIElement el = getUI(name);
		el.is().notAppear(seconds);
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
