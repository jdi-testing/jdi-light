package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class RadioButtonsCustom extends Section {
    @UI("[name='customRadio']")
    public RadioButtons radioButtons;
}
