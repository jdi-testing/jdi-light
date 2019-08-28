package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.complex.MultiSelector;
import com.epam.jdi.tools.LinqUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.testng.Assert.assertEquals;

public class MultiSelectorSteps {

    @When("^I select \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void selectMultiselectorValue(String name, List<String> values) {
        MultiSelector multiSelector = getUI(name, MultiSelector.class);
        multiSelector.check(LinqUtils.toStringArray(values));
    }

    @Then("^I check the \"([^\"]*)\" multiselector text is equals to \"([^\"]*)\"$")
    public void checkMultiselectorText(String name, List<String> values) {
        MultiSelector multiSelector = getUI(name, MultiSelector.class);
        assertEquals(multiSelector.checked(), values);
    }

    @Then("^I check the \"([^\"]*)\" multiselector contains next values:$")
    public void assertMultiselectorValues(String name, List<String> values) {
        MultiSelector multiSelector = getUI(name, MultiSelector.class);
        multiSelector.assertThat().values(containsInAnyOrder(LinqUtils.toStringArray(values)));
    }

    @When("^I select (.*) numbers in \"([^\"]*)\" multiselector$")
    public void selectValuesByNumber(List<Integer> values, String name) {
        MultiSelector multiSelector = getUI(name, MultiSelector.class);
        multiSelector.check(LinqUtils.toIntArray(values));
    }
}