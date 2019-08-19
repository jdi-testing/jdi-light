package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getBaseUI;

import org.junit.Assert;

import com.epam.jdi.light.elements.base.BaseUIElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseUIElementSteps {
	
	/*BaseUIElement methods*/	
	@When("^Click on \"([^\"]*)\" BaseUIElement$")
    public void iMClickOn(String name) {
        BaseUIElement el = getBaseUI(name);
        el.click();
    }
	
	@When("^Send keys \"([^\"]*)\" to \"([^\"]*)\" BaseUIElement$")
	public void iMSendKeys(String value, String name) {
		BaseUIElement el = getBaseUI(name);
		el.sendKeys(value);
	}
	
	@When("^Check \"([^\"]*)\" BaseUIElement$")
	public void iMCheck(String name) {
		BaseUIElement el = getBaseUI(name);
		el.check();
	}
	
	@When("^Uncheck \"([^\"]*)\" BaseUIElement$")
	public void iMUncheck(String name) {
		BaseUIElement el = getBaseUI(name);
		el.uncheck();
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" labelText equals \"([^\"]*)\"$")
	public void isLabelTextEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertEquals(value, el.labelText());
	}
	
	@When("^Clear \"([^\"]*)\" BaseUIElement$")
	public void iMClear(String name) {
		BaseUIElement el = getBaseUI(name);
		el.clear();
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" valueText equals \"([^\"]*)\"$")
	public void iCheckValueText(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertEquals(value, el.getValueText());
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" isSelected$")
	public void isSelected(String name) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertTrue(el.isSelected());
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" isDeselected$")
	public void isDeselected(String name) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertTrue(el.isDeselected());
	}
	
	@When("^jsClick on \"([^\"]*)\" BaseUIElement$")
	public void jsClick(String name) {
		BaseUIElement el = getBaseUI(name);
		el.jsClick();
	}
	
	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" BaseUIElement$")
	public void input(String value, String name) {
		BaseUIElement el = getBaseUI(name);
		el.input(value);
	}
	
	@When("^Select \"([^\"]*)\" from \"([^\"]*)\" BaseUIElement$")
    public void select(String value, String name) {
        BaseUIElement el = getBaseUI(name);
        el.select(value);
    }
	
	/*
	@When("^BaseUIElement \"([^\"]*)\". Select \"(.*)\"$")
    public void select(String name, String... values) {
        BaseUIElement el = getBaseUI(name);
        el.select(values);
    }
    */
	
	/*BaseUIElement methods Debug level */
	@When("^Submit \"([^\"]*)\" BaseUIElement$")
	public void iMSubmit(String name) {
		BaseUIElement el = getBaseUI(name);
		el.submit();
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" placeholder equals \"([^\"]*)\"$")
	public void isPlaceholderEquals(String name, String placeholder) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertEquals(placeholder, el.placeholder());
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" value equals \"([^\"]*)\"$")
	public void isValueEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertEquals(value, el.getValue());
	}
	
	@When("^Focus on \"([^\"]*)\" BaseUIElement$")
	public void focusOn(String name) {
		BaseUIElement el = getBaseUI(name);
		el.focus();
	}
	
	/*JDIBase methods*/
	@Then("^BaseUIElement \"([^\"]*)\" innerText equals \"([^\"]*)\"$")
	public void isInnerTextEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertEquals(value, el.innerText());
	}
	
	@Then("^BaseUIElement \"([^\"]*)\" getText equals \"([^\"]*)\"$")
	public void isTextEquals(String name, String value) {
		BaseUIElement el = getBaseUI(name);
		Assert.assertEquals(value, el.innerText());
	}
}
