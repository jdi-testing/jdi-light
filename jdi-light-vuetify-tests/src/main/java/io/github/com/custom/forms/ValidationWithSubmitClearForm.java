package io.github.com.custom.forms;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import io.github.com.custom.CustomCheckbox;

import static com.epam.jdi.light.common.Exceptions.exception;

public class ValidationWithSubmitClearForm extends Section {

    @UI("//div[contains(@class, 'v-text-field--is-booted')][1]")
    public TextField nameField;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][2]")
    public TextField emailField;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][3]")
    public OverflowButton itemField;

    @UI(".v-input--checkbox")
    public CustomCheckbox confirmingCheckBox;

    @UI("button")
    public Button validateButton;

    @UI("button.error")
    public Button resetFormButton;

    @UI("button.warning")
    public Button resetValidationButton;

    public void validate() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (validateButton.isEnabled()) {
            validateButton.click();
        }
        if (nameField.message().isVisible()) {
            exceptionMessage.append(nameField.message().getText()).append(". ");
        }
        if (emailField.message().isVisible()) {
            exceptionMessage.append(emailField.message().getText()).append(". ");
        }
        if (confirmingCheckBox.message().isVisible()) {
            exceptionMessage.append(confirmingCheckBox.message().getText()).append(" ");
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
        if (!emailField.isEmpty()) {
            exceptionMessage.append("E-mail is not empty. ");
        }
        if (!itemField.selected().equals("Nothing selected")) {
            exceptionMessage.append("Select is not empty. ");
        }
        if (confirmingCheckBox.isChecked()) {
            exceptionMessage.append("Checkbox is checked.");
        }
        if (!exceptionMessage.toString().equals("Form validation failed: ")) {
            throw exception(exceptionMessage.toString(), this);
        }
    }
}
