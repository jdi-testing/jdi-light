package io.github.com.sections.form;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class CheckboxAndRadioButtonCustomDisabled extends Section {

    @UI("#customCheckDisabled1-div")
    public Checkbox checkboxContainer;
    @UI("#customCheckDisabled1")
    public Checkbox checkbox;
    @UI("#customRadioDisabled2-div")
    public RadioButton radioButtonContainer;
    @UI("#customRadioDisabled2")
    public RadioButton radioButton;
    @UI("label[for='customRadioDisabled2']")
    public Label radio1Label;

}
