package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.SliderRangeAssert;
import com.epam.jdi.light.material.interfaces.inputs.ISlider;

/**
 * Represents Range Slider MUI component on GUI.
 * <p>Sliders reflect a range of values along a bar, from which users may select a single value.
 * They are ideal for adjusting settings such as volume, brightness, or applying image filters.</p>
 *
 * @see ISlider
 * @see <a href="https://v4.mui.com/components/slider/#range-slider">Slider MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/sliders">MUI test page</a>
 */

public class SliderRange extends UIBaseElement<SliderRangeAssert> implements ISlider {

    @Override
    public SliderRangeAssert is() {
        return new SliderRangeAssert().set(this);
    }
}
