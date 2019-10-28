package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Checkbox;

public class Switches extends Section {

    @UI("#customSwitch1-div") public Checkbox checkbox;
    //@UI("#customSwitch1-div") public Checkbox checkboxContainer;
    @UI("#customSwitch2-div") public Checkbox checkboxDisabled;
    //@UI("#customSwitch2-div") public Checkbox checkboxDisabledContainer;

}
