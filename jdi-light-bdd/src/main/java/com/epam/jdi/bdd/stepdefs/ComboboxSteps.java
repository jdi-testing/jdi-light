package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.Combobox;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;

public class ComboboxSteps {

    @When("^Select value (\\d+) in combobox \"([^\"]*)\"$")
    public void comboBoxHasValue(int index, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        combobox.select(index);
    }
}