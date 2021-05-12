package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIStepper;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.ArrayList;

public class StepperPage extends WebPage {
    //Simple Linear Stepper
    @UI("//*[@id='simpleStepper']//following-sibling::div//*[@class='MuiTypography-root MuiTypography-body1']")
    public static Text simpleLinearStepperTitle;

    @UI("//*[@id='simpleStepper']//following-sibling::div//button[contains(@class, 'MuiButtonBase-root')]")
    public static WebList simpleLinearStepperButton;

    //Non-linear Stepper
    @UI("//*[@id='nonLinearStepper']//following-sibling::div//*[@class='MuiTypography-root MuiTypography-body1']")
    public static Text nonlinearStepperTitle;

    @UI("//*[@id='nonLinearStepper']//following-sibling::div//button[contains(@class, 'MuiButtonBase-root')]")
    public static WebList nonlinearStepperButton;

    //Vertical Stepper
    @UI("(//*[text()='Vertical stepper']/following-sibling::div//p)[1]")
    public static Text verticalStepperTitle;

    @UI("//*[text()='Vertical stepper']/following-sibling::div//button[contains(@class, MuiButtonBase-root)]")
    public static WebList verticalStepperButton;

    //Mobile Text Stepper
    @UI("(//*[text()='Mobile text stepper']/following-sibling::div//*[contains(@class, 'MuiMobileStepper-root')])[1]")
    public static Text mobileTextStepperTitle;

    @UI("//*[text()='Mobile text stepper']/following-sibling::div//button")
    public static WebList mobileTextStepperButton;

    //Mobile Dots Stepper
    @UI("//*[@id='activeDotStep']")
    public static Text mobileDotsStepperTitle;

    @UI("//*[text()='Mobile dots stepper']/following-sibling::div//button")
    public static WebList mobileDotsStepperButton;

    //Mobile Progress Stepper
    @UI("//*[@id='activeProgressStep']")
    public static Text mobileProgressStepperTitle;

    @UI("//*[text()='Mobile progress stepper']/following-sibling::div//button")
    public static WebList mobileProgressStepperButton;
}
