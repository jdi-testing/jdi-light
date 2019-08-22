package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.light.elements.common.UIElement.SMART_GET_TEXT;
import static com.epam.jdi.light.elements.common.UIElement.SMART_LIST_TEXT;

public enum TextTypes {
    SMART(SMART_GET_TEXT),
    SMART_LIST(SMART_LIST_TEXT),
    TEXT(ui -> ui.get().getText()),
    VALUE(ui -> ui.attr("value")),
    INNER(ui -> ui.jsExecute("innerText")),
    LABEL(UIElement::labelText),
    INDEX();

    public JFunc1<UIElement, String> func;
    TextTypes() { }
    TextTypes(JFunc1<UIElement, String> func) {
        this.func = func;
    }
}
