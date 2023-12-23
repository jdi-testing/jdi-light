package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Tooltip;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> {

    @JDIAction("Assert that '{name}' is displayed'")
    public TooltipAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Tooltip is not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' is hidden'")
    public TooltipAssert hidden() {
        Timer.waitCondition(() -> !element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(false), "Tooltip is displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' text")
    public TooltipAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' color is '{0}'")
    public TooltipAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }
}
