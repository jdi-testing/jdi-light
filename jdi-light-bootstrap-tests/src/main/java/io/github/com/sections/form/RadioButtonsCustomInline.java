package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class RadioButtonsCustomInline extends Section {
    //@FindBy(css = ".custom-control-inline .custom-control-input")
    @UI(".custom-control-inline .custom-control-input")
    public RadioButtons radioButtons;
}
