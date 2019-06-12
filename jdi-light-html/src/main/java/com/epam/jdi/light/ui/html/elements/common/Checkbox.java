package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.ui.html.aserts.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> implements WithLabel, SetValue {
    // region Actions
    @JDIAction("Click on '{name}'")
    public void click() {
        element.click();
    }
    public void check(String value) {
        if (value.equalsIgnoreCase("true") || value.equals("1"))
            check();
        else uncheck();
    }
    @JDIAction("Check '{name}'")
    public void check() {
        element.check();
    }
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        element.uncheck();
    }
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return element.isSelected();
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        check(value);
    }
    public String getValue() {
        return isSelected()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
    // endregion
}
