package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import com.epam.jdi.light.ui.html.common.NumberSelector;

import cucumber.api.java.en.Then;

public class NumberSelectorSteps {
	/*
	@When("^(?:I |)Set number \"([^\"]*)\" in \"([^\"]*)\" number selector$")
	public void setNumber(String value, String name) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.setNumber(value);
	}
	*/
	
	@Then("^the \"([^\"]*)\" number selector value equals to \"([^\"]*)\"$")
	public void getValue(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.has().number(is(Double.valueOf((value))));
	}
	
	@Then("^the \"([^\"]*)\" number selector min is \"([^\"]*)\"$")
	public void getMin(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.has().minValue(is(Double.valueOf((value))));
	}
	
	@Then("^the \"([^\"]*)\" number selector max is \"([^\"]*)\"$")
	public void getMax(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.has().maxValue(is(Double.valueOf((value))));
	}

	@Then("^the \"([^\"]*)\" number selector step is \"([^\"]*)\"$")
	public void getStep(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.has().stepValue(is(Double.valueOf((value))));
	}
	
	@Then("^the \"([^\"]*)\" number selector value is greater or equal to \"([^\"]*)\"$")
	public void numberIsGreaterOrEqual(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.is().number(greaterThanOrEqualTo(Double.valueOf(value)));
	}
	
	@Then("^the \"([^\"]*)\" number selector value less or equal to \"([^\"]*)\"$")
	public void numberLessThanOrEqual(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.is().number(lessThanOrEqualTo(Double.valueOf(value)));
	}
	
	@Then("^the \"([^\"]*)\" number selector value is greater than \"([^\"]*)\"$")
	public void numberIsGreaterThan(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.is().number(greaterThan(Double.valueOf(value)));
	}
	
	@Then("^the \"([^\"]*)\" number selector value less than \"([^\"]*)\"$")
	public void numberLessThan(String name, String value) {
		NumberSelector el = (NumberSelector) getUI(name);
		el.is().number(lessThan(Double.valueOf(value)));
	}
}
