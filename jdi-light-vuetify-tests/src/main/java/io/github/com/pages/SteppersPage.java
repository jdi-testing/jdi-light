package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;

import java.util.List;

public class SteppersPage extends VuetifyPage {

    @UI("#NonLinearStepper .v-stepper")
    public static List<Stepper> nonLinearStepper;

    @UI("#VerticalStepper")
    public static Stepper verticalStepper;

    @UI("#AlternativeLabelWithErrorsStepper")
    public static Stepper alternativeLabelWithErrorsStepper;

    @UI("#EditableStepsStepper")
    public static Stepper editableStepsStepper;

    @UI("#ErrorsStepper")
    public static Stepper errorStepper;

    @UI("#LinearSteppersStepper .v-stepper")
    public static List<Stepper> linearSteppersStepper;

    @UI("#NonEditableStepsStepper")
    public static Stepper nonEditableStepsStepper;

    @UI("#VariousAttributeStepper > .v-stepper")
    public static List<Stepper> variousAttributesStepper;
}
