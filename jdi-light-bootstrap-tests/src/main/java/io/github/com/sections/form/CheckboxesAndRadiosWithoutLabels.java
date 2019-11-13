package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class CheckboxesAndRadiosWithoutLabels extends Section {
    @UI("//input[@id='blankCheckbox']/..")
    public Checkbox checkbox;
    @UI("#blankRadio1")
    public RadioButtons radioButtons;
}
