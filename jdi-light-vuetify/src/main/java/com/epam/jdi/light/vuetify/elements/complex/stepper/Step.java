package com.epam.jdi.light.vuetify.elements.complex.stepper;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.vuetify.asserts.StepperAssert;

public class Step extends UIBaseElement<StepperAssert> implements IClickable {

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }

    @JDIAction("Check that '{name}' is active")
    public boolean stepIsActive() {
        return core().getAttribute("class").contains("v-stepper__step--active");
    }

    @JDIAction("Check that '{name}' is complete")
    public boolean stepIsComplete() {
        return core().getAttribute("class").contains("v-stepper__step--complete");
    }

    @JDIAction("Check that '{name}' is editable")
    public boolean stepIsEditable() {
        return core().getAttribute("class").contains("v-stepper__step--editable");
    }

    @Override
    public String getName() {
        return core().find(".v-stepper__label").text();
    }

    @Override
    public void click() {
        core().click();
    }
}
