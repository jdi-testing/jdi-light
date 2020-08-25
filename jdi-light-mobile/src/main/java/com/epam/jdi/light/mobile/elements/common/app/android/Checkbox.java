package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;

public class Checkbox extends MobileAppBaseElement<TextAssert> {
    @JDIAction(value = "Perform tap on '{name}' to get checked station", level = LogLevels.DEBUG)
    public void check() {
        if (!isChecked()) {
            core().check();
        }
    }

    @JDIAction(value = "Perform tap on '{name}' to get unchecked station", level = LogLevels.DEBUG)
    public void uncheck() {
        if (isChecked()) {
            core().uncheck();
        }
    }

    @JDIAction(value = "Verify '{name}' is checked", level = LogLevels.DEBUG)
    public boolean isChecked() {
        return core().isSelected();
    }
}

