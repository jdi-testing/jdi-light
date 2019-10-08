package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class RadioButtonsCustomInline extends Section {

    @UI("#customRadioInline1")
    public RadioButton radio1;
    @UI("#customRadioInline2")
    public RadioButton radio2;
    @UI(".custom-control-inline")
    public RadioButton radioButton;
    @UI("label[for='customRadioInline1']")
    public Label radio1Label;
    @UI("label[for='customRadioInline2']")
    public Label radio2Label;

}
