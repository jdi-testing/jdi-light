package com.epam.jdi.light.material.elements.navigation.steppers;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class MobileDotsStepper extends MobileProgress {

    protected String activeDotClass = "MuiMobileStepper-dotActive";

    @UI(".MuiMobileStepper-dot")
    protected WebList dots;

    @Override
    @JDIAction("Get '{name}' value")
    public int value() {
        for (int i = 1; i <= dots.size(); i++) {
            if (dots.get(i).hasClass(activeDotClass)) {
                return i;
            }
        }
        throw runtimeException("No dot is active");
    }

    @Override
    @JDIAction("Get '{name}' max value")
    public int maxValue() {
        return dots.size();
    }
}
