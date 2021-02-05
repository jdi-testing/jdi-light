package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;

public class CheckboxFrame {

    @UI("//span[contains(@class,'MuiButtonBase-root')]")
    public Checkbox checkbox;
}
