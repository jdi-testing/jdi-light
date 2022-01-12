package com.epam.jdi.light.material.asserts.feedback;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.progress.Progress;
import com.jdiai.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class ProgressAssert<A extends ProgressAssert<?, ?>, E extends Progress<?>>
        extends UIAssert<A, E> {

    @JDIAction("Assert that '{name}' is indeterminate")
    public A indeterminate() {
        boolean isIndeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isIndeterminate());
        jdiAssert(isIndeterminate, Matchers.is(true));
        return (A) this;
    }

    @Override
    public E element() {
        return super.element();
    }

    @JDIAction("Assert that '{name}' is determinate")
    public A determinate() {
        boolean isDeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDeterminate());
        jdiAssert(isDeterminate, Matchers.is(true));
        return (A) this;
    }

    public A value(int value) {
        jdiAssert(element().getValueNow(), Matchers.is(value));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' value {0}")
    public A value(Matcher<Integer> condition) {
        jdiAssert(element().getValueNow(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' min value is {0}")
    public A min(int minValue) {
        jdiAssert(element().minValue(), Matchers.is(minValue));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' max value is {0}")
    public A max(int maxValue) {
        jdiAssert(element().maxValue(), Matchers.is(maxValue));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has primary color")
    public A primaryColor() {
        jdiAssert(element().hasPrimaryColor() ? "has primary color" : "does not have primary color",
                Matchers.is("has primary color"));
        element().has().color("rgba(63, 81, 181, 1)");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has color {0}")
    public A color(String color) {
        jdiAssert(element().getColor(), Matchers.is(color));
        return (A) this;
    }
}
