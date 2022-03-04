package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileDotsStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileProgressStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileTextStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.Stepper;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.steppers.VerticalStepper;

public class StepperPage extends WebPage {

    @JStepper(root = "#simpleStepper",
        buttonGroup = "//div[@id='simpleStepper']/..//button/..")
    public static Stepper simpleLinearStepper;

    @UI("p.MuiTypography-root")
    public static Text activeLinearStepText;

    @JStepper(root = "#nonLinearStepper",
        buttonGroup = "#nonLinearStepper + div p + div")
    public static Stepper nonlinearStepper;

    @UI("#activeNonLinearStep")
    public static Text activeNonLinearStepText;

    @JStepper(root = ".MuiStepper-vertical",
        buttonGroup = "//p[@id='activeVerticalStep']/../div[2]")
    public static VerticalStepper verticalStepper;

    @UI("#activeVerticalStep")
    public static Text activeVerticalStepText;

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
