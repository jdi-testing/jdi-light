package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

import static org.apache.commons.lang3.StringUtils.isBlank;

public enum ListElementNameTypes {
    SMART(el -> {
        String text = el.text(TextTypes.TEXT);
        if (isBlank(text))
            text = el.labelText();
        return text;
    }),
    TEXT(el -> el.text(TextTypes.TEXT)),
    VALUE(el -> el.text(TextTypes.VALUE)),
    INNER(el -> el.text(TextTypes.INNER)),
    LABEL(UIElement::labelText),
    INDEX();

    public static ListElementNameTypes get(TextTypes type) {
        switch (type) {
            case TEXT:
                return TEXT;
            case VALUE:
                return VALUE;
            case INNER:
                return INNER;
            default:
                return SMART;
        }
    }

    public JFunc1<UIElement, String> func;
    ListElementNameTypes() { }
    ListElementNameTypes(JFunc1<UIElement, String> func) {
        this.func = func;
    }
}
