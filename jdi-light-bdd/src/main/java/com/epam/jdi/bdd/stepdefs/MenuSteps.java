package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.JList;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUIList;

public class MenuSteps {
    @When("^(?:I |)Select \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void select(String value, String name) {
        JList list = getUIList(name);
        list.get(value).click();
    }

    @When("^(?:I |)Select \"([^\"]*)\" items in \"([^\"]*)\" menu$")
    public void selectList(String value, String name) {
        JList list = getUIList(name);
        String[] items = value.split(";");
        for (String item : items)
            list.get(item).click();
    }

    @When("^(?:I |)Show \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void show(String value, String name) {
        JList list = getUIList(name);
        list.get(value).show();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is selected$")
    public void isSelected(String value, String name) {
        JList list = getUIList(name);
        list.get(value).is().selected();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is deselected$")
    public void isDeselected(String value, String name) {
        JList list = getUIList(name);
        list.get(value).is().deselected();
    }
}
