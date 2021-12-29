package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;

/**
 * To see an example of Stepper web element please visit
 * https://mui.com/components/steppers/
 */

public class Stepper extends UIListBase<StepperAssert> {

    @JDIAction("Gets {name}'s list of dots")
    public WebList dots() {
        return finds(".MuiMobileStepper-dot");
    }

    @JDIAction("Gets {name}'s progress bar")
    public UIElement progressBar() {
        return find("[role='progressbar']");
    }

    @JDIAction("Gets {name}'s 'Next' button")
    public UIElement next() {
        return find("//*[contains(text(), 'Next')]");
    }

    @JDIAction("Gets {name}'s 'Back' button")
    public UIElement back() {
        return find("//*[contains(text(), 'Back')]");
    }

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

    @JDIAction("Checks that {name} is vertical")
    public boolean isVertical() {
        return attr("class").contains("vertical");
    }

    @JDIAction("Checks that {name} is horizontal")
    public boolean isHorizontal() {
        return attr("class").contains("horizontal");
    }

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }
}
