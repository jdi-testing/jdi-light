package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.mobile.elements.common.app.Button;

public class RadioButton extends Button {

    public void clickOnTheRadioButton() {
        core().tap();
    }

    public boolean isRadioButtonSelected() {
        return core().isSelected();
    }
}
