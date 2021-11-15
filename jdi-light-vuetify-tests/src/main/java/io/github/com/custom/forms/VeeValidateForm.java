package io.github.com.custom.forms;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import io.github.com.custom.CustomCheckbox;

import static com.epam.jdi.light.common.Exceptions.exception;

public class VeeValidateForm extends Section {

    @UI("//form//span[1]//div[contains(@class, 'v-text-field--is-booted')]")
    public TextField nameField;

    @UI("//form//span[2]//div[contains(@class, 'v-text-field--is-booted')]")
    public TextField phoneNumberField;

    @UI("//form//span[3]//div[contains(@class, 'v-text-field--is-booted')]")
    public TextField emailField;

    @UI("//form//span[4]//div[contains(@class, 'v-text-field--is-booted')]")
    public OverflowButton itemField;

    @UI(".v-input--checkbox")
    public CustomCheckbox optionCheckBox;

    @UI("//button[1]")
    public Button submitButton;

    @UI("//button[2]")
    public Button clearButton;

    public void validate() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (nameField.getText().isEmpty()) {
            exceptionMessage.append("Name can not be empty.  ");
        } else {
            if (nameField.message().isVisible()) {
                exceptionMessage.append(nameField.message().getText()).append(". ");
            }
        }
        if (phoneNumberField.getText().isEmpty()) {
            exceptionMessage.append("phoneNumber can not be empty.  ");
        } else {
            if (phoneNumberField.message().isVisible()) {
                exceptionMessage.append(phoneNumberField.message().getText()).append(". ");
            }
        }
        if (emailField.getText().isEmpty()) {
            exceptionMessage.append("email can not be empty.  ");
        } else {
            if (emailField.message().isVisible()) {
                exceptionMessage.append(emailField.message().getText()).append(". ");
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
            throw exception(exceptionMessage.toString(), this);
        }
    }

    public void isClear() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (!nameField.isEmpty()) {
            exceptionMessage.append("Name is not empty. ");
        }
        if (!phoneNumberField.isEmpty()) {
            exceptionMessage.append("Phone number is not empty. ");
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
            throw exception(exceptionMessage.toString(), this);
        }
    }
}
