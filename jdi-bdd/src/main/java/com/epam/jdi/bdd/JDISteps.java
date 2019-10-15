package com.epam.jdi.bdd;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;

import static com.epam.jdi.bdd.BDDUtils.*;
import static com.epam.jdi.light.common.ElementArea.JS;
import static com.epam.jdi.light.driver.WebDriverByUtils.byText;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getPage;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.light.settings.WebSettings.getDomain;
import static com.epam.jdi.light.settings.WebSettings.init;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JDISteps {
	@Given("^I open application$")
	public void iMOpenSite() {
		init();
		openUrl(getDomain());
	}
	@Given("^I open \"([^\"]*)\"(?: page|)$")
    public void iOpen(String pageName) {
        if (pageName.startsWith("http")) {
			WebPage.openUrl(pageName);
			return;
		}
		getPage(pageName).shouldBeOpened();
    }
	@Given("^I'm on \"([^\"]*)\"(?: page|)$")
	public void iMOpen(String pageName) {
		iOpen(pageName);
	}
	@Given("^I open \"([^\"]*)\"(?: page|) with params \"([^\"]*)\"$")
	public void iMOpenParams(String pageName, Object params) {
		getPage(pageName).shouldBeOpened(params);
	}

	//#region When
    @When("^(?:I |)refresh webpage$")
    public void refreshWebpage() {
        WebPage.refresh();
    }
	@When("^(?:I |)click on \"([^\"]*)\"$")
    public void click(String name) {
		getUI(name, IClickable.class).click();
    }
	@When("^(?:I |)send keys \"([^\"]*)\" to \"([^\"]*)\"$")
	public void sendKeys(String value, String name) {
		input(name).sendKeys(value);
	}
	@When("^(?:I |)check \"([^\"]*)\"$")
	public void check(String name) {
		getUI(name, HasCheck.class).check();
	}
	@When("^(?:I |)uncheck \"([^\"]*)\"$")
	public void uncheck(String name) {
		getUI(name, HasCheck.class).uncheck();
	}
	@When("^(?:I |)clear \"([^\"]*)\"$")
	public void clear(String name) {
		input(name).clear();
	}
	@When("^(?:I |)click with JS on \"([^\"]*)\"$")
	public void jsClick(String name) {
		getUI(name, HasClick.class).click(JS);
	}
	@When("^(?:I |)input \"([^\"]*)\" in \"([^\"]*)\"$")
	public void inputText(String value, String name) {
		input(name).input(value);
	}
	@When("^(?:I |)select \"([^\"]*)\" field from \"([^\"]*)\"$")
    public void select(String value, String name) {
        getUI(name, ISelector.class).select(value);
    }
	@When("^(?:I |)focus on \"([^\"]*)\"$")
	public void focusOn(String name) {
		input(name).focus();
	}
	@When("^(?:I |)set text \"([^\"]*)\" in \"([^\"]*)\"$")
	public void setText(String value, String name) {
		input(name).setText(value);
	}
	@When("^(?:I |)double click on \"([^\"]*)\"$")
	public void doubleClick(String name) {
		getUI(name, HasClick.class).doubleClick();
	}
	@When("^(?:I |)right click on \"([^\"]*)\"$")
	public void rightClick(String name) {
		getUI(name, HasClick.class).rightClick();
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
		core(name).setAttribute(attrName, attrValue);
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

	@Given("Page with url \"([^\"]*)\" opened$")
	@When("^(?:I |)open url \"([^\"]*)\"$")
	public void iOpenUrl(String url) {
		openUrl(url);
	}

	//#endregion
	//#region Then
	@Then("^the \"([^\"]*)\" (?:page |)is opened$")
	public void iMOn(String pageName) {
		getPage(pageName).shouldBeOpened();
	}
	@Then("^the \"([^\"]*)\" (?:page |)is opened with params \"([^\"]*)\"$")
	public void pageOpenedParams(String pageName, Object params) {
		getPage(pageName).shouldBeOpened(params);
	}
	@Then("^the \"([^\"]*)\" label text equals to \"([^\"]*)\"$")
	public void labelTextEquals(String name, String value) {
		getUI(name, HasLabel.class).label().has().text(equalTo(value));
	}

	@Then("^the \"([^\"]*)\" label text contains \"([^\"]*)\"$")
	public void labelTextContains(String name, String value) {
		label(name).has().text(containsString(value));
	}

	@Then("^the \"([^\"]*)\" label text matches to \"([^\"]*)\"$")
	public void labelTextMatchRegex(String name, String regex) {
		label(name).has().text(matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" is selected$")
	public void isSelected(String name) {
		selectedAssert(name).selected();
	}

	@Then("^the \"([^\"]*)\" is deselected$")
	public void isDeselected(String name) {
		selectedAssert(name).deselected();
	}

	@Then("^the \"([^\"]*)\" placeholder equals to \"([^\"]*)\"$")
	public void placeholderEquals(String name, String placeholder) {
		isAssert(name).attr("placeholder", placeholder);
	}

	@Then("^the \"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
	public void placeholderContains(String name, String placeholder) {
		isAssert(name).attr("placeholder", containsString(placeholder));
	}

	@Then("^the \"([^\"]*)\" placeholder matches to \"([^\"]*)\"$")
	public void placeholderMatchRegex(String name, String regex) {
		isAssert(name).attr("placeholder", matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" text equals to \"([^\"]*)\"$")
	public void textEquals(String name, String value) {
		textAssert(name).text(value);
	}

	@Then("^the \"([^\"]*)\" text contains \"([^\"]*)\"$")
	public void textContains(String name, String value) {
		textAssert(name).text(containsString(value));
	}

	@Then("^the \"([^\"]*)\" text matches to \"([^\"]*)\"$")
	public void textMatchRegex(String name, String regex) {
		textAssert(name).text(matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void attributeEquals(String name, String attrName, String attrValue) {
		isAssert(name).attr(attrName, attrValue);
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		isAssert(name).attr(attrName, containsString(attrValue));
	}

	@Then("^the \"([^\"]*)\" attribute \"([^\"]*)\" matches to \"([^\"]*)\"$")
	public void attributeMatchRegex(String name, String attrName, String regex) {
		isAssert(name).attr(attrName, matchesPattern(regex));
	}

	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void cssEquals(String name, String attrName, String cssValue) {
		isAssert(name).css(attrName, cssValue);
	}
	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void cssContains(String name, String css, String cssValue) {
		isAssert(name).css(css, containsString(cssValue));
	}

	@Then("^the \"([^\"]*)\" css \"([^\"]*)\" matches to \"([^\"]*)\"$")
	public void cssMatchRegex(String name, String css, String regex) {
		isAssert(name).css(css, matchesPattern(regex));
	}
	@Then("^the \"([^\"]*)\" is enabled$")
	public void isEnabled(String name) {
		uiAssert(name).enabled();
	}

	@Then("^the \"([^\"]*)\" is disabled$")
	public void isDisabled(String name) {
		uiAssert(name).disabled();
	}

	@Then("^the \"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		uiAssert(name).displayed();
	}

	@Then("^the \"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		uiAssert(name).hidden();
	}
	@Then("^the \"([^\"]*)\" disappear$")
	public void isDisappear(String name) {
		uiAssert(name).disappear();
	}
	@Then("^the \"([^\"]*)\" does not appear$")
	public void isNotAppear(String name) {
		uiAssert(name).notAppear();
	}

	@Then("^the \"([^\"]*)\" does not appear during \"([^\"]*)\"$")
	public void isNotAppear(String name, int seconds) {
		uiAssert(name).notAppear(seconds);
	}

	@Then("^the \"(.*?)\" text is on page$")
	public void textOnPage(String text) {
		$(byText(text)).is().displayed();
	}
    @Then("^the current page url is \"(.*?)\"$")
    public void urlIs(String expectedUrl) {
        assertEquals(expectedUrl, getUrl());
    }
	@Then("^the current page title is \"([^\"]*)\"$")
	public void titleIs(String expectedUrl) {
		assertEquals(expectedUrl, getTitle());
	}
	//#endregion

}
