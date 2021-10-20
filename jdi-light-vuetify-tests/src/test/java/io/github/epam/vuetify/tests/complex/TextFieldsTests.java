package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Input;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.slidersPage;
import static io.github.com.StaticSite.textFieldsPage;
import static io.github.com.pages.TextFieldsPage.*;

public class TextFieldsTests extends TestsInit {

    @BeforeClass
    public void before() {
        textFieldsPage.open();
        textFieldsPage.checkOpened();
    }

    @Test
    public void clearableTextFieldTest() {
//        clearableTextField.get(1).clear();
//
//        clearableTextField.get(1).clear();

        //clearableTextField.get(1).find("input").clearTextField();
//        Button button = new Button(clearableTextField.get(1).find("button"));
//        Boolean isclick = button.core().isClickable();
//        button.click();
//        button.core().isClickable();
    }

}
