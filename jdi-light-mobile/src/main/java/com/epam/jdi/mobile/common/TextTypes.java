package com.epam.jdi.mobile.common;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum TextTypes {
    SMART_TEXT(UIElement.SMART_GET_TEXT),
    SMART_LIST(UIElement.SMART_LIST_TEXT),
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
