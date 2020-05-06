package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JdiSettings;
import com.epam.jdi.light.elements.base.SeleniumSettings;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.pairs.Pair;

import static com.epam.jdi.light.common.SearchStrategies.ANY_ELEMENT;
import static com.epam.jdi.light.common.SearchStrategies.VISIBLE_ELEMENT;
import static com.epam.jdi.light.settings.CommonSettings.getCommonSettings;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;

public enum Strategies {
    JDI_STABLE(() -> {
        JDISettings jdiSettings = getJDISettings();
        jdiSettings.ELEMENT.getElementWithArgs = JdiSettings.GET_WITH_ARGS;
        jdiSettings.ELEMENT.clickType = ElementArea.SMART_CLICK;
        jdiSettings.ELEMENT.getTextType = TextTypes.SMART_TEXT;
        jdiSettings.ELEMENT.setTextType = SetTextTypes.SET_TEXT;
        jdiSettings.ELEMENT.searchRule = Pair.$("Visible", VISIBLE_ELEMENT);
        getCommonSettings().killBrowser = "afterAndBefore";
        jdiSettings.ELEMENT.beforeSearch = UIElement::show;
    }),
    JDI(() -> {
        JDISettings jdiSettings = getJDISettings();
        jdiSettings.ELEMENT.getElementWithArgs = JdiSettings.GET_WITH_ARGS;
        jdiSettings.ELEMENT.clickType = ElementArea.CENTER;
        jdiSettings.ELEMENT.getTextType = TextTypes.SMART_TEXT;
        jdiSettings.ELEMENT.setTextType = SetTextTypes.CLEAR_SEND_KEYS;
        jdiSettings.ELEMENT.searchRule = Pair.$("Visible", VISIBLE_ELEMENT);
        jdiSettings.ELEMENT.beforeSearch = el -> {
        };
    }),
    SELENIUM(() -> {
        JDISettings jdiSettings = getJDISettings();
        jdiSettings.ELEMENT.getElementWithArgs = SeleniumSettings.GET_WITH_ARGS;
        jdiSettings.ELEMENT.clickType = ElementArea.CENTER;
        jdiSettings.ELEMENT.getTextType = TextTypes.TEXT;
        jdiSettings.ELEMENT.setTextType = SetTextTypes.SEND_KEYS;
        jdiSettings.ELEMENT.searchRule = Pair.$("Any", ANY_ELEMENT);
        jdiSettings.ELEMENT.beforeSearch = el -> {
        };
    });

    public JAction action;
    Strategies(JAction action) { this.action = action; }
}
