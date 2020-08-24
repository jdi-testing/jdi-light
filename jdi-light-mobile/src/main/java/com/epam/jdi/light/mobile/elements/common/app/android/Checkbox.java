package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.elements.common.app.Button;

public class Checkbox extends Button {
    @JDIAction(value = "Perform tap on '{name}' to get checked station", level = LogLevels.DEBUG)
    public void check() {
        if (uiElement.getAttribute("checked").equals("true")) {
            core().tap();
        }
    }

    @JDIAction(value = "Perform tap on '{name}' to get unchecked station", level = LogLevels.DEBUG)
    public void uncheck() {
        if (uiElement.getAttribute("checked").equals("false")) {
            core().tap();
        }
    }

    @JDIAction(value = "Verify '{name}' is checked", level = LogLevels.DEBUG)
    public boolean isChecked() {
        return uiElement.getAttribute("checked").equals("true");
    }
}
