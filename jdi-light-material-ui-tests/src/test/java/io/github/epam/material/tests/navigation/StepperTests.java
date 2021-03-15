package io.github.epam.material.tests.navigation;


import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;


public class StepperTests extends TestsInit {

    @Test
    public void mainStepperTest() {
        navigationStepperHorizontalLinearStepperPage.open();
        stepperFrame.stepper.is().stepperDisplayed();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #1");
        stepperFrame.stepper.clickNextButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #2");
        stepperFrame.stepper.clickNextButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #3");
        stepperFrame.stepper.clickFinishButton();
        stepperFrame.stepper.is().stepTitleDisplayed("All steps completed");
        stepperFrame.stepper.clickResetButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #1");
        stepperFrame.stepper.clickNextButton();
        stepperFrame.stepper.clickBackButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #1");
    }

    @Test
    public void skipButtonStepperTest() {
        navigationStepperWithOptionalStepPage.open();
        stepperFrame.stepper.is().stepperDisplayed();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #1");
        stepperFrame.stepper.clickNextButton();
        stepperFrame.stepper.clickSkipButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #3");
    }

    @Test
    public void completeButtonStepperTest() {
        navigationStepperNonlinearStepperPage.open();
        stepperFrame.stepper.is().stepperDisplayed();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #1");
        stepperFrame.stepper.clickCompleteStepButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #2");
        stepperFrame.stepper.clickCompleteStepButton();
        stepperFrame.stepper.is().stepTitleDisplayed("You are on Step #3");
        stepperFrame.stepper.clickFinishButton();
        stepperFrame.stepper.is().stepTitleDisplayed("All steps completed - you're finished");
    }
}
