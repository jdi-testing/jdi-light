package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Step;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.enums.Colors.RED_ACCENT_2;
import static io.github.com.StaticSite.steppersPage;
import static io.github.com.pages.SteppersPage.alternativeLabelWithErrorsStepper;
import static io.github.com.pages.SteppersPage.dynamicStepsStepper;
import static io.github.com.pages.SteppersPage.dynamicStepsStepperInput;
import static io.github.com.pages.SteppersPage.editableStepsStepper;
import static io.github.com.pages.SteppersPage.linearSteppersStepper;
import static io.github.com.pages.SteppersPage.nonEditableStepsStepper;
import static io.github.com.pages.SteppersPage.nonLinearStepper;
import static io.github.com.pages.SteppersPage.verticalStepper;

public class SteppersTests extends TestsInit {

    @BeforeClass
    public void before() {
        steppersPage.open();
        waitCondition(() -> steppersPage.isOpened());
        steppersPage.checkOpened();
    }

    @Test
    public void nonLinearStepperSwitchingStepsTest() {
        Stepper stepper = nonLinearStepper.get(1);

        stepper.getStep(1).is().active();
        stepper.getStep(2).is().notActive();

        stepper.getStep(2).click();
        stepper.getStep(1).is().notActive();
        stepper.getStep(2).is().active();

        stepper.getStep(3).is().notActive();
        stepper.getStep(3).click();
        stepper.getStep(2).is().notActive();
        stepper.getStep(3).is().active();

        stepper.getStep(1).click();
        stepper.getStep(1).is().active();
    }

    @Test
    public void nonLinearStepperNotCompleteTest() {
        Stepper stepper = nonLinearStepper.get(2);

        stepper.getStep(1).is().active();
        stepper.getStep(1).is().complete();
        stepper.getStep(2).is().notActive();
        stepper.getStep(2).is().notComplete();
        stepper.getStep(3).is().notActive();
        stepper.getStep(3).is().complete();

        stepper.getStep(2).click();
        stepper.getStep(2).is().active();
        stepper.getStep(2).is().notComplete();

        stepper.getStep(3).click();
        stepper.getStep(3).is().active();
        stepper.getStep(2).is().notActive();
    }

    @Test
    public void nonLinearStepperCompleteTest() {
        Stepper stepper = nonLinearStepper.get(3);

        stepper.getStepsList().forEach(step -> {
            step.click();
            step.is().active();
            step.is().complete();
        });
    }

    @Test
    public void verticalStepperTest() {
        Map<Step, UIElement> stepperStep = new LinkedHashMap<>();
        IntStream.range(1, verticalStepper.getStepsList().size() + 1).forEach(index ->
                stepperStep.put(verticalStepper.getStepsList().get(index), verticalStepper.getContentList().get(index)));
        stepperStep.forEach((currentStep, currentContent) -> {
            currentStep.is().active();
            currentStep.is().notComplete();
            currentContent.find("button").click();
            currentStep.is().notActive();
            if (!currentStep.getName().equals("View setup instructions")) {
                currentStep.is().complete();
            }
        });
    }

    @Test
    public void alternativeLabelWithErrorsStepperTest() {
        alternativeLabelWithErrorsStepper.getStep(3).is().contains("v-stepper__step--error");
        alternativeLabelWithErrorsStepper.getStep(3).is().contains("error--text");
        alternativeLabelWithErrorsStepper.getStep(3).find(".v-stepper__label")
                .has()
                .css("color", RED_ACCENT_2.value());
        alternativeLabelWithErrorsStepper.getStep(3).is().text("Custom channels\nAlert message");
    }

    @Test
    public void dynamicStepsStepperTest() {
        IntStream.range(2, 7).forEach(index -> {
            dynamicStepsStepperInput.select(String.valueOf(index));
            Assert.assertEquals(dynamicStepsStepper.getStepsList().size(), index);
            IntStream.range(1, index + 1).forEach(stepIndex -> {
                dynamicStepsStepper.getStep(stepIndex).click();
                dynamicStepsStepper.getStep(stepIndex).is().active();
                if (stepIndex != 1) {
                    dynamicStepsStepper.getStep(stepIndex - 1).is().complete();
                }
            });
        });
    }

    @Test
    public void editableStepsStepperTest() {
        editableStepsStepper.getStep(1).is().complete();
        editableStepsStepper.getStep(1).is().editable();
        editableStepsStepper.getStep(2).is().complete();
        editableStepsStepper.getStep(2).is().notEditable();
        editableStepsStepper.getStep(2).is().notActive();
        editableStepsStepper.getStep(3).is().notActive();

        editableStepsStepper.getStep(2).click();
        editableStepsStepper.getStep(2).is().notActive();

        editableStepsStepper.getStep(3).click();
        editableStepsStepper.getStep(3).is().active();

        editableStepsStepper.getStep(1).click();
        editableStepsStepper.getStep(1).is().active();
        editableStepsStepper.getStep(3).is().notActive();
    }

    @Test
    public void linearSteppersStepperTest() {
        IntStream.range(1, linearSteppersStepper.size() + 1)
                .forEach(activeStep -> {
                    Stepper stepper = linearSteppersStepper.get(activeStep);
                    stepper.getStep(activeStep).is().active();
                    IntStream.range(1, activeStep)
                            .forEach(index -> stepper.getStep(index).is().complete());
                    IntStream.range(activeStep, stepper.getStepsList().size() + 1)
                            .forEach(index -> stepper.getStep(index).is().notComplete());
                });
    }

    @Test
    public void nonEditableStepsStepperTest() {
        nonEditableStepsStepper.getStepsList().get(3).is().notEditable();
        nonEditableStepsStepper.getStepsList().get(3).click();
        nonEditableStepsStepper.getStepsList().get(3).is().notActive();
    }
}
