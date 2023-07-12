package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.GridList;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}''s number of columns is '{0}'")
    public GridListAssert numberOfColumns(String expectedNumberOfColumns) {
        String actualNumberOfColumns = element().numberOfColumns();
        jdiAssert(actualNumberOfColumns, Matchers.equalTo(expectedNumberOfColumns),
            actualNumberOfColumns + "is not equal to" + expectedNumberOfColumns);
        return this;
    }

    @JDIAction("Assert that '{name}' has row's height '{0}'")
    public GridListAssert rowHeight(String expectedRowHeight) {
        String actualRowHeight = element().rowHeight();
        jdiAssert(actualRowHeight, Matchers.is(expectedRowHeight),
            actualRowHeight + "is not equal to" + expectedRowHeight);
        return this;
    }

    @JDIAction("Assert that '{name}' cell has text '{1}'")
    public GridListAssert cellText(int cellIndex, String ExpectedText) {
        String actualText = element().cellByIndex(cellIndex).text();
        jdiAssert(actualText, Matchers.is(ExpectedText),
            actualText + "is not equal to" + ExpectedText);
        return this;
    }

    @JDIAction("Assert that '{name}' cell has background color '{1}'")
    public GridListAssert cellBackgroundColor(int cellIndex, String expectedColor) {
        String actualColor = element().cellBackgroundColorByIndex(cellIndex);
        jdiAssert(actualColor, Matchers.is(expectedColor),
            actualColor + "is not equal to" + expectedColor);
        return this;
    }

    @JDIAction("Assert that '{name}' cell's number of columns is '{1}'")
    public GridListAssert numberOfColumnsInCell(int cellIndex, String expectedNumberOfColumns) {
        String actualNumberOfColumns = element().numberOfColumnsInCellByIndex(cellIndex);
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns),
            actualNumberOfColumns + "is not equal to" + expectedNumberOfColumns);
        return this;
    }

    @JDIAction("Assert that '{name}' cell's number of rows is '{1}'")
    public GridListAssert numberOfRowsInCell(int cellIndex, String expectedNumberOfRows) {
        String actualNumberOfRows = element().numberOfRowsInCellByIndex(cellIndex);
        jdiAssert(actualNumberOfRows, Matchers.is(expectedNumberOfRows),
            actualNumberOfRows + "is not equal to" + expectedNumberOfRows);
        return this;
    }
}
