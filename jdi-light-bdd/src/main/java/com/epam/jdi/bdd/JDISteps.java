package com.epam.jdi.bdd;

import static com.epam.jdi.bdd.Utils.getBaseUI;
import static com.epam.jdi.light.elements.composite.WebPage.PAGES;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.composite.WebPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JDISteps {
    @Given("^I open \"(.*?)\"$")
    public void iMOpen(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.open();
    }
    
    @Given("^Refresh webpage$")
    public void refreshWebpage() {
        WebPage.refresh();
    }
   
    @Then("^I'm on \"(.*?)\"$")
    public void iMOn(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.shouldBeOpened();
    }
    
    /*BaseUIElement methods*/	
	@When("^Click with javaScript on \"([^\"]*)\"$")
    public void click(String name) {
        BaseUIElement el = getBaseUI(name);
        el.click();
    }
	
	@When("^Send keys \"([^\"]*)\" to \"([^\"]*)\"$")
	public void sendKeys(String value, String name) {
		BaseUIElement el = getBaseUI(name);
		el.sendKeys(value);
	}
	
	@When("^Check \"([^\"]*)\"$")
	public void check(String name) {
		BaseUIElement el = getBaseUI(name);
		el.check();
	}
	
	@When("^Uncheck \"([^\"]*)\"$")
	public void uncheck(String name) {
		BaseUIElement el = getBaseUI(name);
		el.uncheck();
	}
	
	@Then("^\"([^\"]*)\" label text equals to \"([^\"]*)\"$")
	public void labelTextEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.label().is().text(equalTo(value));
	}
	
	@Then("^\"([^\"]*)\" label text contains \"([^\"]*)\"$")
	public void labelTextContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.label().is().text(containsString(value));
	}
	
	/*
	@Then("^\"([^\"]*)\" label text matches RegExp \"([^\"]*)\"$")
	public void labelTextMatches(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.label().is().text(matchesPattern(value));
	}
	*/
	
	@When("^Clear \"([^\"]*)\"$")
	public void clear(String name) {
		BaseUIElement el = getBaseUI(name);
		el.clear();
	}
	
	@Then("\"([^\"]*)\" is selected$")
	public void isSelected(String name) {
		BaseUIElement el = getBaseUI(name);
		el.is().selected();
	}
	
	@Then("^\"([^\"]*)\" is deselected$")
	public void isDeselected(String name) {
		BaseUIElement el = getBaseUI(name);
		el.is().deselected();
	}
	
	@When("^jsClick on \"([^\"]*)\"$")
	public void jsClick(String name) {
		BaseUIElement el = getBaseUI(name);
		el.jsClick();
	}
	
	@When("^Input \"([^\"]*)\" in \"([^\"]*)\"$")
	public void input(String value, String name) {
		BaseUIElement el = getBaseUI(name);
		el.input(value);
	}
	
	@When("^Select \"([^\"]*)\" field from \"([^\"]*)\"$")
    public void select(String value, String name) {
        BaseUIElement el = getBaseUI(name);
        el.select(value);
    }
	
	@When("^Select \"([^\"]*)\" fields from \"([^\"]*)\"$")
    public void multiSelect(String values, String name) {
        BaseUIElement el = getBaseUI(name);
        el.select(values.split(";"));
    }
	
	@When("^Submit \"([^\"]*)\"$")
	public void submit(String name) {
		BaseUIElement el = getBaseUI(name);
		el.submit();
	}
	
	@Then("^\"([^\"]*)\" placeholder equals to \"([^\"]*)\"$")
	public void placeholderEquals(String name, String placeholder) {
		BaseUIElement el = getBaseUI(name);
		el.is().attr("placeholder", placeholder);
	}
	
	@Then("^\"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
	public void placeholderContains(String name, String placeholder) {
		BaseUIElement el = getBaseUI(name);
		el.is().attr("placeholder", containsString(placeholder));
	}
	
	/*
	@Then("^\"([^\"]*)\" placeholder matches RegExp \"([^\"]*)\"$")
	public void placeholderMatchesRegExp(String name, String placeholder) {
		BaseUIElement el = getBaseUI(name);
		el.is().attr("placeholder", containsString(placeholder));
	}
	 */
	
	@Then("^\"([^\"]*)\" value equals to \"([^\"]*)\"$")
	public void valueEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);		
		el.is().text(value);
	}
	
	@Then("^\"([^\"]*)\" value contains \"([^\"]*)\"$")
	public void valueContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.is().text(containsString(value));
	}
	
	@When("^Focus on \"([^\"]*)\"$")
	public void focusOn(String name) {
		BaseUIElement el = getBaseUI(name);
		el.focus();
	}
	
	@Then("^\"([^\"]*)\" text equals to \"([^\"]*)\"$")
	public void textEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.is().text(equalTo(value));
	}
	
	@Then("^\"([^\"]*)\" text contains \"([^\"]*)\"$")
	public void textContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.is().text(containsString(value));
	}
	
	/*
	 * @Then("^\"([^\"]*)\" text matches RegExp \"([^\"]*)\"$")
	public void textMatchesRegExp(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		el.is().text(containsString(value));
	}
	 */
	
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void attributeEquals(String name, String attrName, String attrValue) {
		BaseUIElement el = getBaseUI(name);
		el.is().attr(attrName, attrValue);	
	}
	
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		BaseUIElement el = getBaseUI(name);
		el.is().attr(attrName, containsString(attrValue));	
	}
	
	/*
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		BaseUIElement el = getBaseUI(name);
		el.is().attr(attrName, containsString(attrValue));	
	}
	*/
	
	@Then("\"([^\"]*)\" is enabled$")
	public void isEnabled(String name) {
		BaseUIElement el = getBaseUI(name);
		el.is().enabled();
	}
	
	@Then("^\"([^\"]*)\" is disabled$")
	public void isDisabled(String name) {
		BaseUIElement el = getBaseUI(name);
		el.is().disabled();
	}
	
	@Then("^\"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		BaseUIElement el = getBaseUI(name);
		el.is().displayed();
	}
	
	@Then("^\"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		BaseUIElement el = getBaseUI(name);
		el.is().hidden();
	}
	
	@When("^Set text \"([^\"]*)\" in \"([^\"]*)\"$")
	public void setText(String value, String name) {
		BaseUIElement el = getBaseUI(name);
		el.setText(value);
	}
	
	@When("^Double click on \"([^\"]*)\"$")
	public void doubleClick(String name) {
		BaseUIElement el = getBaseUI(name);
		el.doubleClick();
	}
	
	@When("^Right click on \"([^\"]*)\"$")
	public void rightClick(String name) {
		BaseUIElement el = getBaseUI(name);
		el.rightClick();
	}
	
	@When("^Highlight \"([^\"]*)\"$")
	public void highlight(String name) {
		BaseUIElement el = getBaseUI(name);
		el.highlight();
	}
	
	@When("^Show \"([^\"]*)\"$")
	public void show(String name) {
		BaseUIElement el = getBaseUI(name);
		el.show();
	}
	
	@When("^Set \"([^\"]*)\" attribute \"([^\"]*)\" with vlaue \"([^\"]*)\" element$")
	public void setAttribute(String name, String attrName, String attrValue) {
		BaseUIElement el = getBaseUI(name);
		el.setAttribute(attrName, attrValue);
	}
}
