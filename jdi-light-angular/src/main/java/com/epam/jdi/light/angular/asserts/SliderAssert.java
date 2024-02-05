package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderAssert extends UIAssert<SliderAssert, Slider> {
    @JDIAction(value = "Assert that '{name}' volume {0}", isAssert = true)
    public SliderAssert value(Matcher<Double> value) {
        jdiAssert(element().value(), value);
        return this;
    }

    public SliderAssert value(double value) {
        return value(Matchers.is(value));
    }

    @JDIAction(value = "Assert that '{name}' min volume is {0}", isAssert = true)
    public SliderAssert minValue(Matcher<Double> min) {
        jdiAssert(element().min(), min);
        return this;
    }

    public SliderAssert minValue(double minValue) {
        return minValue(Matchers.is(minValue));
    }


    @JDIAction(value = "Assert that '{name}' max volume {0}", isAssert = true)
    public SliderAssert maxValue(Matcher<Double> max) {
        jdiAssert(element().max(), max);
        return this;
    }

    public SliderAssert maxValue(double maxValue) {
        return maxValue(Matchers.is(maxValue));
    }

    @JDIAction(value = "Assert that '{name}' orientation is vertical", isAssert = true)
    public SliderAssert orientation(String orientation) {
        jdiAssert(element().orientation(), Matchers.is(orientation));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' axis are inverted", isAssert = true)
    public SliderAssert inverted(boolean value) {
        jdiAssert(element().isInverted(), Matchers.is(value));
        return this;
    }


    @JDIAction(value = "Assert that '{name'} thumb label is displayed", isAssert = true)
    public SliderAssert thumbLabelDisplayed(boolean value) {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(value));
        return this;
    }
}
