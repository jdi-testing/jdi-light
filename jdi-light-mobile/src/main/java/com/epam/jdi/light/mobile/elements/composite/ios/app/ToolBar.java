package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;

public class ToolBar extends Menu {

    private Object pageObject = this;

    @JDIAction(value = "Perform tap on '{name}' {0} button")
    public void tapButton(String buttonName) {
        HasTouchActions button = GET_BUTTON.execute(pageObject, buttonName);
        button.tap();
    }
}
