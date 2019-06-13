package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.SetValue;

public class FileInput extends UIBaseElement<UIAssert> implements WithLabel, SetValue {
    // region Actions
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        element.sendKeys(path);
    }
    @JDIAction("Get '{name}' file name ")
    public String value() { return element.attr("value"); }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        uploadFile(value);
    }
    public String getValue() {
        return value();
    }
    // endregion
}
