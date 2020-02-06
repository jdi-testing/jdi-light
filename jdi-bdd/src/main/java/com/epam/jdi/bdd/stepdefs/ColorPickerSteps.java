package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.mobile.ui.html.elements.common.ColorPicker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ColorPickerSteps {
    public static ColorPicker colorPicker(String name) { return getUI(name, ColorPicker.class); }

    @Given("^the \"([^\"]*)\" was set to \"([^\"]*)\" color$")
    @When("^I set \"([^\"]*)\" to \"([^\"]*)\" color$")
    public void preSetColor(String name, String color){
        colorPicker(name).setColor(color);
    }
    @Then("^the \"([^\"]*)\" color equals to \"([^\"]*)\"$")
    public void haveColor(String name, String expectedColor) {
        colorPicker(name).is().color(expectedColor);
    }
    @Then("^the \"([^\"]*)\" color is \"([^\"]*)\"$")
    public void assertThatColor(String name, String color) {
        colorPicker(name).is().color(color);
    }
}
