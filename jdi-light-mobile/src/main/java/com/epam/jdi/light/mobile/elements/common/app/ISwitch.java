package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.logger.LogLevels;

public interface ISwitch extends ICoreElement {

    @JDIAction(value = "Check that '{name}' is on", level = LogLevels.DEBUG)
    boolean isOn();

    @JDIAction(value = "Set '{name}' to off", level = LogLevels.DEBUG)
    void setToOff();

    @JDIAction(value = "Set '{name}' to on", level = LogLevels.DEBUG)
    void setToOn();


}
