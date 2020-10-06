package com.epam.jdi.light.mobile.elements.common.app;

import com.epam.jdi.light.common.JDIAction;

import static com.epam.jdi.light.common.TextTypes.VALUE;

public interface ITextField {
    void setValue(String value);
    String getValue();
    String getText();
    @JDIAction("Clear value in {name}")
    void clear();
}
