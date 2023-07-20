package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Badge;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> {

    @JDIAction("Assert that '{name}' has '{0}' color")
    public BadgeAssert color(String value) {
        jdiAssert(element().color(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' size")
    public BadgeAssert size(String value) {
        jdiAssert(element().size(value), Matchers.is(true));
        return this;

    }

    @JDIAction("Assert that '{name}' has '{0}' position (vertical)")
    public BadgeAssert positionVertical(String value) {
        jdiAssert(element().positionVertical(value), Matchers.is(true));
        return this;

    }

    @JDIAction("Assert that '{name}' has '{0}' position (horizontal)")
    public BadgeAssert positionHorizontal(String value) {
        jdiAssert(element().positionHorizontal(value), Matchers.is(true));
        return this;

    }

    @JDIAction("Assert that '{name}' is overlap: {0}")
    public BadgeAssert overlap(boolean value) {
        jdiAssert(element().overlap(), Matchers.is(value));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public BadgeAssert displayed() {
        jdiAssert(element().hidden(), Matchers.is(false));
        return super.displayed();
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public BadgeAssert hidden() {
        jdiAssert(element().hidden(), Matchers.is(true));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public BadgeAssert enabled() {
        jdiAssert(element().disabled(), Matchers.is(false));
        return super.enabled();
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public BadgeAssert disabled() {
        jdiAssert(element().disabled(), Matchers.is(true));
        return this;
    }
}
