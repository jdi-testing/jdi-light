package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.complex.RadioButtons;

public class CheckboxAndRadioButtonCustomDisabled extends Section {

    @UI("#customCheckDisabled1-div")
    public Checkbox checkbox;

    @UI("#customRadioDisabled2")
    public RadioButtons radioButtons;
}
