package com.epam.jdi.light.mobile.elements.common.ios.app;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import java.util.HashMap;

public class Picker extends MobileAppBaseElement<TextAssert> implements HasTouchActions, IsText {

    public void sendKeys(String value) {
        core().sendKeys(value);
    }

    public void movePickerWheel(String order, String offset) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", order);
        params.put("offset", offset);
        params.put("element", this.core().get());
        core().js().executeScript("mobile: selectPickerWheelValue", params);
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
