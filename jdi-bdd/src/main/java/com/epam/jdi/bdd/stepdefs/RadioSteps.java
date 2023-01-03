package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @When("^(?:I |)select the radio button with \"([^\"]*)\" index from \"([^\"]*)\"$")
    public void selectRadioIndex(int index, String name) {
        radioButtons(name).select(index);
    }

    //#region Then
    @Then("^the \"([^\"]*)\" consists of next values:$")
    public void theConsistOfNextValues(String name, DataTable values) {
        radioButtons(name).has().values(values.values());
    }

    @Then("^the \"([^\"]*)\" contains \"([^\"]*)\" radio button$")
    public void theContainsRadioButton(String name, String value) {
        radioButtons(name).is().values(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" contains \"([^\"]*)\" disabled radio button$")
    public void theContainsDisabledRadioButton(String name, String value) {
        radioButtons(name).is().disabled(hasItem(value));
    }

    @Then("^the \"([^\"]*)\" does not contain \"([^\"]*)\" enabled radio button$")
    public void theDoesNotContainEnabledRadioButton(String name, String value) {
        radioButtons(name).is().enabled(not(hasItem(value)));
    }

    @Then("^the \"([^\"]*)\" contains next enabled values:$")
    public void theContainsNextValues(String name, DataTable values) {
        for (String string : values.values()) {
            radioButtons(name).is().enabled(hasItem(string));
        }
    }
    //#endregion
}