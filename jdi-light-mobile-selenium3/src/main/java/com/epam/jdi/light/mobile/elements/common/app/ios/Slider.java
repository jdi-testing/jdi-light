package com.epam.jdi.light.mobile.elements.common.app.ios;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class Slider extends MobileAppBaseElement<TextAssert> implements HasTouchActions, IsText {

    @JDIAction("Set {0} as value of '{name}'")
    public void setSliderValue(String value) {
        core().sendKeys(value);
    }

    @JDIAction("Set the minimum value for '{name}'")
    public void setMinimumValue() {
        setSliderValue("0");
    }

    @JDIAction("Set the maximum value for '{name}'")
    public void setMaximumValue() {
        setSliderValue("1");
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
