package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.Combobox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.testng.AssertJUnit.assertEquals;

public class ComboboxSteps {

    @When("^Select \"([^\"]*)\" in combobox \"([^\"]*)\"$")
    public void selectValue(String value, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        combobox.select(value);
    }

    @Then("^\"([^\"]*)\" is selected in combobox \"([^\"]*)\"$")
    public void comboBoxHasValue(String value, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        assertEquals(combobox.getValue(), value);
    }

    @When("^Select value (\\d+) in combobox \"([^\"]*)\"$")
    public void comboBoxHasValue(int index, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        combobox.clear();
        combobox.select(index);
    }
}