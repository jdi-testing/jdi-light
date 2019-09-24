package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.FileInput;

public class CustomFileInputWithButton extends Section {

    @UI(".input-group-prepend") public Label uploadTextBefore;
    @UI(".input-group-append") public Label uploadTextAfter;

    @UI(".custom-file-input") public FileInput inputFiled;
    @UI(".custom-file-label") public UIElement labelText;
}
