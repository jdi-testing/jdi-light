package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class ButtonGroupBasicExample extends Section {

    @UI("//button[text()='Left']") public Button leftButton;
    @UI("//button[text()='Middle']") public Button middleButton;
    @UI("//button[text()='Right']") public Button rightButton;

}
