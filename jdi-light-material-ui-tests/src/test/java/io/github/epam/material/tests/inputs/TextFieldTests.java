package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class TextFieldTests extends TestsInit {

    public static final String DEFAULT_VALUE = "Default value";

    @BeforeMethod
    public void before(){

        textFieldPage.open();
        textFieldPage.isOpened();
    }

    @Test
    public void standardTextFieldTest() {

        textFieldPage.standartTextField.is().enabled();
        textFieldPage.standartTextField.setValue(DEFAULT_VALUE);
        textFieldPage.standartTextField.has().text(DEFAULT_VALUE);
    }

    @Test
    public void filledWithDefaultTextFieldTest() {
        //inputTextFieldFilledWithDefaultPage.open();

        //textFieldFrame.textField.has().text(DEFAULT_VALUE);
    }

    @Test
    public void emptyTextFieldTest() {
        //inputTextFieldFilledPage.open();

        //textFieldFrame.textField.is().empty();
    }

    @Test
    public void disabledTextFieldTest() {
        //inputTextFieldDisabledPage.open();

        //textFieldFrame.textField.is().disabled();
    }

    @Test
    public void timeTextFieldTest() {
        //inputTextFieldTimePage.open();

        /*textFieldFrame.textField.setValue("16:00PM");
        textFieldFrame.textField.has().text("16:00");
        textFieldFrame.textField.setValue("06:00A");
        textFieldFrame.textField.has().text("06:00");
        textFieldFrame.textField.setValue("17:96");
        textFieldFrame.textField.has().text("17:09");
        textFieldFrame.textField.setValue("17:75");
        textFieldFrame.textField.has().text("17:07");
        textFieldFrame.textField.setValue("17:x5");
        textFieldFrame.textField.has().text("17:05");*/
    }

}
