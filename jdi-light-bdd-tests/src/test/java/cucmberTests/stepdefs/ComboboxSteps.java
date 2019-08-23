package cucmberTests.stepdefs;

import com.epam.jdi.light.ui.html.complex.Combobox;
import cucumber.api.java.en.When;
import io.github.com.enums.IceCreams;

import static com.epam.jdi.bdd.Utils.getUI;

public class ComboboxSteps {

    @When("^Select ice cream \"([^\"]*)\" in combobox \"([^\"]*)\"$")
    public void selectEnumValue(IceCreams value, String name) {
        Combobox combobox = getUI(name, Combobox.class);
        combobox.select(value);
    }
}