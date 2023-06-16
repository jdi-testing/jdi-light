package io.github.com.custom.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import io.github.com.custom.CustomVueCheckbox;
import io.github.com.entities.form.ValidationWithSubmitClear;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public class ValidationWithSubmitClearVuetifyForm extends Form<ValidationWithSubmitClear> {

    @UI("//div[contains(@class, 'v-text-field--is-booted')][1]")
    public TextField name;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][2]")
    public TextField email;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][3]")
    public OverflowButton item;

    @UI(".v-input--checkbox")
    public CustomVueCheckbox confirmingCheckBox;

    @UI("button")
    public VuetifyButton validateButton;

    @UI("button.error")
    public VuetifyButton resetFormButton;

    @UI("button.warning")
    public VuetifyButton resetValidationButton;

    @Override
    public void fill(ValidationWithSubmitClear entity) {
        name.setText(entity.name);
        email.setText(entity.email);
        item.select(entity.item);
        if (entity.confirmingCheckBox) {
            confirmingCheckBox.check();
        } else {
            confirmingCheckBox.uncheck();
        }
    }

    public void validate() {
        if (validateButton.isEnabled()) {
            validateButton.click();
        }
        isValid();
    }

    @Override
    public boolean isValid() {
        StringBuilder exceptionMessage = new StringBuilder();

        if (name.hasErrorMessages()) {
            exceptionMessage.append(name.messagesText()).append(". ");
        }
        if (email.hasErrorMessages()) {
            exceptionMessage.append(email.messagesText()).append(". ");
        }
        if (confirmingCheckBox.message().isVisible()) {
            exceptionMessage.append(confirmingCheckBox.message().getText()).append(" ");
        }
        if (!exceptionMessage.toString().isEmpty()) {
            throw runtimeException("Form validation failed: " + exceptionMessage, this);
        }
        return true;
    }

    public void isClear() {
        StringBuilder validationErrors = new StringBuilder();

        if (!name.isEmpty()) {
            validationErrors.append("Name is not empty. ");
        }
        if (!email.isEmpty()) {
            validationErrors.append("E-mail is not empty. ");
        }
        if (!item.selected().equals("")) {
            validationErrors.append("Select is not empty. ");
        }
        if (confirmingCheckBox.isChecked()) {
            validationErrors.append("Checkbox is checked.");
        }
        if (!validationErrors.toString().isEmpty()) {
            throw runtimeException("Form is not clear: " + validationErrors, this);
        }
    }
}
