package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getUI;

import org.junit.Assert;

import com.epam.jdi.light.elements.base.UIElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UIElementSteps {
	
	@When("^Click on \"([^\"]*)\" element$")
    public void iMClickOn(String name) {
        UIElement el = getUI(name);
        el.click();
    }
	
	@When("^Click on \"([^\"]*)\" element at \"([^\"]*)\"$")
    public void iMClickOnLinkFrom(String name, String section) {
        UIElement el = getUI(name, section);
        el.click();
    }
	
	@When("^Submit \"([^\"]*)\" element$")
	public void iMSubmit(String name) {
		UIElement el = getUI(name);
		el.submit();
	}

	@When("^Send keys \"([^\"]*)\" into \"([^\"]*)\"element$")
	public void iMSendKeys(String value, String name) {
		UIElement el = getUI(name);
		el.sendKeys(value);
	}
	
	@When("^Check \"([^\"]*)\" element$")
	public void iMCheck(String name) {
		UIElement el = getUI(name);
		el.check();
	}
	
	@When("^Uncheck \"([^\"]*)\" element$")
	public void iMUncheck(String name) {
		UIElement el = getUI(name);
		el.uncheck();
	}
	
	@Then("^Element \"([^\"]*)\" have label text equals \"([^\"]*)\"$")
	public void isLabelTextEquals(String name, String value) {
		UIElement el = getUI(name);
		Assert.assertEquals(value, el.labelText(), "Label text have correct value");
	}
	
	@When("^Clear \"([^\"]*)\" element$")
	public void iMClear(String name) {
		UIElement el = getUI(name);
		el.clear();
	}
	
	@Then("^Element \"([^\"]*)\" attribute \"([^\"]*)\" equals \"([^\"]*)\"$")
	public void isAttrEquals(String name, String attrName, String value) {
		UIElement el = getUI(name);
		Assert.assertEquals(value, el.getAttribute(attrName), "attribute have correct value!");
	}
	
	@Then("^Element \"([^\"]*)\" isSelected$")
	public void isSelected(String name) {
		UIElement el = getUI(name);
		Assert.assertTrue(el.isSelected());
	}
	
	@Then("^Element \"([^\"]*)\" isDeselected$")
	public void isDeselected(String name) {
		UIElement el = getUI(name);
		Assert.assertTrue(el.isDeselected());
	}
	
	@When("^jsClick on \"([^\"]*)\" element$")
	public void jsClick(String name) {
		UIElement el = getUI(name);
		el.jsClick();
	}
	
	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" element$")
	public void input(String value, String name) {
		UIElement el = getUI(name);
		el.input(value);
	}
	
	@When("^Focus on \"([^\"]*)\" element$")
	public void focusOn(String name) {
		UIElement el = getUI(name);
		el.focus();
	}
	
	@Then("^Element \"([^\"]*)\" value equals \"([^\"]*)\"$")
	public void isValueEquals(String name, String value) {
		UIElement el = getUI(name);
		Assert.assertEquals(value, el.getValue(), "value correct!");
	}
	
	@Then("^Element \"([^\"]*)\" have valuetext equals \"([^\"]*)\"$")
	public void isValueTextEquals(String name, String valueText) {
		UIElement el = getUI(name);
		Assert.assertEquals(valueText, el.getValueText(), "value text correct!");
	}
	
	@When("^Select \"([^\"]*)\" element$")
    public void select(String name) {
        UIElement el = getUI(name);
        el.select();
    }
	
	//????
	@When("^Select \"(.*)\" element$")
    public void select(String... names) {
		for(String name : names) {
          UIElement el = getUI(name);
          el.select();
		}
    }
	
	@Then("^Element \"([^\"]*)\" have placeholder equals \"([^\"]*)\"$")
	public void isPlaceholderEquals(String name, String placeholder) {
		UIElement el = getUI(name);
		Assert.assertEquals(placeholder, el.placeholder(), "placeholder correct!");
	}
	
}
