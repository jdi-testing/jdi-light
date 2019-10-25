package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Form;

public class SelectMenu extends Form implements ISelector {

    @UI("option") public WebList optionsSelectMenu;

    @UI("option[selected]") public UIElement selectedOptionsSelectMenu;

    @Override
    public WebList list() { return optionsSelectMenu; }
}
