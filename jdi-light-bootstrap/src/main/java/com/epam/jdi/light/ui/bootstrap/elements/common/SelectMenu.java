package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

/**
 * To see an example of Select Menu web element please visit https://getbootstrap.com/docs/4.3/components/forms/#select-menu
 */

public class SelectMenu extends Section implements ISelector {

    @UI("option")
    public WebList optionsSelectMenu;

    @UI("option[selected]")
    public UIElement selectedOptionsSelectMenu;

    @Override
    public WebList list() {
        return optionsSelectMenu;
    }
}
