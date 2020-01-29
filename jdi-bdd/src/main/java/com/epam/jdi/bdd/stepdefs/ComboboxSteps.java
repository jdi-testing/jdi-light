package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ComboboxSteps {
    public static IsCombobox combobox(String name) {
        return getUI(name, IsCombobox.class);
    }

    public static DataListOptions options(String name) {
        return getUI(name, DataListOptions.class);
    }

    @When("^select index (\\d+) in \"([^\"]*)\"$")
    public void comboboxSelect(int index, String name) {
        combobox(name).select(index);
    }

    @When("^select value \"([^\"]*)\" in \"([^\"]*)\"$")
    public void comboboxSelect(String index, String name) {
        combobox(name).select(index);
    }
}