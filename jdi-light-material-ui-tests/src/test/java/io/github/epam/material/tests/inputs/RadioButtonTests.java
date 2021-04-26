package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.pages.inputs.RadioButtonPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.radioButtonPage;


public class RadioButtonTests extends TestsInit {

    @BeforeTest()
    public void beforeTest() {
        openSection("Radio");
        radioButtonPage.isOpened();
    }

    @Test
    public void simpleRadioTest() {
        simpleRadioButtons.get(1).select();
//        for (RadioButtons radio : simpleRadioButtons) {
//            System.out.println(radio.text());
//        }
    }

    @Test
    public void labelPlacementTest() {

    }

    @Test
    public void showErrorTest() {

    }

    @Test
    public void defaultRadioButtonTest() {
//
//        radioButtonPage.firstRadioButton.is().enabled();
//        radioButtonPage.secondRadioButton.is().enabled();
//        radioButtonPage.thirdRadioButton.is().enabled();
//        radioButtonPage.disabledRadioButton.is().disabled();
//
//        radioButtonPage.firstRadioButton.is().unchecked();
//        radioButtonPage.secondRadioButton.is().unchecked();
//        radioButtonPage.thirdRadioButton.is().unchecked();
//        radioButtonPage.disabledRadioButton.is().unchecked();
//
//        radioButtonPage.firstRadioButton.toggle();
//        radioButtonPage.firstRadioButton.is().checked();
//        radioButtonPage.secondRadioButton.is().unchecked();
//        radioButtonPage.thirdRadioButton.is().unchecked();
//        radioButtonPage.disabledRadioButton.is().unchecked();
//        radioButtonPage.textField.is().text(containsString("First"));
//
//        radioButtonPage.secondRadioButton.toggle();
//        radioButtonPage.firstRadioButton.is().unchecked();
//        radioButtonPage.secondRadioButton.is().checked();
//        radioButtonPage.thirdRadioButton.is().unchecked();
//        radioButtonPage.disabledRadioButton.is().unchecked();
//        radioButtonPage.textField.is().text(containsString("Second"));
//
//        radioButtonPage.firstRadioButton.is().unchecked();
//        radioButtonPage.secondRadioButton.is().checked();
//        radioButtonPage.thirdRadioButton.is().unchecked();
//        radioButtonPage.disabledRadioButton.is().unchecked();
    }

    @Test
    public void disabledRadioButtonTest() {
//        radioDefaultPage.open();
//
//        radioButtonPage.disabledRadioButton.is().disabled();
    }
}
