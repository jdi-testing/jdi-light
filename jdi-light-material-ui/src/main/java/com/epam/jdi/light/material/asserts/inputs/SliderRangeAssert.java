package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Orientation;
import com.epam.jdi.light.material.interfaces.inputs.ISlider.Type;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link SliderRange}
 */
public class SliderRangeAssert extends UIAssert<SliderRangeAssert, SliderRange> {

    /**
     * Checks that Slider's thumb has given current value.
     *
     * @param value matcher as {@link Matcher}
     * @param index thumb index. Starting from 1
     * @return this {@link SliderRangeAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' value {0}", isAssert = true)
    public SliderRangeAssert value(Matcher<String> value, int index) {
        jdiAssert(element().value(index), value);
        return this;
    }

    /**
     * Checks that Slider has given current orientation.
     *
     * @param orientation expected slider's orientation as {@link Orientation}
     * @return this {@link SliderRangeAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' orientation is '{0}'", isAssert = true)
    public SliderRangeAssert orientation(Orientation orientation) {
        jdiAssert(element().orientation(), Matchers.is(orientation));
        return this;
    }

    /**
     * Checks that Slider has given current type.
     *
     * @param type expected slider's orientation as {@link Type}
     * @return this {@link SliderRangeAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' type is '{0}'", isAssert = true)
    public SliderRangeAssert type(Type type) {
        jdiAssert(element().type(), Matchers.is(type));
        return this;
    }

    /**
     * Checks that Slider's thumb has given current value.
     *
     * @param value expected current value
     * @param index thumb index. Starting from 1
     * @return this {@link SliderRangeAssert} instance
     */
    public SliderRangeAssert value(int index, String value) {
        return value(Matchers.is(value), index);
    }
}




