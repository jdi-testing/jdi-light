package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DropdownSteps {
    public static Dropdown dropdown(String name) {
        return getUI(name, Dropdown.class);
    }
    
    @When("^(?:I |)expand \"([^\"]*)\" dropdown$")
    public void expandTheDropdown(String name) {
        dropdown(name).show();
        dropdown(name).expand();
    }
    
    @When("^(?:I |)close \"([^\"]*)\" dropdown$")
    public void closeTheDropdown(String name) {
        dropdown(name).show();
        dropdown(name).close();
    }

    @Then("^the \"([^\"]*)\" in \"([^\"]*)\" is selected$")
    public void theInIsSelected(String textValue, String name) {
        dropdown(name).is().selected(textValue);
    }
    
    @Then("^the \"([^\"]*)\" dropdown is expanded$")
    public void theIsExpanded(String name) {
        jdiAssert(dropdown(name).isExpanded() ? "expanded" : "closed", Matchers.is("expanded"));
    }
    
    @Then("^the \"([^\"]*)\" dropdown is closed$")
    public void theIsClosed(String name) {
        jdiAssert(dropdown(name).isExpanded() ? "expanded" : "closed", Matchers.is("closed"));
    }
}
