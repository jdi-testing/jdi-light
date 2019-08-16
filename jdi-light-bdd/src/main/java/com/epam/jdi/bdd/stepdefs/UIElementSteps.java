package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getUI;

import com.epam.jdi.light.elements.base.UIElement;

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
	public void iMSendKeys(String name, String value) {
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
	
	//TODO
	/*
	@When("^Check \"([^\"]*)\" element$")
	public void iMSendKeys(String name) {
		UIElement el = getUI(name);
		el.labelText();
	}
	*/
	
	@When("^Clear \"([^\"]*)\" element$")
	public void iMClear(String name) {
		UIElement el = getUI(name);
		el.clear();
	}
}
