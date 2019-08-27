package cucmberTests.stepdefs;

import com.epam.jdi.light.ui.html.complex.MultiSelector;
import cucumber.api.java.en.When;
import io.github.com.enums.Ages;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;

public class MultiDropDownSteps {
    @When("^I check in the \"([^\"]*)\" values by enum:$" )
    public void iCheckInTheValuesByEnum(String name, List<Ages> values){
        MultiSelector multiDropdown = (MultiSelector) getUI(name);
        multiDropdown.check(values.toArray(new Ages[0]));
    }
}
