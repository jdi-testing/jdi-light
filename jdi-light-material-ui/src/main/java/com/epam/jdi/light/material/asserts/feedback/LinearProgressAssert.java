package com.epam.jdi.light.material.asserts.feedback;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;
import org.hamcrest.Matchers;

public class LinearProgressAssert extends ProgressAssert<LinearProgressAssert, LinearProgress> {

    @JDIAction("Assert that '{name}' first bar has color '{0}'")
    public LinearProgressAssert firstBarColor(String firstBarColor) {
        jdiAssert(element().firstBarColor(), Matchers.is(firstBarColor));
        return this;
    }

    @JDIAction("Assert that '{name}' second bar has color '{0}'")
    public LinearProgressAssert secondBarColor(String secondBarColor) {
        jdiAssert(element().secondBarColor(), Matchers.is(secondBarColor));
        return this;
    }

    @JDIAction("Assert that '{name}' is buffer")
    public LinearProgressAssert buffer() {
        jdiAssert(element().isBuffer() ? "is buffer" : "is not buffer",
                Matchers.is("is buffer"));
        return this;
    }
}
