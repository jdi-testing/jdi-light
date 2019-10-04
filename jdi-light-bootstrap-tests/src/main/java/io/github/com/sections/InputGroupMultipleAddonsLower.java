package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class InputGroupMultipleAddonsLower extends Section {
    @UI("#right-sign") public Label firstLabel;
    @UI("#right-nil") public Label secondLabel;
    @UI(".form-control") public TextField textField;
}

