package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> {

    @JDIAction(value = "Assert that '{name}' has '{0}' text", isAssert = true)
    public TooltipAssert assertTooltipText(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' color", isAssert = true)
    public TooltipAssert assertTooltipColor(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' position relative to '{1}' ", isAssert = true)
    public TooltipAssert assertTooltipPosition(Tooltip.Position position, UIBaseElement<?> e) {
        jdiAssert(element().position(e), Matchers.is(position));
        return this;
    }
}
