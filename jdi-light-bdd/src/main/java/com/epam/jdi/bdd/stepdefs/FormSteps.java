package com.epam.jdi.bdd.stepdefs;

import static com.epam.jdi.bdd.Utils.getMapFromJson;
import static com.epam.jdi.bdd.Utils.getMapFromTable;
import static com.epam.jdi.bdd.Utils.getUI;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.Safe;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormSteps {
	public static Safe<String> lastForm = new Safe<>(() -> null);

	@When("^(?:I |)fill form \"([^\"]*)\" with data:$")
	public void fillForm(String name, DataTable data) {
		Form fm = getForm(name);
		fm.fill(getMapFromTable(data));
	}
	
	@When("^(?:I |)fill form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void fillForm(String name, String jsonName) {
		Form fm = getForm(name);
		fm.fill(getMapFromJson(jsonName));
	}

	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form$")
	public void submitDataForm() {
		Form fm = getForm(lastForm.get());
		fm.submit();
	}
	
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form \"([^\"]*)\" with data:$")
	public void submitDataForm(String name, DataTable data) {
		Form fm = getForm(name);
		fm.submit(getMapFromTable(data));
	}
	
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) form using button \"([^\"]*)\"$")
	public void submitForm(String buttonName) {
		Form fm = getForm(lastForm.get());
		fm.pressButton(buttonName);
	}
	
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) "
			+ "form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void submitForm(String name, String jsonName) {
		Form fm = getForm(name);
		fm.submit(getMapFromJson(jsonName));
	}

	@Then("^the form \"([^\"]*)\" data equals to:$")
    public void dataEquals(String name, DataTable data) {
		Form fm = getForm(name);
        fm.check(getMapFromTable(data));
    }
	
	@Then("^the form \"([^\"]*)\" data equals to \"([^\"]*)\"$")
    public void dataEquals(String name, String jsonName) {
		Form fm = getForm(name);
        fm.check(getMapFromJson(jsonName));
    }

	private static Form getForm(String name) {
		Form form = getUI(name, Form.class);
		lastForm.set(name);
		return form;
	}
}
