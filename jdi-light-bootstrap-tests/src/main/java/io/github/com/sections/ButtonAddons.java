package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class ButtonAddons extends Section {
// Button addons locators
    @UI("button")
    public Button button;
    @UI("input")
    public TextField input;

    @UI("button")
    public ListGroup listButtons;
    @UI("input")
    public TextField inputField;
}
