package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.WebList;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getList;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MenuSteps {
    public static WebList menu(String name) {
       return getList(name, Menu.class);
    }

    @When("I select {string} in {string} menu")
    @When("select {string} in {string} menu")
    public void select(String value, String name) {
        menu(name).select(value);
    }

    @When("I select items in {string} menu:")
    @When("select items in {string} menu:")
    public void selectItems(String name, List<List<String>> values) {
        for (String item : values.get(0))
            menu(name).select(item);
    }

    @Then("the {string} in {string} menu is selected")
    public void isSelected(String value, String name) {
        menu(name).is().selected(value);
    }
}
