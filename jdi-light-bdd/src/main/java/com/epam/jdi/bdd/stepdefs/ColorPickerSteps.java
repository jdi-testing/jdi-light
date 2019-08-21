package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.ColorPicker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;
import static org.testng.Assert.*;

public class ColorPickerSteps {
    private ColorPicker colorPicker;

    private ColorPicker getColorPicker(String name) {
        if (ELEMENTS.has(name))
            return (ColorPicker) ELEMENTS.get(name).get(0);
        throw exception("Can't find %s element", name);
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

    @Then("^is validation for \"([^\"]*)\" is successful for color \"([^\"]*)\"$")
    public void isValidation(String colorPickerName, String color) {
        colorPicker = getColorPicker(colorPickerName);
        colorPicker.is().enabled();
        colorPicker.is().color(color);
    }

    @Then("^assertThat for \"([^\"]*)\" is successful for color \"([^\"]*)\"$")
    public void assertThatColor(String colorPickerName, String color) {
        getColorPicker(colorPickerName).assertThat().color(color);
    }
}
