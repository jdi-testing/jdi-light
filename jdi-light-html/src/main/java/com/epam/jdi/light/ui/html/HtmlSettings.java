package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.ui.html.elements.complex.Dropdown;

import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.PRE_INIT;

public class HtmlSettings {
    public static void init() {
        PRE_INIT.add("HtmlSettings", () -> {
            INTERFACES.add(IsDropdown.class, Dropdown.class);
        });
    }
}
