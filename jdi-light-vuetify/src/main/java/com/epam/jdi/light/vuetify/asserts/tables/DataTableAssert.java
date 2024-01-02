package com.epam.jdi.light.vuetify.asserts.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.ArrayList;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DataTableAssert
        extends SimpleTableAssert<DataTable, DataTableAssert>
        implements ThemeAssert<DataTableAssert, DataTable>, LoadingAssert<DataTableAssert, DataTable>,
        MeasurementAssert<DataTableAssert, DataTable> {

    @Override
    public DataTableAssert and() {
        return this;
    }

    @Override
    public DataTableAssert is() {
        return this;
    }

    @Override
    public DataTableAssert waitFor() {
        return this.is();
    }

    @JDIAction(value = "Assert that {name} element has required name")
    public DataTableAssert elementName(int elNum, String elName) {
        jdiAssert(element().getColumn(1).get(elNum).getText(), Matchers.is(elName));
        return this;
    }

    @JDIAction(value = "Assert that {name} has required value")
    public DataTableAssert elementValue(int colNum, int elNum, String elName) {
        jdiAssert(element().webCell(colNum, elNum).text(), Matchers.is(elName));
        return this;
    }

    @JDIAction(value = "Assert that {name} columns are sorted by {0}")
    public DataTableAssert sortedBy(String column) {
        jdiAssert(
            element().isSortedBy(column),
            Matchers.is(true),
            String.format("Table is not sorted by %s", column)
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} aren't sorted by column {0}")
    public DataTableAssert notSortedBy(String value) {
        jdiAssert(element().isSortedBy(value), Matchers.is(false), "Table is sorted by column " + value);
        return this;
    }

    @JDIAction(value = "Assert that {name} element is selected")
    public DataTableAssert cellSelected(int colNum, int elNum) {
        jdiAssert(element().isSelected(colNum, elNum), Matchers.is(true),
                String.format("Rows %d is not selected", elNum));
        return this;
    }

    @JDIAction(value = "Assert that {name} element isn't selected")
    public DataTableAssert cellNotSelected(int colNum, int elNum) {
        jdiAssert(element().isSelected(colNum, elNum), Matchers.is(false),
                String.format("Rows %d is selected", elNum));
        return this;
    }

    @JDIAction(value = "Assert that {name} column header is {0}")
    public DataTableAssert header(int colNum, String value) {
        jdiAssert(element().headerUI().get(colNum).text(), Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that {name} element is expanded")
    public DataTableAssert rowExpanded(int elNum) {
        jdiAssert(element().isRowExpanded(elNum), Matchers.is(true),
                String.format("Rows %d is not expanded", elNum));
        return this;
    }

    @JDIAction(value = "Assert that {name} element is collapsed")
    public DataTableAssert rowCollapsed(int elNum) {
        jdiAssert(element().isRowExpanded(elNum), Matchers.is(false),
                String.format("Rows %d is expanded", elNum));
        return this;
    }

    @JDIAction(value = "Assert that {name} group is collapsed")
    public DataTableAssert groupCollapsed(String groupName) {
        jdiAssert(element().isGroupExpanded(groupName), Matchers.is(false),
                String.format("Group %s doesn't collapsed", groupName));
        return this;
    }

    @JDIAction(value = "Assert that {name} group is expanded")
    public DataTableAssert groupExpanded(String groupName) {
        jdiAssert(element().isGroupExpanded(groupName), Matchers.is(true),
                String.format("Group %s doesn't expanded", groupName));
        return this;
    }

    @JDIAction(value = "Assert that {name} has group")
    public DataTableAssert group(String groupName) {
        jdiAssert(element().hasGroup(groupName), Matchers.is(true),
                String.format("Group %s doesn't exist", groupName));
        return this;
    }

    @JDIAction(value = "Assert that {name} has number of rows per page input field")
    public DataTableAssert numberOfRowsPerPageInput(boolean enabled) {
        jdiAssert(
            element().getNumberOfRowsPerPageInput().hasClass("v-icon--disabled"),
            Matchers.is(!enabled),
            String.format("Expected to have number of rows per page button is %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} has first page button")
    public DataTableAssert firstPageButton(boolean enabled) {
        jdiAssert(
            element().firstPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have first page button is %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} has previous page button")
    public DataTableAssert previousPageButton(boolean enabled) {
        jdiAssert(
            element().previousPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have previous page button is %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} has next page button")
    public DataTableAssert nextPageButton(boolean enabled) {
        jdiAssert(
            element().nextPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have next page button is %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} has last page button")
    public DataTableAssert lastPageButton(boolean enabled) {
        jdiAssert(
            element().lastPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have last page button is %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction(value = "Assert {name} current page")
    public DataTableAssert currentPage(int expectedCurrentPage) {
        int actualCurrentPage = element().currentPage();
        jdiAssert(
            actualCurrentPage,
            Matchers.equalTo(expectedCurrentPage)
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} has footer")
    public DataTableAssert footer(boolean isDisplayed) {
        jdiAssert(
            element().footer().isDisplayed(),
            Matchers.is(isDisplayed),
                String.format("Footer is %s", enabledOrDisabledString(isDisplayed))
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} has header")
    public DataTableAssert header(boolean isDisplayed) {
        jdiAssert(
            element().header().size(),
            isDisplayed ? Matchers.greaterThan(0) : Matchers.equalTo(0),
            "Expected header to be displayed"
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} row has values")
    public DataTableAssert rowWithValues(int rowNumber, String... values) {
        jdiAssert(
            element().getRowValues(rowNumber),
            Matchers.hasItems(values)
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} sort is enabled for column")
    public DataTableAssert sortEnabled(String column, boolean isEnabled) {
        jdiAssert(
            element().isSortEnabled(column),
            Matchers.is(isEnabled),
            String.format("Expected sort to be %s for %s", enabledOrDisabledString(isEnabled), column)
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} sort is required for the table")
    public DataTableAssert sortRequired(boolean isRequired) {
        jdiAssert(
            element().isSortRequired(),
            Matchers.is(isRequired),
            String.format("Expected sort to be %s for current table", requiredOrNotRequiredString(isRequired))
        );
        return this;
    }

    @JDIAction(value = "Assert that {name} is loading")
    public DataTableAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true), "Table is not loading");
        return this;
    }

    @JDIAction(value = "Assert that {name} group has size")
    public DataTableAssert groupSize(String groupName, int expectedSize) {
        int actualSize = element().groupedData().getOrDefault(groupName, new ArrayList<>()).size();
        jdiAssert(actualSize, Matchers.is(expectedSize));
        return this;
    }

    @JDIAction(value = "Assert that {name} has fixed header")
    public DataTableAssert fixedHeader(boolean isFixedHeader) {
        jdiAssert(
            element().isFixedHeader(),
            Matchers.is(isFixedHeader),
            String.format("Expected the header to be: fixed = %s", isFixedHeader)
        );
        return this;
    }

    @JDIAction(value = "Assert that '{name}' do not have '{1}' row")
    public DataTableAssert noRowInColumn(int columnNum, String rowValue) {
        jdiAssert(element().getColumn(columnNum).get(rowValue).isExist(), Matchers.is(false),
                String.format("There is a '%s' in %d column", rowValue, columnNum));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' do not have '{1}' row")
    public DataTableAssert rowInColumn(int columnNum, String rowValue) {
        jdiAssert(element().getColumn(columnNum).get(rowValue).isExist(), Matchers.is(true),
                String.format("There is no '%s' in %d column", rowValue, columnNum));
        return this;
    }

    private static String enabledOrDisabledString(boolean enabled) {
        return enabled ? "enabled" : "disabled";
    }

    private static String requiredOrNotRequiredString(boolean required) {
        return required ? "required" : "not required";
    }
}
