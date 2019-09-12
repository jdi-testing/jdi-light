package cucmberTests.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.stepdefs.CheckListSteps.checklist;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;


public class CheckListSteps {

    @Then("^checkList \"([^\"]*)\" is basically valid$")
    public void checkboxIsBasicallyValid(String name) {
        checklist(name).is().displayed().selected("Hot option");
        checklist(name).is().selected("Hot option");
        checklist(name).assertThat().values(hasItem("Sunny"))
                .disabled(hasItem("Disabled"))
                .enabled(not(hasItem("Disabled")))
                .enabled(hasItems("Cold", "Sunny"));
    }
}