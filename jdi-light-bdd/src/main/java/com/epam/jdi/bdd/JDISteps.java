package com.epam.jdi.bdd;

import static com.epam.jdi.bdd.Utils.getBaseUI;
import static com.epam.jdi.light.elements.composite.WebPage.PAGES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Then("^I'm on \"(.*?)\"$")
    public void iMOn(String pageName) {
        WebPage page = PAGES.get(pageName);
        page.checkOpened();
    }
    
    /*BaseUIElement methods*/	
	@When("^Click on \"([^\"]*)\"$")
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
		assertEquals(value, el.labelText());
	}
	
	@Then("^\"([^\"]*)\" label text contains \"([^\"]*)\"$")
	public void labelTextContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.labelText().contains(value));
	}
	
	@When("^Clear \"([^\"]*)\"$")
	public void clear(String name) {
		BaseUIElement el = getBaseUI(name);
		el.clear();
	}
	
	@Then("^\"([^\"]*)\" value text equals to \"([^\"]*)\"$")
	public void valueTextEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertEquals(value, el.getValueText());
	}
	
	@Then("^\"([^\"]*)\" value text contains \"([^\"]*)\"$")
	public void valueTextContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.getValueText().contains(value));
	}
	
	@Then("\"([^\"]*)\" is selected$")
	public void isSelected(String name) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.isSelected());
	}
	
	@Then("^\"([^\"]*)\" is deselected$")
	public void isDeselected(String name) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.isDeselected());
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
		assertEquals(placeholder, el.placeholder());
	}
	
	@Then("^\"([^\"]*)\" placeholder contains \"([^\"]*)\"$")
	public void placeholderContains(String name, String placeholder) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.placeholder().contains(placeholder));
	}
	
	@Then("^\"([^\"]*)\" value equals to \"([^\"]*)\"$")
	public void valueEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertEquals(value, el.getValue());
	}
	
	@Then("^\"([^\"]*)\" value contains \"([^\"]*)\"$")
	public void valueContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.getValue().contains(value));
	}
	
	@When("^Focus on \"([^\"]*)\"$")
	public void focusOn(String name) {
		BaseUIElement el = getBaseUI(name);
		el.focus();
	}
	
	/*JDIBase methods*/
	@Then("^\"([^\"]*)\" inner text equals to \"([^\"]*)\"$")
	public void innerTextEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertEquals(value, el.innerText());
	}
	
	@Then("^\"([^\"]*)\" inner text contains \"([^\"]*)\"$")
	public void innerTextContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.innerText().contains(value));
	}
	
	@Then("^\"([^\"]*)\" text equals to \"([^\"]*)\"$")
	public void textEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertEquals(value, el.text());
	}
	
	@Then("^\"([^\"]*)\" text contains \"([^\"]*)\"$")
	public void textContains(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.text().contains(value));
	}
	
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" equals to \"([^\"]*)\"$")
	public void attributeEquals(String name, String attrName, String attrValue) {
		BaseUIElement el = getBaseUI(name);
		assertEquals(attrValue, el.getAttribute(attrName));		
	}
	
	@Then("^\"([^\"]*)\" attribute \"([^\"]*)\" contains \"([^\"]*)\"$")
	public void attributeContains(String name, String attrName, String attrValue) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.getAttribute(attrName).contains(attrValue));		
	}
	
	@Then("\"([^\"]*)\" is enabled$")
	public void isEnabled(String name) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.isEnabled());
	}
	
	@Then("^\"([^\"]*)\" is disabled$")
	public void isDisabled(String name) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.isDisabled());
	}
	
	@Then("^\"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.isDisplayed());
	}
	
	@Then("^\"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		BaseUIElement el = getBaseUI(name);
		assertTrue(el.isHidden());
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
