package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SliderAssert;
import com.epam.jdi.light.material.interfaces.inputs.ISlider;

/**
 * To see an example of Slider web element please visit
 * https://mui.com/components/slider/
 */

public class Slider extends UIBaseElement<SliderAssert> implements ISlider {

    public UIElement thumb() {
        return thumb(1);
    }

    public void setValue(String value) {
        setValue(1, value);
    }

    public void setValue(int value) {
        setValue(String.valueOf(value));
    }

    public void setValue(double value) {
        setValue(String.valueOf(value));
    }

    public String value() {
        return value(1);
    }

    public void dragAndDropThumbTo(String value) {
        dragAndDropThumbTo(1, value);
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }
}
