package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.StepperSection.linearModeButton;
import static io.github.com.pages.sections.StepperSection.linearStepper;
import static io.github.com.pages.sections.StepperSection.optionalStepButton;
import static io.github.com.pages.sections.StepperSection.optionalStepper;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class StepperTests extends TestsInit {
    private static final String ENABLE_LINEAR = "Enable linear mode";
    private static final String DISABLE_LINEAR = "Disable linear mode";
    private static final String ENABLE_OPTIONAL = "Enable optional steps";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedTest() {
        linearStepper.show();
        linearStepper.is().displayed();
        optionalStepper.is().displayed();

    }

    @Test
    public void basicStepperTest() {
        linearStepper.show();
        linearStepper.is().active("1");
        linearStepper.gotoStep("2");
        linearStepper.is().active("2");
        linearStepper.gotoStep("1");
        linearStepper.is().active("1").and().notActive("2");
    }

    @Test
    public void basicLinearStepperTest() {
        linearStepper.show();
        linearModeButton.click();
        linearStepper.is().active("1");
        linearStepper.gotoStep("2");
        linearStepper.is().active("1").and().notActive("2");
        linearModeButton.click();
    }

    @Test
    public void basicOptionalStepperTest() {
        optionalStepper.show();
        optionalStepButton.click();
        optionalStepper.input("test name");
        optionalStepper.clickNextButton();
        optionalStepper.is().active("2");
        optionalStepper.clickNextButton();
        optionalStepper.is().active("3").and().notActive("2");
        optionalStepper.gotoStep("1");
        optionalStepper.is().active("1");
        optionalStepButton.click();
    }

    @Test
    public void fullLinearStepperFlowTest() {
        linearStepper.show();
        linearStepper.is().active("1");
        linearStepper.input("test name");
        linearStepper.clickNextButton();
        linearStepper.is().active("2");
        linearStepper.input("test address");
        linearStepper.clickNextButton();
        linearStepper.is().active("3");
        linearStepper.clickResetButton();
        linearStepper.is().active("1");
    }

    @Test
    public void fullOptionalStepperFlowTest() {
        optionalStepper.show();
        optionalStepper.is().active("1");
        optionalStepper.input("test name");
        optionalStepper.clickNextButton();
        optionalStepper.is().active("2");
        optionalStepper.input("test address");
        optionalStepper.clickNextButton();
        optionalStepper.is().active("3");
        optionalStepper.clickResetButton();
        optionalStepper.is().active("1");
    }

}
