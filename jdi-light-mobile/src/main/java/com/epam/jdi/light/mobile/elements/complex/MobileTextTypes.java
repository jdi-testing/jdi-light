package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.tools.func.JFunc1;

import static  com.epam.jdi.light.mobile.elements.base.MobileAppUIElement.MOBILE_SMART_LIST_TEXT;


public enum MobileTextTypes {
    MOBILE_SMART_LIST(MOBILE_SMART_LIST_TEXT),
    TEXT(mobile -> mobile.get().getText()),
    VALUE(mobile -> mobile.attr("value")),
    INNER(mobile -> mobile.jsExecute("innerText")),
    MOBILE_LABEL(MobileAppUIElement::labelText),
    MOBILE_INDEX();
    public JFunc1<MobileAppUIElement, String> func;
    MobileTextTypes() { }
    MobileTextTypes(JFunc1<MobileAppUIElement, String> func) {
        this.func = func;
    }
}
