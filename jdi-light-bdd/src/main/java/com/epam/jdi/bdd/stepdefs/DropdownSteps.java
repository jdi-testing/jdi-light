package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import cucumber.api.java.en.Then;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

public class DropdownSteps {
    public static Dropdown dropdown(String name) { return getUI(name, Dropdown.class); }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" is selected$")
    public void theInIsSelected(String textValue, String name) {
        dropdown(name).is().selected(textValue);
    }
}