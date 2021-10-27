package io.github.com.custom.windows;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class SignUpWindow extends AccountWindow {

    @UI("input")
    private TextField email;

    public TextField email() {
        return email;
    }
}
