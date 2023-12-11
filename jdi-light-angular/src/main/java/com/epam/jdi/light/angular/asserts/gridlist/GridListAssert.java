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

    @JDIAction("Assert that in '{name}' tile#{0} has number of columns '{1}'")
    public GridListAssert tileColspan(int tileIndex, int expectedColspan) {
        int actualNumberOfColumns = element().tileByIndex(tileIndex).getColspan();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedColspan));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has number of rows '{1}'")
    public GridListAssert tileRowspan(int tileIndex, int expectedRowspan) {
        int actualNumberOfRows = element().tileByIndex(tileIndex).getRowspan();
        jdiAssert(actualNumberOfRows, Matchers.is(expectedRowspan));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has text '{1}'")
    public GridListAssert tileText(int tileIndex, String expectedText) {
        String actualText = element().tileByIndex(tileIndex).getText();
        jdiAssert(actualText, Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has background color '{1}'")
    public GridListAssert tileColor(int tileIndex, String expectedColor) {
        String actualColor = element().tileByIndex(tileIndex).color();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has background color '{1}'")
    public GridListAssert tileColor(int tileIndex, AngularColors expectedColor) {
        AngularColors actualColor = element().tileByIndex(tileIndex).angularColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has header color '{1}'")
    public GridListAssert headerColor(int tileIndex, String expectedColor) {
        String actualColor = element().tileByIndex(tileIndex).headerColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has header color '{1}'")
    public GridListAssert headerColor(int tileIndex, AngularColors expectedColor) {
        AngularColors actualColor = element().tileByIndex(tileIndex).headerAngularColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has footer color '{1}'")
    public GridListAssert footerColor(int tileIndex, String expectedColor) {
        String actualColor = element().tileByIndex(tileIndex).footerColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has footer color '{1}'")
    public GridListAssert footerColor(int tileIndex, AngularColors expectedColor) {
        AngularColors actualColor = element().tileByIndex(tileIndex).footerAngularColor();
        jdiAssert(actualColor, Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} header text is '{1}'")
    public GridListAssert tileHeaderText(int tileIndex, String expectedText) {
        jdiAssert(element().tileByIndex(tileIndex).headerText(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} footer text is '{1}'")
    public GridListAssert tileFooterText(int tileIndex, String expectedText) {
        jdiAssert(element().tileByIndex(tileIndex).footerText(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} has avatar")
    public GridListAssert tileHasAvatar(int tileIndex) {
        jdiAssert(element().tileByIndex(tileIndex).hasAvatar(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that in '{name}' tile#{0} avatar url is {1}")
    public GridListAssert tileAvatarUrl(int tileIndex, String url) {
        jdiAssert(element().tileByIndex(tileIndex).avatarUrl(), Matchers.is(url));
        return this;
    }
}
