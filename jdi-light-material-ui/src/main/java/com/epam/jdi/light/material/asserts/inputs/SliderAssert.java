package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Slider;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Orientation;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Type;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link Slider}
 */
public class SliderAssert extends UIAssert<SliderAssert, Slider> {

    /**
     * Checks that Slider is disabled.
     *
     * @return this {@link SliderAssert} instance
     */
    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SliderAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Slider is not disabled");
        return this;
    }

    /**
     * Checks that Slider's thumb has given current value.
     *
     * @param value matcher as {@link Matcher}
     * @return this {@link SliderAssert} instance
     */
    @JDIAction("Assert that '{name}' value is {0}")
    public SliderAssert value(Matcher<String> value) {
        jdiAssert(element().value(), value);
        return this;
    }

    /**
     * Checks that Slider has given current orientation.
     *
     * @param orientation expected slider's orientation as {@link Orientation}
     * @return this {@link SliderAssert} instance
     */
    @JDIAction("Assert that '{name}' orientation is '{0}'")
    public SliderAssert orientation(Orientation orientation) {
        jdiAssert(element().orientation(), Matchers.is(orientation));
        return this;
    }

    /**
     * Checks that Slider's thumb has given current value.
     *
     * @param value expected current value
     * @return this {@link SliderRangeAssert} instance
     */
    public SliderAssert value(String value) {
        return value(Matchers.is(value));
    }

    /**
     * Checks that Slider has given current type.
     *
     * @param type expected slider's orientation as {@link Type}
     * @return this {@link SliderAssert} instance
     */
    public SliderAssert type(Type type) {
        jdiAssert(element().type(), Matchers.is(type));
        return this;
    }
}


