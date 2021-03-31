package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radioDefaultPage;
import static io.github.com.StaticSite.radioButtonFrame;
import static org.hamcrest.Matchers.containsString;


public class RadioButtonTests extends TestsInit {

    @Test
    public void defaultRadioButtonTest() {
        radioDefaultPage.open();

        radioButtonFrame.firstRadioButton.is().enabled();
        radioButtonFrame.secondRadioButton.is().enabled();
        radioButtonFrame.thirdRadioButton.is().enabled();
        radioButtonFrame.disabledRadioButton.is().disabled();

        radioButtonFrame.firstRadioButton.is().unchecked();
        radioButtonFrame.secondRadioButton.is().unchecked();
        radioButtonFrame.thirdRadioButton.is().unchecked();
        radioButtonFrame.disabledRadioButton.is().unchecked();

        radioButtonFrame.firstRadioButton.toggle();
        radioButtonFrame.firstRadioButton.is().checked();
        radioButtonFrame.secondRadioButton.is().unchecked();
        radioButtonFrame.thirdRadioButton.is().unchecked();
        radioButtonFrame.disabledRadioButton.is().unchecked();
        radioButtonFrame.textField.is().text(containsString("First"));

        radioButtonFrame.secondRadioButton.toggle();
        radioButtonFrame.firstRadioButton.is().unchecked();
        radioButtonFrame.secondRadioButton.is().checked();
        radioButtonFrame.thirdRadioButton.is().unchecked();
        radioButtonFrame.disabledRadioButton.is().unchecked();
        radioButtonFrame.textField.is().text(containsString("Second"));

        radioButtonFrame.firstRadioButton.is().unchecked();
        radioButtonFrame.secondRadioButton.is().checked();
        radioButtonFrame.thirdRadioButton.is().unchecked();
        radioButtonFrame.disabledRadioButton.is().unchecked();
    }

    @Test
    public void disabledRadioButtonTest() {
        radioDefaultPage.open();

        radioButtonFrame.disabledRadioButton.is().disabled();
    }
}
