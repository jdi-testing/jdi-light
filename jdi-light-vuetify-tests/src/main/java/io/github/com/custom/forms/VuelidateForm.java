package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.Form;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import io.github.com.custom.CustomCheckbox;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public class VuelidateForm extends Form {

    @UI("//div[contains(@class, 'v-text-field--is-booted')][1]")
    public TextField nameField;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][2]")
    public TextField emailField;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][3]")
    public OverflowButton itemField;

    @UI(".v-input--checkbox")
    public CustomCheckbox optionCheckBox;

    @UI("//button[1]")
    public VuetifyButton submitButton;

    @UI("//button[2]")
    public VuetifyButton clearButton;

    public void validate() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (nameField.getText().isEmpty()) {
            exceptionMessage.append("Name can not be empty.  ");
        } else {
            if (nameField.hint().isVisible()) {
                exceptionMessage.append(nameField.hint().getText()).append(". ");
            }
        }
        if (emailField.getText().isEmpty()) {
            exceptionMessage.append("email can not be empty.  ");
        } else {
            if (emailField.hint().isVisible()) {
                exceptionMessage.append(emailField.hint().getText()).append(". ");
            }
        }
        if (itemField.selected().equals("Nothing selected")) {
            exceptionMessage.append("Select can not be empty.  ");
        } else {
            if (!itemField.hint().equals("Hint doesn't exist")) {
                exceptionMessage.append(itemField.hint());
            }
        }
        if (optionCheckBox.message().isVisible()) {
            exceptionMessage.append(optionCheckBox.message().getText()).append(" ");
        }
        if (!exceptionMessage.toString().equals("Form validation failed: ")) {
            throw runtimeException(exceptionMessage.toString(), this);
        }
    }

    public void isClear() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (!nameField.isEmpty()) {
            exceptionMessage.append("Name is not empty. ");
        }
        if (!emailField.isEmpty()) {
            exceptionMessage.append("E-mail is not empty. ");
        }
        if (!itemField.selected().equals("Nothing selected")) {
            exceptionMessage.append("Select is not empty. ");
        }
        if (optionCheckBox.isChecked()) {
            exceptionMessage.append("Checkbox is checked.");
        }
        if (!exceptionMessage.toString().equals("Form validation failed: ")) {
            throw runtimeException(exceptionMessage.toString(), this);
        }
    }
}
