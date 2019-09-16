package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.Dropdown;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getUI;

public class DropdownSteps {
    /*
    TODO: Step for Expand, Close, Size and other functionality
     */

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" is selected$")
    public void theInIsSelected(String textValue, String elemName) {
        Dropdown dropdown = getUI(elemName, Dropdown.class);
        dropdown.is().selected(textValue);
    }
}
