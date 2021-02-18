package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.GridList;
import org.hamcrest.Matchers;

public class GridListAssert extends UIAssert<GridListAssert, GridList> {

    @JDIAction("Assert that '{name}' text equals '{0}'")
    public GridListAssert titleEquals(final int index, final String expectedText) {
        jdiAssert(element().getGridTitle(index).equals(expectedText), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text equals '{0}'")
    public GridListAssert subtitleContains(final int index, final String expectedText) {
        jdiAssert(element().getGridSubtitle(index).contains(expectedText), Matchers.is(true));
        return this;
    }
}
