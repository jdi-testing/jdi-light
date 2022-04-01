package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.stepperPage;
import static io.github.com.pages.navigation.StepperPage.activeDotsStepText;
import static io.github.com.pages.navigation.StepperPage.activeLinearStepText;
import static io.github.com.pages.navigation.StepperPage.activeNonLinearStepText;
import static io.github.com.pages.navigation.StepperPage.activeProgressStepText;
import static io.github.com.pages.navigation.StepperPage.activeVerticalStepText;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepper;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepper;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepper;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepper;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepper;
import static io.github.com.pages.navigation.StepperPage.verticalStepper;

public class StepperTests extends TestsInit {
    private final String[] stepsLabels = {"Step #1", "Step #2", "Step #3"};

    @BeforeMethod
    public void chooseSection() {
        stepperPage.open();
        stepperPage.isOpened();
    }

    @Test
    public void simpleLinearStepperTest() {
        simpleLinearStepper.show();
        simpleLinearStepper.is().displayed().and()
                .has().cssClass("MuiStepper-horizontal").and().steps(stepsLabels);

        simpleLinearStepper.step(1).is().enabled().and().incomplete();
        simpleLinearStepper.step(2).is().disabled().and().incomplete();
        simpleLinearStepper.step(3).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #1");

        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        simpleLinearStepper.step(1).is().enabled().and().completed();
        simpleLinearStepper.step(2).is().enabled().and().incomplete();
        simpleLinearStepper.step(3).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #2");

        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        simpleLinearStepper.step(1).is().enabled().and().completed();
        simpleLinearStepper.step(2).is().enabled().and().completed();
        simpleLinearStepper.step(3).is().enabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #3");

        simpleLinearStepper.buttonGroup().getButtonByIndex(1).click();
        simpleLinearStepper.step(1).is().enabled().and().completed();
        simpleLinearStepper.step(2).is().enabled().and().incomplete();
        simpleLinearStepper.step(3).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #2");

        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        simpleLinearStepper.step(1).is().enabled().and().completed();
        simpleLinearStepper.step(2).is().enabled().and().completed();
        simpleLinearStepper.step(3).is().enabled().and().completed();
        activeLinearStepText.has().text("All steps completed");

        simpleLinearStepper.buttonGroup().getButtonByIndex(1).click();
        simpleLinearStepper.step(1).is().enabled().and().incomplete();
        simpleLinearStepper.step(2).is().disabled().and().incomplete();
        simpleLinearStepper.step(3).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #1");
    }

    @Test
    public void nonlinearStepperTest() {
        nonlinearStepper.show();
        nonlinearStepper.is().displayed().and().has().steps(stepsLabels);

        nonlinearStepper.step(1).is().enabled().and().incomplete();
        nonlinearStepper.step(2).is().disabled().and().incomplete();
        nonlinearStepper.step(3).is().disabled().and().incomplete();
        activeNonLinearStepText.has().text("You are on Step #1");

        nonlinearStepper.buttonGroup().getButtonByIndex(3).click();
        nonlinearStepper.buttonGroup().getButtonByIndex(3).click();
        nonlinearStepper.buttonGroup().getButtonByIndex(2).click();
        nonlinearStepper.step(1).is().enabled().and().completed();
        nonlinearStepper.step(2).is().enabled().and().completed();
        nonlinearStepper.step(3).is().enabled().and().incomplete();
        activeNonLinearStepText.has().text("You are on Step #3");

        nonlinearStepper.step(2).click();
        nonlinearStepper.step(1).is().enabled().and().completed();
        nonlinearStepper.step(2).is().enabled().and().incomplete();
        nonlinearStepper.step(3).is().disabled().and().incomplete();
        activeNonLinearStepText.has().text("You are on Step #2");
    }


    @Test
    public void verticalStepperTest() {
        String[] stepsLabels = {"Select campaign settings", "Create an ad group", "Create an ad"};

        verticalStepper.show();
        verticalStepper.is().displayed().and()
                .has().cssClass("MuiStepper-vertical").has().steps(stepsLabels)
                .and().allStepsIncomplete();
        activeVerticalStepText.has().text("You are on Step 0");

        verticalStepper.buttonGroup().getButtonByText("Next").click();
        verticalStepper.buttonGroup().getButtonByText("Next").click();
        activeVerticalStepText.has().text("You are on Step 2");

        verticalStepper.buttonGroup().getButtonByText("Finish").click();
        activeVerticalStepText.has().text("You are on Step 3");
        verticalStepper.has().allStepsCompleted();

        verticalStepper.buttonGroup().getButtonByText("Reset").click();
        verticalStepper.has().allStepsIncomplete();
    }

    @Test
    public void mobileTextStepperTest() {
        mobileTextStepper.show();
        mobileTextStepper.is().displayed()
                .and().has().currentIndex(1).and().maxIndex(5);

        mobileTextStepper.nextButton().click();
        mobileTextStepper.nextButton().click();
        mobileTextStepper.nextButton().click();
        mobileTextStepper.has().currentIndex(4);

        mobileTextStepper.backButton().click();
        mobileTextStepper.has().currentIndex(3);
    }

    @Test
    public void mobileDotsTest() {
        mobileDotsStepper.show();
        mobileDotsStepper.is().displayed().and().has().currentIndex(1).and().maxIndex(6);

        for (int i = 0; i < 5; i++) {
            activeDotsStepText.has().text("You are on Step " + i);
            mobileDotsStepper.has().currentIndex(i + 1);
            mobileDotsStepper.nextButton().click();
        }
        activeDotsStepText.has().text("You are on Step 5");
        mobileDotsStepper.has().currentIndex(6);
        mobileDotsStepper.backButton().click();
        activeDotsStepText.has().text("You are on Step 4");
        mobileDotsStepper.has().currentIndex(5);
    }

    @Test
    public void mobileProgressTest() {
        mobileProgressStepper.show();
        mobileProgressStepper.is().displayed().and().has().currentIndex(0).and().maxIndex(100);

        for (int i = 0, value = 0; i < 5; i++, value += 20) {
            activeProgressStepText.has().text("You are on Step " + i);
            mobileProgressStepper.has().currentIndex(value);
            mobileProgressStepper.nextButton().click();
        }
        activeProgressStepText.has().text("You are on Step 5");
        mobileProgressStepper.has().currentIndex(100);
        mobileProgressStepper.backButton().click();
        mobileProgressStepper.has().currentIndex(80);
        activeProgressStepText.is().text("You are on Step 4");
    }
}
