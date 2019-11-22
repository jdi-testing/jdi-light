package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ButtonGroupBasicExample extends Section {

    @UI("//button[contains(., 'Left')]") public Button leftButton;
    @UI("//button[contains(., 'Middle')]") public Button middleButton;
    @UI("//button[contains(., 'Right')]") public Button rightButton;

}
