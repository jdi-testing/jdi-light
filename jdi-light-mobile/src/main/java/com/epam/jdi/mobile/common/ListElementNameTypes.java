package com.epam.jdi.mobile.common;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
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
