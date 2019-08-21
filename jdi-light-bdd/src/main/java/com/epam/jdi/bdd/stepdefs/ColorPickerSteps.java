package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.ColorPicker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;

public class ColorPickerSteps {
    private ColorPicker colorPicker;

    private ColorPicker getColorPicker(String name) {
        return (ColorPicker) getUI(name, ColorPicker.class);
    }

    @Given("^\"([^\"]*)\" was set to \"([^\"]*)\" color$")
    @When("^I set \"([^\"]*)\" to \"([^\"]*)\" color$")
    public void preSetColor(String colorPickerName, String color){
        getColorPicker(colorPickerName).setColor(color);
    }

    @Then("^\"([^\"]*)\" color equals to \"([^\"]*)\"$")
    public void haveColor(String colorPickerName, String expectedColor) {
        getColorPicker(colorPickerName).is().color(expectedColor);
    }

    @Then("^\"([^\"]*)\" color is \"([^\"]*)\"$")
    public void assertThatColor(String colorPickerName, String color) {
        getColorPicker(colorPickerName).assertThat().color(color);
    }
}
