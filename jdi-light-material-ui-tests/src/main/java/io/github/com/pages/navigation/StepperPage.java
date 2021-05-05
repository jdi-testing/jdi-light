package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JDIStepper;
import com.epam.jdi.light.material.elements.navigation.Stepper;

public class StepperPage extends WebPage {

    //Simple Linear Stepper
    @JDIStepper(root = "//*[@id='simpleStepper']")
    public static Stepper simpleLinearStepper;

    @JDIStepper(stepperTitle = "//*[@id='simpleStepper']//following-sibling::div//*[@class='MuiTypography-root MuiTypography-body1']")
    public static Stepper simpleLinearStepperTitle;

    @JDIStepper(stepperButtonByIndex = "//*[@id='simpleStepper']//following-sibling::div//button[contains(@class, 'MuiButtonBase-root')]")
    public static Stepper simpleLinearStepperButton;


    //Non-linear Stepper
    @JDIStepper(root = "//*[@id='nonLinearStepper']")
    public static Stepper nonlinearStepper;

    @JDIStepper(stepperTitle = "//*[@id='nonLinearStepper']//following-sibling::div//*[@class='MuiTypography-root MuiTypography-body1']")
    public static Stepper nonlinearStepperTitle;

    @JDIStepper(stepperButtonByIndex = "//*[@id='nonLinearStepper']//following-sibling::div//button[contains(@class, 'MuiButtonBase-root')]")
    public static Stepper nonlinearStepperButton;


    //Vertical Stepper
//    @JDIStepper(stepperTitle = "//*[@id='activeVerticalStep']")
    @JDIStepper(stepperTitle = "(//*[text()='Vertical stepper']/following-sibling::div//p)[1]")
    public static Stepper verticalStepperTitle;

    @JDIStepper(stepperButtonByIndex = "//*[text()='Vertical stepper']/following-sibling::div//button[contains(@class, MuiButtonBase-root)]")
    public static Stepper verticalStepperButton;


    //Mobile Text Stepper
    @JDIStepper(stepperTitle = "(//*[text()='Mobile text stepper']/following-sibling::div//*[contains(@class, 'MuiMobileStepper-root')])[1]")
    public static Stepper mobileTextStepperTitle;

    @JDIStepper(stepperButtonByIndex = "//*[text()='Mobile text stepper']/following-sibling::div//button")
    public static Stepper mobileTextStepperButton;


    //Mobile Dots Stepper
    @JDIStepper(stepperTitle = "//*[@id='activeDotStep']")
    public static Stepper mobileDotsStepperTitle;

    @JDIStepper(stepperButtonByIndex = "//*[text()='Mobile dots stepper']/following-sibling::div//button")
    public static Stepper mobileDotsStepperButton;


    //Mobile Progress Stepper
    @JDIStepper(stepperTitle = "//*[@id='activeProgressStep']")
    public static Stepper mobileProgressStepperTitle;

    @JDIStepper(stepperButtonByIndex = "//*[text()='Mobile progress stepper']/following-sibling::div//button")
    public static Stepper mobileProgressStepperButton;
}
