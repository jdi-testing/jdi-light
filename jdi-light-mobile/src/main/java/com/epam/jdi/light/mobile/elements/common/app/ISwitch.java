package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.SwitchAndroidAssert;
import com.epam.jdi.light.mobile.asserts.generic.ISwitchAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

public interface ISwitch {

    @JDIAction(value = "Check that '{name}' is on", level = LogLevels.DEBUG)
    boolean isOn();

    @JDIAction(value = "Set '{name}' to off", level = LogLevels.DEBUG)
    void setToOff();

    @JDIAction(value = "Set '{name}' to on", level = LogLevels.DEBUG)
    void setToOn();

}
