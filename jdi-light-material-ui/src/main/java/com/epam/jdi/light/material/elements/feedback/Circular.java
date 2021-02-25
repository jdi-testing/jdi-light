package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.feedback.CircularAssert;

import static java.lang.Thread.sleep;

public class Circular extends UIBaseElement<CircularAssert> {
    int rotationPeriodMillis = 400;

    @JDIAction("Get '{name}' value ")
    public int value() throws Exception {
        if (isDeterminate()) {
            return Integer.parseInt(attr("aria-valuenow"));
        }
        throw new Exception("No exist 'value' attribute");
    }

    @JDIAction("Is '{name}' indeterminate")
    public Boolean isIndeterminate() {
        return !isDeterminate();
    }

    @JDIAction("Is '{name}' determinate")
    public Boolean isDeterminate() {
        return hasAttribute("aria-valuenow");
    }

    @JDIAction("Is '{name}' spinning")
    public Boolean isSpinning() throws Exception {
        int position = value();
        sleep(rotationPeriodMillis);
        int currentPosition = value();
        return !(position == currentPosition);
    }

    @JDIAction("Is '{name}' shrinkDisabled")
    public Boolean isShrinkDisabled() {
        return core().find(".MuiCircularProgress-circle").hasClass("MuiCircularProgress-circleDisableShrink");
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public CircularAssert is() {
        return new CircularAssert().set(this);
    }

    @Override
    public CircularAssert has() {
        return this.is();
    }

}

