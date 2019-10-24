package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;

public class CustomCheckbox extends Checkbox {
    // region Actions
    @JDIAction("Check '{name}'")
    @Override
    public void check() {
        if (uiElement.isDeselected())
            click();
    }

    @JDIAction("Uncheck '{name}'")
    @Override
    public void uncheck() {
        if (uiElement.isSelected())
            click();
    }

    @JDIAction("Click on '{name}'")
    @Override
    public void click() {
        uiElement.label().click();

    }

    @JDIAction("Assert that '{name}' is displayed")
    @Override
    public boolean isDisplayed() {
        return uiElement.label().isDisplayed();
    }
    // endregion

}
