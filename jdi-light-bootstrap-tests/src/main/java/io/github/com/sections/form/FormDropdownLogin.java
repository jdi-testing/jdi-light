package io.github.com.sections.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.elements.composite.Form;
import io.github.com.entities.User;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class FormDropdownLogin extends  Form<User> {
    @UI("#exampleDropdownFormEmail1") public TextField email;
    @UI("#exampleDropdownFormPassword1") public TextField password;
    @UI("//input[@id='dropdownCheck']/..") public Checkbox remember;
    @UI("//button") public Button signIn;
}
