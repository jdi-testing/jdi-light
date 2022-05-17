package com.epam.jdi.light.vuetify.elements.complex.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

public class PasswordInputTextField extends TextField {
    private static final String hidedIcon = ".//button[contains(@class,'mdi-eye-off')]";
    private static final String showedIcon = ".//button[contains(@class,'mdi-eye ')]";

    @JDIAction("'{name}' show password")
    public void showPassword() {
        find(hidedIcon).click();
    }
    @JDIAction("'{name}' show password")
    public void hidePassword() {
        find(showedIcon).click();
    }
}
