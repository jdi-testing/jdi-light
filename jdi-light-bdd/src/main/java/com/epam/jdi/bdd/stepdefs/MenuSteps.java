package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.JList;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

public class MenuSteps {
    public static JList list(String name) { return getUI(name, JList.class); }

    @When("^(?:I |)select \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void select(String value, String name) {
        list(name).get(value).click();
    }

    @When("^(?:I |)select items in \"([^\"]*)\" menu:$")
    public void selectItems(String name, List<String> values) {
        String[] items = values.toArray(new String[0]);
        for (String item : items)
            list(name).get(item).click();
    }

    @When("^(?:I |)show \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void show(String value, String name) {
        list(name).get(value).show();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is selected$")
    public void isSelected(String value, String name) {
        list(name).get(value).isSelected();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is deselected$")
    public void isDeselected(String value, String name) {
        list(name).get(value).isDeselected();
    }
}
