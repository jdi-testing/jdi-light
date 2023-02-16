package io.github.com.custom.windows;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class PasswordCreationWindow extends AccountWindow {

    @UI("input[1]")
    private TextField password;

    @UI("input[2]")
    private TextField confirmPassword;

    public TextField password() {
        return password;
    }

    public TextField confirmPassword() {
        return confirmPassword;
    }
}
