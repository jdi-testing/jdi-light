package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.logger.LogLevels;

public interface ICheckbox extends ICoreElement {
    @JDIAction(value = "Perform tap on '{name}' to get checked station", level = LogLevels.DEBUG)
    void check();

    @JDIAction(value = "Perform tap on '{name}' to get unchecked station", level = LogLevels.DEBUG)
    void uncheck();

    @JDIAction(value = "Verify '{name}' is checked", level = LogLevels.DEBUG)
    boolean isChecked();
}
