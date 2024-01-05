package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressCircular;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressCircularAssert extends UIAssert<ProgressCircularAssert, ProgressCircular> {
    @JDIAction(value = "Assert that '{name}' has expected height", isAssert = true)
    public ProgressCircularAssert height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected width", isAssert = true)
    public ProgressCircularAssert width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected color", isAssert = true)
    public ProgressCircularAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is spinning", isAssert = true)
    public ProgressCircularAssert spinning() {
        jdiAssert(element().isSpinning(), Matchers.is(true), "ProgressCircular is not spinning");
        return this;
    }
    @JDIAction(value = "Assert that '{name}' is not spinning", isAssert = true)
    public ProgressCircularAssert notSpinning() {
        jdiAssert(element().isSpinning(), Matchers.is(false), "ProgressCircular is spinning");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public ProgressCircularAssert hasNoLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has line thickness", isAssert = true)
    public ProgressCircularAssert thickness(int thickness) {
        jdiAssert(element().getThickness(), Matchers.equalTo(thickness));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text", isAssert = true)
    public ProgressCircularAssert text(String text) {
        jdiAssert(element().getText(), Matchers.equalTo(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has value", isAssert = true)
    public ProgressCircularAssert value(int value) {
        jdiAssert(element().getValue(), Matchers.equalTo(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has rotate {0}", isAssert = true)
    public ProgressCircularAssert rotation(int startAngle) {
        jdiAssert(element().getRotate(), Matchers.equalTo(startAngle));
        return this;
    }
}
