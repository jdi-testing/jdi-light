package io.github.epam.material.tests.navigation;

import com.epam.jdi.tools.Timer;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.stepperPage;
import static io.github.com.pages.navigation.StepperPage.*;

/**
 * To see an example of Steppers please visit https://material-ui.com/components/steppers/
 */

public class StepperTests extends TestsInit {
    @BeforeMethod
    public void chooseSection() {
        stepperPage.open();
        stepperPage.isOpened();
    }

    @Test
    public void simpleLinearStepperTest(){
        simpleLinearStepperTitle.is().text("You are on Step #1");
        simpleLinearStepperButton.get(2).click();
        simpleLinearStepperTitle.is().text("You are on Step #2");
        simpleLinearStepperButton.get(1).click();
        simpleLinearStepperTitle.is().text("You are on Step #1");
        simpleLinearStepperButton.get(2).click();
        simpleLinearStepperTitle.is().text("You are on Step #2");
        simpleLinearStepperButton.get(2).click();
        simpleLinearStepperTitle.is().text("You are on Step #3");
        simpleLinearStepperButton.get(2).click();
        simpleLinearStepperTitle.is().text("All steps completed");
        simpleLinearStepperButton.get(1).click();
        simpleLinearStepperTitle.is().text("You are on Step #1");
    }

    @Test
    public void nonlinearStepperTest() {
        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.get(4).click();
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.get(3).click();
        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.get(4).click();
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.get(4).click();
        nonlinearStepperTitle.is().text("You are on Step #3");
        nonlinearStepperButton.get(4).click();

        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.get(5).click();
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.get(5).click();
        nonlinearStepperTitle.is().text("You are on Step #3");
        nonlinearStepperButton.get(5).click();
        nonlinearStepperTitle.is().text("All steps completed - you're finished");
        nonlinearStepperButton.get(3).click();

        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.get(5).click();
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.get(4).click();
        nonlinearStepperTitle.is().text("You are on Step #3");
        nonlinearStepperButton.get(5).click();
        nonlinearStepperTitle.is().text("You are on Step #2");
    }

    @Test
    public void verticalStepperTest(){
        Timer timer = new Timer(10000L);

        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 0"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 1"));
        timer.wait(() ->verticalStepperButton.get(1).click());
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 0"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 1"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 2"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->verticalStepperTitle.is().text("All steps completed - you're finished"));
        timer.wait(() ->verticalStepperButton.get(1).click());
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 0"));
    }

    @Test
    public void mobileTextStepperTest(){
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
    public void mobileDotsTest(){
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
    public void mobileProgressTest(){
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
