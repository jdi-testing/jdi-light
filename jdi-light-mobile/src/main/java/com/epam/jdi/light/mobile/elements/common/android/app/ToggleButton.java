package com.epam.jdi.light.mobile.elements.common.android.app;

import com.epam.jdi.light.mobile.elements.common.ios.app.Button;

public class ToggleButton extends Button {

    public void toggleButtonClick() {
        core().tap();
    }

    public String getToggleButtonText() {
        return core().getText();
    }

    public boolean isToggleButtonDisplayed() {
        return core().isDisplayed();
    }
}
