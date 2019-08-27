package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.TextArea;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ekaterina Vasilkova on 22.08.2019
 */

public class TextAreaSteps {

    @When("^(?:I |)Input in the \"([^\"]*)\" line \"([^\"]*)\"$")
    public void addNewLine(String name, String line) {
        TextArea textArea = getUI(name, TextArea.class);
        textArea.addNewLine(line);
    }

    @When("^(?:I |)Input in the \"([^\"]*)\" lines$")
    public void inputIn(String name, List<String> lines) {
        TextArea textArea = getUI(name, TextArea.class);
        textArea.setLines(lines.toArray(new String[0]));
    }

    @Then("^The \"([^\"]*)\" rows count equals \"([^\"]*)\"$")
    public void rowsCountEquals(String name, int rows) {
        TextArea textArea = getUI(name, TextArea.class);
        textArea.is().rowsCount(is(rows));
    }

    @Then("^The \"([^\"]*)\" columns count equals \"([^\"]*)\"$")
    public void colsCountEquals(String name, int cols) {
        TextArea textArea = getUI(name, TextArea.class);
        textArea.is().colsCount(is(cols));
    }

    @Then("^Lines in the \"([^\"]*)\" are equal$")
    public void linesInTextAreaAreEqual(String name, List<String> lines) {
        TextArea textArea = getUI(name, TextArea.class);
        assertEquals(lines, textArea.getLines());
    }

    @Then("^The \"([^\"]*)\" minimal length equals \"([^\"]*)\"$")
    public void minLengthEquals(String name, int minLength) {
        TextArea textArea = getUI(name, TextArea.class);
        textArea.is().minlength(is(minLength));
    }

    @Then("^The \"([^\"]*)\" maximal length equals \"([^\"]*)\"$")
    public void maxLengthEquals(String name, int maxLength) {
        TextArea textArea = getUI(name, TextArea.class);
        textArea.is().maxlength(is(maxLength));
    }

}
