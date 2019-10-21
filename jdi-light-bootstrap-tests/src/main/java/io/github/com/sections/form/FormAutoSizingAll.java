package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormAutoSizingAll extends Section {

    @UI("#inlineFormInput")
    public TextField name;
    @UI("#inlineFormInputGroup")
    public TextField email;
    @UI("#autoSizingCheck")
    public Checkbox rememberMeCheckbox;
    @UI("button")
    public Button submit;
}
