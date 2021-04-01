package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIStepper;
import com.epam.jdi.light.material.elements.navigation.Stepper;

public class StepperFrame extends Section {

    @JDIStepper(root = "#root")
    public Stepper stepper;

    @JDIStepper(stepperTitle = ".MuiTypography-root.MuiTypography-body1")
    public Stepper stepperTitle;

    @JDIStepper(stepperButtonByIndex = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text']")
    public Stepper stepperButton;
}
