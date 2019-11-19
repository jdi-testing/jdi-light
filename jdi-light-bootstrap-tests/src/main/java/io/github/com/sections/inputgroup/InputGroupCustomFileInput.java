package io.github.com.sections.inputgroup;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.FileInput;

public class InputGroupCustomFileInput extends Section {
    //@FindBy(css ="label[for='file-input-c']")
    @UI("label[for='file-input-c']")
    public Label labelInputFile;
    //@FindBy(css ="input#file-input-c")
    @UI("input#file-input-c")
    public FileInput fileInput;
}
