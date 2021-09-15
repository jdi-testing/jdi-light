package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.stepperPage;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepperButton;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepperTitle;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepperButton;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepperTitle;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepperButton;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepperTitle;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepper;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepperCompleteStepButton;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepper;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.verticalStepper;
import static io.github.com.pages.navigation.StepperPage.verticalStepperNextButton;


/**
 * To see an example of Steppers please visit
 * https://material-ui.com/components/steppers/
 */

public class StepperTests extends TestsInit {
    private final String[] steps = {"Step #1", "Step #2", "Step #3"};

    @BeforeMethod
    public void chooseSection() {
        stepperPage.open();
        stepperPage.isOpened();
    }

    @Test
    public void simpleLinearStepperTest() {
        simpleLinearStepper.is().displayed().and().has().steps(Arrays.asList(steps));

        simpleLinearStepper.steps().get(0).is().enabled().and().incomplete();
        simpleLinearStepper.steps().get(1).is().disabled().and().incomplete();
        simpleLinearStepper.steps().get(2).is().disabled().and().incomplete();

        simpleLinearStepperNextButton.click();

        simpleLinearStepper.steps().get(0).is().enabled().and().completed();
        simpleLinearStepper.steps().get(1).is().enabled().and().incomplete();
        simpleLinearStepper.steps().get(2).is().disabled().and().incomplete();

        simpleLinearStepperNextButton.click();

        simpleLinearStepper.steps().get(0).is().enabled().and().completed();
        simpleLinearStepper.steps().get(1).is().enabled().and().completed();
        simpleLinearStepper.steps().get(2).is().enabled().and().incomplete();

        simpleLinearStepperBackButton.click();

        simpleLinearStepper.steps().get(0).is().enabled().and().completed();
        simpleLinearStepper.steps().get(1).is().enabled().and().incomplete();
        simpleLinearStepper.steps().get(2).is().disabled().and().incomplete();

        simpleLinearStepperNextButton.click();
        simpleLinearStepperNextButton.click();

        simpleLinearStepper.steps().get(0).is().enabled().and().completed();
        simpleLinearStepper.steps().get(1).is().enabled().and().completed();
        simpleLinearStepper.steps().get(2).is().enabled().and().completed();
    }

    @Test
    public void nonlinearStepperTest() {
        nonlinearStepper.is().displayed().and().has().steps(Arrays.asList(steps));

        nonlinearStepper.steps().get(0).is().enabled();
        nonlinearStepper.steps().get(1).is().disabled();
        nonlinearStepper.steps().get(2).is().disabled();

        nonlinearStepperNextButton.click();
        nonlinearStepper.steps().get(1).is().enabled();
        nonlinearStepper.steps().get(2).is().disabled();

        nonlinearStepperNextButton.click();
        nonlinearStepper.steps().get(2).is().enabled();

        nonlinearStepper.steps().get(1).click();
        nonlinearStepper.steps().get(1).is().enabled();

        nonlinearStepper.steps().get(0).click();
        nonlinearStepper.steps().get(0).is().enabled().and().incomplete();
        nonlinearStepper.steps().get(1).is().disabled();

        nonlinearStepperCompleteStepButton.click();
        nonlinearStepper.steps().get(0).is().enabled().and().completed();
        nonlinearStepper.steps().get(1).is().enabled().and().incomplete();
    }

    @Test
    public void verticalStepperTest() {
        String[] steps = {"Select campaign settings", "Create an ad group", "Create an ad"};

        verticalStepper.is().displayed().and().has().steps(Arrays.asList(steps));

        verticalStepper.steps().get(0).is().enabled().and().incomplete();
        verticalStepper.steps().get(1).is().disabled().and().incomplete();
        verticalStepper.steps().get(2).is().disabled().and().incomplete();

        verticalStepperNextButton.click();

        verticalStepper.steps().get(0).is().enabled().and().completed();
        verticalStepper.steps().get(1).is().enabled().and().incomplete();
        verticalStepper.steps().get(2).is().disabled().and().incomplete();

        verticalStepperNextButton.click();

        verticalStepper.steps().get(0).is().enabled().and().completed();
        verticalStepper.steps().get(1).is().enabled().and().completed();
        verticalStepper.steps().get(2).is().enabled().and().incomplete();

        verticalStepperNextButton.click();

        verticalStepper.steps().get(0).is().enabled().and().completed();
        verticalStepper.steps().get(1).is().enabled().and().completed();
        verticalStepper.steps().get(2).is().enabled().and().completed();
    }

    @Test
    public void mobileTextStepperTest() {
        mobileTextStepperTitle.is().text("BACK\n1 / 5\nNEXT");
        mobileTextStepperButton.get(2).click();
        mobileTextStepperTitle.is().text("BACK\n2 / 5\nNEXT");
        mobileTextStepperButton.get(1).click();
        mobileTextStepperTitle.is().text("BACK\n1 / 5\nNEXT");
        mobileTextStepperButton.get(2).click();
        mobileTextStepperTitle.is().text("BACK\n2 / 5\nNEXT");
        mobileTextStepperButton.get(2).click();
        mobileTextStepperTitle.is().text("BACK\n3 / 5\nNEXT");
        mobileTextStepperButton.get(2).click();
        mobileTextStepperTitle.is().text("BACK\n4 / 5\nNEXT");
        mobileTextStepperButton.get(2).click();
        mobileTextStepperTitle.is().text("BACK\n5 / 5\nNEXT");
    }

    @Test
    public void mobileDotsTest() {
        mobileDotsStepperTitle.is().text("You are on Step 0");
        mobileDotsStepperButton.get(2).click();
        mobileDotsStepperTitle.is().text("You are on Step 1");
        mobileDotsStepperButton.get(1).click();
        mobileDotsStepperTitle.is().text("You are on Step 0");
        mobileDotsStepperButton.get(2).click();
        mobileDotsStepperTitle.is().text("You are on Step 1");
        mobileDotsStepperButton.get(2).click();
        mobileDotsStepperTitle.is().text("You are on Step 2");
        mobileDotsStepperButton.get(2).click();
        mobileDotsStepperTitle.is().text("You are on Step 3");
        mobileDotsStepperButton.get(2).click();
        mobileDotsStepperTitle.is().text("You are on Step 4");
        mobileDotsStepperButton.get(2).click();
        mobileDotsStepperTitle.is().text("You are on Step 5");
    }

    @Test
    public void mobileProgressTest() {
        mobileProgressStepperTitle.is().text("You are on Step 0");
        mobileProgressStepperButton.get(2).click();
        mobileProgressStepperTitle.is().text("You are on Step 1");
        mobileProgressStepperButton.get(1).click();
        mobileProgressStepperTitle.is().text("You are on Step 0");
        mobileProgressStepperButton.get(2).click();
        mobileProgressStepperTitle.is().text("You are on Step 1");
        mobileProgressStepperButton.get(2).click();
        mobileProgressStepperTitle.is().text("You are on Step 2");
        mobileProgressStepperButton.get(2).click();
        mobileProgressStepperTitle.is().text("You are on Step 3");
        mobileProgressStepperButton.get(2).click();
        mobileProgressStepperTitle.is().text("You are on Step 4");
        mobileProgressStepperButton.get(2).click();
        mobileProgressStepperTitle.is().text("You are on Step 5");
    }
}
