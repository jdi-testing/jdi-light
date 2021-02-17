package com.epam.jdi.light.material.asserts.gridView;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.GridView.GridView;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridViewAssert extends UIAssert<GridViewAssert, GridView> {

    @JDIAction("Assert that '{name}' is enabled")
    public GridViewAssert isEnabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }
}
