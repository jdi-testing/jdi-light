package cucmberTests.stepdefs;

import com.epam.jdi.light.ui.html.complex.Checklist;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;


public class CheckListSteps {

    @When("^(?:I |)select nothing in \"([^\"]*)\" checklist and should be exception$")
    public void iSelectNothingIn(String name) {
        Checklist checklist = (Checklist) getUI(name);
        try {
            checklist.select();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString(
                    "Select for Checklist should have at least one parameter"));
        }
    }

    @Then("^checkList \"([^\"]*)\" is basically valid$")
    public void checkboxIsBasicallyValid(String name) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.is().displayed().selected("Hot option");
        checklist.is().selected("Hot option");
        checklist.assertThat().values(hasItem("Sunny"))
                .disabled(hasItem("Disabled"))
                .enabled(not(hasItem("Disabled")))
                .enabled(hasItems("Cold", "Sunny"));
    }
}