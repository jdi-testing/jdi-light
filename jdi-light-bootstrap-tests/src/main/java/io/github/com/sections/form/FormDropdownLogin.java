package io.github.com.sections.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.elements.composite.Form;
import io.github.com.entities.FormContacts;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class FormDropdownLogin extends  Form<FormContacts> {
    @UI("#exampleDropdownFormEmail1") public TextField email;
    @UI("#exampleDropdownFormPassword1") public TextField password;
    @UI("//input[@id='dropdownCheck']/..") public Checkbox checkbox;
    @UI("//button") public Button accept;
}
