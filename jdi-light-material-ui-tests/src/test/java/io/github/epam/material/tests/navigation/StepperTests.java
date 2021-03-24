package io.github.epam.material.tests.navigation;


import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;


public class StepperTests extends TestsInit {

    @Test
    public void mainStepperTest() {
        navigationStepperHorizontalLinearStepperPage.open();

        stepperFrame.stepper.is().stepperDisplayed();
        stepperFrame.stepperTitle.is().text("You are on Step #1");
        stepperFrame.stepperNextButton.clickNextButton();
        stepperFrame.stepperTitle.is().text("You are on Step #2");
        stepperFrame.stepperNextButton.clickNextButton();
        stepperFrame.stepperTitle.is().text("You are on Step #3");
        stepperFrame.stepperFinishButton.clickFinishButton();
        stepperFrame.stepperTitle.is().text("All steps completed");
        stepperFrame.stepperResetButton.clickResetButton();
        stepperFrame.stepperTitle.is().text("You are on Step #1");
        stepperFrame.stepperNextButton.clickNextButton();
        stepperFrame.stepperBackButton.clickBackButton();
        stepperFrame.stepperTitle.is().text("You are on Step #1");
    }

    @Test
    public void skipButtonStepperTest() {
        navigationStepperWithOptionalStepPage.open();

        stepperFrame.stepper.is().stepperDisplayed();
        stepperFrame.stepperTitle.is().text("You are on Step #1");
        stepperFrame.stepperNextButton.clickNextButton();
        stepperFrame.stepperSkipButton.clickSkipButton();
        stepperFrame.stepperTitle.is().text("You are on Step #3");
    }

    @Test
    public void completeButtonStepperTest() {
        navigationStepperNonlinearStepperPage.open();

        stepperFrame.stepper.is().stepperDisplayed();
        stepperFrame.stepperTitle.is().text("You are on Step #1");
        stepperFrame.stepperCompleteButton.clickCompleteStepButton();
        stepperFrame.stepperTitle.is().text("You are on Step #2");
        stepperFrame.stepperCompleteButton.clickCompleteStepButton();
        stepperFrame.stepperTitle.is().text("You are on Step #3");
        stepperFrame.stepperFinishButton.clickFinishButton();
        stepperFrame.stepperTitle.is().text("All steps completed - you're finished");
    }
}
