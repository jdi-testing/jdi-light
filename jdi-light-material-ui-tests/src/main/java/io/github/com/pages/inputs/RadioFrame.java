package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Radio;

public class RadioFrame extends Section {
    @UI("//span[text()='First']/../span[1]")
    public Radio firstRadio;

    @UI("//span[text()='Second']/../span[1]")
    public Radio secondRadio;

    @UI("//span[text()='Third']/../span[1]")
    public Radio thirdRadio;

    @UI("//span[text()='Disabled']/../span[1]")
    public Radio disabledRadio;

    @UI("//fieldset/p")
    public Radio textField;
}
