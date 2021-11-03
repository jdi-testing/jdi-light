package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.GridSystem;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridSystemAssert extends UIAssert<GridSystemAssert, GridSystem> {

    @JDIAction("Assert that '{name}' is displayed")
    public GridSystemAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text in in column {1}")
    public GridSystemAssert columnText(String text, int rowIndex, int columnIndex) {
        jdiAssert(element().getColumnByIndex(rowIndex, columnIndex).text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' row {0} has expected alignment")
    public GridSystemAssert rowVerticalAlignment(int rowIndex, String alignment) {
        jdiAssert(element().getRowVerticalAlignment(rowIndex), Matchers.is(String.format("align-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' row {0} has expected alignment")
    public GridSystemAssert rowHorizontalAlignment(int rowIndex, String alignment) {
        jdiAssert(element().getRowHorizontalAlignment(rowIndex), Matchers.is(String.format("justify-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected alignment")
    public GridSystemAssert columnVerticalAlignment(int rowIndex, int columnIndex, String alignment) {
        jdiAssert(element().getColumnVerticalAlignment(rowIndex, columnIndex),
                Matchers.is(String.format("align-self-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected order")
    public GridSystemAssert columnOrder(int rowIndex, int columnIndex, String order) {
        jdiAssert(element().getColumnOrder(rowIndex, columnIndex), Matchers.is(String.format("order-%s", order)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected order")
    public GridSystemAssert columnOrder(int rowIndex, int columnIndex, int order) {
        jdiAssert(element().getColumnOrder(rowIndex, columnIndex), Matchers.is(String.format("order-%s", order)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected alignment")
    public GridSystemAssert columnOffset(int rowIndex, int columnIndex) {
        jdiAssert(element().hasColumnOffset(rowIndex, columnIndex) ? "has an offset" : "does not have an offset",
                Matchers.is("has an offset"));
        return this;
    }

    @JDIAction("Assert that '{name}' columns in a row {0} have equal widths")
    public GridSystemAssert columnsWithEqualWidthsInRow(int rowIndex) {
        jdiAssert(element().hasColumnsWithEqualWidthInRow(rowIndex) ? "columns have equal widths" : "columns have different widths",
                Matchers.is("columns have equal widths"));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has expected parameter of its width (integer from 1 to 12)")
    public GridSystemAssert columnsWithCustomWidth(int rowIndex, int columnIndex, int widthParameter) {
        jdiAssert(element().hasColumnsWithCustomWidth(rowIndex, columnIndex),
                Matchers.is(String.format("col-%s", widthParameter)));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has expected parameter of its width (integer from 1 to 12)")
    public GridSystemAssert columnWithMargin(int rowIndex, int columnIndex) {
        jdiAssert(element().hasMargin(rowIndex, columnIndex) ? "column has margin" : "column does not have margin",
                Matchers.is("column has margin"));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has expected parameter of its width (integer from 1 to 12)")
    public GridSystemAssert backgroundColor(int rowIndex, int columnIndex, String color) {
        jdiAssert(element().hasBackgroundColor(rowIndex, columnIndex), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}'s column in row {0} has expected parameter of its width (integer from 1 to 12)")
    public GridSystemAssert rowWithSpacers(int rowIndex) {
        jdiAssert(element().hasRowWithSpacers(rowIndex) ? "row has spacer" : "row does not have spacer",
                Matchers.is("row has spacer"));
        return this;
    }



}
