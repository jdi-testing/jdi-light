package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxFrame;
import static io.github.com.StaticSite.inputCheckboxDisabled;
import static io.github.com.StaticSite.primaryCheckBoxPage;

public class CheckBoxTests extends TestsInit {

    @Test
    public void primaryCheckBoxTest() {
        primaryCheckBoxPage.open();
        checkboxFrame.checkbox.is().enabled();
        checkboxFrame.checkbox.check();
        checkboxFrame.checkbox.is().checked();
        checkboxFrame.checkbox.uncheck();
        checkboxFrame.checkbox.is().unChecked();
    }

    @Test
    public void disabledCheckboxTest() {
        inputCheckboxDisabled.open();
        checkboxFrame.checkbox.is().disabled();
    }

}
