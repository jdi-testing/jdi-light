package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ButtonGroup;

public class ButtonGroupSizing extends ButtonGroup {

    @UI("//button[contains(text(), 'Left')]")
    public Button leftBtn;
    @UI("//button[contains(text(), 'Middle')]")
    public Button midBtn;
    @UI("//button[contains(text(), 'Right')]")
    public Button rightBtn;

}
