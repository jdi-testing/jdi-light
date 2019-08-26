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
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;


public class CheckListSteps {

    @When("I check in \"([^\"]*)\" checklist elements by enum:$")
    public void iCheckViaEnum(String name, List<Weather> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.check(values.toArray(new Weather[0]));
    }

    @When("I uncheck in \"([^\"]*)\" checklist elements by enum:$")
    public void uncheckElementViaEnum(String name, List<Weather> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.uncheck(values.toArray(new Weather[0]));
    }

    @When("^I select in \"([^\"]*)\" checklist elements by enum:$")
    public void iSelectInViaEnum(String name, List<Weather> values) {
        Checklist checklist = (Checklist) getUI(name);
        checklist.select(values.toArray(new Weather[0]));
    }

    @When("^I select nothing in \"([^\"]*)\" checklist and should be exception$")
    public void iSelectNothingIn(String name) {
        Checklist checklist = (Checklist) getUI(name);
        try {
            checklist.select();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString(
                    "Select for Checklist should have at least one parameter"));
        }
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
}