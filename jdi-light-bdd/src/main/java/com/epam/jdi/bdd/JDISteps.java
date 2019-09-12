package com.epam.jdi.bdd;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;

import static com.epam.jdi.light.common.ElementArea.JS;
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
    @When("^(?:I |)refresh webpage$")
    public void refreshWebpage() {
        WebPage.refresh();
    }
	@When("^(?:I |)click on \"([^\"]*)\"$")
    public void click(String name) {
		getUI(name).click();
    }
	@When("^(?:I |)send keys \"([^\"]*)\" to \"([^\"]*)\"$")
	public void sendKeys(String value, String name) {
		getUI(name).sendKeys(value);
	}
	@When("^(?:I |)check \"([^\"]*)\"$")
	public void check(String name) {
		getUI(name).check();
	}
	@When("^(?:I |)uncheck \"([^\"]*)\"$")
	public void uncheck(String name) {
		getUI(name).uncheck();
	}
	@When("^(?:I |)clear \"([^\"]*)\"$")
	public void clear(String name) {
		getUI(name).clear();
	}
	@When("^(?:I |)click with JS on \"([^\"]*)\"$")
	public void jsClick(String name) {
		getUI(name).click(JS);
	}
	@When("^(?:I |)input \"([^\"]*)\" in \"([^\"]*)\"$")
	public void input(String value, String name) {
		getUI(name).input(value);
	}
	@When("^(?:I |)select \"([^\"]*)\" field from \"([^\"]*)\"$")
    public void select(String value, String name) {
        getUI(name).select(value);
    }
	@When("^(?:I |)focus on \"([^\"]*)\"$")
	public void focusOn(String name) {
		getUI(name).focus();
	}
	@When("^(?:I |)set text \"([^\"]*)\" in \"([^\"]*)\"$")
	public void setText(String value, String name) {
		getUI(name).setText(value);
	}
	@When("^(?:I |)double click on \"([^\"]*)\"$")
	public void doubleClick(String name) {
		getUI(name).doubleClick();
	}
	@When("^(?:I |)right click on \"([^\"]*)\"$")
	public void rightClick(String name) {
		getUI(name).rightClick();
	}

	@When("^(?:I |)highlight \"([^\"]*)\"$")
	public void highlight(String name) {
		getUI(name).highlight();
	}

	@When("^(?:I |)show \"([^\"]*)\"$")
	public void show(String name) {
		getUI(name).show();
	}

    @When("^(?:I |)set \"([^\"]*)\" attribute \"([^\"]*)\" with value \"([^\"]*)\" element$")
	public void setAttribute(String name, String attrName, String attrValue) {
		getUI(name).setAttribute(attrName, attrValue);
	}

	@When("^(?:I |)go forward$")
	public void goForward() {
		WebPage.forward();
	}

	@When("^(?:I |)go back$")
	public void goBack() {
		WebPage.back();
	}

	@When("^(?:I |)set browser size to \"(\\d+)\"px width and \"(\\d+)\"px height$")
	public void setBrowserSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		WebDriverFactory.getDriver().manage().window().setSize(dimension);
	}

	@When("^(?:I |)open url \"([^\"]*)\"$")
	public void openUrl(String url) {
		WebPage.openUrl(url);
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
		getUI(name).label().has().text(equalTo(value));
	}

	@Then("^the \"([^\"]*)\" label text contains \"([^\"]*)\"$")
	public void labelTextContains(String name, String value) {
		getUI(name).label().has().text(containsString(value));
	}

	@Then("^the \"([^\"]*)\" label text matches to \"([^\"]*)\"$")
	public void labelTextMatchRegex(String name, String regex) {
		getUI(name).label().has().text(matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" is selected$")
	public void isSelected(String name) {
		getUI(name).is().selected();
	}

	@Then("^the \"([^\"]*)\" is deselected$")
	public void isDeselected(String name) {
		getUI(name).is().deselected();
	}

	@Then("^the \"([^\"]*)\" placeholder equals to \"([^\"]*)\"$")
	public void placeholderEquals(String name, String placeholder) {
		getUI(name).is().attr("placeholder", placeholder);
	}

	@Then("^the \"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
	public void placeholderContains(String name, String placeholder) {
		getUI(name).is().attr("placeholder", containsString(placeholder));
	}

	@Then("^the \"([^\"]*)\" placeholder matches to \"([^\"]*)\"$")
	public void placeholderMatchRegex(String name, String regex) {
		getUI(name).is().attr("placeholder", matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" text equals to \"([^\"]*)\"$")
	public void textEquals(String name, String value) {
		getUI(name).is().text(value);
	}

	@Then("^the \"([^\"]*)\" text contains \"([^\"]*)\"$")
	public void textContains(String name, String value) {
		getUI(name).is().text(containsString(value));
	}

	@Then("^the \"([^\"]*)\" text matches to \"([^\"]*)\"$")
	public void textMatchRegex(String name, String regex) {
		getUI(name).is().text(matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void attributeEquals(String name, String attrName, String attrValue) {
		getUI(name).is().attr(attrName, attrValue);
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		getUI(name).is().attr(attrName, containsString(attrValue));
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" matches to \"([^\"]*)\"$")
	public void attributeMatchRegex(String name, String attrName, String regex) {
		getUI(name).is().attr(attrName, matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void cssEquals(String name, String attrName, String cssValue) {
		getUI(name).is().css(attrName, cssValue);
	}
	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void cssContains(String name, String css, String cssValue) {
		getUI(name).is().css(css, containsString(cssValue));
	}

	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" matches to \"([^\"]*)\"$")
	public void cssMatchRegex(String name, String css, String regex) {
		getUI(name).is().css(css, matchesPattern(regex));
	}
	@Then("^the \"([^\"]*)\" is enabled$")
	public void isEnabled(String name) {
		getUI(name).is().enabled();
	}

	@Then("^the \"([^\"]*)\" is disabled$")
	public void isDisabled(String name) {
		getUI(name).is().disabled();
	}

	@Then("^the \"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		getUI(name).is().displayed();
	}

	@Then("^the \"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		getUI(name).is().hidden();
	}
	@Then("^the \"([^\"]*)\" disappear$")
	public void isDisappear(String name) {
		getUI(name).is().disappear();
	}
	@Then("^the \"([^\"]*)\" does not appear$")
	public void isNotAppear(String name) {
		getUI(name).is().notAppear();
	}

	@Then("^the \"([^\"]*)\" does not appear during \"([^\"]*)\"$")
	public void isNotAppear(String name, int seconds) {
		getUI(name).is().notAppear(seconds);
	}
	//#endregion

    @Then("^the current page url is \"(.*?)\"$")
    public void urlIs(String expectedUrl) {
        assertEquals(expectedUrl, getUrl());
    }
	@Then("^the current page title is \"([^\"]*)\"$")
	public void titleIs(String expectedUrl) {
		assertEquals(expectedUrl, getTitle());
	}

}
