package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class StepperPage extends WebPage {
    @UI("//*[@id='simpleStepper']//following-sibling::div//*[@class='MuiTypography-root MuiTypography-body1']")
    public static Text simpleLinearStepperTitle;

    @UI("//*[@id='simpleStepper']//following-sibling::div//button[contains(@class, 'MuiButtonBase-root')]")
    public static WebList simpleLinearStepperButton;

    @UI("//*[@id='nonLinearStepper']//following-sibling::div//*[@class='MuiTypography-root MuiTypography-body1']")
    public static Text nonlinearStepperTitle;

    @UI("//*[@id='nonLinearStepper']//following-sibling::div//button[contains(@class, 'MuiButtonBase-root')]")
    public static WebList nonlinearStepperButton;

    @UI("(//*[text()='Vertical stepper']/following-sibling::div//p)[1]")
    public static Text verticalStepperTitle;

    @UI("//*[text()='Vertical stepper']/following-sibling::div//button[contains(@class, MuiButtonBase-root)]")
    public static WebList verticalStepperButton;

    @UI("(//*[text()='Mobile text stepper']/following-sibling::div//*[contains(@class, 'MuiMobileStepper-root')])[1]")
    public static Text mobileTextStepperTitle;

    @UI("//*[text()='Mobile text stepper']/following-sibling::div//button")
    public static WebList mobileTextStepperButton;

    @UI("//*[@id='activeDotStep']")
    public static Text mobileDotsStepperTitle;

    @UI("//*[text()='Mobile dots stepper']/following-sibling::div//button")
    public static WebList mobileDotsStepperButton;

    @UI("//*[@id='activeProgressStep']")
    public static Text mobileProgressStepperTitle;

    @UI("//*[text()='Mobile progress stepper']/following-sibling::div//button")
    public static WebList mobileProgressStepperButton;
}
