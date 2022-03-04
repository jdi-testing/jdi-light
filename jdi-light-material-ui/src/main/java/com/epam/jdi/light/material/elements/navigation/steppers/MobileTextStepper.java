package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;

public class MobileTextStepper extends MobileProgress implements IsText {

    @Override
    public int value() {
        return Integer.parseInt(getText().split("/")[0].trim());
    }

    @Override
    public String getText() {
        return core().text().split("\\n")[1];
    }

    @Override
    public int maxValue() {
        return Integer.parseInt(getText().split("/")[1].trim());
    }
}
