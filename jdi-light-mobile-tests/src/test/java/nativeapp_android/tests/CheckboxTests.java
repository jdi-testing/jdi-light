package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.animationPage;
import static nativeapp.android.apidemos.animation.AnimationPage.layoutAnimationsButton;
import static nativeapp.android.apidemos.animation.CheckboxesPage.*;


public class CheckboxTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        animationPage.tap();
        layoutAnimationsButton.tap();
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


