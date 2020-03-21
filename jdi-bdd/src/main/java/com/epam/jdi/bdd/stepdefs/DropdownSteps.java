package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import cucumber.api.java.en.Then;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DropdownSteps {
    public static IsDropdown dropdown(String name) {
        return getUI(name, IsDropdown.class);
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" is selected$")
    public void theInIsSelected(String textValue, String name) {
        dropdown(name).is().selected(textValue);
    }
}
