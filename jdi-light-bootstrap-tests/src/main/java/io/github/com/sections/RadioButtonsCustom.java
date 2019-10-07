package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class RadioButtonsCustom extends Section {

    @UI("#customRadio1")
    public RadioButton radio1;
    @UI("#customRadio1")
    public RadioButton radio2;
    @UI("input[name='customRadio']")
    public RadioButton radioButton;
    @UI("label[for='customRadio1']")
    public Label radio1Label;
    @UI("label[for='customRadio2']")
    public Label radio2Label;

}
