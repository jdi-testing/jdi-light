package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.TextArea;
import cucumber.api.java.en.*;

import java.util.List;

import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by Ekaterina Vasilkova on 22.08.2019
 */
public class TextAreaSteps {
    public static TextArea textArea(String name) {
        return getUI(name, TextArea.class);
    }

    @When("^(?:I |)input in the \"([^\"]*)\" line \"([^\"]*)\"$")
    public void addNewLine(String name, String line) {
        textArea(name).addNewLine(line);
    }

    @When("^(?:I |)input in the \"([^\"]*)\" lines$")
    public void inputIn(String name, List<String> lines) {
        textArea(name).setLines(lines.toArray(new String[0]));
    }

    @Then("^the \"([^\"]*)\" rows count equals \"([^\"]*)\"$")
    public void rowsCountEquals(String name, int rows) {
        textArea(name).is().rowsCount(is(rows));
    }

    @Then("^the \"([^\"]*)\" columns count equals \"([^\"]*)\"$")
    public void colsCountEquals(String name, int cols) {
        textArea(name).is().colsCount(is(cols));
    }

    @Then("^the lines in the \"([^\"]*)\" are equal$")
    public void linesInTextAreaAreEqual(String name, List<String> lines) {
        assertEquals(lines, textArea(name).getLines());
    }

    @Then("^the \"([^\"]*)\" minimal length equals \"([^\"]*)\"$")
    public void minLengthEquals(String name, int minLength) {
        textArea(name).is().minlength(is(minLength));
    }

    @Then("^the \"([^\"]*)\" maximal length equals \"([^\"]*)\"$")
    public void maxLengthEquals(String name, int maxLength) {
        textArea(name).is().maxlength(is(maxLength));
    }

}
