package io.github.epam.material.tests.navigation;

import static io.github.com.MaterialNavigator.openSection;

import com.epam.jdi.tools.Timer;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.navigation.StepperPage.*;


public class StepperTests extends TestsInit {

    @BeforeMethod
    public void chooseSection() {
        openSection("Stepper");
    }

    @Test
    public void simpleLinearStepperTest(){
        simpleLinearStepper.is().stepperDisplayed();

        simpleLinearStepperTitle.is().text("You are on Step #1");
        simpleLinearStepperButton.clickOnButtonByIndex(2);
        simpleLinearStepperTitle.is().text("You are on Step #2");
        simpleLinearStepperButton.clickOnButtonByIndex(1);
        simpleLinearStepperTitle.is().text("You are on Step #1");
        simpleLinearStepperButton.clickOnButtonByIndex(2);
        simpleLinearStepperTitle.is().text("You are on Step #2");
        simpleLinearStepperButton.clickOnButtonByIndex(2);
        simpleLinearStepperTitle.is().text("You are on Step #3");
        simpleLinearStepperButton.clickOnButtonByIndex(2);
        simpleLinearStepperTitle.is().text("All steps completed");
        simpleLinearStepperButton.clickOnButtonByIndex(1);
        simpleLinearStepperTitle.is().text("You are on Step #1");
    }

    @Test
    public void nonlinearStepperTest() {
        nonlinearStepper.is().stepperDisplayed();

        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.clickOnButtonByIndex(4);
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.clickOnButtonByIndex(3);
        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.clickOnButtonByIndex(4);
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.clickOnButtonByIndex(4);
        nonlinearStepperTitle.is().text("You are on Step #3");
        nonlinearStepperButton.clickOnButtonByIndex(4);

        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.clickOnButtonByIndex(5);
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.clickOnButtonByIndex(5);
        nonlinearStepperTitle.is().text("You are on Step #3");
        nonlinearStepperButton.clickOnButtonByIndex(5);
        nonlinearStepperTitle.is().text("All steps completed - you're finished");
        nonlinearStepperButton.clickOnButtonByIndex(3);

        nonlinearStepperTitle.is().text("You are on Step #1");
        nonlinearStepperButton.clickOnButtonByIndex(5);
        nonlinearStepperTitle.is().text("You are on Step #2");
        nonlinearStepperButton.clickOnButtonByIndex(4);
        nonlinearStepperTitle.is().text("You are on Step #3");
        nonlinearStepperButton.clickOnButtonByIndex(5);
        nonlinearStepperTitle.is().text("You are on Step #2");

    }


    @Test
    public void verticalStepperTest(){
        Timer timer = new Timer(10000L);

        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 0"));
        timer.wait(() ->verticalStepperButton.clickOnButtonByIndex(2));
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 1"));
        timer.wait(() ->verticalStepperButton.clickOnButtonByIndex(1));
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 0"));
        timer.wait(() ->verticalStepperButton.clickOnButtonByIndex(2));
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 1"));
        timer.wait(() ->verticalStepperButton.clickOnButtonByIndex(2));
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 2"));
        timer.wait(() ->verticalStepperButton.clickOnButtonByIndex(2));
        timer.wait(() ->verticalStepperTitle.is().text("All steps completed - you're finished"));
        timer.wait(() ->verticalStepperButton.clickOnButtonByIndex(1));
        timer.wait(() ->verticalStepperTitle.is().text("You are on Step 0"));
    }

    @Test
    public void mobileTextStepperTest(){
        mobileTextStepperTitle.is().text("BACK\n" + "1 / 5\n" + "NEXT");
        mobileTextStepperButton.clickOnButtonByIndex(2);
        mobileTextStepperTitle.is().text("BACK\n" + "2 / 5\n" + "NEXT");
        mobileTextStepperButton.clickOnButtonByIndex(1);
        mobileTextStepperTitle.is().text("BACK\n" + "1 / 5\n" + "NEXT");
        mobileTextStepperButton.clickOnButtonByIndex(2);
        mobileTextStepperTitle.is().text("BACK\n" + "2 / 5\n" + "NEXT");
        mobileTextStepperButton.clickOnButtonByIndex(2);
        mobileTextStepperTitle.is().text("BACK\n" + "3 / 5\n" + "NEXT");
        mobileTextStepperButton.clickOnButtonByIndex(2);
        mobileTextStepperTitle.is().text("BACK\n" + "4 / 5\n" + "NEXT");
        mobileTextStepperButton.clickOnButtonByIndex(2);
        mobileTextStepperTitle.is().text("BACK\n" + "5 / 5\n" + "NEXT");
    }

    @Test
    public void mobileTextDotsTest(){
        mobileDotsStepperTitle.is().text("You are on Step 0");
        mobileDotsStepperButton.clickOnButtonByIndex(2);
        mobileDotsStepperTitle.is().text("You are on Step 1");
        mobileDotsStepperButton.clickOnButtonByIndex(1);
        mobileDotsStepperTitle.is().text("You are on Step 0");
        mobileDotsStepperButton.clickOnButtonByIndex(2);
        mobileDotsStepperTitle.is().text("You are on Step 1");
        mobileDotsStepperButton.clickOnButtonByIndex(2);
        mobileDotsStepperTitle.is().text("You are on Step 2");
        mobileDotsStepperButton.clickOnButtonByIndex(2);
        mobileDotsStepperTitle.is().text("You are on Step 3");
        mobileDotsStepperButton.clickOnButtonByIndex(2);
        mobileDotsStepperTitle.is().text("You are on Step 4");
        mobileDotsStepperButton.clickOnButtonByIndex(2);
        mobileDotsStepperTitle.is().text("You are on Step 5");
    }

    @Test
    public void mobileTextProgressTest(){
        mobileProgressStepperTitle.is().text("You are on Step 0");
        mobileProgressStepperButton.clickOnButtonByIndex(2);
        mobileProgressStepperTitle.is().text("You are on Step 1");
        mobileProgressStepperButton.clickOnButtonByIndex(1);
        mobileProgressStepperTitle.is().text("You are on Step 0");
        mobileProgressStepperButton.clickOnButtonByIndex(2);
        mobileProgressStepperTitle.is().text("You are on Step 1");
        mobileProgressStepperButton.clickOnButtonByIndex(2);
        mobileProgressStepperTitle.is().text("You are on Step 2");
        mobileProgressStepperButton.clickOnButtonByIndex(2);
        mobileProgressStepperTitle.is().text("You are on Step 3");
        mobileProgressStepperButton.clickOnButtonByIndex(2);
        mobileProgressStepperTitle.is().text("You are on Step 4");
        mobileProgressStepperButton.clickOnButtonByIndex(2);
        mobileProgressStepperTitle.is().text("You are on Step 5");
    }

}
