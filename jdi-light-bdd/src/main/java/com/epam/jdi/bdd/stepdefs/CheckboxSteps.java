package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.Checkbox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;

public class CheckboxSteps {
    @When("^Check \"([^\"]*)\" checkbox$")
    public void iCheckCheckbox(String checkboxName) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        checkbox.check();
    }

    @When("^Uncheck \"([^\"]*)\" checkbox$")
    public void iUncheckCheckbox(String checkboxName) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        checkbox.uncheck();
    }

    @When("^Click \"([^\"]*)\" checkbox$")
    public void iClickCheckbox(String checkboxName) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        checkbox.click();
    }

    @Then("^\"([^\"]*)\" checkbox is selected$")
    public void iAssertCheckboxIsSelected(String checkboxName) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        Assert.assertTrue(checkbox.isSelected());
    }

    @Then("^\"([^\"]*)\" checkbox is deselected$")
    public void iAssertCheckboxIsDeselected(String checkboxName) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        Assert.assertFalse(checkbox.isSelected());
    }

    @Then("^\"([^\"]*)\" checkbox label text equals to \"([^\"]*)\"$")
    public void iAssertCheckboxLabelTextEquals(String checkboxName, String value) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        Assert.assertEquals(value, checkbox.labelText());
    }

    @Then("^\"([^\"]*)\" checkbox label text equals to \"([^\"]*)\" ignoring case$")
    public void iAssertCheckboxLabelTextEqualsIgnoringCase(String checkboxName, String value) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        Assert.assertTrue(value.equalsIgnoreCase(checkbox.labelText()));
    }

    @Then("^\"([^\"]*)\" checkbox label text contains \"([^\"]*)\"$")
    public void iAssertCheckboxLabelTextContains(String checkboxName, String value) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        Assert.assertTrue(checkbox.labelText().contains(value));
    }
}
