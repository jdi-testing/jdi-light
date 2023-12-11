package com.epam.jdi.light.angular.asserts.gridlist;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridList;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridListAssert cols(int expectedCols) {
        int actualNumberOfColumns = element().сols();
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

    @JDIAction("Assert that '{name}' cell#{0} has number of columns '{1}'")
    public GridListAssert cellColspan(int cellIndex, int expectedColspan) {
        int actualNumberOfColumns = element().cellByIndex(cellIndex).getColspan();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedColspan));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has number of rows '{1}'")
    public GridListAssert cellRowspan(int cellIndex, int expectedRowspan) {
        int actualNumberOfRows = element().cellByIndex(cellIndex).getRowspan();
        jdiAssert(actualNumberOfRows, Matchers.is(expectedRowspan));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has text '{1}'")
    public GridListAssert cellText(int cellIndex, String expectedText) {
        String actualText = element().cellByIndex(cellIndex).getText();
        jdiAssert(actualText, Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has background color '{1}'")
    public GridListAssert cellColor(int cellIndex, String expectedColor) {
        String actualColor = element().cellByIndex(cellIndex).color();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has background color '{1}'")
    public GridListAssert cellColor(int cellIndex, AngularColors expectedColor) {
        AngularColors actualColor = element().cellByIndex(cellIndex).angularColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has header color '{1}'")
    public GridListAssert headerColor(int cellIndex, String expectedColor) {
        String actualColor = element().cellByIndex(cellIndex).headerColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has header color '{1}'")
    public GridListAssert headerColor(int cellIndex, AngularColors expectedColor) {
        AngularColors actualColor = element().cellByIndex(cellIndex).headerAngularColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has footer color '{1}'")
    public GridListAssert footerColor(int cellIndex, String expectedColor) {
        String actualColor = element().cellByIndex(cellIndex).footerColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has footer color '{1}'")
    public GridListAssert footerColor(int cellIndex, AngularColors expectedColor) {
        AngularColors actualColor = element().cellByIndex(cellIndex).footerAngularColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} header text is '{1}'")
    public GridListAssert cellHeaderText(int cellIndex, String expectedText) {
        jdiAssert(element().cellByIndex(cellIndex).headerText(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} footer text is '{1}'")
    public GridListAssert cellFooterText(int cellIndex, String expectedText) {
        jdiAssert(element().cellByIndex(cellIndex).footerText(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} has avatar")
    public GridListAssert cellHasAvatar(int cellIndex) {
        jdiAssert(element().cellByIndex(cellIndex).hasAvatar(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' cell#{0} avatar url is {1}")
    public GridListAssert cellAvatarUrl(int cellIndex, String url) {
        jdiAssert(element().cellByIndex(cellIndex).avatarUrl(), Matchers.is(url));
        return this;
    }
}
