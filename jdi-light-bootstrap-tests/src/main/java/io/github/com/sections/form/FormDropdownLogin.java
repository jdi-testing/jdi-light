package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.FormContacts;

public class FormDropdownLogin extends  Form<FormContacts> {
    @UI("#exampleDropdownFormEmail1") public TextField email;
    @UI("#exampleDropdownFormPassword1") public TextField password;
    @UI("//input[@id='dropdownCheck']/..") public Checkbox checkbox;
    @UI("//button") public Button accept;
}
