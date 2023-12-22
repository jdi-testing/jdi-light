package com.epam.jdi.light.angular.asserts.gridlist;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridList;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridListAssert cols(int expectedCols) {
        int actualNumberOfColumns = element().cols();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedCols),
            String.format("\nActual number of columns in Grid List: '%s'\n" +
                "is not equal to expected: '%s'", actualNumberOfColumns, expectedCols));
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
}
