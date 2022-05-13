package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Slider;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Orientation;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Type;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class SliderAssert extends UIAssert<SliderAssert, Slider> {

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SliderAssert disabled() {
        jdiAssert(element().isDisabled()
                ? "element is disabled" : "element is enabled", Matchers.is("element is disabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' value is {0}")
    public SliderAssert value(Matcher<String> value) {
        jdiAssert(element().value(), value);
        return this;
    }

    @JDIAction("Assert that '{name}' orientation is '{0}'")
    public SliderAssert orientation(Orientation orientation) {
        jdiAssert(element().orientation(), Matchers.is(orientation));
        return this;
    }

    public SliderAssert value(String value) {
        return value(Matchers.is(value));
    }

    public SliderAssert type(Type type) {
        jdiAssert(element().type(), Matchers.is(type));
        return this;
    }
}


