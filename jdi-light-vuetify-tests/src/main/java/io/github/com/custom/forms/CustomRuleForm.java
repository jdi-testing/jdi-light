package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.TextFieldDemo;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.composite.Forms;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.common.Exceptions.exception;

public class CustomRuleForm extends Forms {

    @UI(".col-md-4 .v-text-field--is-booted")
    public TextFieldDemo mainTextFieldDemo;

    @UI(".col-md-6 .v-text-field--is-booted")
    public TextFieldDemo validationTextFieldDemo;

    @UI(".v-input__slider")
    public Slider slider;

    @UI(".v-input--checkbox")
    public Checkbox checkbox;

    public boolean validate() {
        Timer.waitCondition(mainTextFieldDemo::isDisplayed);
        if (mainTextFieldDemo.message().isVisible()) {
            throw exception("Form validation failed: " + mainTextFieldDemo.getMessage(), this);
        } else {
            return true;
        }
    }
}
