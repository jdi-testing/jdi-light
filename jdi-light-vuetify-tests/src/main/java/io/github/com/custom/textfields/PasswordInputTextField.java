package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

public class PasswordInputTextField extends TextField {

    private static final String HIDED_ICON = ".//button[contains(@class,'mdi-eye-off')]";
    private static final String SHOWED_ICON = ".//button[contains(@class,'mdi-eye ')]";

    @JDIAction("Show '{name}' password")
    public void showPassword() {
        find(HIDED_ICON).click();
    }

    @JDIAction("Hide '{name}' password")
    public void hidePassword() {
        find(SHOWED_ICON).click();
    }
}
