package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.elements.common.TextArea;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.epam.jdi.bdd.BDDUtils.getListFromData;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.LinqUtils.toStringArray;
import static org.hamcrest.Matchers.is;

/**
 * Created by Ekaterina Vasilkova on 22.08.2019
 */
public class TextAreaSteps {
    public static TextArea textArea(String name) {
        return getUI(name, TextArea.class);
    }

    @When("I input in the {string} line {string}")
    @When("input in the {string} line {string}")
    public void addNewLine(String name, String line) {
        textArea(name).addNewLine(line);
    }

    @When("I input in the {string} lines")
    @When("input in the {string} lines")
    public void inputIn(String name, List<List<String>> lines) {
        textArea(name).setLines(toStringArray(getListFromData(lines)));
    }

    @Then("the {string} rows count equals {int}")
    public void rowsCountEquals(String name, int rows) {
        textArea(name).is().rowsCount(is(rows));
    }

    @Then("the {string} columns count equals {int}")
    public void colsCountEquals(String name, int cols) {
        textArea(name).is().colsCount(is(cols));
    }

    @Then("the lines in the {string} are equal")
    public void linesInTextAreaAreEqual(String name, List<List<String>> lines) {
        textArea(name).has().lines(getListFromData(lines));
    }

    @Then("the {string} minimal length equals {int}")
    public void minLengthEquals(String name, int minLength) {
        textArea(name).is().minlength(is(minLength));
    }

    @Then("the {string} maximal length equals {int}")
    public void maxLengthEquals(String name, int maxLength) {
        textArea(name).is().maxlength(is(maxLength));
    }

}
