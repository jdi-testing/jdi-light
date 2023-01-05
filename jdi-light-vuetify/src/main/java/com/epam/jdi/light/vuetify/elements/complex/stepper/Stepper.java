package com.epam.jdi.light.vuetify.elements.complex.stepper;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.asserts.steppers.StepperAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Subheader web element please visit https://vuetifyjs.com/en/components/steppers
 */
public class Stepper extends UIBaseElement<StepperAssert> implements HasOrientation, HasColor, HasTheme, HasElevation,
        HasMeasurement, IsOutlined, HasRounded, IsShaped, IsTile {

    @UI(".v-stepper__step")
    private List<Step> steps;

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }

    public Step getStep(int index) {
        return steps.get(index);
    }

    public List<Step> getStepsList() {
        return steps;
    }

    public WebList getContentList() {
        return $$(".v-stepper__content", core());
    }

    @JDIAction("Check that '{name}' is non-linear")
    public boolean isNonLinear() {
        return hasClass("v-stepper--non-linear");
    }

    @JDIAction("Check that '{name}' has alt label")
    public boolean hasAltLabel() {
        return hasClass("v-stepper--alt-labels");
    }
}
