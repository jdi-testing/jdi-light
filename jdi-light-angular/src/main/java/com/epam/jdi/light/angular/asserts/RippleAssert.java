package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Ripple;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RippleAssert extends UIAssert<RippleAssert, Ripple> {
    @JDIAction("Assert that '{name}' displayed")
    @Override
    public RippleAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Ripple container is not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' disabled")
    @Override
    public RippleAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Ripple is not disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' unbounded")
    public RippleAssert unbounded() {
        jdiAssert(element().isUnbounded(), Matchers.is(true), "Ripple is bounded");
        return this;
    }

    @JDIAction("Assert that '{name}' centered")
    public RippleAssert centered() {
        jdiAssert(element().isCentered(), Matchers.is(true), "Ripple is not centered");
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public RippleAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Ripple is not active");
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public RippleAssert notActive() {
        jdiAssert(element().isNotActive(), Matchers.is(true), "Ripple is active");
        return this;
    }

    @JDIAction("Assert that '{name}' ripple center by coordinates x:'{0}'; y:'{1}'")
    public RippleAssert rippleCenter(final int x, final int y) {
        jdiAssert(element().isRippleCenter(x, y), Matchers.is(true),
            String.format("Ripple center coordinates are not equal %d, %d", x, y));
        return this;
    }

    @JDIAction("Assert that '{name}' radius '{0}'")
    public RippleAssert radius(final Matcher<Integer> condition) {
        jdiAssert(element().radius(), condition, "Ripple radius is not equal " + condition);
        return this;
    }

    @JDIAction("Assert that '{name}' ripple radius: '{0}'")
    public RippleAssert radius(final int radius) {
        jdiAssert(element().isRadius(radius), Matchers.is(true), "Ripple radius in not equal " + radius);
        return this;
    }

    @JDIAction("Assert that '{name}' color '{0}'")
    public RippleAssert color(final Matcher<String> condition) {
        jdiAssert(element().color(), condition, "Ripple color is not equal " + condition);
        return this;
    }

    @JDIAction("Assert that '{name}' ripple color: '{0}'")
    public RippleAssert color(final String color) {
        jdiAssert(element().isColor(color), Matchers.is(true), "Ripple color is not equal " + color);
        return this;
    }

    @JDIAction("Assert that '{name}' input color is correct")
    public RippleAssert correctColor() {
        jdiAssert(element().isCorrectColor(), Matchers.is(true), "Ripple does not have color attributes");
        return this;
    }

    @JDIAction("Assert that '{name}' input color is incorrect")
    public RippleAssert incorrectColor() {
        jdiAssert(element().isCorrectColor(), Matchers.is(false), "Ripple has color attributes");
        return this;
    }

    @JDIAction("Assert that '{name}' input radius is correct")
    public RippleAssert correctRadius() {
        jdiAssert(element().isCorrectRadius(), Matchers.is(true), "Ripple does not have radius attributes");
        return this;
    }

    @JDIAction("Assert that '{name}' input radius is incorrect")
    public RippleAssert incorrectRadius() {
        jdiAssert(element().isCorrectRadius(), Matchers.is(false), "Ripple has color attributes");
        return this;
    }
}
