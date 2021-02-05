package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxFrame;
import static io.github.com.StaticSite.primaryCheckBoxPage;

public class CheckBoxTests extends TestsInit {

    @Test
    public void primaryCheckBoxTest() {
        primaryCheckBoxPage.shouldBeOpened();
        checkboxFrame.checkbox.is().enabledCheckbox();
        checkboxFrame.checkbox.check();
        checkboxFrame.checkbox.is().selectedCheckbox();
        checkboxFrame.checkbox.clickOnCheckbox();
        checkboxFrame.checkbox.is().unSelectedCheckbox();
        checkboxFrame.checkbox.unCheck();
    }

}
