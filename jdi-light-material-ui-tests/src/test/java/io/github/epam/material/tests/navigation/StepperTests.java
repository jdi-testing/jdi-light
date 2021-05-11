package io.github.epam.material.tests.navigation;

import static io.github.com.MaterialNavigator.openSection;

import com.epam.jdi.tools.Timer;

import io.github.epam.TestsInit;
import org.testng.Assert;
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
        Assert.assertEquals(simpleLinearStepperTitle.text(), "You are on Step #1");
        simpleLinearStepperButton.get(2).click();
        Assert.assertEquals(simpleLinearStepperTitle.text(), "You are on Step #2");
        simpleLinearStepperButton.get(1).click();
        Assert.assertEquals(simpleLinearStepperTitle.text(), "You are on Step #1");
        simpleLinearStepperButton.get(2).click();
        Assert.assertEquals(simpleLinearStepperTitle.text(), "You are on Step #2");
        simpleLinearStepperButton.get(2).click();
        Assert.assertEquals(simpleLinearStepperTitle.text(), "You are on Step #3");
        simpleLinearStepperButton.get(2).click();
        Assert.assertEquals(simpleLinearStepperTitle.text(), "All steps completed");
        simpleLinearStepperButton.get(1).click();
        Assert.assertEquals(simpleLinearStepperTitle.text(), "You are on Step #1");
    }


    @Test
    public void nonlinearStepperTest() {
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #1");
        nonlinearStepperButton.get(4).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #2");
        nonlinearStepperButton.get(3).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #1");
        nonlinearStepperButton.get(4).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #2");
        nonlinearStepperButton.get(4).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #3");
        nonlinearStepperButton.get(4).click();

        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #1");
        nonlinearStepperButton.get(5).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #2");
        nonlinearStepperButton.get(5).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #3");
        nonlinearStepperButton.get(5).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "All steps completed - you're finished");
        nonlinearStepperButton.get(3).click();

        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #1");
        nonlinearStepperButton.get(5).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #2");
        nonlinearStepperButton.get(4).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #3");
        nonlinearStepperButton.get(5).click();
        Assert.assertEquals(nonlinearStepperTitle.text(), "You are on Step #2");
    }


    @Test
    public void verticalStepperTest(){
        Timer timer = new Timer(10000L);

        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"You are on Step 0"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"You are on Step 1"));
        timer.wait(() ->verticalStepperButton.get(1).click());
        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"You are on Step 0"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"You are on Step 1"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"You are on Step 2"));
        timer.wait(() ->verticalStepperButton.get(2).click());
        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"All steps completed - you're finished"));
        timer.wait(() ->verticalStepperButton.get(1).click());
        timer.wait(() ->Assert.assertEquals(verticalStepperTitle.text(),"You are on Step 0"));

    }


    @Test
    public void mobileTextStepperTest(){
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "1 / 5\n" + "NEXT");
        mobileTextStepperButton.get(2).click();
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "2 / 5\n" + "NEXT");
        mobileTextStepperButton.get(1).click();
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "1 / 5\n" + "NEXT");
        mobileTextStepperButton.get(2).click();
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "2 / 5\n" + "NEXT");
        mobileTextStepperButton.get(2).click();
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "3 / 5\n" + "NEXT");
        mobileTextStepperButton.get(2).click();
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "4 / 5\n" + "NEXT");
        mobileTextStepperButton.get(2).click();
        Assert.assertEquals(mobileTextStepperTitle.text(), "BACK\n" + "5 / 5\n" + "NEXT");
    }


    @Test
    public void mobileTextDotsTest(){
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 0");
        mobileDotsStepperButton.get(2).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 1");
        mobileDotsStepperButton.get(1).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 0");
        mobileDotsStepperButton.get(2).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 1");
        mobileDotsStepperButton.get(2).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 2");
        mobileDotsStepperButton.get(2).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 3");
        mobileDotsStepperButton.get(2).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 4");
        mobileDotsStepperButton.get(2).click();
        Assert.assertEquals(mobileDotsStepperTitle.text(), "You are on Step 5");
    }


    @Test
    public void mobileTextProgressTest(){
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 0");
        mobileProgressStepperButton.get(2).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 1");
        mobileProgressStepperButton.get(1).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 0");
        mobileProgressStepperButton.get(2).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 1");
        mobileProgressStepperButton.get(2).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 2");
        mobileProgressStepperButton.get(2).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 3");
        mobileProgressStepperButton.get(2).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 4");
        mobileProgressStepperButton.get(2).click();
        Assert.assertEquals(mobileProgressStepperTitle.text(), "You are on Step 5");
    }

}
