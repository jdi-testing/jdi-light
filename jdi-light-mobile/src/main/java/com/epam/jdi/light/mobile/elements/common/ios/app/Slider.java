package com.epam.jdi.light.mobile.elements.common.ios.app;

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

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
