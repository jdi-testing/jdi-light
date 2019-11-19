package io.github.com.sections.inputgroup;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.FileInput;

public class InputGroupCustomUploadFile extends Section {
    //@FindBy(css ="label[for='upload-file-c']")
    @UI("label[for='upload-file-c']")
    public Label labelInputFile;
    //@FindBy(css ="input#upload-file-c")
    @UI("input#upload-file-c")
    public FileInput fileInput;
    //@FindBy(css = "button")
    @UI("button")
    public Button btnSubmit;
}
