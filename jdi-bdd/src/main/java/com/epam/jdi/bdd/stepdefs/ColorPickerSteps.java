package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.ColorPicker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ColorPickerSteps {
    public static ColorPicker colorPicker(String name) {
        return getUI(name, ColorPicker.class);
    }

    @Given("the {string} was set to {string} color")
    @When("I set {string} to {string} color")
    public void preSetColor(String name, String color) {
        colorPicker(name).setColor(color);
    }

    @Then("the {string} has color {string}")
    public void hasColor(String name, String color) {
        colorPicker(name).has().color(color);
    }
}
