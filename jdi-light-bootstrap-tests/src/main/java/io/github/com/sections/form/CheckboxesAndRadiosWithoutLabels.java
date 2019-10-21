package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class CheckboxesAndRadiosWithoutLabels extends Section {

    @UI("#blankCheckbox")
    public Checkbox checkbox;
    @UI("#blankRadio1")
    public RadioButton radioButton;

}
