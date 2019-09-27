package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.FileInput;

public class CustomFileInputWithButton extends Section {

    @UI(".btn.btn-outline-secondary") public Button button;
    @UI(".custom-file-input")public FileInput input;
    @UI(".custom-file-label") public UIElement label;
}
