package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.User;

public class InputsForm extends Form<User> {

    @UI("#inputs_form_firstName")
    public TextField firstName;

    @UI("#inputs_form_lastName")
    public TextField lastName;

    @UI("#inputs_form_address")
    public TextField address;

    @UI("#inputs_form_address2")
    public TextField address2;

    @UI("#inputs_form_city")
    public TextField city;

    @UI("#inputs_form_state")
    public TextField state;

    @UI("#inputs_form_postalCode")
    public TextField postalCode;
}
