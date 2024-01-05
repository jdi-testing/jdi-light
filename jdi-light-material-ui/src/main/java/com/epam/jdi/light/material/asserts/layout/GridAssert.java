package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Grid;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link Grid}.
 */
public class GridAssert extends UIAssert<GridAssert, Grid> {

    /**
     * Checks that {@link Grid} contains given number of items.
     *
     * @param number expected number of items
     * @return this {@link GridAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has {0} items", isAssert = true)
    public GridAssert items(int number) {
        jdiAssert(element().items().size(), Matchers.is(number));
        return this;
    }
}
