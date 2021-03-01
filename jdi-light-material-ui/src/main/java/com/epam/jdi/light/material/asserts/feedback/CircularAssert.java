package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Circular;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CircularAssert extends UIAssert<CircularAssert, Circular> {

    @JDIAction(value = "Get '{name}' value '{0}'")
    public CircularAssert value(Matcher<Integer> value) throws Exception {
        jdiAssert(element().value(), value);
        return this;
    }

    public CircularAssert value(int value) throws Exception {
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CircularAssert indeterminate() {
        boolean isIndeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isIndeterminate());
        jdiAssert(isIndeterminate, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is determinate")
    public CircularAssert determinate() {
        boolean isDeterminate = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDeterminate());
        jdiAssert(isDeterminate, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is spinning")
    public CircularAssert spinning() throws Exception {
        boolean isSpinning = element().isSpinning();
        jdiAssert(isSpinning, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is shrinkDisabled")
    public CircularAssert shrinkDisabled() throws Exception {
        boolean isShrinkDisabled = element().isShrinkDisabled();
        jdiAssert(isShrinkDisabled, Matchers.is(true));
        return this;
    }
}
