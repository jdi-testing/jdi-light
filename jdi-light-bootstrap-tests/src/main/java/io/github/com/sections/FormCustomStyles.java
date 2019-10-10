package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.FormContacts;

public class FormCustomStyles extends Form<FormContacts> {

    @UI("#validationCustom01")
    public TextField name;
    @UI("#validationCustom02")
    public TextField lastName;
    @UI("#validationCustomUsername")
    public TextField userName;
    @UI("#validationCustom03")
    public TextField city;
    @UI("#validationCustom04")
    public TextField state;
    @UI("#validationCustom05")
    public TextField zip;

    @UI("#invalidCheck")
    public Checkbox accept;

    @UI("button")
    public Button submit;

}
