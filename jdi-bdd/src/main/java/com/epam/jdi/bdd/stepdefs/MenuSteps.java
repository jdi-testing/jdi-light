package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.Menu;
import cucumber.api.java.en.*;

import java.util.List;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MenuSteps {
    public static Menu list(String name) {
        return getUI(name, Menu.class);
    }

    @When("^(?:I |)select \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void select(String value, String name) {
        list(name).select(value);
    }

    @When("^(?:I |)select items in \"([^\"]*)\" menu:$")
    public void selectItems(String name, List<String> values) {
        String[] items = values.toArray(new String[0]);
        for (String item : items)
            list(name).select(item);
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is selected$")
    public void isSelected(String value, String name) {
        list(name).is().selected(value);
    }
}
