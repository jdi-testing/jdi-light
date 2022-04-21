package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.DesktopStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileStepper;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class StepperPage extends WebPage {

    @JStepper(root = "#simpleStepper",
        buttonGroup = "#simpleStepper < * button")
    public static DesktopStepper simpleLinearStepper;

    @UI("p.MuiTypography-root")
    public static Text activeLinearStepText;

    @JStepper(root = "#nonLinearStepper",
        buttonGroup = "#nonLinearStepper + div button")
    public static DesktopStepper nonlinearStepper;

    @UI("#activeNonLinearStep")
    public static Text activeNonLinearStepText;

    @JStepper(root = ".MuiStepper-vertical",
        buttonGroup = "//div[contains(@class,'MuiStepContent-root')]//button | //p[@id='activeVerticalStep']/..//button")
    public static DesktopStepper verticalStepper;

    @UI("#activeVerticalStep")
    public static Text activeVerticalStepText;

    @JStepper(root = ".MuiMobileStepper-root[1]")
    public static MobileStepper mobileTextStepper;

    @JStepper(root = ".MuiMobileStepper-root[2]")
    public static MobileStepper mobileDotsStepper;

    @UI("#activeDotStep")
    public static Text activeDotsStepText;

    @JStepper(root = ".MuiMobileStepper-root[3]")
    public static MobileStepper mobileProgressStepper;

    @UI("#activeProgressStep")
    public static Text activeProgressStepText;
}
