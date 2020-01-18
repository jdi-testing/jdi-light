package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.RadioButtons;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

public class CheckboxAndRadioButtonCustomDisabled extends Section {
    //FindBy(css = "#customCheckDisabled1-div")
    @UI("#customCheckDisabled1-div")
    public Checkbox checkbox;
    //FindBy(css = "#customRadioDisabled2")
    @UI("#customRadioDisabled2")
    public RadioButtons radioButtons;
}
