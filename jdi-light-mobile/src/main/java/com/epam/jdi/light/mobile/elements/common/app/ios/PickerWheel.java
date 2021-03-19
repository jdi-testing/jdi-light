package com.epam.jdi.light.mobile.elements.common.app.ios;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import java.util.HashMap;

public class PickerWheel extends MobileAppBaseElement<TextAssert> implements HasTouchActions, IsText {

    @JDIAction("Set {0} as value of '{name}'")
    public void setPickerWheelValue(String value) {
        core().sendKeys(value);
    }

    private void movePickerWheel(String order, String offset) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", order);
        params.put("offset", offset);
        params.put("element", this.core().get());
        core().js().executeScript("mobile: selectPickerWheelValue", params);
    }

    @JDIAction("Move '{name}' forward by {0} of its height")
    public void movePickerWheelForward(String offset) {
        movePickerWheel("next", offset);
    }

    @JDIAction("Move '{name}' backward by {0} of its height")
    public void movePickerWheelBackward(String offset) {
        movePickerWheel("previous", offset);
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
