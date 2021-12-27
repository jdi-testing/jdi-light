package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Slider;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class SliderAssert extends UIAssert<SliderAssert, Slider> {

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public SliderAssert disabled() {
        jdiAssert(element().isDisabled()
                ? "element is disabled" : "element is enabled", Matchers.is("element is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' value is {0}")
    public SliderAssert value(Matcher<Integer> value) {
        jdiAssert(element().value(), value);
        return this;
    }

    @JDIAction("Assert that orientation is '{0}'")
    public SliderAssert orientation(String orientation) {
        jdiAssert(element().orientation(), Matchers.is(orientation));
        return this;
    }

    public SliderAssert value(int value) {
        return value(Matchers.is(value));
    }

    @JDIAction("Assert that {name} is discrete")
    public SliderAssert discrete() {
        jdiAssert(element().isDiscrete()
                ? "is discrete" : "isn't discrete", Matchers.is("is discrete"));
        return this;
    }

    @JDIAction("Assert that {name}'s label is visible")
    public SliderAssert labelIsVisible() {
        jdiAssert(element().labelIsVisible()
                ? "is visible" : "isn't visible", Matchers.is("is visible"));
        return this;
    }

    @JDIAction("Assert that {name}'s label is not visible")
    public SliderAssert labelIsNotVisible() {
        jdiAssert(element().labelIsVisible()
                ? "is visible" : "isn't visible", Matchers.is("isn't visible"));
        return this;
    }
}


