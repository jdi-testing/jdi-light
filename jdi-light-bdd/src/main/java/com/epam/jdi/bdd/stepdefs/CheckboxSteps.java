package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.Checkbox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.epam.jdi.light.elements.composite.WebPage.ELEMENTS;

public class CheckboxSteps {
    @When("^Set \"([^\"]*)\" checkbox to \"([^\"]*)\"$")
    public void iSetCheckboxTo(String checkboxName, String value) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        boolean cond = (value.equalsIgnoreCase("true") || value.equals("1")) ? true : false;
        if (cond && (!checkbox.isSelected())) {
            checkbox.check();
        } else if ((!cond) && (checkbox.isSelected())) {
            checkbox.uncheck();
        }
    }

    @Then("^\"([^\"]*)\" checkbox is \"([^\"]*)\"$")
    public void iAssertCheckbox(String checkboxName, String value) {
        Checkbox checkbox = (Checkbox) ELEMENTS.get(checkboxName).get(0);
        boolean cond = (value.equalsIgnoreCase("true") || value.equals("1")) ? true : false;
        Assert.assertTrue(cond == checkbox.isSelected());
    }
}
