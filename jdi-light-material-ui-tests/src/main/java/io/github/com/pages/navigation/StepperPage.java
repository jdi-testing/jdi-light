package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileDotsStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileProgressStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileTextStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class StepperPage extends WebPage {

    @JStepper(root = "#simpleStepper")
    public static Stepper simpleLinearStepper;

    @UI("//div[@id='simpleStepper']/..//button[1]")
    public static Button simpleLinearStepperBackButton;

    @UI("//div[@id='simpleStepper']/..//button[2]")
    public static Button simpleLinearStepperNextButton;

    @JStepper(root = "#nonLinearStepper")
    public static Stepper nonlinearStepper;

    @UI("//p[@id='activeNonLinearStep']/..//button[1]")
    public static Button nonlinearStepperBackButton;

    @UI("//p[@id='activeNonLinearStep']/..//button[2]")
    public static Button nonlinearStepperNextButton;

    @UI("//p[@id='activeNonLinearStep']/..//button[3]")
    public static Button nonlinearStepperCompleteStepButton;

    @JStepper(root = ".MuiStepper-vertical")
    public static Stepper verticalStepper;

    @JStepper(root = "(//*[contains(@class, 'MuiMobileStepper-root')])[1]")
    public static MobileTextStepper mobileTextStepper;

    @JStepper(root = "(//*[contains(@class, 'MuiMobileStepper-root')])[2]")
    public static MobileDotsStepper mobileDotsStepper;

    @UI("#activeDotStep")
    public static Text activeDotsStepText;

    @JStepper(root = "(//*[contains(@class, 'MuiMobileStepper-root')])[3]")
    public static MobileProgressStepper mobileProgressStepper;

    @UI("#activeProgressStep")
    public static Text activeProgressStepText;
}
