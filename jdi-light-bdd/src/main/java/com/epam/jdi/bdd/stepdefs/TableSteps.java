package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.elements.complex.table.Table;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableSteps {
    public static Table table(String name) { return getUI(name, Table.class); }

    @Then("^the \"([^\"]*)\" table columns count equals \"([^\"]*)\"$")
    public void assertColumnsCount(String name, int columns) {
        assertEquals(table(name).size(), columns);
    }
    @Then("^the \"([^\"]*)\" table rows count equals \"([^\"]*)\"$")
    public void assertRowsCount(String name, int rows) {
        assertEquals(table(name).rows().size(), rows);
    }
    @Then("^the \"([^\"]*)\" table header has items:$")
    public void assertHasItems(String name, List<String> values) {
        assertTrue(table(name).header().containsAll(values));
    }
    @Then("^the \"([^\"]*)\" table preview equals values:$")
    public void assertEqualsValues(String name, List<String> values) {
        String tableValues = String.join(", ", table(name).preview().replaceAll(" ", ""));
        String expectedValue = String.join(", ", values).replaceAll(", ", "");
        Assert.assertEquals(tableValues, expectedValue);

    }
    @Then("^the \"([^\"]*)\" table is not empty$")
    public void assertNotEmpty(String name) {
        table(name).isNotEmpty();
    }
    @Then("^the \"([^\"]*)\" table has size \"([^\"]*)\"$")
    public void assertSize(String name, int size) {
        table(name).has().size(size);
    }
    @Then("^the \"([^\"]*)\" table has size greater than \"([^\"]*)\"$")
    public void assertSizeGreaterThan(String name, int size) {
        table(name).assertThat().size(greaterThan(size));
    }
    @Then("^the \"([^\"]*)\" table has size less or equal to \"([^\"]*)\"$")
    public void assertSizeLessOrEqualTo(String name, int size) {
        table(name).assertThat().size(lessThanOrEqualTo(size));
    }
    @Then("^the \"([^\"]*)\" table has row that contains value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertHasRowContainValue(String name, String value, String column) {
        table(name).has().rowThat(containsValue(value, inColumn(column)));
    }
    @Then("^the \"([^\"]*)\" table all rows contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertAllRowsContainValue(String name, String value, String column) {
        table(name).assertThat().all().rows(containsValue(value, inColumn(column)));
    }
    @Then("^the \"([^\"]*)\" table has no rows which contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertNoRowsContainValue(String name, String value, String column) {
        table(name).assertThat().no().rows(containsValue(value, inColumn(column)));
    }
    @Then("^the \"([^\"]*)\" table has at least \"([^\"]*)\" rows which contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertAtLeastRowsContainValue(String name, int rows, String value, String column) {
        table(name).assertThat().atLeast(rows).rows(containsValue(value, inColumn(column)));
    }
    @Then("^the \"([^\"]*)\" table has exact \"([^\"]*)\" rows which contain value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertExactRowsContainValue(String name, int rows, String value, String column) {
        table(name).assertThat().exact(rows).rows(containsValue(value, inColumn(column)));
    }
    @Then("^the \"([^\"]*)\" table has exact \"([^\"]*)\" rows which have value \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertExactRowsHaveValue(String name, int rows, String value, String column) {
        table(name).assertThat().exact(rows).rows(hasValue(value, inColumn(column)));
    }
    @When("^(?:I |)click the cell in row \"([^\"]*)\" in column \"([^\"]*)\" of the table \"([^\"]*)\"$")
    public void selectCell(int row, int column, String name) {
        table(name).webCell(column, row).click();
    }
    @Then("^the cell in row \"([^\"]*)\" in column \"([^\"]*)\" of the table \"([^\"]*)\" is selected$")
    public void isCellSelected(int row, int column, String name) {
        assertTrue(table(name).webCell(column, row).isSelected());
    }
    @Then("^the cell in row \"([^\"]*)\" in column \"([^\"]*)\" of the table \"([^\"]*)\" is deselected$")
    public void isCellDeselected(int row, int column, String name) {
        assertTrue(table(name).webCell(column, row).isDeselected());
    }
}
