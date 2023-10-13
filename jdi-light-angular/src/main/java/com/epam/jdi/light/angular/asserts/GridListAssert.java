package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.GridList;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridListAssert numberOfColumns(int expectedNumberOfColumns) {
        int actualNumberOfColumns = element().numberOfColumns();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns),
            String.format("\nActual number of columns in Grid List: '%s'\n" +
                "is not equal to expected: '%s'", actualNumberOfColumns, expectedNumberOfColumns));
        return this;
    }

    @JDIAction("Assert that '{name}' has row's height '{0}'")
    public GridListAssert rowHeight(String expectedRowHeight) {
        String actualRowHeight = element().rowHeight();
        jdiAssert(actualRowHeight, Matchers.is(expectedRowHeight));
        return this;
    }

    @JDIAction("Assert that '{name}' has gutter size '{0}'")
    public GridListAssert gutterSize(String expectedGutterSize) {
        String actualGutterSize = element().gutterSize();
        jdiAssert(actualGutterSize, Matchers.is(expectedGutterSize));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has text '{1}'")
    public GridListAssert cellText(int cellIndex, String expectedText) {
        String actualText = element().cellByIndex(cellIndex).text();
        jdiAssert(actualText, Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has background color '{1}'")
    public GridListAssert cellBackgroundColor(int cellIndex, String expectedColor) {
        String actualColor = element().cellBackgroundColorByIndex(cellIndex);
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has number of columns '{1}'")
    public GridListAssert numberOfColumnsInCell(int cellIndex, int expectedNumberOfColumns) {
        int actualNumberOfColumns = element().numberOfColumnsInCellByIndex(cellIndex);
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has number of rows '{1}'")
    public GridListAssert numberOfRowsInCell(int cellIndex, int expectedNumberOfRows) {
        int actualNumberOfRows = element().numberOfRowsInCellByIndex(cellIndex);
        jdiAssert(actualNumberOfRows, Matchers.is(expectedNumberOfRows));
        return this;
    }
}
