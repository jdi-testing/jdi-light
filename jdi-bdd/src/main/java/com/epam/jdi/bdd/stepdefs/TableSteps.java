package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Issue;
import org.testng.Assert;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TableSteps {
    static Table lastTable;

    public static Table table(String name) {
        return lastTable = getUI(name, Table.class);
    }

    //#region When
    @When("^(?:I |)click the cell \\(([^\\)]*)\\) in the \"([^\"]*)\"(?: table|)$")
    public void selectCell(String cellPair, String name) {
        cell(name, cellPair).click();
    }
    //endregion

    //#region Then
    @Then("^the \"([^\"]*)\" (?:table |)has \"([^\"]*)\" columns$")
    public void assertColumnsCount(String name, int columns) {
        assertEquals(table(name).size(), columns);
    }

    @Then("^the \"([^\"]*)\" (?:table |)has \"([^\"]*)\" rows$")
    public void assertRowsCount(String name, int count) {
        table(name).has().size(count);
    }

    @Then("^the \"([^\"]*)\" (?:table |)has at least \"([^\"]*)\" rows$")
    public void atLeastRows(String name, int count) {
        table(name).has().size(greaterThanOrEqualTo(count));
    }

    @Then("^the \"([^\"]*)\" (?:table |)has not more than \"([^\"]*)\" rows$")
    public void notMoreThan(String name, int count) {
        table(name).has().size(lessThanOrEqualTo(count));
    }

    @Then("^the \"([^\"]*)\" (?:table |)header is:$")
    public void assertHasItems(String name, List<String> values) {
        assertTrue(table(name).header().containsAll(values));
    }

    @Then("^the \"([^\"]*)\" (?:table |)preview is:$")
    public void assertEqualsValues(String name, List<String> values) {
        String tableValues = String.join(", ", table(name).preview().replaceAll(" ", ""));
        String expectedValue = String.join(", ", values).replaceAll(", ", "");
        Assert.assertEquals(tableValues, expectedValue);
    }

    @Then("^the \"([^\"]*)\" (?:table |)is not empty$")
    public void assertNotEmpty(String name) {
        table(name).is().notEmpty();
    }

    @Then("^the \"([^\"]*)\" (?:table |)is empty$")
    public void assertEmpty(String name) {
        table(name).is().empty();
    }

    @Then("^the \"([^\"]*)\" (?:table |)has row with \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertHasRowContainValue(String name, String value, String column) {
        table(name).has().rowThat(containsValue(value, inColumn(column)));
    }

    @Then("^all rows of the \"([^\"]*)\" (?:table |)contains \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertAllRowsContainValue(String name, String value, String column) {
        table(name).assertThat().all().rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" (?:table |)has no rows which has \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertNoRowsContainValue(String name, String value, String column) {
        table(name).assertThat().no().rows(hasValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" (?:table |)has at least \"([^\"]*)\" rows which contains \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertAtLeastRowsContainValue(String name, int rows, String value, String column) {
        table(name).assertThat().atLeast(rows).rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" (?:table |)has exact \"([^\"]*)\" rows which contains \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertExactRowsContainValue(String name, int rows, String value, String column) {
        table(name).assertThat().exact(rows).rows(containsValue(value, inColumn(column)));
    }

    @Then("^the \"([^\"]*)\" (?:table |)has exact \"([^\"]*)\" rows with \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void assertExactRowsHaveValue(String name, int rows, String value, String column) {
        table(name).assertThat().exact(rows).rows(hasValue(value, inColumn(column)));
    }

    @Then("^the cell \\(([^\\)]*)\\) in the \"([^\"]*)\" (?:table |)is selected$")
    public void isCellSelected(String cellPair, String name) {
        cellIs(name, cellPair).selected();
    }

    @Issue("1691")
    @Then("^the cell \\(([^\\)]*)\\) in the \"([^\"]*)\" (?:table |)is deselected$")
    public void isCellDeselected(String cellPair, String name) {
        cellIs(name, cellPair).deselected();
    }

    @Then("^the \"([^\"]*)\" (?:table |)cell \\(([^\\)]*)\\) text equals to \"([^\"]*)\"$")
    public void isHasText(String name, String cellPair, String text) {
        cellIs(name, cellPair).text(text);
    }

    @Then("^the \"([^\"]*)\" (?:table |)cell \\(([^\\)]*)\\) text contains \"([^\"]*)\"$")
    public void isTextContains(String name, String cellPair, String text) {
        cellIs(name, cellPair).text(containsString(text));
    }

    @Then("^the \"([^\"]*)\" (?:table |)cell \\(([^\\)]*)\\) text matches to \"([^\"]*)\"$")
    public void isTextMatches(String name, String cellPair, String regex) {
        cellIs(name, cellPair).text(matchesPattern(regex));
    }

    //endregion
    private IsAssert cellIs(String name, String cellPair) {
        return cell(name, cellPair).is();
    }

    private UIElement cell(String name, String cellPair) {
        int x, y;
        try {
            String[] xy = cellPair.split(",");
            x = Integer.parseInt(xy[0].trim());
            y = Integer.parseInt(xy[1].trim());
        } catch (Exception ex) {
            throw exception("Can't parse cell. Correct format is (col,row): " + safeException(ex));
        }
        return table(name).webCell(x, y);
    }
}
