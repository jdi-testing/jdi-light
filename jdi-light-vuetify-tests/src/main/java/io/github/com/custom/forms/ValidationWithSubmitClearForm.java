package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.TextFieldDemo;
import com.epam.jdi.light.vuetify.elements.composite.Forms;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import io.github.com.custom.CustomCheckbox;

import static com.epam.jdi.light.common.Exceptions.exception;

public class ValidationWithSubmitClearForm extends Forms {

    //form[@id = 'ValidationWithSubmitClearForm']/div[contains(@class, 'v-text-field')]

    @UI("//div[contains(@class, 'v-text-field--is-booted')][1]")
    public TextFieldDemo nameField;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][2]")
    public TextFieldDemo emailField;

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

    public boolean validate() {
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
        } else {
            return true;
        }
    }
}
