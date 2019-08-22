package cucmberTests.stepdefs;

import com.epam.jdi.light.ui.html.complex.Checklist;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.com.enums.Weather;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static io.github.com.enums.Weather.Hot;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;


public class CheckListSteps {

    @When("I check in \"([^\"]*)\":$")
    public void iCheckCheckbox(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(values.toArray(new String[0]));
    }

    @When("I select in \"([^\"]*)\":$")
    public void iSelectCheckbox(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(values.toArray(new String[0]));
    }

    @When("I uncheck in \"([^\"]*)\":$")
    public void uncheckElement(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(values.toArray(new String[0]));
    }

    @When("I check in \"([^\"]*)\" via enum:$")
    public void iCheckViaEnum(String name, List<Weather> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(values.toArray(new Weather[0]));
    }

    @When("I check all in \"([^\"]*)\"")
    public void iCheckAll(String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.checkAll();
    }

    @When("I uncheck in \"([^\"]*)\" labels via enum:$")
    public void uncheckElementViaEnum(String name, List<Weather> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(values.toArray(new Weather[0]));
    }

    @When("^I check element \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iCheckLabelIn(String value, String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(value);
    }

    @When("^I select element \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iSelectElement(String value, String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(value);
    }

    @When("^I select in \"([^\"]*)\" via enum:$")
    public void iSelectInViaEnum(String name, List<Weather> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(values.toArray(new Weather[0]));
    }

    @When("^I check in \"([^\"]*)\" via numbers:$")
    public void iCheckInViaNumbers(String name, List<Integer> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(getIntArrayFromIntegerList(values));
    }

    @When("^I uncheck in \"([^\"]*)\" via numbers:$")
    public void iUncheckInViaNumbers(String name, List<Integer> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(getIntArrayFromIntegerList(values));
    }

    @When("^I select checkbox in \"([^\"]*)\" via numbers:$")
    public void iSelectInViaNumbers(String name, List<Integer> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(getIntArrayFromIntegerList(values));
    }

    @When("^I select nothing in \"([^\"]*)\" should be exception$")
    public void iSelectNothingIn(String name) {
        Checklist checklist = (Checklist) getUI(name);
        try {
            checklist.select();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString(
                    "Select for Checklist should have at least one parameter"));
        }
    }

    @When("^I uncheck All in \"([^\"]*)\"$")
    public void iUncheckAll(String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheckAll();
    }

    @Then("^In \"([^\"]*)\" checked element is \"([^\"]*)\"$")
    public void inCheckedLabelsIs(String name, String value) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.is().selected(value);
    }

    @Then("Count of selected checkboxes in \"([^\"]*)\" is \"([^\"]*)\"")
    public void countOfSelected(String name, int count) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.is().selected(hasSize(count));
    }

    @Then("In \"([^\"]*)\" checked elements are:$")
    public void isChecked(String name, List<String> values) {
        Checklist checklist = (Checklist) getUI(name);
        assertEquals(checklist.checked(), values);
    }

    @Then("^CheckList \"([^\"]*)\" is basically valid$")
    public void checkboxIsBasicallyValid(String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.is().displayed().selected("Hot option");
        checklist.is().selected(Hot);
        checklist.assertThat().values(hasItem("Sunny"))
                .disabled(hasItem("Disabled"))
                .enabled(not(hasItem("Disabled")))
                .enabled(hasItems("Cold", "Sunny"));
    }

    @Then("\"([^\"]*)\" Checklist text is \"([^\"]*)\"$")
    public void checkListTextIs(String name, String text) {
        Checklist checklist = (Checklist) getUI(name);
        assertEquals(checklist.getValue(), text);
    }

    private int[] getIntArrayFromIntegerList(List<Integer> inputList) {
        int[] intValues = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            intValues[i] = inputList.get(i);
        }
        return intValues;
    }
}

