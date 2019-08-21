package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.ColorPicker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;

public class ColorPickerSteps {
    @Given("^\"([^\"]*)\" was set to \"([^\"]*)\" color$")
    @When("^I set \"([^\"]*)\" to \"([^\"]*)\" color$")
    public void preSetColor(String name, String color){
        ColorPicker colorPicker = getUI(name, ColorPicker.class);
        colorPicker.setColor(color);
    }

    @Then("^\"([^\"]*)\" color equals to \"([^\"]*)\"$")
    public void haveColor(String name, String expectedColor) {
        ColorPicker colorPicker = getUI(name, ColorPicker.class);
        colorPicker.is().color(expectedColor);
    }

    @Then("^\"([^\"]*)\" color is \"([^\"]*)\"$")
    public void assertThatColor(String name, String color) {
        ColorPicker colorPicker = getUI(name, ColorPicker.class);
        colorPicker.is().color(color);
    }
}
