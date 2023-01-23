package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyForm;
import io.github.com.entities.form.Rules;

public class RulesVuetifyForm extends VuetifyForm<Rules> {
    @UI(".col-md-4 .v-text-field--is-booted")
    public TextField firstName;
    @UI(".v-input__slider")
    public Slider maxCharacters;
    @UI(".v-input--checkbox")
    public VueCheckbox allowSpaces;
    @UI(".col-md-6 .v-text-field--is-booted")
    public TextField valueMustMatch;

    @Override
    public void fill(Rules entity) {
        firstName.setText(entity.firstName);
        maxCharacters.slideHorizontalTo(Double.parseDouble(entity.maxCharacters));
        if (entity.allowSpaces) {
            allowSpaces.check();
        } else {
            allowSpaces.uncheck();
        }
        valueMustMatch.setText(entity.valueMustMatch);
    }
}
