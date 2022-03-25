package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Grid;
import org.hamcrest.Matchers;

public class GridAssert extends UIAssert<GridAssert, Grid> {

    @JDIAction("Assert that '{name}' has {0} items")
    public GridAssert items(int num) {
        jdiAssert(element().items().size(), Matchers.is(num));
        return this;
    }
}
