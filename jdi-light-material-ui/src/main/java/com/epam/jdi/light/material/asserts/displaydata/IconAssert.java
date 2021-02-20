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

    @JDIAction("Assert that '{name}' has correct size")
    public IconAssert checkSize(String size) {
        jdiAssert(element().isSize(size), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has correct color")
    public IconAssert checkColor(String color) {
        jdiAssert(element().isColor(color), Matchers.is(true));
        return this;
    }
}
