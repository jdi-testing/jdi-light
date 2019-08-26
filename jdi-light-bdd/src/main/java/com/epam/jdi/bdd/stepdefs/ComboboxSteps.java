package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.Combobox;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ComboboxSteps {

    @When("^Select value (\\d+) in \"([^\"]*)\"$")
    public void comboBoxHasValue(int index, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        combobox.select(index);
    }

    @When("^the \"([^\"]*)\" selected value is \"([^\"]*)\"$")
    public void comboBoxHasValue(String name, String value) {
        Combobox combobox = getUI(name, Combobox.class);
        assertThat(combobox.selected(), is(value));
    }
}