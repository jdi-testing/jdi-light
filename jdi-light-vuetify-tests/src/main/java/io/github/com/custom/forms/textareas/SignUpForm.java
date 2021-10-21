package io.github.com.custom.forms.textareas;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import io.github.com.custom.textareas.TextFieldArea;
import io.github.com.entities.textareas.SignUpData;

public class SignUpForm extends Form<SignUpData> {
    @UI(".v-input[1]")
    public static TextFieldArea password;

    @UI(".v-input[2]")
    public static TextFieldArea phone;

    @UI(".v-input[3]")
    public static TextFieldArea email;

    @UI(".v-input[4]")
    public static TextArea bio;

    @UI(".v-input[5] .v-input--selection-controls__input")
    public static UIElement agree;

    @UI(".v-card__actions button[1]")
    public static Button clear;

    @UI(".v-card__actions button[2]")
    public static Button submit;

    @Override
    public void fill(SignUpData entity) {
        clear.click();
        password.setText(entity.getPassword());
        phone.setText(entity.getPhone());
        email.setText(entity.getEmail());
        bio.setLines(entity.getBio());
        if (entity.isAgree()) {
            agree.click();
        }
    }
}
