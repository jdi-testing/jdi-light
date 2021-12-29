package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.material.elements.navigation.Stepper;
import com.epam.jdi.light.ui.html.elements.common.Button;
import static io.github.com.StaticSite.stepperPage;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepper;
import static io.github.com.pages.navigation.StepperPage.mobileDotsStepperTitle;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepper;
import static io.github.com.pages.navigation.StepperPage.mobileProgressStepperTitle;
import static io.github.com.pages.navigation.StepperPage.mobileTextStepper;
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
import io.github.epam.TestsInit;
import java.util.Arrays;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StepperTests extends TestsInit {
    private final String[] steps = {"Step #1", "Step #2", "Step #3"};

    @BeforeMethod
    public void chooseSection() {
        stepperPage.open();
        stepperPage.isOpened();
    }

    @Test
    public void simpleLinearStepperTest() {
        simpleLinearStepper.show();
        simpleLinearStepper.is().displayed().and().horizontal().and().has().steps(Arrays.asList(steps));
        checkStepperLogic(simpleLinearStepper, simpleLinearStepperNextButton, simpleLinearStepperBackButton);
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
    public void verticalStepperTest() {
        String[] steps = {"Select campaign settings", "Create an ad group", "Create an ad"};

        verticalStepper.show();
        verticalStepper.is().displayed().and().vertical().and().has().steps(Arrays.asList(steps));
        checkStepperLogic(verticalStepper, verticalStepperNextButton, verticalStepperBackButton);
    }

    @Test
    public void mobileTextStepperTest() {
        mobileTextStepper.show();
        for (int i = 1; i <= 5; i++) {
            mobileTextStepper.has().value("BACK\n" + i + " / 5\nNEXT");
            if (i == 5) {
                mobileTextStepper.back().click();
                mobileTextStepper.has().value("BACK\n4 / 5\nNEXT");
            } else {
                mobileTextStepper.next().click();
            }
        }
    }

    @Test
    public void mobileDotsTest() {
        mobileDotsStepper.show();
        for (int i = 0; i <= 5; i++) {
            mobileDotsStepperTitle.has().text("You are on Step " + i);
            mobileDotsStepper.dots().get(i + 1).is().enabled();
            if (i == 5) {
                mobileDotsStepper.back().click();
                mobileDotsStepperTitle.has().text("You are on Step 4");
                mobileDotsStepper.dots().get(i).is().enabled();
            } else {
                mobileDotsStepper.next().click();
            }
        }
    }

    @Test
    public void mobileProgressTest() {
        mobileProgressStepper.show();
        for (int i = 0, value = 0; i <= 5; i++, value += 20) {
            mobileProgressStepperTitle.has().text("You are on Step " + i);
            mobileProgressStepper.progressBar().has().attr("aria-valuenow", String.valueOf(value));
            if (i == 5) {
                mobileProgressStepper.back().click();
                mobileProgressStepperTitle.is().text("You are on Step 4");
            } else {
                mobileProgressStepper.next().click();
            }
        }
    }

    private void checkStepperLogic(Stepper stepper, Button next, Button back) {
        stepper.is().stepEnabled(1).and().stepIncomplete(1);
        stepper.is().stepDisabled(2).and().stepIncomplete(2);
        stepper.is().stepDisabled(3).and().stepIncomplete(3);

        next.click();
        stepper.is().stepEnabled(1).and().stepCompleted(1);
        stepper.is().stepEnabled(2).and().stepIncomplete(2);
        stepper.is().stepDisabled(3).and().stepIncomplete(3);

        next.click();
        stepper.is().stepEnabled(1).and().stepCompleted(1);
        stepper.is().stepEnabled(2).and().stepCompleted(2);
        stepper.is().stepEnabled(3).and().stepIncomplete(3);

        back.click();
        stepper.is().stepEnabled(1).and().stepCompleted(1);
        stepper.is().stepEnabled(2).and().stepIncomplete(2);
        stepper.is().stepDisabled(3).and().stepIncomplete(3);

        next.click();
        next.click();
        stepper.is().stepEnabled(1).and().stepCompleted(1);
        stepper.is().stepEnabled(2).and().stepCompleted(2);
        stepper.is().stepEnabled(3).and().stepCompleted(3);

        back.click();
        stepper.is().stepEnabled(1).and().stepIncomplete(1);
        stepper.is().stepDisabled(2).and().stepIncomplete(2);
        stepper.is().stepDisabled(3).and().stepIncomplete(3);
    }
}
