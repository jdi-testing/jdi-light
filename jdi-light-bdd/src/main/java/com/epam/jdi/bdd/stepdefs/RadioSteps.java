package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.RadioButtons;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.testng.Assert.assertEquals;

public class RadioSteps {

    @When("^(?:I |)select the radio button with \"([^\"]*)\" index from \"([^\"]*)\"$")
    public void selectRadioIndex(int index, String name) {
        RadioButtons el = getUI(name, RadioButtons.class);
        el.select(index);
    }

    //#region Then
    @Then("^the \"([^\"]*)\" consists of next values:$")
    public void theConsistOfNextValues(String name, List<String> values) {
        RadioButtons el = getUI(name, RadioButtons.class);
        assertEquals(el.values(), values);
    }


    @Then("^the \"([^\"]*)\" contains \"([^\"]*)\" radio button$")
    public void theContainsRadioButton(String name, String value) {
        RadioButtons el = getUI(name, RadioButtons.class);
        el.is().values(hasItem(value));
    }


    @Then("^the \"([^\"]*)\" contains \"([^\"]*)\" disabled radio button$")
    public void theContainsDisabledRadioButton(String name, String value) {
        RadioButtons el = getUI(name, RadioButtons.class);
        el.is().disabled(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" does not contain \"([^\"]*)\" enabled radio button$")
    public void theDoesNotContainEnabledRadioButton(String name, String value) {
        RadioButtons el = getUI(name, RadioButtons.class);
        el.is().enabled(not(hasItem(value)));
    }


    @Then("^the \"([^\"]*)\" contains next enabled values:$")
    public void theContainsNextValues(String name, List<String> values) {
        RadioButtons el = getUI(name, RadioButtons.class);
        for (String string : values) {
            el.is().enabled(hasItem(string));
        }
    }
    //#endregion
}