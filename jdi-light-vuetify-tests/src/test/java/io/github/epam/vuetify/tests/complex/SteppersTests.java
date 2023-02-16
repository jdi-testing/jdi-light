package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.stepper.Step;
import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.steppersPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.RED_ACCENT_2;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.SteppersPage.alternativeLabelWithErrorsStepper;
import static io.github.com.pages.SteppersPage.editableStepsStepper;
import static io.github.com.pages.SteppersPage.errorStepper;
import static io.github.com.pages.SteppersPage.linearSteppersStepper;
import static io.github.com.pages.SteppersPage.nonEditableStepsStepper;
import static io.github.com.pages.SteppersPage.nonLinearStepper;
import static io.github.com.pages.SteppersPage.variousAttributesStepper;
import static io.github.com.pages.SteppersPage.verticalStepper;

public class SteppersTests extends TestsInit {

    @BeforeClass
    public void before() {
        steppersPage.open();
        waitCondition(() -> steppersPage.isOpened());
        steppersPage.checkOpened();
    }

    @Test(description = "Test checks if step is active or not")
    public void activeStepStepperTest() {
        Stepper stepper = nonLinearStepper.get(1);
        stepper.show();
        List<Step> steps = stepper.steps();
        steps.get(0).is().active();
        steps.get(1).is().notActive();
        steps.get(1).click();
        steps.get(0).is().notActive();
        steps.get(1).is().active();
        steps.get(2).is().notActive();
        steps.get(2).click();
        steps.get(1).is().notActive();
        steps.get(2).is().active();
        steps.get(0).click();
        steps.get(0).is().active();
    }

    @Test(description = "Test checks if step is completed or not")
    public void completeStepStepperTest() {
        Stepper stepper = nonLinearStepper.get(2);
        stepper.getStep(0).is().complete();
        stepper.getStep(1).is().notComplete();
    }

    @Test(description = "Test gives an example how to work with getStepsList and getContentList methods")
    public void getStepListGetContentListStepperTest() {
        verticalStepper.show();
        verticalStepper.steps().get(0).is().active();
        verticalStepper.getContentList().get(1).find("button").click();
        verticalStepper.steps().get(0).is().notActive();
        verticalStepper.is().vertical();
    }

    @Test(description = "Test checks if step has error or not")
    public void alternativeStepperTest() {
        alternativeLabelWithErrorsStepper.show();
        alternativeLabelWithErrorsStepper.is().horizontal();

        List<Step> steps = alternativeLabelWithErrorsStepper.steps();
        steps.get(2).has().error();
        steps.get(2).has().text("Custom channels\nAlert message");
        steps.get(3).has().noError();
        steps.get(2).has().color(RED_ACCENT_2.value());
        steps.get(2).has().backgroundColor(TRANSPARENT.value());

        alternativeLabelWithErrorsStepper.has().color(BLACK_TRANSPARENT_087.value());
        alternativeLabelWithErrorsStepper.has().backgroundColor(WHITE.value());
    }

    @Test(description = "Test checks if element is editable or not")
    public void editableStepsStepperTest() {
        editableStepsStepper.show();
        editableStepsStepper.getStep(0).is().editable();
        editableStepsStepper.getStep(1).is().notEditable();
    }

    @Test(description = "Test checks stepper's theme")
    public void themeStepperTest() {
        errorStepper.show();
        errorStepper.is().darkTheme();
        nonEditableStepsStepper.show();
        nonEditableStepsStepper.has().lightTheme();
    }

    @Test(description = "Test checks if stepper is elevated or not")
    public void elevationStepperTest() {
        variousAttributesStepper.get(1).show();
        variousAttributesStepper.get(1).is().elevated().and().elevation(4);
        nonEditableStepsStepper.show();
        nonEditableStepsStepper.is().notElevated();
    }

    @Test(description = "Test checks stepper's measurements")
    public void measurementStepperTest() {
        nonEditableStepsStepper.show();
        nonEditableStepsStepper.has().heightGreaterThan(50);
        nonEditableStepsStepper.has().heightLessThan(300);
        nonEditableStepsStepper.has().widthGreaterThan(500);
        nonEditableStepsStepper.has().widthLessThan(1800);
    }

    @Test(description = "Test checks if stepper is non-linear or not")
    public void nonLinearStepperTest() {
        nonLinearStepper.get(1).show();
        nonLinearStepper.get(1).is().nonLinear();
        linearSteppersStepper.get(1).show();
        linearSteppersStepper.get(1).is().linear();
    }

    @Test(description = "Test checks if stepper is outlined or not")
    public void outlinedStepperTest() {
        variousAttributesStepper.get(1).show();
        variousAttributesStepper.get(1).is().outlined();
        verticalStepper.show();
        verticalStepper.is().notOutlined();
    }

    @Test(description = "Test checks if stepper is rounded or not")
    public void roundedStepperTest() {
        variousAttributesStepper.get(3).show();
        variousAttributesStepper.get(3).is().rounded().and().rounded(10);
        verticalStepper.show();
        verticalStepper.is().notRounded();
    }

    @Test(description = "Test checks if stepper is shaped or not")
    public void shapedStepperTest() {
        variousAttributesStepper.get(2).show();
        variousAttributesStepper.get(2).is().shaped();
        variousAttributesStepper.get(3).is().notShaped();
    }

    @Test(description = "Test checks if stepper is tile or not")
    public void tileStepperTest() {
        variousAttributesStepper.get(1).show();
        variousAttributesStepper.get(1).is().tile();
        variousAttributesStepper.get(3).is().notTile();
    }

    @Test(description = "Test checks if stepper has alt label or not")
    public void altLabelsStepperTest() {
        alternativeLabelWithErrorsStepper.show();
        alternativeLabelWithErrorsStepper.has().altLabel();
        editableStepsStepper.has().notAltLabel();
    }
}
