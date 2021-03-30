package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class TextFieldFrame extends Section {

    @UI(".MuiTextField-root")
    public TextField textField;

    @UI("textarea[rows]")
    public TextArea textAreaAutoSize;

}
