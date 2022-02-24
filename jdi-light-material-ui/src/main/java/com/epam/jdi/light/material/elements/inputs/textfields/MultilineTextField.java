package com.epam.jdi.light.material.elements.inputs.textfields;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class MultilineTextField extends TextField {

    @UI("//textarea[1]")
    public TextArea textArea;

    @Override
    protected TextArea inputField() {
        return textArea;
    }
}
