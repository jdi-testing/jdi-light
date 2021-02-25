package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.asserts.ToggleButtonAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class ToggleButton extends MobileAppBaseElement<ToggleButtonAssert>  implements HasTouchActions, IsButton, IsText {
    @JDIAction(value = "Check that '{name}' is on")
    public boolean isOn() {
        return core().attr("checked").equals("true");
    }

    @JDIAction(value = "Set '{name}' to off")
    public void setToOff() {
        if (isOn())
            core().tap();
    }

    @JDIAction(value = "Set '{name}' to on")
    public void setToOn() {
        if (!isOn())
            core().tap();

    }

    @Override
    public ToggleButtonAssert is() {
        return new ToggleButtonAssert().set(this);
    }


}
