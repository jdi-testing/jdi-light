package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxFrame;
import static io.github.com.StaticSite.inputCheckboxDisabled;
import static io.github.com.StaticSite.primaryCheckBoxPage;

public class CheckBoxTests extends TestsInit {

    @Test
    public void primaryCheckBoxTest() {
        primaryCheckBoxPage.shouldBeOpened();
        checkboxFrame.checkbox.is().enabled();
        checkboxFrame.checkbox.check();
        checkboxFrame.checkbox.is().selected();
        checkboxFrame.checkbox.uncheck();
        checkboxFrame.checkbox.is().unSelected();
    }

    @Test
    public void disabledCheckboxTest() {
        inputCheckboxDisabled.shouldBeOpened();
        checkboxFrame.checkbox.is().disabled();
    }

}
