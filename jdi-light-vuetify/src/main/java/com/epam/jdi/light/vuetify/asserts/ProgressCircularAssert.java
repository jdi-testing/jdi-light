package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressCircularAssert extends UIAssert<ProgressCircularAssert, ProgressCircular> {

    @JDIAction("Assert that {name} is displayed")
    public ProgressCircularAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has expected height")
    public ProgressCircularAssert height(String height) {
        jdiAssert(element().hasHeight(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that {name} has expected width")
    public ProgressCircularAssert width(String width) {
        jdiAssert(element().hasWidth(), Matchers.is(width));
        return this;
    }

    @JDIAction("Assert that {name} has expected color")
    public ProgressCircularAssert color(String color) {
        jdiAssert(element().hasColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that {name} has expected color")
    public ProgressCircularAssert spinning() {
        jdiAssert(element().isSpinning(), Matchers.is(true));
        return this;
    }
    @JDIAction("Assert that {name} has expected color")
    public ProgressCircularAssert notSpinning() {
        jdiAssert(element().isSpinning(), Matchers.is(false));
        return this;
    }
}
