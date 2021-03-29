package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.inputTextFieldDisabledPage;
import static io.github.com.StaticSite.inputTextFieldFilledPage;
import static io.github.com.StaticSite.inputTextFieldFilledWithDefaultPage;
import static io.github.com.StaticSite.inputTextFieldStandardPage;
import static io.github.com.StaticSite.inputTextFieldTimePage;
import static io.github.com.StaticSite.textFieldFrame;

public class TextFieldTests extends TestsInit {

    public static final String DEFAULT_VALUE = "Default value";

    @Test
    public void standardTextFieldTest() {
        inputTextFieldStandardPage.open();

        textFieldFrame.textField.is().enabled();
        textFieldFrame.textField.setValue(DEFAULT_VALUE);
        textFieldFrame.textField.has().text(DEFAULT_VALUE);
    }

    @Test
    public void filledWithDefaultTextFieldTest() {
        inputTextFieldFilledWithDefaultPage.open();

        textFieldFrame.textField.has().text(DEFAULT_VALUE);
    }

    @Test
    public void emptyTextFieldTest() {
        inputTextFieldFilledPage.open();

        textFieldFrame.textField.is().empty();
    }

    @Test
    public void timeTextFieldTest() {
        inputTextFieldTimePage.open();

        textFieldFrame.textField.setValue("16:00PM");
        textFieldFrame.textField.has().text("16:00");
        textFieldFrame.textField.setValue("06:00A");
        textFieldFrame.textField.has().text("06:00");
        textFieldFrame.textField.setValue("17:96");
        textFieldFrame.textField.has().text("17:09");
        textFieldFrame.textField.setValue("17:75");
        textFieldFrame.textField.has().text("17:07");
        textFieldFrame.textField.setValue("17:x5");
        textFieldFrame.textField.has().text("17:05");
    }

}
