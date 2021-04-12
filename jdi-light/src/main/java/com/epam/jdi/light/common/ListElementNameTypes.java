package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.tools.func.JFunc1;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum ListElementNameTypes {
    SMART(uiElement::text),
    TEXT(el -> el.text(TextTypes.TEXT)),
    VALUE(el -> el.text(TextTypes.VALUE)),
    INNER(el -> el.text(TextTypes.INNER)),
    LABEL(uiElement::labelText),
    INDEX();

    public JFunc1<uiElement, String> func;
    ListElementNameTypes() { }
    ListElementNameTypes(JFunc1<uiElement, String> func) {
        this.func = func;
    }
}
