package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.Forms;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.common.Exceptions.exception;

public class RuleForm extends Forms {

    @UI(".col-md-4 .v-text-field--is-booted")
    public TextField mainTextField;

    @UI(".col-md-6 .v-text-field--is-booted")
    public TextField validationTextField;

    @UI(".v-input__slider")
    public Slider slider;

    @UI(".v-input--checkbox")
    public Checkbox checkbox;

    @Override
    public boolean validate() {
        Timer.sleep(1000);
        if (!mainTextField.getMessage().isEmpty()) {
            throw exception("Form validation failed: " + mainTextField.getMessage(), this);
        } else {
            return true;
        }
    }

    @Override
    public boolean isClear() {
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
        return true;
    }
}
