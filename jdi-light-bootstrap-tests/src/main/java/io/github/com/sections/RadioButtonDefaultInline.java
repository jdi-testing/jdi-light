package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class RadioButtonDefaultInline extends Section {

    @UI("input[name='inlineRadioOptions']")
    public RadioButton radioButton;
    @UI("#inlineRadio1")
    public RadioButton radio1;
    @UI("#inlineRadio2")
    public RadioButton radio2;
    @UI("#inlineRadio3")
    public RadioButton radio3;
    @UI("label[for='inlineRadio1']")
    public Label radio1Label;
    @UI("label[for='inlineRadio2']")
    public Label radio2Label;
    @UI("label[for='inlineRadio3']")
    public Label radio3Label;

}
