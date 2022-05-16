package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SliderRangeAssert;
import com.epam.jdi.light.material.interfaces.inputs.ISlider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * To see an example of Slider web element please visit
 * https://mui.com/components/slider/
 */

public class SliderRange extends UIBaseElement<SliderRangeAssert> implements ISlider {

    @Override
    public SliderRangeAssert is() {
        return new SliderRangeAssert().set(this);
    }
}
