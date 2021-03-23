package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Grid;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

public class GridAssert extends UIAssert<GridAssert, Grid> {

    @JDIAction("Assert that '{name}' has attribute '{attr}' with value '{value}'")
    public GridAssert attr(String attr, String value) {
        jdiAssert(element().hasAttr(attr, value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public GridAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }
}
