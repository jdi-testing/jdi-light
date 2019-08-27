package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.MultiSelector;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.testng.Assert.assertEquals;

public class MultiDropDownSteps {

    @When("^I check in the \"([^\"]*)\" values:$" )
    public void iCheckInTheValues(String name, List<String> values){
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        multiDropdown.check(values.toArray(new String[0]));
    }

    @Then("^the \"([^\"]*)\" selected values:$" )
    public void theSelectedValues(String name, List<String> values){
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        assertEquals(multiDropdown.checked(), values);
    }

    @When("^I check in the \"([^\"]*)\" values by number:$" )
    public void iCheckInTheValuesByNumber(String name, List<Integer> values){
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        int[] numbers = values.stream().mapToInt(Integer::intValue).toArray();
        multiDropdown.check(numbers);
    }


}
