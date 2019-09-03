package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.table.Table;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

import static com.epam.jdi.bdd.Utils.getUIComplex;
import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableSteps {
    @Then("^the \"([^\"]*)\" table columns count equals \"([^\"]*)\"$")
    public void assertColumnsCount(String elementName, int columns) {
        Table table = getUIComplex(elementName);
        assertEquals(table.size(), columns);
    }

    @Then("^the \"([^\"]*)\" table rows count equals \"([^\"]*)\"$")
    public void assertRowsCount(String elementName, int rows) {
        Table table = getUIComplex(elementName);
        assertEquals(table.rows().size(), rows);
    }

    @Then("^the \"([^\"]*)\" table header has items:$")
    public void assertHasItems(String elementName, List<String> values) {
        Table table = getUIComplex(elementName);
        assertTrue(table.header().containsAll(values));
    }

    @Then("^the \"([^\"]*)\" table preview equals values:$")
    public void assertEqualsValues(String elementName, List<String> values) {
        Table table = getUIComplex(elementName);
        String tableValues = String.join(", ", table.preview().replaceAll(" ", ""));
        String expectedValue = String.join(", ", values).replaceAll(", ", "");
        Assert.assertEquals(tableValues, expectedValue);

    }

    @Then("^the \"([^\"]*)\" table is not empty$")
    public void assertNotEmpty(String elementName) {
        Table table = getUIComplex(elementName);
        table.isNotEmpty();
    }

    @Then("^the \"([^\"]*)\" table has size \"([^\"]*)\"$")
    public void assertSize(String elementName, int size) {
        Table table = getUIComplex(elementName);
        table.has().size(size);
    }

    @Then("^the \"([^\"]*)\" table has size greater than \"([^\"]*)\"$")
    public void assertSizeGreaterThan(String elementName, int size) {
        Table table = getUIComplex(elementName);
        table.assertThat().size(greaterThan(size));
    }

    @Then("^the \"([^\"]*)\" table has size less or equal to \"([^\"]*)\"$")
    public void assertSizeLessOrEqualTo(String elementName, int size) {
        Table table = getUIComplex(elementName);
        table.assertThat().size(lessThanOrEqualTo(size));
    }

    @Then("^the \"([^\"]*)\" table has row that contains value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertHasRowContainValue(String elementName, String value, String column) {
        Table table = getUIComplex(elementName);
        table.has().rowThat(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" table all rows contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertAllRowsContainValue(String elementName, String value, String column) {
        Table table = getUIComplex(elementName);
        table.assertThat().all().rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" table has no rows which contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertNoRowsContainValue(String elementName, String value, String column) {
        Table table = getUIComplex(elementName);
        table.assertThat().no().rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" table has at least \"([^\"]*)\" rows which contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertAtLeastRowsContainValue(String elementName, int rows, String value, String column) {
        Table table = getUIComplex(elementName);
        table.assertThat().atLeast(rows).rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" table has exact \"([^\"]*)\" rows which contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertExactRowsContainValue(String elementName, int rows, String value, String column) {
        Table table = getUIComplex(elementName);
        table.assertThat().exact(rows).rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" table has exact \"([^\"]*)\" rows which have value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertExactRowsHaveValue(String elementName, int rows, String value, String column) {
        Table table = getUIComplex(elementName);
        table.assertThat().exact(rows).rows(hasValue(value, inColumn(column)));
    }

    @When("^(?:I |)click the cell in row \"([^\"]*)\" in column \"([^\"]*)\" of the table \"([^\"]*)\"$")
    public void selectCell(int row, int column, String elementName) {
        Table table = getUIComplex(elementName);
        table.webCell(column, row).click();
    }

    @Then("^the cell in row \"([^\"]*)\" in column \"([^\"]*)\" of the table \"([^\"]*)\" is selected$")
    public void isCellSelected(int row, int column, String elementName) {
        Table table = getUIComplex(elementName);
        assertTrue(table.webCell(column, row).isSelected());
    }

    @Then("^the cell in row \"([^\"]*)\" in column \"([^\"]*)\" of the table \"([^\"]*)\" is deselected$")
    public void isCellDeselected(int row, int column, String elementName) {
        Table table = getUIComplex(elementName);
        assertTrue(table.webCell(column, row).isDeselected());
    }
}
