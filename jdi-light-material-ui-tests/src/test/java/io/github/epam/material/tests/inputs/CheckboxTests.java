package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxFrame;
import static io.github.com.StaticSite.inputCheckboxDisabled;

public class CheckboxTests extends TestsInit {

    @Test
    public void disabledCheckboxTests() {
        inputCheckboxDisabled.shouldBeOpened();
        checkboxFrame.checkbox.is().disabledCheckbox();
    }
}
