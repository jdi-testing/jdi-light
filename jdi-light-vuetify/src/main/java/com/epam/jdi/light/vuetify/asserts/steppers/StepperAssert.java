package com.epam.jdi.light.vuetify.asserts.steppers;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
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

	@JDIAction("Assert that '{name}' is non-linear")
	public StepperAssert nonLinear() {
		jdiAssert(element().isNonLinear(), Matchers.is(true), "Element is linear");
		return this;
	}

	@JDIAction("Assert that '{name}' is linear")
	public StepperAssert linear() {
		jdiAssert(element().isNonLinear(), Matchers.is(false), "Element is non-linear");
		return this;
	}

	@JDIAction("Assert that '{name}' has alt label")
	public StepperAssert altLabel() {
		jdiAssert(element().hasAltLabel(), Matchers.is(true), "Element has not alt label");
		return this;
	}

	@JDIAction("Assert that '{name}' has not alt label")
	public StepperAssert notAltLabel() {
		jdiAssert(element().hasAltLabel(), Matchers.is(false), "Element has alt label");
		return this;
	}
}
