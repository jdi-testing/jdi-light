package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class Toast extends Section {
    @UI(".toast-header") public Label header;
    @UI(".mr-auto") public Text headerText;
    @UI(".toast-body") public Text body;
    @UI(".close") public Button closeButton;
}
