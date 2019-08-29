package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getForm;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.map.MapArray;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class FormSteps {
	
	@When("^(?:I |)fill form \"([^\"]*)\" with data")
	public void fillForm(String name, DataTable data) throws Throwable {
		Form fm = getForm(name);
		MapArray<String, String> fieldsMap = new MapArray<String, String>();
		for (DataTableRow row : data.getGherkinRows()) {
			fieldsMap.add(row.getCells().get(0), row.getCells().get(1));
		}
		fm.fill(fieldsMap);
	}
	
	@When("^(?:I |)submit form \"([^\"]*)\"$")
	public void submitForm(String name) {
		Form fm = getForm(name);
		fm.submit();
	}
	
	@Then("^the form \"([^\"]*)\" data equals$")
    public void dataEquals(String name, DataTable data) {
		Form fm = getForm(name);
        MapArray<String, String> fieldsMap = new MapArray<String, String>();
		for (DataTableRow row : data.getGherkinRows()) {
			fieldsMap.add(row.getCells().get(0), row.getCells().get(1));
		}
        fm.check(fieldsMap);
    }
}
