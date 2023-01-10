package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressCircularAssert extends UIAssert<ProgressCircularAssert, ProgressCircular> {

    @JDIAction("Assert that '{name}' is displayed")
    public ProgressCircularAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected height")
    public ProgressCircularAssert height(String height) {
        jdiAssert(element().height(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected width")
    public ProgressCircularAssert width(String width) {
        jdiAssert(element().width(), Matchers.is(width));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public ProgressCircularAssert color(String color) {
        jdiAssert(element().hasColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' is spinning")
    public ProgressCircularAssert spinning() {
        jdiAssert(element().isSpinning() ? "is spinning" : "is not spinning", Matchers.is("is spinning"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not spinning")
    public ProgressCircularAssert notSpinning() {
        jdiAssert(element().isSpinning() ? "is spinning" : "is not spinning", Matchers.is("is not spinning"));
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public ProgressCircularAssert hasNoLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
        return this;
    }

    @JDIAction("Assert that '{name}' has line thickness")
    public ProgressCircularAssert thickness(int thickness) {
        jdiAssert(element().getThickness(), Matchers.equalTo(thickness));
        return this;
    }

    @JDIAction("Assert that '{name}' has text")
    public ProgressCircularAssert text(String text) {
        jdiAssert(element().getText(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has value")
    public ProgressCircularAssert value(int value) {
        jdiAssert(element().getValue(), Matchers.equalTo(value));
        return this;
    }

    @JDIAction("Assert that '{name}' has rotate")
    public ProgressCircularAssert rotate(int startAngle) {
        jdiAssert(element().getRotate(), Matchers.equalTo(startAngle));
        return this;
    }
}
