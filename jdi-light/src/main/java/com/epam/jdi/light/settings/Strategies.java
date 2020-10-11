package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.JdiSettings;
import com.epam.jdi.light.elements.base.SeleniumSettings;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.pairs.Pair;

import static com.epam.jdi.light.common.SearchStrategies.ANY_ELEMENT;
import static com.epam.jdi.light.common.SearchStrategies.VISIBLE_ELEMENT;
import static com.epam.jdi.light.logger.Strategy.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.STRICT_SEARCH;
import static com.epam.jdi.tools.LinqUtils.list;

public enum Strategies {
    JDI_SMART(() -> {
        ELEMENT.getElementWithArgs = JdiSettings.GET_WITH_ARGS;
        ELEMENT.getElementAndValidate = JdiSettings.GET_AND_VALIDATE;
        ELEMENT.clickType = ElementArea.SMART_CLICK;
        ELEMENT.getTextType = TextTypes.SMART_TEXT;
        ELEMENT.setTextType = SetTextTypes.SET_TEXT;
        ELEMENT.searchRule = Pair.$("Visible", VISIBLE_ELEMENT);
        STRICT_SEARCH = true;
        COMMON.killBrowser = "afterAndBefore";
        ELEMENT.beforeSearch = UIElement::show;
    }),
    JDI(() -> {
        ELEMENT.clickType = ElementArea.CENTER;
        ELEMENT.getElementWithArgs = JdiSettings.GET_WITH_ARGS;
        ELEMENT.getElementAndValidate = JdiSettings.GET_AND_VALIDATE;
        ELEMENT.getTextType = TextTypes.SMART_TEXT;
        ELEMENT.setTextType = SetTextTypes.CLEAR_SEND_KEYS;
        ELEMENT.searchRule = Pair.$("Visible", VISIBLE_ELEMENT);
        STRICT_SEARCH = true;
        ELEMENT.beforeSearch = el -> {};
    }),
    SELENIUM(() -> {
        ELEMENT.getElementWithArgs = SeleniumSettings.GET_WITH_ARGS;
        ELEMENT.getElementAndValidate = SeleniumSettings.GET_AND_VALIDATE;
        ELEMENT.clickType = ElementArea.CENTER;
        ELEMENT.getTextType = TextTypes.TEXT;
        ELEMENT.setTextType = SetTextTypes.SEND_KEYS;
        ELEMENT.searchRule = Pair.$("Any", ANY_ELEMENT);
        ELEMENT.beforeSearch = el -> {};
    }),
    TRACE(() -> {
        LOGS.htmlCodeStrategy = list(FAIL);
        LOGS.requestsStrategy = list(FAIL);
        LOGS.screenStrategy = list(NEW_PAGE, FAIL, ASSERT);
        LOGS.logInfoDetails = LogInfoDetails.ELEMENT;
        LOGS.logLevel = LogLevels.TRACE;
        LOGS.writeToAllure = true;
        LOGS.writeToLog = true;
    });

    public JAction action;
    Strategies(JAction action) { this.action = action; }
}
