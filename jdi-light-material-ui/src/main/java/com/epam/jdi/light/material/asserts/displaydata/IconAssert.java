package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.generic.IColorAssert;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Icon}
 */
public class IconAssert extends UIAssert<IconAssert, Icon> implements IColorAssert<IconAssert> {

    /**
     * Checks that this icon is colored.
     *
     * @return this {@link IconAssert} instance
     */
    @JDIAction("Assert that {name} is colored")
    public IconAssert colored() {
        jdiAssert(element().colored() ? "colored" : "not colored", Matchers.is("colored"));
        return this;
    }

    /**
     * Checks that this icon is not colored.
     *
     * @return this {@link IconAssert} instance
     */
    @JDIAction("Assert that {name} is not colored")
    public IconAssert notColored() {
        jdiAssert(element().colored() ? "colored" : "not colored", Matchers.is("not colored"));
        return this;
    }

    /**
     * Checks if the icon color matches the given one.
     *
     * @param condition expected icon color
     * @return this {@link IconAssert} instance
     */
    @JDIAction("Assert that {name} color {0}")
    public IconAssert color(Matcher<String> condition) {
        jdiAssert(element().color(), condition);
        return this;
    }

    /**
     * Checks if the icon height matches the given one.
     *
     * @param height expected icon height
     * @return this {@link IconAssert} instance
     */
    @JDIAction("Assert that {name} height is {0}")
    public IconAssert height(int height) {
        jdiAssert(element().getSize().getHeight(), Matchers.is(height));
        return this;
    }

    /**
     * Checks if the icon width matches the given one.
     *
     * @param width expected icon width
     * @return this {@link IconAssert} instance
     */
    @JDIAction("Assert that {name} width is {0}")
    public IconAssert width(int width) {
        jdiAssert(element().getSize().getWidth(), Matchers.is(width));
        return this;
    }
}
