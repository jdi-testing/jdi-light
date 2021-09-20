package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.material.elements.navigation.Stepper;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class StepperPage extends WebPage {
    @UI("#simpleStepper")
    public static Stepper simpleLinearStepper;

    @UI("//div[@id='simpleStepper']/..//button[1]")
    public static MaterialButton simpleLinearStepperBackButton;

    @UI("//div[@id='simpleStepper']/..//button[2]")
    public static MaterialButton simpleLinearStepperNextButton;

    @UI("#nonLinearStepper")
    public static Stepper nonlinearStepper;

    @UI("//p[@id='activeNonLinearStep']/..//button[1]")
    public static MaterialButton nonlinearStepperBackButton;

    @UI("//p[@id='activeNonLinearStep']/..//button[2]")
    public static MaterialButton nonlinearStepperNextButton;

    @UI("//p[@id='activeNonLinearStep']/..//button[3]")
    public static MaterialButton nonlinearStepperCompleteStepButton;

    @UI("//h2[text()='Vertical stepper']/following-sibling::div[1]/div")
    public static Stepper verticalStepper;

    @UI("//h2[text()='Vertical stepper']/following-sibling::div[1]//button[1]")
    public static MaterialButton verticalStepperBackButton;

    @UI("//h2[text()='Vertical stepper']/following-sibling::div[1]//button[2]")
    public static MaterialButton verticalStepperNextButton;

    @UI("(//*[text()='Mobile text stepper']/following-sibling::div//*[contains(@class, 'MuiMobileStepper-root')])[1]")
    public static Text mobileTextStepperTitle;

    @UI("//*[text()='Mobile text stepper']/following-sibling::div[1]//button[2]")
    public static MaterialButton mobileTextStepperNextButton;

    @UI("//*[text()='Mobile text stepper']/following-sibling::div[1]//button[1]")
    public static MaterialButton mobileTextStepperBackButton;

    @UI("//*[@id='activeDotStep']")
    public static Text mobileDotsStepperTitle;

    @UI("//*[text()='Mobile dots stepper']//following-sibling::div[1]//button[2]")
    public static MaterialButton mobileDotsStepperNextButton;

    @UI("//*[text()='Mobile dots stepper']//following-sibling::div[1]//button[1]")
    public static MaterialButton mobileDotsStepperBackButton;

    @UI("//*[@id='activeProgressStep']")
    public static Text mobileProgressStepperTitle;

    @UI("//*[text()='Mobile progress stepper']//following-sibling::div[1]//button[2]")
    public static MaterialButton mobileProgressStepperNextButton;

    @UI("//*[text()='Mobile progress stepper']//following-sibling::div[1]//button[1]")
    public static MaterialButton mobileProgressStepperBackButton;
}
