package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.stepper.Stepper;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    @Test(description = "Test checks if step is completed or not")
    public void completeStepStepperTest() {
        Stepper stepper = nonLinearStepper.get(2);
        stepper.getStep(1).is().complete();
        stepper.getStep(2).is().notComplete();
    }

    @Test(description = "Test gives an example how to work with getStepsList and getContentList methods")
    public void getStepListGetContentListStepperTest() {
        verticalStepper.show();
        verticalStepper.getStepsList().get(1).is().active();
        verticalStepper.getContentList().get(1).find("button").click();
        verticalStepper.getStepsList().get(1).is().notActive();
    }

    @Test(description = "Test checks stepper's orientation")
    public void orientationStepperTest() {
        verticalStepper.show();
        verticalStepper.is().vertical();
        alternativeLabelWithErrorsStepper.show();
        alternativeLabelWithErrorsStepper.is().horizontal();
    }

    @Test(description = "Test checks if step has error or not")
    public void errorStepperTest() {
        alternativeLabelWithErrorsStepper.show();
        alternativeLabelWithErrorsStepper.getStep(3).has().error();
        alternativeLabelWithErrorsStepper.getStep(3).has().text("Custom channels\nAlert message");
        alternativeLabelWithErrorsStepper.getStep(4).has().noError();
    }

    @Test(description = "Test checks if stepper and step color")
    public void colorStepperTest() {
        alternativeLabelWithErrorsStepper.show();
        alternativeLabelWithErrorsStepper.getStep(3).has().color(RED_ACCENT_2.value());
        alternativeLabelWithErrorsStepper.getStep(3).has().backgroundColor(TRANSPARENT.value());
        alternativeLabelWithErrorsStepper.has().color(BLACK_TRANSPARENT_087.value());
        alternativeLabelWithErrorsStepper.has().backgroundColor(WHITE.value());
    }

    @Test(description = "Test checks if element is editable or not")
    public void editableStepsStepperTest() {
        editableStepsStepper.show();
        editableStepsStepper.getStep(1).is().editable();
        editableStepsStepper.getStep(2).is().notEditable();
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
        variousAttributesStepper.get(1).is().elevated();
        variousAttributesStepper.get(1).has().elevation(4);
        nonEditableStepsStepper.show();
        nonEditableStepsStepper.is().notElevated();
    }

    @Test(description = "Test checks stepper's measurements")
    public void measurementStepperTest() {
        nonEditableStepsStepper.show();
        nonEditableStepsStepper.has().heightGreaterThan(70);
        nonEditableStepsStepper.has().heightLessThan(80);
        nonEditableStepsStepper.has().height(72);
        nonEditableStepsStepper.has().widthGreaterThan(900);
        nonEditableStepsStepper.has().widthLessThan(1000);
        nonEditableStepsStepper.has().width(959);
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
        variousAttributesStepper.get(3).is().rounded();
        variousAttributesStepper.get(3).is().rounded(10);
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
