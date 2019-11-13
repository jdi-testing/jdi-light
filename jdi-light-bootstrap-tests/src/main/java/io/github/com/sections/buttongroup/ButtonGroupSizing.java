package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ButtonGroupSizing extends Section {

    @UI("//button[contains(text(), 'Left')]")
    public Button leftBtn;
    @UI("//button[contains(text(), 'Middle')]")
    public Button midBtn;
    @UI("//button[contains(text(), 'Right')]")
    public Button rightBtn;

}
