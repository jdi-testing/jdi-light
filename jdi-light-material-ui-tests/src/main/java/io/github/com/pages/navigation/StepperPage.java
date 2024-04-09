package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.material.elements.navigation.steppers.MUIStepper;
import com.epam.jdi.light.material.elements.navigation.steppers.MobileStepper;
import com.epam.jdi.light.ui.html.elements.common.Text;


public class StepperPage extends WebPage {

    @UI("#simpleStepper")
    public static MUIStepper simpleLinearStepper;

    @UI("#simpleStepper < * button")
    public static WebList simpleLinearButtons;

    @UI("p.MuiTypography-root")
    public static Text activeLinearStepText;

    @UI("#nonLinearStepper")
    public static MUIStepper nonlinearStepper;
    @UI("#nonLinearStepper + div button")
    public static WebList nonLinearButtons;

    @UI("#activeNonLinearStep")
    public static Text activeNonLinearStepText;

    @UI(".MuiStepper-vertical")
    public static MUIStepper verticalStepper;

    @UI("//button[./span[text()='Reset']]")
    public static MUIButton resetVerticalStepButton;
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
