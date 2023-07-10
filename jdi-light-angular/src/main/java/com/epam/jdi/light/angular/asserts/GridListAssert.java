package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.GridList;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' is displayed")
    public GridListAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Element is not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridListAssert numberOfColumns(String expectedNumberOfColumns) {
        String actualNumberOfColumns = element().getNumberOfColumnsInGridList();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns),
            String.format("Actual number of columns in element '%s' " +
                "is not equal to expected '%s'", actualNumberOfColumns, expectedNumberOfColumns));
        return this;
    }

    @JDIAction("Assert that '{name}' has row's height '{0}'")
    public GridListAssert rowHeight(String expectedRowHeight) {
        String actualRowHeight = element().getRowHeight();
        jdiAssert(actualRowHeight, Matchers.is(expectedRowHeight),
            String.format("Actual element's row height '%s' " +
                "is not equal to expected '%s'", actualRowHeight, expectedRowHeight));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has text '{1}'")
    public GridListAssert cellText(int cellIndex, String ExpectedText) {
        String actualText = element().getCellByIndex(cellIndex).text();
        jdiAssert(actualText, Matchers.is(ExpectedText),
            String.format("Actual element's cell text '%s' " +
                "is not equal to expected '%s'", actualText, ExpectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has background color '{1}'")
    public GridListAssert cellBackgroundColor(int cellIndex, String expectedColor) {
        String actualColor = element().getCellBackgroundColor(cellIndex);
        jdiAssert(actualColor, Matchers.is(expectedColor),
            String.format("Actual element's cell background color '%s' " +
                "is not equal to expected '%s'", actualColor, expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has number of columns '{1}'")
    public GridListAssert numberOfColumnsInCell(int cellIndex, String expectedNumberOfColumns) {
        String actualNumberOfColumns = element().getAmountOfColumnsInCell(cellIndex);
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedNumberOfColumns),
            String.format("Actual number of columns in element's cell '%s' " +
                "is not equal to expected '%s'", actualNumberOfColumns, expectedNumberOfColumns));
        return this;
    }

    @JDIAction("Assert that '{name}' cell has number of rows '{1}'")
    public GridListAssert numberOfRowsInCell(int cellIndex, String expectedNumberOfRows) {
        String actualNumberOfRows = element().getAmountOfRowsInCell(cellIndex);
        jdiAssert(actualNumberOfRows, Matchers.is(expectedNumberOfRows),
            String.format("Actual number of rows in element's cell '%s' " +
                "is not equal to expected '%s'", actualNumberOfRows, expectedNumberOfRows));
        return this;
    }
}
