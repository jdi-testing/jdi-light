package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Icon}
 */
public class IconAssert extends UIAssert<IconAssert, Icon> {

    /**
     * Checks that icon has given height.
     *
     * @param height expected icon height
     * @return this {@link IconAssert} instance
     */
    @JDIAction(value = "Assert that {name} height is {0}", isAssert = true)
    public IconAssert height(int height) {
        jdiAssert(element().getSize().getHeight(), Matchers.is(height));
        return this;
    }

    /**
     * Checks that icon has given width.
     *
     * @param width expected icon width
     * @return this {@link IconAssert} instance
     */
    @JDIAction(value = "Assert that {name} width is {0}", isAssert = true)
    public IconAssert width(int width) {
        jdiAssert(element().getSize().getWidth(), Matchers.is(width));
        return this;
    }
}
