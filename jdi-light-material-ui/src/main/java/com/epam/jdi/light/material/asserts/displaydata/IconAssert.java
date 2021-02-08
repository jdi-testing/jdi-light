package com.epam.jdi.light.material.asserts.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import org.hamcrest.Matchers;

public class IconAssert extends UIAssert<IconAssert, Icon> {

    @JDIAction("Assert that '{name}' is visible")
    @Override
    public IconAssert visible() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is large")
    public IconAssert largeSize() {
        jdiAssert(element().isLarge(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is inherit")
    public IconAssert inheritSize() {
        jdiAssert(element().isInherit(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is small")
    public IconAssert smallSize() {
        jdiAssert(element().isSmall(), Matchers.is(true));
        return this;
    }
}
