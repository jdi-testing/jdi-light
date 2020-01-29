package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JAction2;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: romClickTextFieldClickTextFieldan.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum SetTextTypes {
    SET_TEXT(UIElement::setText),
    SEND_KEYS(UIElement::sendKeys),
    CLEAR_SEND_KEYS((uiElement, value) -> {
        uiElement.clear();
        uiElement.sendKeys(value);
    });

    public JAction2<UIElement, String> action;
    SetTextTypes(JAction2<UIElement, String> action) {
        this.action = action;
    }
}
