package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;

public class MobileTextStepper extends MobileProgress implements IsText {

    @Override
    @JDIAction("Get '{name}' value")
    public int value() {
        return Integer.parseInt(getText().split("/")[0].trim());
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().text().split("\\n")[1];
    }

    @Override
    @JDIAction("Get '{name}' mox value")
    public int maxValue() {
        return Integer.parseInt(getText().split("/")[1].trim());
    }
}
