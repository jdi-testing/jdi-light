package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SliderAssert;
import com.epam.jdi.light.material.interfaces.inputs.ISlider;

/**
 * Represents simple Slider MUI component on GUI.
 * <p>Sliders reflect a range of values along a bar, from which users may select a single value.
 * They are ideal for adjusting settings such as volume, brightness, or applying image filters.</p>
 * @see ISlider
 * @see <a href="https://v4.mui.com/components/slider/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/sliders">MUI test page</a>
 */

public class Slider extends UIBaseElement<SliderAssert> implements ISlider {

    /**
     * Gets simple Slider's thumb.
     *
     * @return Slider's label as {@link UIElement}
     */
    public UIElement thumb() {
        return thumb(1);
    }

    /**
     * Sets simple Slider's thumb value.
     *
     * @param value value to set
     */
    public void setValue(String value) {
        setValue(1, value);
    }

    /**
     * Sets simple Slider's thumb value.
     *
     * @param value value to set
     */
    public void setValue(int value) {
        setValue(String.valueOf(value));
    }

    /**
     * Sets simple Slider's thumb value.
     *
     * @param value value to set
     */
    public void setValue(double value) {
        setValue(String.valueOf(value));
    }

    /**
     * Gets simple Slider's thumb value.
     *
     * @return Slider's thumb value as {@link String}
     */
    public String value() {
        return value(1);
    }

    /**
     * Performs simple Slider's thumb drag and drop to value.
     *
     * @param value value to set
     */
    public void dragAndDropThumbTo(String value) {
        dragAndDropThumbTo(1, value);
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
