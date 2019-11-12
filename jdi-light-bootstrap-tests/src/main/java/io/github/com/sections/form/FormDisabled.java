package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.composite.MediaObject;

public class FormDisabled extends Section {

    @UI("fieldset")
    public MediaObject formContainer;
    @UI("#disabledTextInput")
    public TextField textField;
    @UI("#disabledSelect")
    public Selector selector;
    @UI("//input[@id='disabledFieldsetCheck']/..")
    public Checkbox checkbox;
    @UI("button")
    public Button submit;

}
