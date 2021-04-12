package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.light.mobile.elements.base.mobileUIElement.SMART_GET_TEXT;
import static com.epam.jdi.light.mobile.elements.base.mobileUIElement.SMART_LIST_TEXT;

public enum MobileTextTypes {
    SMART_TEXT(SMART_GET_TEXT),
    SMART_LIST(SMART_LIST_TEXT),
    TEXT(ui -> ui.get().getText()),
    VALUE(ui -> ui.attr("value")),
    INNER(ui -> ui.jsExecute("innerText")),
    LABEL(UIElement::labelText),
    INDEX();

    public JFunc1<mobileUIElement, String> func;
    MobileTextTypes() { }
    MobileTextTypes(JFunc1<mobileUIElement, String> func) {
        this.func = func;
    }
}
