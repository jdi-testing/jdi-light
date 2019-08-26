package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.Combobox;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ComboboxSteps {

    @When("^Select index (\\d+) in \"([^\"]*)\"$")
    public void comboboxSelect(int index, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        combobox.select(index);
    }

    @When("^the \"([^\"]*)\" combobox selected value is \"([^\"]*)\"$")
    public void comboboxSelectedValue(String name, String value) {
        Combobox combobox = getUI(name, Combobox.class);
        assertThat(combobox.selected(), is(value));
    }
}