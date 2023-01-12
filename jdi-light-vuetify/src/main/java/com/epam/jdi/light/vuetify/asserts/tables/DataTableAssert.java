package com.epam.jdi.light.vuetify.asserts.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.util.ArrayList;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DataTableAssert
    extends SimpleTableAssert<DataTable, DataTableAssert>
    implements ThemeAssert<DataTableAssert, DataTable> {

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

    @JDIAction("Assert that {name} element has required name")
    public DataTableAssert elementName(int elNum, String elName) {
        jdiAssert(element().getColumn(1).get(elNum).getText(), Matchers.is(elName));
        return this;
    }

    @JDIAction("Assert that {name} has required value")
    public DataTableAssert elementValue(int colNum, int elNum, String elName) {
        jdiAssert(element().columnElement(colNum, elNum), Matchers.is(elName));
        return this;
    }

    @JDIAction("Assert that {name} is loading")
    public DataTableAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} columns are sorted by {0}")
    public DataTableAssert sortedBy(String column) {
        jdiAssert(
            element().isSortedBy(column),
            Matchers.is(true),
            String.format("Expected the table to be sorted by %s", column)
        );
        return this;
    }

    @JDIAction("Assert that {name} columns aren't sorted by {0}")
    public DataTableAssert notSortedBy(String value) {
        jdiAssert(element().isSortedBy(value), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} element is selected")
    public DataTableAssert cellSelected(int colNum, int elNum) {
        jdiAssert(element().isSelected(colNum, elNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} checkbox has proper color")
    public DataTableAssert blankCheckbox(int colNum, int elNum) {
        jdiAssert(element().blankCheckbox(colNum, elNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} checkbox has proper color")
    public DataTableAssert greyCheckbox(int colNum, int elNum) {
        jdiAssert(element().blankCheckbox(colNum, elNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} element isn't selected")
    public DataTableAssert cellNotSelected(int colNum, int elNum) {
        jdiAssert(element().isSelected(colNum, elNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} column header is {0}")
    public DataTableAssert header(int colNum, String value) {
        jdiAssert(element().headerUI().get(colNum).text(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that {name} element is expanded")
    public DataTableAssert rowExpanded(int elNum) {
        jdiAssert(element().rowIsExpanded(elNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} element is collapsed")
    public DataTableAssert rowCollapsed(int elNum) {
        jdiAssert(element().rowIsExpanded(elNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} group is collapsed")
    public DataTableAssert groupCollapsed(String groupName) {
        jdiAssert(element().groupIsExpanded(groupName), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} group is expanded")
    public DataTableAssert groupExpanded(String groupName) {
        jdiAssert(element().groupIsExpanded(groupName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has group")
    public DataTableAssert group(String groupName) {
        jdiAssert(element().hasGroup(groupName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has number of rows per page input field")
    public DataTableAssert numberOfRowsPerPageInput(boolean enabled) {
        jdiAssert(
            element().getNumberOfRowsPerPageInput().hasClass("v-icon--disabled"),
            Matchers.is(!enabled),
            String.format("Expected to have number of rows per page button to be %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction("Assert that {name} has first page button")
    public DataTableAssert firstPageButton(boolean enabled) {
        jdiAssert(
            element().getFirstPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have first page button to be %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction("Assert that {name} has previous page button")
    public DataTableAssert previousPageButton(boolean enabled) {
        jdiAssert(
            element().getPreviousPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have previous page button to be %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction("Assert that {name} has next page button")
    public DataTableAssert nextPageButton(boolean enabled) {
        jdiAssert(
            element().getNextPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have next page button to be %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction("Assert that {name} has last page button")
    public DataTableAssert lastPageButton(boolean enabled) {
        jdiAssert(
            element().getLastPageButton().isEnabled(),
            Matchers.is(enabled),
            String.format("Expected to have last page button to be %s", enabledOrDisabledString(enabled))
        );
        return this;
    }

    @JDIAction("Assert {name} current page")
    public DataTableAssert currentPage(int expectedCurrentPage) {
        int actualCurrentPage = element().currentPage();
        jdiAssert(
            actualCurrentPage,
            Matchers.equalTo(expectedCurrentPage),
            String.format(
                "Expected current page to be: %d, but was: %d",
                expectedCurrentPage, actualCurrentPage
            )
        );
        return this;
    }

    @JDIAction("Assert that {name} has footer")
    public DataTableAssert footer(boolean isDisplayed) {
        jdiAssert(
            element().footer().isDisplayed(),
            Matchers.is(isDisplayed),
            "Expected footer to be displayed"
        );
        return this;
    }

    @JDIAction("Assert that {name} has header")
    public DataTableAssert header(boolean isDisplayed) {
        jdiAssert(
            element().header().size(),
            isDisplayed ? Matchers.greaterThan(0) : Matchers.equalTo(0),
            "Expected header to be displayed"
        );
        return this;
    }

    @JDIAction("Assert that {name} row has values")
    public DataTableAssert rowWithValues(int rowNumber, String... values) {
        jdiAssert(
            element().getRowValues(rowNumber),
            Matchers.hasItems(values)
        );
        return this;
    }

    @JDIAction("Assert that {name} sort is enabled for column")
    public DataTableAssert sortEnabled(String column, boolean isEnabled) {
        jdiAssert(
            element().isSortEnabled(column),
            Matchers.is(isEnabled),
            String.format("Expected sort to be %s for %s", enabledOrDisabledString(isEnabled), column)
        );
        return this;
    }

    @JDIAction("Assert that {name} group has size")
    public DataTableAssert groupSize(String groupName, int expectedSize) {
        int actualSize = element().groupElements().getOrDefault(groupName, new ArrayList<>()).size();
        jdiAssert(
            actualSize,
            Matchers.is(expectedSize),
            String.format(
                "Expected '%s' group size to be: %d, but was: %d",
                groupName, expectedSize, actualSize
            )
        );
        return this;
    }

    @JDIAction("Assert that {name} has fixed header")
    public DataTableAssert fixedHeader(boolean isFixedHeader) {
        jdiAssert(
            element().isFixedHeader(),
            Matchers.is(isFixedHeader),
            String.format("Expected the header to be: fixed = %s", isFixedHeader)
        );
        return this;
    }

    @JDIAction("Assert that '{name}' do not have '{name}' row")
    public DataTableAssert hasNoRow(int columnNum, String columnName) {
        jdiAssert(element().getColumn(columnNum).get(columnName).isExist(), Matchers.is(false));
        return this;
    }

    private static String enabledOrDisabledString(boolean enabled) {
        return enabled ? "enabled" : "disabled";
    }

}
