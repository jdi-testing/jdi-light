package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.TextField;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TextFieldSteps {
    private String text;
    private String value;

    @And("^the \"([^\"]*)\" have \"([^\"]*)\" value$")
    public void haveValue(String name, String value) {
        TextField textField = (TextField) getUI(name);
        textField.setText(value);
    }

    @When("^I get text from \"([^\"]*)\"$")
    public void iGetTextFrom(String name) {
        TextField textField = (TextField) getUI(name);
        text = textField.getText();
    }

    @Then("^the \"([^\"]*)\" text is \"([^\"]*)\"$")
    public void textIs(String name, String value) throws Throwable {
        TextField textField = (TextField) getUI(name);
        textField.assertThat().text(equalTo(value));
    }
}
