package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.tools.Safe;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.BDDUtils.getMapFromTable;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.JsonUtils.getMapFromJson;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FormSteps {
	public static Safe<Form> lastForm = new Safe<>(() -> null);
	static Form getForm(String name) {
		Form form = null;
		try {
			form = getUI(name, Form.class);
		} catch (Exception ignore) { }
		if (form == null)
			form = new Form<>().setup(Form.class, cl->cl.setName(name));
		lastForm.set(form);
		return form;
	}
	static Form getLastForm() {
		if (lastForm.get() != null)
			return lastForm.get();
		throw exception("You should execute form action with name before steps without form name");
	}
	@When("^I login as \"([^\"]*)\"$")
	public void loginAsForm(String jsonName) {
		getForm("Login form").submit(getMapFromJson(jsonName, "json.test.data"));
	}

	@When("^(?:I |)fill form \"([^\"]*)\" with data:$")
	public void fillForm(String name, DataTable data) {
		getForm(name).fill(getMapFromTable(data));
	}
	@When("^(?:I |)fill form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void fillForm(String name, String jsonName) {
		getForm(name).fill(getMapFromJson(jsonName, "json.test.data"));
	}
	@When("^(?:I |)(?:submit|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form$")
	public void submitDataForm() {
		getLastForm().submit();
	}
	@When("^(?:I |)(?:submit|send|add|publich|save|update|cancel|close|back|select|next|search) " +
			"form \"([^\"]*)\" with data:$")
	public void submitDataForm(String name, DataTable data) {
		getForm(name).submit(getMapFromTable(data));
	}
	@When("^(?:I |)(?:submit|send|add|publich|save|update|cancel|close|back|select|next|search) form using button \"([^\"]*)\"$")
	public void submitForm(String buttonName) {
		getLastForm().pressButton(buttonName);
	}
	@When("^(?:I |)(?:submit|send|add|publich|save|update|cancel|close|back|select|next|search) "
			+ "form \"([^\"]*)\" with \"([^\"]*)\"$")
	public void submitForm(String name, String jsonName) {
		getForm(name).submit(getMapFromJson(jsonName, "json.test.data"));
	}
	@Then("^the form \"([^\"]*)\" data equals to:$")
    public void dataEquals(String name, DataTable data) {
		getForm(name).check(getMapFromTable(data));
    }
	@Then("^the form \"([^\"]*)\" data equals to \"([^\"]*)\"$")
    public void dataEquals(String name, String jsonName) {
		getForm(name).check(getMapFromJson(jsonName, "json.test.data"));
    }
}
