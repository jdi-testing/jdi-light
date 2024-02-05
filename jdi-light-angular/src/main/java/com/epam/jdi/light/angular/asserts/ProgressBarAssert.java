package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.ProgressBar;
import com.epam.jdi.light.angular.elements.enums.ProgressBarColors;
import com.epam.jdi.light.angular.elements.enums.ProgressBarModes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.jdiai.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressBarAssert extends UIAssert<ProgressBarAssert, ProgressBar> {

    @JDIAction(value = "Get '{name}' value '{0}'", isAssert = true)
    public ProgressBarAssert value(Matcher<Integer> value) {
        jdiAssert(element().value(), value);
        return this;
    }

    public ProgressBarAssert value(int value) {
        return value(Matchers.is(value));
    }

    @JDIAction(value = "Get '{name}' min value '{0}'", isAssert = true)
    public ProgressBarAssert min(Matcher<Integer> condition) {
        jdiAssert(element().min(), condition);
        return this;
    }

    public ProgressBarAssert min(int minValue) {
        return min(Matchers.is(minValue));
    }

    @JDIAction(value = "Get '{name}' max value '{0}'", isAssert = true)
    public ProgressBarAssert max(Matcher<Integer> condition) {
        jdiAssert(element().max(), condition);
        return this;
    }

    public ProgressBarAssert max(int maxValue) {
        return max(Matchers.is(maxValue));
    }

    @JDIAction(value = "Get '{name}' mode value '{0}'", isAssert = true)
    public ProgressBarAssert mode(Matcher<String> value) {
        jdiAssert(element().mode(), value);
        return this;
    }

    public ProgressBarAssert mode(ProgressBarModes mode) {
        return mode(Matchers.is(mode.getMode()));
    }

    @JDIAction(value = "Assert that '{name}' does not appear during '{0}' seconds", isAssert = true)
    public ProgressBarAssert disappear(int timeoutSec) {
        boolean result = new Timer(timeoutSec * 1000L)
                .wait(() -> element().isHidden());
        jdiAssert(result ? "hidden" : "displayed", Matchers.is("hidden"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' visible on th screen", isAssert = true)
    public ProgressBarAssert color(ProgressBarColors color) {
        return cssClass(color.getColor());
    }

    @JDIAction(value = "Assert that '{name}' has buffer value '{0}'", isAssert = true)
    public ProgressBarAssert bufferValue(Matcher<Integer> value) {
        jdiAssert(element().bufferValue(), value);
        return this;
    }

    public ProgressBarAssert bufferValue(Integer value) {
        return bufferValue(Matchers.is(value));
    }
}
