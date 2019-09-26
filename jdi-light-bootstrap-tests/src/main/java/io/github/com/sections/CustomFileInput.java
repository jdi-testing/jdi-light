package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.IG_FileInput;

public class CustomFileInput extends Section {

    @UI(".input-group-text") public Label uploadText;
    @UI("#inputGroupFile01") public IG_FileInput inputField;
    @UI(".custom-file-label") public Label labelText;
}
