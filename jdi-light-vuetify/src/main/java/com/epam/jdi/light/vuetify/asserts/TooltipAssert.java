package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Tooltip;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> {

    @JDIAction(value = "Assert that '{name}' is displayed'", isAssert = true)
    public TooltipAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Tooltip is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is hidden'", isAssert = true)
    public TooltipAssert hidden() {
        jdiAssert(element().isDisplayed(), Matchers.is(false), "Tooltip is displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' text", isAssert = true)
    public TooltipAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' color is '{0}'", isAssert = true)
    public TooltipAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }
}
