package com.epam.jdi.light.vuetify.asserts.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class StepperAssert extends UIAssert<StepperAssert, Stepper> implements
        OrientationAssert<StepperAssert, Stepper>, ColorAssert<StepperAssert, Stepper>,
        ThemeAssert<StepperAssert, Stepper>, ElevationAssert<StepperAssert, Stepper>,
        MeasurementAssert<StepperAssert, Stepper>, OutlinedAssert<StepperAssert, Stepper>,
        RoundedAssert<StepperAssert, Stepper>, ShapedAssert<StepperAssert, Stepper>,
        TileAssert<StepperAssert, Stepper> {

    @JDIAction(value = "Assert that '{name}' is non-linear", isAssert = true)
    public StepperAssert nonLinear() {
        jdiAssert(element().isNonLinear(), Matchers.is(true), "Stepper is linear");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is linear", isAssert = true)
    public StepperAssert linear() {
        jdiAssert(element().isNonLinear(), Matchers.is(false), "Stepper is non-linear");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has alt label", isAssert = true)
    public StepperAssert altLabel() {
        jdiAssert(element().hasAltLabel(), Matchers.is(true), "Stepper has not alt label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not alt label", isAssert = true)
    public StepperAssert notAltLabel() {
        jdiAssert(element().hasAltLabel(), Matchers.is(false), "Stepper has alt label");
        return this;
    }
}
