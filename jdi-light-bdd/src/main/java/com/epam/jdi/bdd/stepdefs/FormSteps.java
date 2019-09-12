package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.Safe;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getMapFromJson;
import static com.epam.jdi.bdd.Utils.getMapFromTable;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

public class FormSteps {
	public static Safe<String> lastForm = new Safe<>(() -> null);
	private static Form getForm(String name) {
		Form form = getUI(name, Form.class);
		lastForm.set(name);
		return form;
	}

	@When("^(?:I |)fill form \"([^\"]*)\" with data:$")
	public void fillForm(String name, DataTable data) {
		getForm(name).fill(getMapFromTable(data));
	}
	@When("^(?:I |)fill form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void fillForm(String name, String jsonName) {
		getForm(name).fill(getMapFromJson(jsonName));
	}
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form$")
	public void submitDataForm() {
		getForm(lastForm.get()).submit();
	}
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form \"([^\"]*)\" with data:$")
	public void submitDataForm(String name, DataTable data) {
		getForm(name).submit(getMapFromTable(data));
	}
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) form using button \"([^\"]*)\"$")
	public void submitForm(String buttonName) {
		getForm(lastForm.get()).pressButton(buttonName);
	}
	@When("^(?:I |)(?:submit|login as|send|add|publich|save|update|cancel|close|back|select|next|search) "
			+ "form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void submitForm(String name, String jsonName) {
		getForm(name).submit(getMapFromJson(jsonName));
	}
	@Then("^the form \"([^\"]*)\" data equals to:$")
    public void dataEquals(String name, DataTable data) {
		getForm(name).check(getMapFromTable(data));
    }
	@Then("^the form \"([^\"]*)\" data equals to \"([^\"]*)\"$")
    public void dataEquals(String name, String jsonName) {
		getForm(name).check(getMapFromJson(jsonName));
    }
}
