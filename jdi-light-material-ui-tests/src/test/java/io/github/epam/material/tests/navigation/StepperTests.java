package io.github.epam.material.tests.navigation;

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

import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import io.github.epam.TestsInit;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
            .has().cssClass("MuiStepper-horizontal").and().stepsLabels(stepsLabels);
        List<? extends Step> steps = simpleLinearStepper.steps();

        steps.get(0).is().enabled().and().incomplete();
        steps.get(1).is().disabled().and().incomplete();
        steps.get(2).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #1");

        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        steps.get(0).is().enabled().and().completed();
        steps.get(1).is().enabled().and().incomplete();
        steps.get(2).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #2");

        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        steps.get(0).is().enabled().and().completed();
        steps.get(1).is().enabled().and().completed();
        steps.get(2).is().enabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #3");

        simpleLinearStepper.buttonGroup().getButtonByIndex(1).click();
        steps.get(0).is().enabled().and().completed();
        steps.get(1).is().enabled().and().incomplete();
        steps.get(2).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #2");

        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        simpleLinearStepper.buttonGroup().getButtonByIndex(2).click();
        steps.get(0).is().enabled().and().completed();
        steps.get(1).is().enabled().and().completed();
        steps.get(2).is().enabled().and().completed();
        activeLinearStepText.has().text("All steps completed");

        simpleLinearStepper.buttonGroup().getButtonByIndex(1).click();
        steps.get(0).is().enabled().and().incomplete();
        steps.get(1).is().disabled().and().incomplete();
        steps.get(2).is().disabled().and().incomplete();
        activeLinearStepText.has().text("You are on Step #1");
    }

    @Test
    public void nonlinearStepperForwardTest() {
        nonlinearStepper.show();
        nonlinearStepper.is().displayed().and().has().stepsLabels(stepsLabels);
        List<? extends Step> steps = nonlinearStepper.steps();

        steps.get(0).is().enabled().and().incomplete();
        steps.get(1).is().disabled().and().incomplete();
        steps.get(2).is().disabled().and().incomplete();
        activeNonLinearStepText.has().text("You are on Step #1");

        nonlinearStepper.buttonGroup().getButtonByIndex(3).click();
        nonlinearStepper.buttonGroup().getButtonByIndex(3).click();
        nonlinearStepper.buttonGroup().getButtonByIndex(2).click();
        steps.get(0).is().enabled().and().completed();
        steps.get(1).is().enabled().and().completed();
        steps.get(2).is().enabled().and().incomplete();
        activeNonLinearStepText.has().text("You are on Step #3");

        steps.get(1).click();
        steps.get(0).is().enabled().and().completed();
        steps.get(1).is().enabled().and().incomplete();
        steps.get(2).is().disabled().and().incomplete();
        activeNonLinearStepText.has().text("You are on Step #2");
    }


    @Test
    public void verticalStepperTest() {
        String[] stepsLabels = {"Select campaign settings", "Create an ad group", "Create an ad"};

        verticalStepper.show();
        verticalStepper.is().displayed().and()
            .has().cssClass("MuiStepper-vertical").has().stepsLabels(stepsLabels)
            .and().allStepsIncomplete();

        verticalStepper.step(1).content().has().text("You are on Step 0");
        verticalStepper.step(1).buttonGroup().getButtonByText("Next").click();
        verticalStepper.step(2).buttonGroup().getButtonByText("Next").click();
        verticalStepper.step(3).content().has().text("You are on Step 2");
        verticalStepper.step(3).buttonGroup().getButtonByText("Finish").click();
        activeVerticalStepText.has().text("You are on Step 3");
        verticalStepper.has().allStepsCompleted();

        verticalStepper.buttonGroup().getButtonByText("Reset").click();
        verticalStepper.has().allStepsIncomplete();
    }

    @Test
    public void mobileTextStepperTest() {
        mobileTextStepper.show();
        mobileTextStepper.is().displayed()
            .and().has().value(1).and().maxValue(5);

        mobileTextStepper.buttonGroup().getButtonByText("Next").click();
        mobileTextStepper.buttonGroup().getButtonByText("Next").click();
        mobileTextStepper.buttonGroup().getButtonByText("Next").click();
        mobileTextStepper.has().value(4);

        mobileTextStepper.buttonGroup().getButtonByText("Back").click();
        mobileTextStepper.has().value(3);
    }

    @Test
    public void mobileDotsTest() {
        mobileDotsStepper.show();
        mobileDotsStepper.is().displayed().and().has().value(1).and().maxValue(6);

        for (int i = 0; i < 5; i++) {
            activeDotsStepText.has().text("You are on Step " + i);
            mobileDotsStepper.has().value(i + 1);
            mobileDotsStepper.buttonGroup().getButtonByText("Next").click();
        }
        activeDotsStepText.has().text("You are on Step 5");
        mobileDotsStepper.has().value(6);
        mobileDotsStepper.buttonGroup().getButtonByText("Back").click();
        activeDotsStepText.has().text("You are on Step 4");
        mobileDotsStepper.has().value(5);
    }

    @Test
    public void mobileProgressTest() {
        mobileProgressStepper.show();
        mobileProgressStepper.is().displayed().and().has().value(0).and().maxValue(100);
        mobileProgressStepper.progress.is().displayed();
        for (int i = 0, value = 0; i < 5; i++, value += 20) {
            activeProgressStepText.has().text("You are on Step " + i);
            mobileProgressStepper.has().value(value);
            mobileProgressStepper.buttonGroup().getButtonByText("Next").click();
        }
        activeProgressStepText.has().text("You are on Step 5");
        mobileProgressStepper.has().value(100);
        mobileProgressStepper.buttonGroup().getButtonByText("Back").click();
        mobileProgressStepper.has().value(80);
        activeProgressStepText.is().text("You are on Step 4");
    }
}
