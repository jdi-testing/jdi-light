package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Grid;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridAssert extends UIAssert<GridAssert, Grid> {

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public GridAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Grid is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}' in in column '{1}'", isAssert = true)
    public GridAssert cellText(String text, int rowIndex, int columnIndex) {
        jdiAssert(element().getCellByIndex(rowIndex, columnIndex).text(), Matchers.is(text));
        return this;
    }

    // @todo Check this method validation: expected value must be from the parameter without any changes
    @JDIAction(value = "Assert that '{name}' row '{0}' has vertical alignment '{1}'", isAssert = true)
    public GridAssert rowVerticalAlignment(int rowIndex, String alignment) {
        String expectedAlignment = String.format("align-%s", alignment);
        jdiAssert(element().getRowVerticalAlignment(rowIndex), Matchers.is(expectedAlignment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has horizontal alignment '{1}'", isAssert = true)
    public GridAssert rowHorizontalAlignment(int rowIndex, String alignment) {
        String expectedAlignment = String.format("justify-%s", alignment);
        jdiAssert(element().getRowHorizontalAlignment(rowIndex), Matchers.is(expectedAlignment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has vertical alignment '{2}'", isAssert = true)
    public GridAssert cellVerticalAlignment(int rowIndex, int columnIndex, String alignment) {
        String expectedAlignment = String.format("align-self-%s", alignment);
        jdiAssert(element().getCellVerticalAlignment(rowIndex, columnIndex), Matchers.is(expectedAlignment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has order '{2}'", isAssert = true)
    public GridAssert cellOrder(int rowIndex, int columnIndex, String order) {
        String expectedOrder = String.format("order-%s", order);
        jdiAssert(element().getCellOrder(rowIndex, columnIndex), Matchers.is(expectedOrder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has order '{2}'", isAssert = true)
    public GridAssert cellOrder(int rowIndex, int columnIndex, int order) {
        String expectedOrder = String.format("order-%s", order);
        jdiAssert(element().getCellOrder(rowIndex, columnIndex), Matchers.is(expectedOrder));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has offset", isAssert = true)
    public GridAssert cellOffset(int rowIndex, int columnIndex) {
        jdiAssert(element().hasCellOffset(rowIndex, columnIndex), Matchers.is(true),
                "Grid's cell has no offset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has no offset", isAssert = true)
    public GridAssert noCellOffset(int rowIndex, int columnIndex) {
        jdiAssert(element().hasCellOffset(rowIndex, columnIndex), Matchers.is(false),
                "Grid's cell has an offset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cells in row '{0}' have equal width", isAssert = true)
    public GridAssert cellWithEqualWidthsInRow(int rowIndex) {
        jdiAssert(element().hasCellsWithEqualWidthInRow(rowIndex), Matchers.is(true),
                "Grid's cells in row have different width");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cells in row '{0}' have different width", isAssert = true)
    public GridAssert cellWithDifferentWidthsInRow(int rowIndex) {
        jdiAssert(element().hasCellsWithEqualWidthInRow(rowIndex), Matchers.is(false),
                "Grid's cells in row have equal width");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has width '{2}' - integer from 1 to 12", isAssert = true)
    public GridAssert cellWithCustomWidth(int rowIndex, int columnIndex, int widthParameter) {
        jdiAssert(element().hasCellWithCustomWidth(rowIndex, columnIndex),
                Matchers.containsString(String.format("col-%s", widthParameter)));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has margin", isAssert = true)
    public GridAssert cellWithMargin(int rowIndex, int columnIndex) {
        jdiAssert(element().hasMargin(rowIndex, columnIndex), Matchers.is(true),
                String.format("Grid's cell at row '%s' column '%s' has no margin", rowIndex, columnIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' has no margin", isAssert = true)
    public GridAssert cellWithoutMargin(int rowIndex, int columnIndex) {
        jdiAssert(element().hasMargin(rowIndex, columnIndex), Matchers.is(false),
                String.format("Grid's cell at row '%s' column '%s' has margin", rowIndex, columnIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell in row '{0}' column '{1}' has background color '{2}'", isAssert = true)
    public GridAssert cellBackgroundColor(int rowIndex, int columnIndex, String color) {
        String actualCellBackgroundColor = element().getCellBackgroundColor(rowIndex, columnIndex);
        jdiAssert(element().getCellBackgroundColor(rowIndex, columnIndex), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell in row '{0}' column '{1}' has font color '{2}'", isAssert = true)
    public GridAssert cellFontColor(int rowIndex, int columnIndex, String color) {
        jdiAssert(element().getCellFontColor(rowIndex, columnIndex), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has spacers", isAssert = true)
    public GridAssert rowWithSpacers(int rowIndex) {
        jdiAssert(element().hasRowWithSpacers(rowIndex), Matchers.is(true), "Grid has no spacers");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' has no spacers", isAssert = true)
    public GridAssert rowWithoutSpacers(int rowIndex) {
        jdiAssert(element().hasRowWithSpacers(rowIndex), Matchers.is(false), "Grid has spacers");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' cell at row '{0}' column '{1}' is auto-width", isAssert = true)
    public GridAssert cellWithAutoWidth(int rowIndex, int columnIndex) {
        jdiAssert(element().hasCellWithAutoWidth(rowIndex, columnIndex), Matchers.is(true),
                String.format("Grid's cell at row '%s' column '%s' is not auto-width", rowIndex, columnIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fluid", isAssert = true)
    public GridAssert fluid() {
        jdiAssert(element().isFluid(), Matchers.is(true), "Grid is not fluid");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not fluid", isAssert = true)
    public GridAssert notFluid() {
        jdiAssert(element().isFluid(), Matchers.is(false), "Grid is fluid");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' is no-gutters", isAssert = true)
    public GridAssert noGuttersRow(int rowIndex) {
        jdiAssert(element().hasNoGuttersRow(rowIndex), Matchers.is(true),
                String.format("Grid's row '%s' is not no-gutters", rowIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row '{0}' is not no-gutters", isAssert = true)
    public GridAssert notNoGuttersRow(int rowIndex) {
        jdiAssert(element().hasNoGuttersRow(rowIndex), Matchers.is(false),
                String.format("Grid's row '%s' is no-gutters", rowIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row is dense", isAssert = true)
    public GridAssert dense(int rowIndex) {
        jdiAssert(element().isDense(rowIndex), Matchers.is(true),
                String.format("Grid's row '%s' is not dense", rowIndex));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' row is not dense", isAssert = true)
    public GridAssert notDense(int rowIndex) {
        jdiAssert(element().isDense(rowIndex), Matchers.is(false),
                String.format("Grid's row '%s' is dense", rowIndex));
        return this;
    }
}
