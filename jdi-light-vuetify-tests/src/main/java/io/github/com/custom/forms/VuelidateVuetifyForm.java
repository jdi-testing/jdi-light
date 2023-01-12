package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyForm;
import io.github.com.custom.CustomCheckbox;
import io.github.com.entities.form.Vuelidate;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public class VuelidateVuetifyForm extends VuetifyForm<Vuelidate> {

    @UI("//div[contains(@class, 'v-text-field--is-booted')][1]")
    public TextField name;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][2]")
    public TextField email;

    @UI("//div[contains(@class, 'v-text-field--is-booted')][3]")
    public OverflowButton item;

    @UI(".v-input--checkbox")
    public CustomCheckbox confirmingCheckBox;

    @UI("//button[1]")
    public VuetifyButton submitButton;

    @UI("//button[2]")
    public VuetifyButton clearButton;

    @Override
    public void fill(Vuelidate entity) {
        name.setText(entity.name);
        email.setText(entity.email);
        item.select(entity.item);
        if (entity.confirmingCheckBox) {
            confirmingCheckBox.check();
        } else {
            confirmingCheckBox.uncheck();
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
        if (!item.selected().equals("")) {
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
