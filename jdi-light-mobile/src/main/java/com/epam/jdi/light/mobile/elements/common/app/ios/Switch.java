package com.epam.jdi.light.mobile.elements.common.app.ios;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.asserts.SwitchAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.ISwitch;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public class Switch extends MobileAppBaseElement<SwitchAssert>
        implements ISwitch, HasTouchActions, IsButton {

    @JDIAction(value = "Check that '{name}' is on")
    public boolean isOn() {
        return core().getValue().equals("1");
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
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
