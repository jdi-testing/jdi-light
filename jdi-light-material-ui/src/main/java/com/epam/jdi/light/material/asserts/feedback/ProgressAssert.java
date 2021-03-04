package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressAssert extends UIAssert<ProgressAssert, ProgressBar> {

    @JDIAction(value = "Get '{name}' value '{0}'")
    public ProgressAssert value(Matcher<Integer> value) throws Exception {
        jdiAssert(element().value(), value);
        return this;
    }

    public ProgressAssert value(int value) throws Exception {
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public ProgressAssert indeterminate() {
        boolean isIndeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isIndeterminate());
        jdiAssert(isIndeterminate, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is determinate")
    public ProgressAssert determinate() {
        boolean isDeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDeterminate());
        jdiAssert(isDeterminate, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is in progress")
    public ProgressAssert inProgress() throws Exception {
        boolean inProgress = element().inProgress();
        jdiAssert(inProgress, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is shrinkDisabled")
    public ProgressAssert shrinkDisabled() throws Exception {
        boolean isShrinkDisabled = element().isShrinkDisabled();
        jdiAssert(isShrinkDisabled, Matchers.is(true));
        return this;
    }

    @JDIAction(value = "Get '{name}' min value {0}")
    public ProgressAssert min(Matcher<Integer> condition) {
        jdiAssert(element().min(), condition);
        return this;
    }

    public ProgressAssert min(int minValue) {
        return min(Matchers.is(minValue));
    }

    @JDIAction(value = "Get '{name}' max value {0}")
    public ProgressAssert max(Matcher<Integer> condition) {
        jdiAssert(element().max(), condition);
        return this;
    }

    public ProgressAssert max(int maxValue) {
        return max(Matchers.is(maxValue));
    }

    @JDIAction("Assert that '{name}' has correct color")
    public ProgressAssert color(String color) {
        jdiAssert(element().color(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has correct colors")
    public ProgressAssert color(String bar1Color, String bar2Color) {
        jdiAssert(element().bufferColors(bar1Color, bar2Color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is buffer")
    public ProgressAssert buffer() {
        jdiAssert(element().isBuffer(), Matchers.is(true));
        return this;
    }
}
