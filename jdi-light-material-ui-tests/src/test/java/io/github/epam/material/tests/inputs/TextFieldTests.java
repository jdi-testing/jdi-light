package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.inputTextFieldStandardPage;
import static io.github.com.StaticSite.textFieldFrame;

public class TextFieldTests extends TestsInit {

    @Test
    public void standardTextFieldTest() {
        inputTextFieldStandardPage.open();

//        textFieldFrame.textField.is().enabled();
        textFieldFrame.textField.setValue("aaa");
    }

}
