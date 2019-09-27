package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class RadioButtonGroup extends Section {

    @UI("#exampleRadios1")
    public RadioButton radio1;
    @UI("#exampleRadios2")
    public RadioButton radio2;
    @UI("#exampleRadios3")
    public RadioButton radio3;
    @UI("input[type='radio']")
    public RadioButton radioButton;

//    Use next type of css locator to combine several radio buttons from different containers in to one group.
//    @UI("input[name='exampleRadios']") public RadioButton radioButton;

    @UI("label[for='exampleRadios1']")
    public Label radio1Label;
    @UI("label[for='exampleRadios2']")
    public Label radio2Label;
    @UI("label[for='exampleRadios3']")
    public Label radio3Label;
}
