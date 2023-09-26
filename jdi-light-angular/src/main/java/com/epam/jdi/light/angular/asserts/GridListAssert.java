package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.GridList;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridListAssert numberOfColumnsInGridList(String expectedNumberOfColumns) {
        String actualNumberOfColumns = element().numberOfColumnsInGridList();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns),
            String.format("\nActual number of columns in Grid List: '%s'\n" +
                "is not equal to expected: '%s'", actualNumberOfColumns, expectedNumberOfColumns));
        return this;
    }

    @JDIAction("Assert that '{name}' has row's height '{0}'")
    public GridListAssert rowHeight(String expectedRowHeight) {
        String actualRowHeight = element().rowHeight();
        jdiAssert(actualRowHeight, Matchers.is(expectedRowHeight),
            String.format("\nActual row height: '%s'\n" +
                "is not equal to expected: '%s'", actualRowHeight, expectedRowHeight));
        return this;
    }

    @JDIAction("Assert that '{name}' has gutter size '{0}'")
    public GridListAssert gutterSize(String expectedGutterSize) {
        String actualGutterSize = element().gutterSize();
        jdiAssert(actualGutterSize, Matchers.is(expectedGutterSize),
            String.format("\nActual gutter size: '%s'\n" +
                "is not equal to expected: '%s'", actualGutterSize, expectedGutterSize));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has text '{1}'")
    public GridListAssert cellText(int cellIndex, String ExpectedText) {
        String actualText = element().cellByIndex(cellIndex).text();
        jdiAssert(actualText, Matchers.is(ExpectedText),
            String.format("\nActual cell's text: '%s'\n" +
                "is not equal to expected: '%s'", actualText, ExpectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has background color '{1}'")
    public GridListAssert cellBackgroundColor(int cellIndex, String expectedColor) {
        String actualColor = element().cellBackgroundColorByIndex(cellIndex);
        jdiAssert(actualColor, Matchers.is(expectedColor),
            String.format("\nActual cell's background color: '%s'\n" +
                "is not equal to expected: '%s'", actualColor, expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has number of columns '{1}'")
    public GridListAssert numberOfColumnsInCell(int cellIndex, String expectedNumberOfColumns) {
        String actualNumberOfColumns = element().numberOfColumnsInCellByIndex(cellIndex);
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns),
            String.format("\nActual number of columns in cell: '%s'\n" +
                "is not equal to expected: '%s'", actualNumberOfColumns, expectedNumberOfColumns));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has number of rows '{1}'")
    public GridListAssert numberOfRowsInCell(int cellIndex, String expectedNumberOfRows) {
        String actualNumberOfRows = element().numberOfRowsInCellByIndex(cellIndex);
        jdiAssert(actualNumberOfRows, Matchers.is(expectedNumberOfRows),
            String.format("\nActual number of rows in cell: '%s'\n" +
                "is not equal to expected: '%s'", actualNumberOfRows, expectedNumberOfRows));
        return this;
    }
}
