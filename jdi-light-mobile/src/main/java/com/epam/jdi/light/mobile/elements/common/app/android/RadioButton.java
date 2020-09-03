package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.android.app.RadioButtons;

public class RadioButton extends RadioButtons {

    public void clickOnTheRadioButton() {

    }

    public boolean isRadioButtonSelected() {
        return core().isSelected();
    }
}
