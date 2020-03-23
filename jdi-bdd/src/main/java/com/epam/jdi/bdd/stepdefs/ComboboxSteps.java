package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ComboboxSteps {
    public static IsCombobox combobox(String name) {
        return getUI(name, IsCombobox.class);
    }

    @When("^select index (\\d+) in \"([^\"]*)\"$")
    public void comboboxSelect(int index, String name) {
        combobox(name).select(index);
    }
}