package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.ProgressBar;
import com.epam.jdi.light.angular.elements.enums.ProgressBarColors;
import com.epam.jdi.light.angular.elements.enums.ProgressBarModes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressBarAssert extends UIAssert<ProgressBarAssert, ProgressBar> {

    @JDIAction(value = "Get '{name}' value '{0}'")
    public ProgressBarAssert value(Matcher<Integer> value) throws Exception {
        jdiAssert(element().value(), value);
        return this;
    }

    public ProgressBarAssert value(int value) throws Exception {
        return value(Matchers.is(value));
    }

    @JDIAction("Get '{name}' min value '{0}'")
    public ProgressBarAssert min(Matcher<Integer> condition) {
        jdiAssert(element().min(), condition);
        return this;
    }

    public ProgressBarAssert min(int minValue) {
        return min(Matchers.is(minValue));
    }

    @JDIAction("Get '{name}' max value '{0}'")
    public ProgressBarAssert max(Matcher<Integer> condition) {
        jdiAssert(element().max(), condition);
        return this;
    }

    public ProgressBarAssert max(int maxValue) {
        return max(Matchers.is(maxValue));
    }

    @JDIAction(value = "Get '{name}' mode value '{0}'")
    public ProgressBarAssert mode(Matcher<String> value) {
        jdiAssert(element().mode(), value);
        return this;
    }

    public ProgressBarAssert mode(ProgressBarModes mode) {
        return mode(Matchers.is(mode.getMode()));
    }

    @JDIAction("Assert that '{name}' does not appear during '{0}' seconds")
    public ProgressBarAssert disappear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000L)
                .wait(() -> element().isHidden());
        jdiAssert(result ? "hidden" : "displayed", Matchers.is("hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' visible on th screen")
    public ProgressBarAssert color(ProgressBarColors color) {
        return cssClass(color.getColor());
    }

    @JDIAction("Assert that '{name}' has buffer value '{0}'")
    public ProgressBarAssert bufferValue(Matcher<Double> value) throws Exception {
        jdiAssert(element().bufferValue(), value);
        return this;
    }

    public ProgressBarAssert bufferValue(Double value) throws Exception {
        return bufferValue(Matchers.is(value));
    }
}
