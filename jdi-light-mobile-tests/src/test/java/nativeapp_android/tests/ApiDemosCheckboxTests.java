package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apiDemos.AnimationPage.*;
import static nativeapp.android.apiDemos.CheckboxesPage.*;


public class ApiDemosCheckboxTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        animationButton.click();
        layoutAnimationsButton.click();
    }

    @Test
    public void customAnimationsCheckboxTest(){
        customAnimations.check();
        customAnimations.is().selected();
        customAnimations.uncheck();
        customAnimations.is().deselected();

    }

    @Test
    public void inCheckboxTest(){
        in.check();
        in.is().selected();
        in.uncheck();
        in.is().deselected();
    }

    @Test
    public void outCheckboxTest(){
        out.check();
        out.is().selected();
        out.uncheck();
        out.is().deselected();
    }

    @Test
    public void changingInCheckboxTest(){
        changingIn.check();
        changingIn.is().selected();
        changingIn.uncheck();
        changingIn.is().deselected();
    }

    @Test
    public void changingOutCheckboxTest(){
        changingOut.check();
        changingOut.is().selected();
        changingOut.uncheck();
        changingOut.is().deselected();
    }
}


