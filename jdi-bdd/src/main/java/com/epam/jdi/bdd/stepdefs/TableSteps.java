package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.safeException;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.*;

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
    @Then("the {string} table has {string} columns")
    @Then("the {string} has {string} columns")
    public void assertColumnsCount(String name, int size) {
        table(name).assertThat().columns(hasSize(size));
    }

    @Then("the {string} table has {string} rows")
    @Then("the {string} has {string} rows")
    public void assertRowsCount(String name, int count) {
        table(name).has().size(count);
    }

    @Then("the {string} table has at least {string} rows")
    @Then("the {string} has at least {string} rows")
    public void atLeastRows(String name, int count) {
        table(name).has().size(greaterThanOrEqualTo(count));
    }

    @Then("the {string} table has not more than {string} rows")
    @Then("the {string} has not more than {string} rows")
    public void notMoreThan(String name, int count) {
        table(name).has().size(lessThanOrEqualTo(count));
    }

    @Then("the {string} table has header:")
    @Then("the {string} has header:")
    public void assertHasItems(String name, List<String> values) {
        table(name).has().columns(values);
    }

    @Then("the {string} table preview is:")
    @Then("the {string} preview is:")
    public void assertEqualsValues(String name, List<List<String>> values) {
        String preview = print(map(values, v -> print(map(v, String::trim), " ")), " ");
        table(name).has().preview(preview);
    }

    @Then("the {string} table is not empty")
    @Then("the {string} is not empty")
    public void assertNotEmpty(String name) {
        table(name).is().notEmpty();
    }

    @Then("the {string} table is empty")
    @Then("the {string} is empty")
    public void assertEmpty(String name) {
        table(name).is().empty();
    }

    @Then("the {string} table has row with {string} in column {string}")
    @Then("the {string} has row with {string} in column {string}")
    public void assertHasRowContainValue(String name, String value, String column) {
        table(name).has().rowThat(containsValue(value, inColumn(column)));
    }

    @Then("all rows of the {string} table contains {string} in column {string}")
    @Then("all rows of the {string} contains {string} in column {string}")
    public void assertAllRowsContainValue(String name, String value, String column) {
        table(name).assertThat().all().rows(containsValue(value, inColumn(column)));
    }

    @Then("the {string} table has no rows which has {string} in column {string}")
    @Then("the {string} has no rows which has {string} in column {string}")
    public void assertNoRowsContainValue(String name, String value, String column) {
        table(name).assertThat().no().rows(hasValue(value, inColumn(column)));
    }

    @Then("the {string} table has at least {string} rows which contains {string} in column {string}")
    @Then("the {string} has at least {string} rows which contains {string} in column {string}")
    public void assertAtLeastRowsContainValue(String name, int rows, String value, String column) {
        table(name).assertThat().atLeast(rows).rows(containsValue(value, inColumn(column)));
    }

    @Then("the {string} table has exact {string} rows which contains {string} in column {string}")
    @Then("the {string} has exact {string} rows which contains {string} in column {string}")
    public void assertExactRowsContainValue(String name, int rows, String value, String column) {
        table(name).assertThat().exact(rows).rows(containsValue(value, inColumn(column)));
    }

    @Then("the {string} table has exact {string} rows with {string} in column {string}")
    @Then("the {string} has exact {string} rows with {string} in column {string}")
    public void assertExactRowsHaveValue(String name, int rows, String value, String column) {
        table(name).assertThat().exact(rows).rows(hasValue(value, inColumn(column)));
    }

    @Then("^the cell \\(([^\\)]*)\\) in the \"([^\"]*)\" (?:table |)is selected$")
    public void isCellSelected(String cellPair, String name) {
        cellIs(name, cellPair).selected();
    }

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
            x = parseInt(xy[0].trim());
            y = parseInt(xy[1].trim());
        } catch (Exception ex) {
            throw exception("Can't parse cell. Correct format is (col,row): " + safeException(ex));
        }
        return table(name).webCell(x, y);
    }
}
