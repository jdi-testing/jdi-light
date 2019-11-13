package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.FormContacts;

public class FormInlineUsername extends Form<FormContacts> {

    @UI("#inlineFormInputName2")
    public TextField name;
    @UI("#inlineFormInputGroupUsername2")
    public TextField userName;
    @UI("//input[@id='inlineFormCheck']/..")
    public Checkbox rememberMeCheckbox;
    @UI(".btn")
    public Button submit;
}
