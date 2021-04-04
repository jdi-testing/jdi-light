package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.Stepper;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class StepperSection {
    @UI("stepper-overview-example")
    public static UIElement linearExample;
    @UI("#linear-mode-button")
    public static Button linearModeButton;
    @UI("#linear-stepper")
    public static Stepper linearStepper;
    @UI("stepper-optional-example")
    public static UIElement optionalExample;
    @UI("#optional-step-button")
    public static Button optionalStepButton;
    @UI("#optional-steps-stepper")
    public static Stepper optionalStepper;
}
