package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TooltipAssert extends UIAssert<TooltipAssert, Tooltip> {

    @JDIAction("Assert that '{name}' has '{0}' text")
    public TooltipAssert text(String text) {
        jdiAssert(element.text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' color")
    public TooltipAssert color(String color) {
        jdiAssert(element.color(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' position relative to '{1}' ")
    public TooltipAssert position(Tooltip.Position position, UIBaseElement<?> e) {
        jdiAssert(element.position(e), Matchers.is(position));
        return this;
    }
}
