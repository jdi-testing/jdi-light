package io.github.com.custom.forms;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.Form;

import static com.epam.jdi.light.common.Exceptions.exception;

public class RuleForm extends Form {

    @UI(".col-md-4 .v-text-field--is-booted")
    public TextField mainTextField;

    @UI(".col-md-6 .v-text-field--is-booted")
    public TextField validationTextField;

    @UI(".v-input__slider")
    public Slider slider;

    @UI(".v-input--checkbox")
    public Checkbox checkbox;

    public void validate() {
        if (mainTextField.message().isVisible()) {
            throw exception("Form validation failed: " + mainTextField.message().getText(), this);
        }
    }

    public void isClear() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (!mainTextField.isEmpty()) {
            exceptionMessage.append("Main field is not empty. ");
        }
        if (checkbox.isChecked()) {
            exceptionMessage.append("Checkbox is checked.");
        }
        if (!validationTextField.isEmpty()) {
            exceptionMessage.append("Validation field is not empty. ");
        }
        if (!exceptionMessage.toString().equals("Form validation failed: ")) {
            throw exception(exceptionMessage.toString(), this);
        }
    }
}
