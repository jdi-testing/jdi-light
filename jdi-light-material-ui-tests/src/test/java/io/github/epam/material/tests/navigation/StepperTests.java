package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.stepperPage;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepperTitle;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepperTitle;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepperTitle;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepper;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepperCompleteStepButton;
import static io.github.com.pages.navigation.StepperPage.nonlinearStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepper;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.simpleLinearStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.verticalStepper;
import static io.github.com.pages.navigation.StepperPage.verticalStepperBackButton;
import static io.github.com.pages.navigation.StepperPage.verticalStepperNextButton;
import static io.github.com.pages.navigation.StepperPage.verticalStepperResetButton;


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
    public void simpleLinearStepperForwardTest() {
        simpleLinearStepper.show();
        simpleLinearStepper.is().displayed().and().has().steps(Arrays.asList(steps));

        simpleLinearStepper.is().stepEnabled(1).and().stepIncomplete(1);
        simpleLinearStepper.is().stepDisabled(2).and().stepIncomplete(2);
        simpleLinearStepper.is().stepDisabled(3).and().stepIncomplete(3);

        simpleLinearStepperNextButton.click();
        simpleLinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        simpleLinearStepper.is().stepEnabled(2).and().stepIncomplete(2);
        simpleLinearStepper.is().stepDisabled(3).and().stepIncomplete(3);

        simpleLinearStepperNextButton.click();
        simpleLinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        simpleLinearStepper.is().stepEnabled(2).and().stepCompleted(2);
        simpleLinearStepper.is().stepEnabled(3).and().stepIncomplete(3);

        simpleLinearStepperNextButton.click();
        simpleLinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        simpleLinearStepper.is().stepEnabled(2).and().stepCompleted(2);
        simpleLinearStepper.is().stepEnabled(3).and().stepCompleted(3);
    }

    @Test
    public void simpleLinearStepperBackTest() {
        simpleLinearStepper.show();
        simpleLinearStepper.is().displayed().and().has().steps(Arrays.asList(steps));

        simpleLinearStepperNextButton.click();
        simpleLinearStepperNextButton.click();
        simpleLinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        simpleLinearStepper.is().stepEnabled(2).and().stepCompleted(2);
        simpleLinearStepper.is().stepEnabled(3).and().stepIncomplete(3);

        simpleLinearStepperBackButton.click();
        simpleLinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        simpleLinearStepper.is().stepEnabled(2).and().stepIncomplete(2);
        simpleLinearStepper.is().stepDisabled(3).and().stepIncomplete(3);

        simpleLinearStepperBackButton.click();
        simpleLinearStepper.is().stepEnabled(1).and().stepIncomplete(1);
        simpleLinearStepper.is().stepDisabled(2).and().stepIncomplete(2);
        simpleLinearStepper.is().stepDisabled(3).and().stepIncomplete(3);
    }

    @Test
    public void nonlinearStepperForwardTest() {
        nonlinearStepper.show();
        nonlinearStepper.is().displayed().and().has().steps(Arrays.asList(steps));
        nonlinearStepper.is().stepEnabled(1).and().stepIncomplete(1);
        nonlinearStepper.is().stepDisabled(2).and().stepIncomplete(2);
        nonlinearStepper.is().stepDisabled(3).and().stepIncomplete(3);

        nonlinearStepperNextButton.click();
        nonlinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        nonlinearStepper.is().stepEnabled(2).and().stepIncomplete(2);
        nonlinearStepper.is().stepDisabled(3).and().stepIncomplete(3);

        nonlinearStepperNextButton.click();
        nonlinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        nonlinearStepper.is().stepEnabled(2).and().stepCompleted(2);
        nonlinearStepper.is().stepEnabled(3).and().stepIncomplete(3);

        nonlinearStepper.list().get(2).click();
        nonlinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        nonlinearStepper.is().stepEnabled(2).and().stepIncomplete(2);
        nonlinearStepper.is().stepDisabled(3).and().stepIncomplete(3);

        nonlinearStepperCompleteStepButton.click();
        nonlinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        nonlinearStepper.is().stepEnabled(2).and().stepCompleted(2);
        nonlinearStepper.is().stepEnabled(3).and().stepIncomplete(3);
    }

    @Test
    public void nonlinearStepperBackTest() {
        nonlinearStepper.show();
        nonlinearStepper.is().displayed().and().has().steps(Arrays.asList(steps));
        nonlinearStepper.is().stepEnabled(1).and().stepDisabled(2).and().stepDisabled(3);

        nonlinearStepperNextButton.click();
        nonlinearStepperNextButton.click();
        nonlinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        nonlinearStepper.is().stepEnabled(2).and().stepCompleted(2);
        nonlinearStepper.is().stepEnabled(3).and().stepIncomplete(3);

        nonlinearStepperBackButton.click();
        nonlinearStepper.is().stepEnabled(1).and().stepCompleted(1);
        nonlinearStepper.is().stepEnabled(2).and().stepIncomplete(2);
        nonlinearStepper.is().stepDisabled(3).and().stepIncomplete(3);
    }

    @Test
    public void verticalStepperForwardTest() {
        String[] steps = {"Select campaign settings", "Create an ad group", "Create an ad"};

        verticalStepper.show();
        verticalStepper.is().displayed().and().has().steps(Arrays.asList(steps));
        verticalStepper.is().stepEnabled(1).and().stepIncomplete(1);
        verticalStepper.is().stepDisabled(2).and().stepIncomplete(2);
        verticalStepper.is().stepDisabled(3).and().stepIncomplete(3);

        verticalStepperNextButton.click();
        verticalStepper.is().stepEnabled(1).and().stepCompleted(1);
        verticalStepper.is().stepEnabled(2).and().stepIncomplete(2);
        verticalStepper.is().stepDisabled(3).and().stepIncomplete(3);

        verticalStepperNextButton.click();
        verticalStepper.is().stepEnabled(1).and().stepCompleted(1);
        verticalStepper.is().stepEnabled(2).and().stepCompleted(2);
        verticalStepper.is().stepEnabled(3).and().stepIncomplete(3);

        verticalStepperNextButton.click();
        verticalStepper.is().stepEnabled(1).and().stepCompleted(1);
        verticalStepper.is().stepEnabled(2).and().stepCompleted(2);
        verticalStepper.is().stepEnabled(3).and().stepCompleted(3);

        verticalStepperResetButton.click();
    }

    @Test
    public void verticalStepperBackTest() {
        String[] steps = {"Select campaign settings", "Create an ad group", "Create an ad"};

        verticalStepper.show();
        verticalStepper.is().displayed().and().has().steps(Arrays.asList(steps));

        verticalStepperNextButton.click();
        verticalStepperNextButton.click();
        verticalStepper.is().stepEnabled(1).and().stepCompleted(1);
        verticalStepper.is().stepEnabled(2).and().stepCompleted(2);
        verticalStepper.is().stepEnabled(3).and().stepIncomplete(3);

        verticalStepperBackButton.click();
        verticalStepper.is().stepEnabled(1).and().stepCompleted(1);
        verticalStepper.is().stepEnabled(2).and().stepIncomplete(2);
        verticalStepper.is().stepDisabled(3).and().stepIncomplete(3);

        verticalStepperBackButton.click();
        verticalStepper.is().stepEnabled(1).and().stepIncomplete(1);
        verticalStepper.is().stepDisabled(2).and().stepIncomplete(2);
        verticalStepper.is().stepDisabled(3).and().stepIncomplete(3);
    }

    @Test
    public void mobileTextStepperTest() {
        mobileTextStepperTitle.show();
        mobileTextStepperTitle.is().text("BACK\n1 / 5\nNEXT");
        mobileTextStepperNextButton.click();
        mobileTextStepperTitle.is().text("BACK\n2 / 5\nNEXT");
        mobileTextStepperBackButton.click();
        mobileTextStepperTitle.is().text("BACK\n1 / 5\nNEXT");
        mobileTextStepperNextButton.click();
        mobileTextStepperTitle.is().text("BACK\n2 / 5\nNEXT");
        mobileTextStepperNextButton.click();
        mobileTextStepperTitle.is().text("BACK\n3 / 5\nNEXT");
        mobileTextStepperNextButton.click();
        mobileTextStepperTitle.is().text("BACK\n4 / 5\nNEXT");
        mobileTextStepperNextButton.click();
        mobileTextStepperTitle.is().text("BACK\n5 / 5\nNEXT");
    }

    @Test
    public void mobileDotsTest() {
        mobileDotsStepperTitle.show();
        mobileDotsStepperTitle.is().text("You are on Step 0");
        mobileDotsStepperNextButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 1");
        mobileDotsStepperBackButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 0");
        mobileDotsStepperNextButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 1");
        mobileDotsStepperNextButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 2");
        mobileDotsStepperNextButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 3");
        mobileDotsStepperNextButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 4");
        mobileDotsStepperNextButton.click();
        mobileDotsStepperTitle.is().text("You are on Step 5");
    }

    @Test
    public void mobileProgressTest() {
        mobileProgressStepperTitle.is().text("You are on Step 0");
        mobileProgressStepperNextButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 1");
        mobileProgressStepperBackButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 0");
        mobileProgressStepperNextButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 1");
        mobileProgressStepperNextButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 2");
        mobileProgressStepperNextButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 3");
        mobileProgressStepperNextButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 4");
        mobileProgressStepperNextButton.click();
        mobileProgressStepperTitle.is().text("You are on Step 5");
    }
}
