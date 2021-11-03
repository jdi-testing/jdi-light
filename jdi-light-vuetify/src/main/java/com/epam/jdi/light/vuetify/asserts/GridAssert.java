package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Grid;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridAssert extends UIAssert<GridAssert, Grid> {

    @JDIAction("Assert that '{name}' is displayed")
    public GridAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text in in column {1}")
    public GridAssert columnText(String text, int rowIndex, int columnIndex) {
        jdiAssert(element().getColumnByIndex(rowIndex, columnIndex).text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' row {0} has expected alignment")
    public GridAssert rowVerticalAlignment(int rowIndex, String alignment) {
        jdiAssert(element().getRowVerticalAlignment(rowIndex), Matchers.is(String.format("align-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' row {0} has expected alignment")
    public GridAssert rowHorizontalAlignment(int rowIndex, String alignment) {
        jdiAssert(element().getRowHorizontalAlignment(rowIndex), Matchers.is(String.format("justify-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected alignment")
    public GridAssert columnVerticalAlignment(int rowIndex, int columnIndex, String alignment) {
        jdiAssert(element().getColumnVerticalAlignment(rowIndex, columnIndex),
                Matchers.is(String.format("align-self-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected order")
    public GridAssert columnOrder(int rowIndex, int columnIndex, String order) {
        jdiAssert(element().getColumnOrder(rowIndex, columnIndex), Matchers.is(String.format("order-%s", order)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected order")
    public GridAssert columnOrder(int rowIndex, int columnIndex, int order) {
        jdiAssert(element().getColumnOrder(rowIndex, columnIndex), Matchers.is(String.format("order-%s", order)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected alignment")
    public GridAssert columnOffset(int rowIndex, int columnIndex) {
        jdiAssert(element().hasColumnOffset(rowIndex, columnIndex) ? "has an offset" : "does not have an offset",
                Matchers.is("has an offset"));
        return this;
    }

    @JDIAction("Assert that '{name}' columns in a row {0} have equal widths")
    public GridAssert columnsWithEqualWidthsInRow(int rowIndex) {
        jdiAssert(element().hasColumnsWithEqualWidthInRow(rowIndex) ? "columns have equal widths" : "columns have different widths",
                Matchers.is("columns have equal widths"));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has expected parameter of its width (integer from 1 to 12)")
    public GridAssert columnsWithCustomWidth(int rowIndex, int columnIndex, int widthParameter) {
        jdiAssert(element().hasColumnsWithCustomWidth(rowIndex, columnIndex),
                Matchers.containsString(String.format("col-%s", widthParameter)));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has margin")
    public GridAssert columnWithMargin(int rowIndex, int columnIndex) {
        jdiAssert(element().hasMargin(rowIndex, columnIndex) ? "column has margin" : "column does not have margin",
                Matchers.is("column has margin"));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has expected background color")
    public GridAssert columnBackgroundColor(int rowIndex, int columnIndex, String color) {
        jdiAssert(element().getColumnBackgroundColor(rowIndex, columnIndex), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}'s row {0} has spacers")
    public GridAssert rowWithSpacers(int rowIndex) {
        jdiAssert(element().hasRowWithSpacers(rowIndex) ? "row has spacer" : "row does not have spacer",
                Matchers.is("row has spacer"));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has variable width")
    public GridAssert columnWithVariableWidth(int rowIndex, int columnIndex) {
        jdiAssert(element().hasColumnWithVariableWidth(rowIndex, columnIndex) ?
                        "column has variable width" : "column does not have variable width",
                Matchers.is("column has variable width"));
        return this;
    }
}
