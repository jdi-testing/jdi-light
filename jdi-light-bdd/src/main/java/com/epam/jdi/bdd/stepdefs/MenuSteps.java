package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.JList;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUIComplex;

public class MenuSteps {
    @When("^(?:I |)select \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void select(String value, String name) {
        JList list = getUIComplex(name, JList.class);
        list.get(value).click();
    }

    @When("^(?:I |)select items in \"([^\"]*)\" menu:$")
    public void selectItems(String name, List<String> values) {
        JList list = getUIComplex(name, JList.class);
        String[] items = values.toArray(new String[0]);
        for (String item : items)
            list.get(item).click();
    }

    @When("^(?:I |)show \"([^\"]*)\" in \"([^\"]*)\" menu$")
    public void show(String value, String name) {
        JList list = getUIComplex(name, JList.class);
        list.get(value).show();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is selected$")
    public void isSelected(String value, String name) {
        JList list = getUIComplex(name, JList.class);
        list.get(value).is().selected();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" menu is deselected$")
    public void isDeselected(String value, String name) {
        JList list = getUIComplex(name, JList.class);
        list.get(value).is().deselected();
    }
}
