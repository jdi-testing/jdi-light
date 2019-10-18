package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormDisabled extends Section {

    @UI("#disabledTextInput")
    public TextField textField;
    @UI("#disabledSelect")
    public Selector selector;
    @UI("#disabledFieldsetCheck")
    public Checkbox checkbox;
    @UI("button")
    public Button submit;

}
