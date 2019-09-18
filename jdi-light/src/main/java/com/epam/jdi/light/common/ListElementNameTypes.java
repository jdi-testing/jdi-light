package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

public enum ListElementNameTypes {
    SMART(UIElement::text),
    TEXT(el -> el.text(TextTypes.TEXT)),
    VALUE(el -> el.text(TextTypes.VALUE)),
    INNER(el -> el.text(TextTypes.INNER)),
    LABEL(UIElement::labelText),
    INDEX();

    public JFunc1<UIElement, String> func;
    ListElementNameTypes() { }
    ListElementNameTypes(JFunc1<UIElement, String> func) {
        this.func = func;
    }
}
