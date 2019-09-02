package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getForm;
import static com.epam.jdi.bdd.JsonHelper.deserializeJsonToMap;
import static com.epam.jdi.tools.PropertyReader.getProperty;

import java.util.Map;

import com.epam.jdi.bdd.JsonHelper;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.map.MapArray;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class FormSteps {
	String json = "{\"name\": \"Roman\", \r\n" + 
			"  \"lastName\": \"Iovlev\", \r\n" + 
			"  \"position\": \"ChiefQA\", \r\n" + 
			"  \"number\": \"654321\",\r\n" + 
			"  \"passportSeria\": \"1234\", \r\n" + 
			"  \"description\": \"JDI - awesome UI automation tool\", \r\n" + 
			"  \"acceptConditions\": \"true\", \r\n" + 
			"  \"gender\": \"Female\", \r\n" + 
			"  \"religion\": \"Other\"\r\n" + 
			"}";
	
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
		System.out.println(getProperty("jsonTestDataResourcePath"));
		Map<String, String> map = deserializeJsonToMap(jsonName);
		fm.fill(MapArray.toMapArray(map));
	}
	
	@When("^(?:I |)submit form \"([^\"]*)\"$")
	public void submitForm(String name) {
		Form fm = getForm(name);
		fm.submit();
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
