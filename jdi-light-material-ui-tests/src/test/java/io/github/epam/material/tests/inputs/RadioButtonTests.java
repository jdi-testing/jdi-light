package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
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
        for (int i = 1; i <= 4; i++) {
            selectRadio(i, 1);
        }
    }

    public void selectRadio(int x, int section) {
        switch(section) {
            case 1 :
                System.out.println(simpleRadioButtons.get(x).base().searchRules.toString());
                simpleRadioButtons.get(x).select();
                lastRadioText.has().text(Matchers.containsString(simpleRadioTexts.get(x).text()));
                break;
            case 2 :
                labelPlacementButtons.get(x).select();
                break;
            case 3:
                showErrorButtons.select(x);
                break;
        }
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
