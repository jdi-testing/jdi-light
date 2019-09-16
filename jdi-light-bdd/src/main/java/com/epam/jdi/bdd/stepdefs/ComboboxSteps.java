package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.Combobox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ComboboxSteps {
    public static IsCombobox combobox(String name) { return getUI(name, IsCombobox.class); }

    @When("^select index (\\d+) in \"([^\"]*)\"$")
    public void comboboxSelect(int index, String name) {
        combobox(name).select(index);
    }
}