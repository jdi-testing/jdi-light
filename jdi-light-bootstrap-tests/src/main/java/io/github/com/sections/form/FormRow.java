package io.github.com.sections.form;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormRow extends Section {
    @UI(".form-row")
    public UIElement row;
    @UI(".col")
    public WebList cols;
    @UI("[placeholder=\"First name\"]")
    public TextField firstName;
    @UI("[placeholder=\"Last name\"]")
    public TextField lastName;
}
