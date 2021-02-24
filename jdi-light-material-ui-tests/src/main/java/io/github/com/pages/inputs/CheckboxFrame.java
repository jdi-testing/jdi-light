package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;

public class CheckboxFrame extends Section {

    @UI("//span[contains(@class,'MuiButtonBase-root')]")
    public Checkbox checkbox;
}
