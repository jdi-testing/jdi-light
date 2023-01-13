package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyForm;
import io.github.com.custom.CustomCheckbox;
import io.github.com.entities.form.VeeValidate;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public class VeeValidateVuetifyForm extends VuetifyForm<VeeValidate> {

    @UI("//form//span[1]//div[contains(@class, 'v-text-field--is-booted')]")
    public TextField name;

    @UI("//form//span[2]//div[contains(@class, 'v-text-field--is-booted')]")
    public TextField phoneNumber;

    @UI("//form//span[3]//div[contains(@class, 'v-text-field--is-booted')]")
    public TextField email;

    @UI("//form//span[4]//div[contains(@class, 'v-text-field--is-booted')]")
    public OverflowButton item;

    @UI(".v-input--checkbox")
    public CustomCheckbox optionCheckBox;

    @UI("//button[1]")
    public VuetifyButton submitButton;

    @UI("//button[2]")
    public VuetifyButton clearButton;

    @Override
    public void fill(VeeValidate entity) {
        name.setText(entity.name);
        phoneNumber.setText(entity.phoneNumber);
        email.setText(entity.email);
        item.select(entity.item);
        if (entity.confirmingCheckBox) {
            optionCheckBox.check();
        } else {
            optionCheckBox.uncheck();
        }
    }

    @Override
    public boolean isValid() {
        StringBuilder exceptionMessage = new StringBuilder();
        exceptionMessage.append("Form validation failed: ");

        if (name.getText().isEmpty()) {
            exceptionMessage.append("Name can not be empty.  ");
        } else {
            if (name.hasErrorMessages()) {
                exceptionMessage.append(name.messagesText()).append(". ");
            }
        }
        if (phoneNumber.getText().isEmpty()) {
            exceptionMessage.append("phoneNumber can not be empty.  ");
        } else {
            if (phoneNumber.hasErrorMessages()) {
                exceptionMessage.append(phoneNumber.messagesText()).append(". ");
            }
        }
        if (email.getText().isEmpty()) {
            exceptionMessage.append("email can not be empty.  ");
        } else {
            if (email.hasErrorMessages()) {
                exceptionMessage.append(email.messagesText()).append(". ");
            }
        }
        if (item.selected().equals("Nothing selected")) {
            exceptionMessage.append("Select can not be empty.  ");
        } else {
            if (!Integer.valueOf(item.messagesCount()).equals(0)) {
                exceptionMessage.append(item.messagesText().get(1));
            }
        }
        if (optionCheckBox.message().isVisible()) {
            exceptionMessage.append(optionCheckBox.message().getText()).append(" ");
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
        if (!phoneNumber.isEmpty()) {
            exceptionMessage.append("Phone number is not empty. ");
        }
        if (!email.isEmpty()) {
            exceptionMessage.append("E-mail is not empty. ");
        }
        if (!item.selected().equals("")) {
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
