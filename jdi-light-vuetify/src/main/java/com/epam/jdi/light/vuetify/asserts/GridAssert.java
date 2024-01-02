package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Grid;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridAssert extends UIAssert<GridAssert, Grid> {

    @JDIAction(value = "Assert that '{name}' is displayed")
    public GridAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Element is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}' in in column '{1}'")
    public GridAssert cellText(String text, int rowIndex, int columnIndex) {
        String actualCellText = element().getCellByIndex(rowIndex, columnIndex).text();
        jdiAssert(actualCellText, Matchers.is(text), String.format("Actual element's cell text '%s' is not equal to " +
                "expected '%s'", actualCellText, text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has vertical alignment '{1}'")
    public GridAssert rowVerticalAlignment(int rowIndex, String alignment) {
        String actualAlignment = element().getRowVerticalAlignment(rowIndex);
        String expectedAlignment = String.format("align-%s", alignment);
        jdiAssert(actualAlignment, Matchers.is(expectedAlignment), String.format("Actual element's alignment '%s' " +
                "is not equal to expected '%s'", actualAlignment, expectedAlignment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has horizontal alignment '{1}'")
    public GridAssert rowHorizontalAlignment(int rowIndex, String alignment) {
        String actualAlignment = element().getRowHorizontalAlignment(rowIndex);
        String expectedAlignment = String.format("justify-%s", alignment);
        jdiAssert(actualAlignment, Matchers.is(expectedAlignment), String.format("Actual element's alignment '%s' " +
                "is not equal to expected '%s'", actualAlignment, expectedAlignment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has vertical alignment '{2}'")
    public GridAssert cellVerticalAlignment(int rowIndex, int columnIndex, String alignment) {
        String actualAlignment = element().getCellVerticalAlignment(rowIndex, columnIndex);
        String expectedAlignment = String.format("align-self-%s", alignment);
        jdiAssert(actualAlignment, Matchers.is(expectedAlignment), String.format("Actual element's alignment '%s' is " +
                "not equal to expected '%s'", actualAlignment, expectedAlignment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has order '{2}'")
    public GridAssert cellOrder(int rowIndex, int columnIndex, String order) {
        String actualOrder = element().getCellOrder(rowIndex, columnIndex);
        String expectedOrder = String.format("order-%s", order);
        jdiAssert(actualOrder, Matchers.is(expectedOrder), String.format("Actual element's order '%s' is not equal " +
                "to expected '%s'", actualOrder, expectedOrder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has order '{2}'")
    public GridAssert cellOrder(int rowIndex, int columnIndex, int order) {
        String actualOrder = element().getCellOrder(rowIndex, columnIndex);
        String expectedOrder = String.format("order-%s", order);
        jdiAssert(actualOrder, Matchers.is(expectedOrder), String.format("Actual element's order '%s' is not equal " +
                "to expected '%s'", actualOrder, expectedOrder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has offset")
    public GridAssert cellOffset(int rowIndex, int columnIndex) {
        jdiAssert(element().hasCellOffset(rowIndex, columnIndex), Matchers.is(true), "Element's cell " +
                "has no offset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has no offset")
    public GridAssert noCellOffset(int rowIndex, int columnIndex) {
        jdiAssert(element().hasCellOffset(rowIndex, columnIndex), Matchers.is(false), "Element's cell " +
                "has an offset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cells in row '{0}' have equal width")
    public GridAssert cellWithEqualWidthsInRow(int rowIndex) {
        jdiAssert(element().hasCellsWithEqualWidthInRow(rowIndex), Matchers.is(true), "Element's cells " +
                "in row have different width");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cells in row '{0}' have different width")
    public GridAssert cellWithDifferentWidthsInRow(int rowIndex) {
        jdiAssert(element().hasCellsWithEqualWidthInRow(rowIndex), Matchers.is(false), "Element's cells " +
                "in row have equal width");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has width '{2}' - integer from 1 to 12")
    public GridAssert cellWithCustomWidth(int rowIndex, int columnIndex, int widthParameter) {
        jdiAssert(element().hasCellWithCustomWidth(rowIndex, columnIndex),
                Matchers.containsString(String.format("col-%s", widthParameter)), String.format("Element's column " +
                        "width parameter is not '%s'", widthParameter));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has margin")
    public GridAssert cellWithMargin(int rowIndex, int columnIndex) {
        jdiAssert(element().hasMargin(rowIndex, columnIndex), Matchers.is(true), String.format("Element's cell " +
                "at row '%s' column '%s' has no margin", rowIndex, columnIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has no margin")
    public GridAssert cellWithoutMargin(int rowIndex, int columnIndex) {
        jdiAssert(element().hasMargin(rowIndex, columnIndex), Matchers.is(false), String.format("Element's cell " +
                "at row '%s' column '%s' has margin", rowIndex, columnIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell in row '{0}' column '{1}' has background color '{2}'")
    public GridAssert cellBackgroundColor(int rowIndex, int columnIndex, String color) {
        String actualCellBackgroundColor = element().getCellBackgroundColor(rowIndex, columnIndex);
        jdiAssert(actualCellBackgroundColor, Matchers.is(color), String.format("Actual element's cell background " +
                "color '%s' is not equal to expected '%s'", actualCellBackgroundColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell in row '{0}' column '{1}' has font color '{2}'")
    public GridAssert cellFontColor(int rowIndex, int columnIndex, String color) {
        String actualCellFontColor = element().getCellFontColor(rowIndex, columnIndex);
        jdiAssert(actualCellFontColor, Matchers.is(color), String.format("Actual element's cell font color '%s' is " +
                "not equal to expected '%s'", actualCellFontColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has spacers")
    public GridAssert rowWithSpacers(int rowIndex) {
        jdiAssert(element().hasRowWithSpacers(rowIndex), Matchers.is(true), "Element has no spacers");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has no spacers")
    public GridAssert rowWithoutSpacers(int rowIndex) {
        jdiAssert(element().hasRowWithSpacers(rowIndex), Matchers.is(false), "Element has spacers");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' is auto-width")
    public GridAssert cellWithAutoWidth(int rowIndex, int columnIndex) {
        jdiAssert(element().hasCellWithAutoWidth(rowIndex, columnIndex), Matchers.is(true), String.format(
                "Element's cell at row '%s' column '%s' is not auto-width", rowIndex, columnIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fluid")
    public GridAssert fluid() {
        jdiAssert(element().isFluid(), Matchers.is(true), "Element is not fluid");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not fluid")
    public GridAssert notFluid() {
        jdiAssert(element().isFluid(), Matchers.is(false), "Element is fluid");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' is no-gutters")
    public GridAssert noGuttersRow(int rowIndex) {
        jdiAssert(element().hasNoGuttersRow(rowIndex), Matchers.is(true), String.format("Element's row '%s' is " +
                "not no-gutters", rowIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' is not no-gutters")
    public GridAssert notNoGuttersRow(int rowIndex) {
        jdiAssert(element().hasNoGuttersRow(rowIndex), Matchers.is(false), String.format("Element's row '%s' is " +
                "no-gutters", rowIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row is dense")
    public GridAssert dense(int rowIndex) {
        jdiAssert(element().isDense(rowIndex), Matchers.is(true), String.format("Element's row '%s' is not dense",
                rowIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row is not dense")
    public GridAssert notDense(int rowIndex) {
        jdiAssert(element().isDense(rowIndex), Matchers.is(false), String.format("Element's row '%s' is dense",
                rowIndex));
        return this;
    }
}
