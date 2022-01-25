package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressSpinner;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressSpinnerAssert extends UIAssert<ProgressSpinnerAssert, ProgressSpinner> {

    @JDIAction("Assert that '{name}' is displayed")
    public ProgressSpinnerAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected height")
    public ProgressSpinnerAssert height(String height) {
        jdiAssert(element().hasHeight(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected width")
    public ProgressSpinnerAssert width(String width) {
        jdiAssert(element().hasWidth(), Matchers.is(width));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public ProgressSpinnerAssert color(String color) {
        jdiAssert(element().hasColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' is spinning")
    public ProgressSpinnerAssert spinning() {
        jdiAssert(element().isSpinning() ? "is spinning" : "is not spinning", Matchers.is("is spinning"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not spinning")
    public ProgressSpinnerAssert notSpinning() {
        jdiAssert(element().isSpinning() ? "is spinning" : "is not spinning", Matchers.is("is not spinning"));
        return this;
    }
}
