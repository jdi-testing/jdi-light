package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.Users;

public class InputsForm extends Form<Users> {

    @UI("#mat-input-20")
    public static TextField firstName;

    @UI("#mat-input-21")
    public static TextField lastName;

    @UI("#mat-input-22")
    public static TextField address;

    @UI("#mat-input-23")
    public static TextField address2;

    @UI("#mat-input-24")
    public static TextField city;

    @UI("#mat-input-25")
    public static TextField state;

    @UI("#mat-input-26")
    public static TextField postalCode;
}
