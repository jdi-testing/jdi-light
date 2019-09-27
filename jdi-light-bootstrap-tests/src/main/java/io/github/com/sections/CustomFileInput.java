package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.FileInput;

public class CustomFileInput extends Section {
    //@FindBy(css = ".input-group-text")
    @UI(".input-group-text") public Label upload;

    //@FindBy(css = ".custom-file-input")
    @UI(".custom-file-input") public FileInput input;

    //@FindBy(css = ".custom-file-label")
    @UI(".custom-file-label") public Label label;
}
