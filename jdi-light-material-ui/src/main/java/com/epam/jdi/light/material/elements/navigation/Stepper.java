package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;
import com.epam.jdi.light.material.interfaces.base.HasImage;

/**
 * To see an example of Stepper web element please visit
 * https://mui.com/components/steppers/
 */

public class Stepper extends UIListBase<StepperAssert> {

    @JDIAction("Check that step {0} in '{name}' is completed")
    public boolean stepCompleted(int step) {
        String completedClass = "MuiStep-completed";
        return list().get(step).hasClass(completedClass);
    }

    @JDIAction(value = "Check that step {0} in '{name}' is enabled", timeout = 0)
    public boolean stepEnabled(int step) {
        String disabledClass = "Mui-disabled";
        String innerLocator = ".MuiStepLabel-root";
        return !list().get(step).find(innerLocator).hasClass(disabledClass);
    }

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }
}
