package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apidemos.AnimationPage.*;
import static nativeapp.android.apidemos.CheckboxesPage.*;
import static nativeapp.android.apidemos.IndexPage.*;


public class CheckboxTests extends ApiDemosTestInit {

    @BeforeClass
    public void beforeClass() {
        logger.toLog("Run CheckboxTests");
    }

    @BeforeMethod
    public void initSteps() {
        animationPage.click();
        layoutAnimationsButton.click();
    }

    @Test
    public void customAnimationsCheckboxTest(){
        customAnimationsCheckbox.check();
        customAnimationsCheckbox.is().selected();
        customAnimationsCheckbox.uncheck();
        customAnimationsCheckbox.is().deselected();

    }

    @Test
    public void inCheckboxTest(){
        inCheckbox.check();
        inCheckbox.is().selected();
        inCheckbox.uncheck();
        inCheckbox.is().deselected();
    }

    @Test
    public void outCheckboxTest(){
        outCheckbox.check();
        outCheckbox.is().selected();
        outCheckbox.uncheck();
        outCheckbox.is().deselected();
    }

    @Test
    public void changingInCheckboxTest(){
        changingInCheckbox.check();
        changingInCheckbox.is().selected();
        changingInCheckbox.uncheck();
        changingInCheckbox.is().deselected();
    }

    @Test
    public void changingOutCheckboxTest(){
        changingOutCheckbox.check();
        changingOutCheckbox.is().selected();
        changingOutCheckbox.uncheck();
        changingOutCheckbox.is().deselected();
    }
}


