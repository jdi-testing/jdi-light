package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

/**
 * Represents clearable text field component on Vuetify.
 *
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/text-fields">Text fields test page</a>
 */
public class ClearableTextField extends TextField {

    private static final String CLEAR_TEXT_BUTTON = ".//button[@aria-label='clear icon']";

    /** Clear the text of the TextField by clicking on clear text button.
     */
    @JDIAction("Clear '{name}' by click on clear button")
    public void clear() {
        find(CLEAR_TEXT_BUTTON).click();
    }

}
