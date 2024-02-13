package com.epam.jdi.light.angular.asserts.gridlist;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridTile;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridTileAssert extends UIAssert<GridTileAssert, GridTile> implements ColorAssert<GridTileAssert, GridTile> {

    @JDIAction("Assert that '{name}' has number of columns '{0}'")
    public GridTileAssert colspan(int expectedColspan) {
        jdiAssert(element().colspan(), Matchers.is(expectedColspan));
        return this;
    }

    @JDIAction("Assert that '{name}' has number of rows '{0}'")
    public GridTileAssert rowspan(int expectedRowspan) {
        jdiAssert(element().rowspan(), Matchers.is(expectedRowspan));
        return this;
    }

    @JDIAction("Assert that '{name}' has text '{0}'")
    public GridTileAssert text(String expectedText) {
        jdiAssert(element().text(), Matchers.is(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public GridTileAssert color(AngularColors expectedColor) {
        jdiAssert(element().angularColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' background color is '{0}'")
    public GridTileAssert backgroundColor(AngularColors expectedColor) {
        jdiAssert(element().angularBackgroundColor(), Matchers.is(expectedColor));
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

    @JDIAction("Assert that '{name}' header background color is '{0}'")
    public GridTileAssert headerBackgroundColor(AngularColors expectedColor) {
        jdiAssert(element().headerAngularBackgroundColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' header background color is '{0}'")
    public GridTileAssert headerBackgroundColor(String expectedColor) {
        jdiAssert(element().headerBackgroundColor(), Matchers.is(expectedColor));
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

    @JDIAction("Assert that '{name}' footer background color is '{0}'")
    public GridTileAssert footerBackgroundColor(AngularColors expectedColor) {
        jdiAssert(element().footerAngularBackgroundColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that '{name}' footer background color is '{0}'")
    public GridTileAssert footerBackgroundColor(String expectedColor) {
        jdiAssert(element().footerBackgroundColor(), Matchers.is(expectedColor));
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
}
