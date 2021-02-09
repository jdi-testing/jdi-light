package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.BDDUtils.getListFromData;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsIterableContaining.hasItem;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RadioSteps {
    public static RadioButtons radioButtons(String name) {
        return getUI(name, RadioButtons.class);
    }

    @When("I select the radio button with {int} index from {string}")
    @When("select the radio button with {int} index from {string}")
    public void selectRadioIndex(int index, String name) {
        radioButtons(name).select(index);
    }

    //#region Then
    @Then("the {string} consists of next values:")
    public void theConsistOfNextValues(String name, List<List<String>> values) {
        radioButtons(name).has().values(getListFromData(values));
    }

    @Then("the {string} contains {string} radio button")
    public void theContainsRadioButton(String name, String value) {
        radioButtons(name).is().values(hasItem(value));
    }

    @Then("the {string} contains {string} disabled radio button")
    public void theContainsDisabledRadioButton(String name, String value) {
        radioButtons(name).is().disabled(hasItem(value));
    }

    @Then("the {string} does not contain {string} enabled radio button")
    public void theDoesNotContainEnabledRadioButton(String name, String value) {
        radioButtons(name).is().enabled(not(hasItem(value)));
    }

    @Then("the {string} contains next enabled values:")
    public void theContainsNextValues(String name, List<List<String>> values) {
        for (String string : getListFromData(values)) {
            radioButtons(name).is().enabled(hasItem(string));
        }
    }
    //#endregion
}