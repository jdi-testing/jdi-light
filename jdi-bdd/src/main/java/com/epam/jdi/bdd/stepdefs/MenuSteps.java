package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.WebList;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Issue;

import java.util.List;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;

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
    
    @Issue("1692")
    @JDIAction(timeout = 15)
    @When("^(?:I |)select items in \"([^\"]*)\" menu:$")
    public void selectItems(String name, List<String> values) {
        for (String item : values)
            list(name).select(item);
    }

    @Issue("1692")
    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is selected$")
    public void isSelected(String value, String name) {
        list(name).selected(value);
    }
}
