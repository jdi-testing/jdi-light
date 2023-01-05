package com.epam.jdi.light.vuetify.elements.complex.stepper;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.vuetify.asserts.steppers.StepAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;

public class Step extends UIBaseElement<StepAssert> implements IClickable, HasColor {

    @Override
    public StepAssert is() {
        return new StepAssert().set(this);
    }

    @JDIAction("Check that '{name}' is active")
    public boolean isActive() {
        return core().getAttribute("class").contains("v-stepper__step--active");
    }

    @JDIAction("Check that '{name}' is complete")
    public boolean isComplete() {
        return core().getAttribute("class").contains("v-stepper__step--complete");
    }

    @JDIAction("Check that '{name}' is editable")
    public boolean isEditable() {
        return core().getAttribute("class").contains("v-stepper__step--editable");
    }

    @JDIAction("Check that '{name}' has error")
    public boolean hasError() {
        return hasClass("v-stepper__step--error");
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
