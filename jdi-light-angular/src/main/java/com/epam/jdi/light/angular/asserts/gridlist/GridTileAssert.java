package com.epam.jdi.light.angular.asserts.gridlist;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridTile;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridTileAssert extends UIAssert<GridTileAssert, GridTile> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridTileAssert colspan(int expectedColspan) {
        int actualNumberOfColumns = element().getColspan();
        jdiAssert(actualNumberOfColumns, Matchers.is(expectedColspan));
        return this;
    }

    @JDIAction("Assert that '{name}' has number of rows '{0}'")
    public GridTileAssert rowspan(int expectedRowspan) {
        int actualNumberOfRows = element().getRowspan();
        jdiAssert(actualNumberOfRows, Matchers.is(expectedRowspan));
        return this;
    }

    @JDIAction("Assert that '{name}' has text '{0}'")
    public GridTileAssert text(String expectedText) {
        String actualText = element().getText();
        jdiAssert(actualText, Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public GridTileAssert color(AngularColors expectedColor) {
        jdiAssert(element().angularColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public GridTileAssert color(String expectedColor) {
        jdiAssert(element().color(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' header color is '{0}'")
    public GridTileAssert headerColor(AngularColors expectedColor) {
        jdiAssert(element().headerAngularColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' header color is '{0}'")
    public GridTileAssert headerColor(String expectedColor) {
        jdiAssert(element().headerColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' footer color is '{0}'")
    public GridTileAssert footerColor(AngularColors expectedColor) {
        jdiAssert(element().footerAngularColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' footer color is '{0}'")
    public GridTileAssert footerColor(String expectedColor) {
        jdiAssert(element().footerColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' header text is '{0}'")
    public GridTileAssert headerText(String expectedText) {
        jdiAssert(element().headerText(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' footer text is '{0}'")
    public GridTileAssert footerText(String expectedText) {
        jdiAssert(element().footerText(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' has avatar")
    public GridTileAssert hasAvatar() {
        jdiAssert(element().hasAvatar(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' avatar url is {0}")
    public GridTileAssert avatarUrl(String url) {
        jdiAssert(element().avatarUrl(), Matchers.is(url));
        return this;
    }
}
