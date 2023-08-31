package io.github.com.entities;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class InputsForm extends Form<User> {

    @UI("#inputs_form_firstName")
    public Input firstName;

    @UI("#inputs_form_lastName")
    public Input lastName;

    @UI("#inputs_form_address")
    public Input address;

    @UI("#inputs_form_address2")
    public Input address2;

    @UI("#inputs_form_city")
    public Input city;

    @UI("#inputs_form_state")
    public Input state;

    @UI("#inputs_form_postalCode")
    public Input postalCode;
}
