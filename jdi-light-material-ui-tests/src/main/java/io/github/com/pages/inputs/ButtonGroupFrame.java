package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;

public class ButtonGroupFrame extends Section {

    @UI(".MuiButtonGroup-root")
    public ButtonGroup buttonGroup;

}
