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

    @JDIAction("Assert that '{name}' has text '{1}'")
    public GridListAssert tileText(int tileIndex, String ExpectedText) {
        String actualText = element().tileByIndex(tileIndex).text();
        jdiAssert(actualText, Matchers.is(ExpectedText), String.format("Actual element's tile text '%s' " +
                "is not equal to expected '%s'", actualText, ExpectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' tile has background color '{1}'")
    public GridListAssert tileBackgroundColor(int tileIndex, String expectedColor) {
        String actualTileBackgroundColor = element().tileBackgroundColor(tileIndex);
        jdiAssert(actualTileBackgroundColor, Matchers.is(expectedColor),
            String.format("Actual element's tile background color '%s'" +
                "is not equal to expected '%s'", actualTileBackgroundColor, expectedColor));
        return this;
    }
}
