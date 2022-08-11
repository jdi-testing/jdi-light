package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.Form;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import io.github.com.custom.CustomCheckbox;
import io.github.com.entities.form.ValidationWithSubmitClear;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public class ValidationWithSubmitClearForm extends Form<ValidationWithSubmitClear> {

    @UI("//div[contains(@class, 'v-text-field--is-booted')][1]")
    public TextField name;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][2]")
    public TextField email;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][3]")
    public OverflowButton item;

    @UI(".v-input--checkbox")
    public CustomCheckbox confirmingCheckBox;

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
        exceptionMessage.append("Form validation failed: ");

        if (name.hint().isVisible()) {
            exceptionMessage.append(name.hint().getText()).append(". ");
        }
        if (email.hint().isVisible()) {
            exceptionMessage.append(email.hint().getText()).append(". ");
        }
        if (confirmingCheckBox.message().isVisible()) {
            exceptionMessage.append(confirmingCheckBox.message().getText()).append(" ");
        }
        if (!exceptionMessage.toString().equals("Form validation failed: ")) {
            throw runtimeException(exceptionMessage.toString(), this);
        }
        return true;
    }

    public void isClear() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (!name.isEmpty()) {
            exceptionMessage.append("Name is not empty. ");
        }
        if (!email.isEmpty()) {
            exceptionMessage.append("E-mail is not empty. ");
        }
        if (!item.selected().equals("Nothing selected")) {
            exceptionMessage.append("Select is not empty. ");
        }
        if (confirmingCheckBox.isChecked()) {
            exceptionMessage.append("Checkbox is checked.");
        }
        if (!exceptionMessage.toString().equals("Form validation failed: ")) {
            throw runtimeException(exceptionMessage.toString(), this);
        }
    }
}
