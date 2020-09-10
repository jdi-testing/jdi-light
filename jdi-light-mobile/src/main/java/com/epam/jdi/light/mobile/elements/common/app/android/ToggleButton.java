package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.SwitchAssert;

public class ToggleButton extends Switch {
    @JDIAction(value = "Check that '{name}' is on", level = LogLevels.DEBUG)
    public boolean isOn() {
        return core().text().equals("ON");
    }

    @JDIAction(value = "Set '{name}' to off", level = LogLevels.DEBUG)
    public void setToOff() {
        if (isOn())
            core().tap();
    }

    @JDIAction(value = "Set '{name}' to on", level = LogLevels.DEBUG)
    public void setToOn() {
        if (!isOn())
            core().tap();
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
