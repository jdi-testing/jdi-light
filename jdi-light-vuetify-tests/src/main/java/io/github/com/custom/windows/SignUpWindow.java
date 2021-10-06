package io.github.com.custom.windows;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class SignUpWindow extends AccountWindow {

    @UI(".v-text-field__slot")
    private Label label;

    @UI("input")
    private TextField email;

    public Label label() {
        return label;
    }

    public TextField email() {
        return email;
    }

}
