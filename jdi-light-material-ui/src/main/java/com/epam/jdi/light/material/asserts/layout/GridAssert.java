package com.epam.jdi.light.material.asserts.layout;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.Grid;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link Grid}
 */
public class GridAssert extends UISelectAssert<GridAssert, Grid> {

    /**
     * Checks that {@link Grid} contains given number of items.
     *
     * @param num expected number of items
     * @return this {@link GridAssert} instance
     */
    @JDIAction("Assert that '{name}' has {0} items")
    public GridAssert items(int num) {
        jdiAssert(element().items().size(), Matchers.is(num));
        return this;
    }
}
