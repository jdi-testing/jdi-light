package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public enum ListElementNameTypes {
    SMART(el -> {
        String text = el.text(TextTypes.TEXT);
        if (isNotBlank(text))
            return text;
        text = el.text(TextTypes.INNER_TEXT);
        if (isNotBlank(text))
            return text;
        String id = el.attr("id");
        if (isNotBlank(id)) {
            UIElement label = $(By.cssSelector("[for=" + id + "]"));
            label.setTimeout(0);
            try {
                text = label.getText();
            } catch (Throwable ignore) { }
        }
        return isNotBlank(text) ? text : "";
    }),
    TEXT(el -> el.text(TextTypes.TEXT)),
    VALUE(el -> el.text(TextTypes.VALUE)),
    INNER(el -> el.text(TextTypes.INNER_TEXT)),
    LABEL(UIElement::labelText),
    INDEX();

    public static ListElementNameTypes get(TextTypes type) {
        switch (type) {
            case TEXT:
                return TEXT;
            case VALUE:
                return VALUE;
            case INNER_TEXT:
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
