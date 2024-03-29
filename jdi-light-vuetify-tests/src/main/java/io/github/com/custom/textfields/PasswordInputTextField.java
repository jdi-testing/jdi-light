package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

/**
 * Represents password input text field component on Vuetify.
 *
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/text-fields">Text fields test page</a>
 */
public class PasswordInputTextField extends TextField {

    private static final String HIDED_ICON = ".//button[contains(@class,'mdi-eye-off')]";
    private static final String SHOWED_ICON = ".//button[contains(@class,'mdi-eye ')]";

    /** Show the input password.
     */
    @JDIAction("Show '{name}' password")
    public void showPassword() {
        find(HIDED_ICON).click();
    }

    /** Hide the input password.
     */
    @JDIAction("Hide '{name}' password")
    public void hidePassword() {
        find(SHOWED_ICON).click();
    }
}
