package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressBarAssert extends UIAssert<ProgressBarAssert, ProgressLinear> {

    @JDIAction("Assert that '{name}' is displayed")
    public ProgressBarAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public ProgressBarAssert indeterminate() {
        jdiAssert(element().isIndeterminate() ? "is indeterminate" : "is not indeterminate",
                Matchers.is("is indeterminate"));
        return this;
    }

    @JDIAction("Assert that '{name}' is determinate")
    public ProgressBarAssert determinate() {
        jdiAssert(element().isDeterminate() ? "is determinate" : "is not determinate",
                Matchers.is("is determinate"));
        return this;
    }

    @JDIAction("Assert that '{name}' is reactive")
    public ProgressBarAssert reactive() {
        jdiAssert(element().isReactive() ? "is reactive" : "is not reactive",
                Matchers.is("is reactive"));
        return this;
    }

    @JDIAction("Assert that '{name}' is rounded")
    public ProgressBarAssert rounded() {
        jdiAssert(element().isRounded() ? "is rounded" : "is not rounded",
                Matchers.is("is rounded"));
        return this;
    }

    @JDIAction("Assert that '{name}' is striped")
    public ProgressBarAssert striped() {
        jdiAssert(element().isStriped() ? "is striped" : "is not striped",
                Matchers.is("is striped"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public ProgressBarAssert color(String color) {
        jdiAssert(element().hasColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected bar color")
    public ProgressBarAssert barColor(String barColor) {
        jdiAssert(element().hasBarColor(), Matchers.is(barColor));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected value")
    public ProgressBarAssert value(Double value) {
        boolean hasExpectedValue = Math.abs((element().hasValue()) - value) < 0.5;
        Timer.waitCondition(() -> hasExpectedValue);
        if(!hasExpectedValue) {
            element().click();
        }
        jdiAssert(element().hasValue(), Matchers.closeTo(value, 0.5));
        return this;
    }

    @JDIAction("Assert that '{name}' has stream")
    public ProgressBarAssert stream() {
        jdiAssert(element().hasStream() ? "has stream" : "does not have stream",
                Matchers.is("has stream"));
        return this;
    }
}
