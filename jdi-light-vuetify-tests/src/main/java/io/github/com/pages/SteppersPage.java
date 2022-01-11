package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;

import java.util.List;

public class SteppersPage extends VuetifyPage {

    @UI("#NonLinearStepper .v-stepper")
    public static List<Stepper> nonLinearStepper;

    @UI("#VerticalStepper")
    public static Stepper verticalStepper;

    @UI("#AlternativeLabelWithErrorsStepper")
    public static Stepper alternativeLabelWithErrorsStepper;

    @UI("#DynamicStepsStepper .v-stepper")
    public static Stepper dynamicStepsStepper;

    @UI("#DynamicStepsStepper .v-input__control")
    public static OverflowButton dynamicStepsStepperInput;

    @UI("#EditableStepsStepper")
    public static Stepper editableStepsStepper;

    @UI("#LinearSteppersStepper .v-stepper")
    public static List<Stepper> linearSteppersStepper;

    @UI("#NonEditableStepsStepper")
    public static Stepper nonEditableStepsStepper;
}
