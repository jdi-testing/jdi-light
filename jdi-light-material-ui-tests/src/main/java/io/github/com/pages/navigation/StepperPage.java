package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.navigation.steppers.MUIStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileStepper;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class StepperPage extends WebPage {

    @UI("#simpleStepper")
    public static MUIStepper simpleLinearStepper;

    @UI("#simpleStepper < * button")
    public static ButtonGroup simpleLinearButtons;

    @UI("p.MuiTypography-root")
    public static Text activeLinearStepText;

    @UI("#nonLinearStepper")
    public static MUIStepper nonlinearStepper;
    @UI("#nonLinearStepper + div button")
    public static ButtonGroup nonLinearButtons;

    @UI("#activeNonLinearStep")
    public static Text activeNonLinearStepText;

    @UI(".MuiStepper-vertical")
    //    buttonGroup = "//div[contains(@class,'MuiStepContent-root')]//button | //p[@id='activeVerticalStep']/..//button")
    public static MUIStepper verticalStepper;

    @UI("#activeVerticalStep")
    public static Text activeVerticalStepText;

    @UI(".MuiMobileStepper-root[1]")
    public static MobileStepper mobileTextStepper;

    @UI(".MuiMobileStepper-root[2]")
    public static MobileStepper mobileDotsStepper;

    @UI("#activeDotStep")
    public static Text activeDotsStepText;

    @UI(".MuiMobileStepper-root[3]")
    public static MobileStepper mobileProgressStepper;

    @UI("#activeProgressStep")
    public static Text activeProgressStepText;
}
