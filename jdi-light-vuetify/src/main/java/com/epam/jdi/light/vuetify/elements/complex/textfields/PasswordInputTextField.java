package com.epam.jdi.light.vuetify.elements.complex.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

public class PasswordInputTextField extends TextField {
    private static final String HIDED_ICON = ".//button[contains(@class,'mdi-eye-off')]";
    private static final String SHOWED_ICON = ".//button[contains(@class,'mdi-eye ')]";

    @JDIAction("'{name}' show password")
    public void showPassword() {
        find(HIDED_ICON).click();
    }
    @JDIAction("'{name}' show password")
    public void hidePassword() {
        find(SHOWED_ICON).click();
    }
}
