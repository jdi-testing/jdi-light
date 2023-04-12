package com.epam.jdi.light.vuetify.elements.complex.stepper;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
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
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Subheader web element please visit https://vuetifyjs.com/en/components/steppers
 */
public class Stepper extends UIBaseElement<StepperAssert> implements HasOrientation, HasColor, HasTheme, HasElevation,
        HasMeasurement, IsOutlined, HasRounded, IsShaped, IsTile {

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }

    @JDIAction("Returns step by index")
    public Step getStep(int index) {
        return steps().get(index);
    }

    @JDIAction("Returns list of steps for stepper")
    public List<Step> steps() {
        return core().finds(".v-stepper__step").stream()
                .map(e -> new Step().setCore(Step.class, e))
                .collect(Collectors.toList());
    }

    @JDIAction("Returns content list for stepper")
    public WebList getContentList() {
        return $$(".v-stepper__content", core());
    }

    @JDIAction("Get if '{name}' is non-linear")
    public boolean isNonLinear() {
        return hasClass("v-stepper--non-linear");
    }

    @JDIAction("Get if '{name}' has alt label")
    public boolean hasAltLabel() {
        return hasClass("v-stepper--alt-labels");
    }
}
