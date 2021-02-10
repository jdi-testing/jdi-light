package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxFrame;
import static io.github.com.StaticSite.formControlCheckBox;
import static io.github.com.StaticSite.groupCheckBox;
import static io.github.com.StaticSite.inputCheckboxDisabled;
import static io.github.com.StaticSite.primaryCheckBoxPage;

public class CheckBoxTests extends TestsInit {

    @Test
    public void primaryCheckBoxTest() {
        primaryCheckBoxPage.shouldBeOpened();
        checkboxFrame.checkbox.is().enabledCheckbox();
        checkboxFrame.checkbox.clickOnCheckbox();
        checkboxFrame.checkbox.check();
        checkboxFrame.checkbox.is().selectedCheckbox();
        checkboxFrame.checkbox.clickOnCheckbox();
        checkboxFrame.checkbox.is().unSelectedCheckbox();
        checkboxFrame.checkbox.unCheck();
    }

    @Test
    public void disabledCheckboxTest() {
        inputCheckboxDisabled.shouldBeOpened();
        checkboxFrame.checkbox.is().disabledCheckbox();
    }

    @Test
    public void formControlCheckBoxTest() {
        formControlCheckBox.shouldBeOpened();
        checkboxFrame.checkbox.is().enabledCheckbox();
        checkboxFrame.checkbox.is().assertEmailText();
        checkboxFrame.checkbox.is().assertHelperText();
        checkboxFrame.checkbox.clickOnCheckbox();
        checkboxFrame.checkbox.is().formControlDisplayed();
        checkboxFrame.checkbox.clickOnCheckbox();
    }

    @Test
    public void groupCheckBoxTest() {
        groupCheckBox.shouldBeOpened();
        checkboxFrame.groupCheckBox.is().assertGroupDisabled();
        checkboxFrame.groupCheckBox.is().assertGroupChecked();
        checkboxFrame.checkbox.is().enabledCheckbox();
        checkboxFrame.checkbox.clickOnCheckbox();
        checkboxFrame.checkbox.check();
        checkboxFrame.checkbox.clickOnCheckbox();
        checkboxFrame.checkbox.unCheck();
    }

}
