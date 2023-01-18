package io.github.com.custom.elements.textfields;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

/**
 * Represents multiline text field MUI component on GUI.
 * This text field has textarea component that represents the input field.
 *
 * @see <a href="https://mui.com/components/text-fields/#multiline">Multiline Text Field MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class MultilineTextField extends TextField {

    /**
     * Textarea that represents the input field of the text field.
     */
    @UI("//textarea[1]")
    public TextArea textArea;

    @Override
    protected TextArea inputField() {
        return textArea;
    }
}
