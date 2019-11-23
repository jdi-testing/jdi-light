package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

public class Switches extends Section {

    @UI("#customSwitch1-div")
    public Checkbox checkbox;
    @UI("#customSwitch2-div")
    public Checkbox checkboxDisabled;

}
