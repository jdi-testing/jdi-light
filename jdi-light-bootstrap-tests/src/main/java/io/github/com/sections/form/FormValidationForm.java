package io.github.com.sections.form;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Form;
import io.github.com.entities.SimpleContact;

public class FormValidationForm extends Form<SimpleContact> {

    @UI("#validated-form-name-field")
    private TextField name;
    @UI("#validated-form-email")
    private TextField email;
    @UI("#validated-form-phone")
    private TextField phone;



}
