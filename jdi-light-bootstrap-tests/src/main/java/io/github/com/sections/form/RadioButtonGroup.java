package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.RadioButtons;

public class RadioButtonGroup extends Section {
    @UI("input[type='radio']")
    public RadioButtons radioButtons;
}
