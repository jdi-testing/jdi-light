package com.epam.jdi.bdd.elements;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.webList;

public class CustomMenu extends Menu {
    @Override
    public webList list() {
        return super.list().setUIElementName(ui -> ui.findFirst("span").getText());
    }
}
