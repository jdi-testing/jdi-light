package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ButtonWithBadge extends Button {

    @UI(".badge")
    public Text badge;
}
