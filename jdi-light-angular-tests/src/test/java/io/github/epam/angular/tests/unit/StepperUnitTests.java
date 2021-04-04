package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ExpansionPanelSection.accordionExpansionPanel;
import static io.github.com.pages.sections.ExpansionPanelSection.basicExpansionPanel;
import static io.github.com.pages.sections.StepperSection.linearStepper;
import static io.github.com.pages.sections.StepperSection.optionalStepper;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepperUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        linearStepper.show();
    }


    @Test
    public void displayedTest() {
        assertTrue(linearStepper.isDisplayed() && optionalStepper.isDisplayed());
    }

    @Test
    public void getActiveStepTest() {
        linearStepper.show();
        Assert.assertEquals(linearStepper.getActiveStep(), "1");
    }

    @Test
    public void gotoStepTest() {
        linearStepper.show();
        linearStepper.gotoStep("2");
        Assert.assertEquals(linearStepper.getActiveStep(), "2");
        linearStepper.gotoStep("1");
        Assert.assertEquals(linearStepper.getActiveStep(), "1");
    }

    @Test
    public void nextPreviousButtonTest() {
        linearStepper.show();
        linearStepper.clickNextButton();
        Assert.assertEquals(linearStepper.getActiveStep(), "2");
        linearStepper.gotoStep("1");
        Assert.assertEquals(linearStepper.getActiveStep(), "1");
    }

    @Test
    public void previousButtonTest() {
        linearStepper.show();
        linearStepper.gotoStep("2");
        Assert.assertEquals(linearStepper.getActiveStep(), "2");
        linearStepper.clickPreviousButton();
        Assert.assertEquals(linearStepper.getActiveStep(), "1");
    }

}
