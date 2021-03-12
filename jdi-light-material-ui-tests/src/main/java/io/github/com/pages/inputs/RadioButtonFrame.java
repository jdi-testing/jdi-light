package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.RadioButton;

public class RadioButtonFrame extends Section {
    @UI("//span[text()='First']/../span[1]")
    public RadioButton firstRadioButton;

    @UI("//span[text()='Second']/../span[1]")
    public RadioButton secondRadioButton;

    @UI("//span[text()='Third']/../span[1]")
    public RadioButton thirdRadioButton;

    @UI("//span[text()='Disabled']/../span[1]")
    public RadioButton disabledRadioButton;

    @UI("//fieldset/p")
    public RadioButton textField;
}
