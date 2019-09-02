package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.deserializeJsonToMap;
import static com.epam.jdi.bdd.Utils.getForm;

import java.util.Map;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.map.MapArray;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class FormSteps {
	@When("^(?:I |)fill form \"([^\"]*)\" with data:$")
	public void fillForm(String name, DataTable data) {
		Form fm = getForm(name);
		MapArray<String, String> fieldsMap = new MapArray<String, String>();
		for (DataTableRow row : data.getGherkinRows()) {
			fieldsMap.add(row.getCells().get(0), row.getCells().get(1));
		}
		fm.fill(fieldsMap);
	}
	
	@When("^(?:I |)fill form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void fillForm(String name, String jsonName) {
		Form fm = getForm(name);		
		Map<String, String> map = deserializeJsonToMap(jsonName);
		fm.fill(MapArray.toMapArray(map));
	}
	
	@When("^(?:I |)submit form \"([^\"]*)\"$")
	public void submitForm(String name) {
		Form fm = getForm(name);
		fm.submit();
	}
	
	@When("^(?:I |)submit form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void submitForm(String name, String jsonName) {
		Form fm = getForm(name);
		Map<String, String> map = deserializeJsonToMap(jsonName);
		fm.submit(MapArray.toMapArray(map));
	}
	
	@Then("^the form \"([^\"]*)\" data equals to:$")
    public void dataEquals(String name, DataTable data) {
		Form fm = getForm(name);
        MapArray<String, String> fieldsMap = new MapArray<String, String>();
		for (DataTableRow row : data.getGherkinRows()) {
			fieldsMap.add(row.getCells().get(0), row.getCells().get(1));
		}
        fm.check(fieldsMap);        
    }
	
	@Then("^the form \"([^\"]*)\" data equals to \"([^\"]*)\"$")
    public void dataEquals(String name, String jsonName) {
		Form fm = getForm(name);
		Map<String, String> map = deserializeJsonToMap(jsonName);
        fm.check(map);        
    }
	
	@Then("^the form \"([^\"]*)\" is displayed$")
	public void isDisplayed(String name) {
		Form fm = getForm(name);
		fm.is().displayed();
	}
	
	@Then("^the form \"([^\"]*)\" is hidden$")
	public void isHidden(String name) {
		Form fm = getForm(name);
		fm.is().hidden();
	}
	
	@Then("^the form \"([^\"]*)\" does not appear$")
	public void isNotAppear(String name) {
		Form fm = getForm(name);
		fm.is().notAppear();
	}

	@Then("^the form \"([^\"]*)\" does not appear during \"([^\"]*)\"$")
	public void isNotAppear(String name, int seconds) {
		Form fm = getForm(name);
		fm.is().notAppear(seconds);
	}
	
	@Then("^the form \"([^\"]*)\" disappear$")
	public void disappear(String name) {
		Form fm = getForm(name);
		fm.is().disappear();
	}
}
