package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class IconAssert extends UIAssert<IconAssert, Icon> {
    @JDIAction("Assert that {name} is colored")
    public IconAssert colored() {
        jdiAssert(element().colored() ? "colored" : "not colored", Matchers.is("colored"));
        return this;
    }

    @JDIAction("Assert that {name} is not colored")
    public IconAssert notColored() {
        jdiAssert(element().colored() ? "colored" : "not colored", Matchers.is("not colored"));
        return this;
    }

    /**
     * String color example: "rgba(0, 0, 0, 0.54)"
     */
    @JDIAction("Assert that {name} color is {0}")
    public IconAssert color(String color) {
        jdiAssert(element().getColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that {name} height is {0}")
    public IconAssert height(int height) {
        jdiAssert(element().getSize().getHeight(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that {name} width is {0}")
    public IconAssert width(int width) {
        jdiAssert(element().getSize().getWidth(), Matchers.is(width));
        return this;
    }
}
