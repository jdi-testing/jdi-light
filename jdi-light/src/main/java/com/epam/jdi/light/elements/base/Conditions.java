package com.epam.jdi.light.elements.base;

import org.openqa.selenium.WebElement;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class Conditions {
    public static final Condition visible = condition("element is %not% visible",  el -> el.isVisible());

    public static final Condition displayed = condition("element is %not% displayed",  el -> el.isDisplayed());

    public static final Condition exist = condition("element is exist on page", el -> el.isExist());
    
    public static final Condition hidden = not(visible);

    public static final Condition appear = condition("element is %not% appear",  visible);

    public static final Condition disappear = not(appear);

    public static final Condition readonly = attribute("readonly");
    
    public static Condition attribute(String attributeName) {
        return condition("element has %no% '" + attributeName + "' attribute",
            el -> el.hasAttribute(attributeName));
    }

    public static Condition attribute(String attributeName, String value) {
        return condition("element has %no% '" + attributeName + "=" + value + "' attribute",
            el -> el.attr(attributeName).equals(value));
    }

    public static Condition attributeMatching(String attributeName, String regEx) {
        return condition("element has %no% '" + attributeName + " matches " + regEx + "' attribute",
            el -> el.attr(attributeName).matches(regEx));
    }

    public static Condition href(String href) {
        return attribute("href", href);
    }

    public static Condition value(String value) {
        return attribute("value", value);
    }
    
    public static Condition pseudo(String pseudoName, String propertyName, String expectedValue) {
        return el -> el.pseudo(pseudoName, propertyName).equals(expectedValue);
    }

    public static Condition pseudo(String pseudoElementName, String expectedValue) {
        return el -> el.pseudo(pseudoElementName, "content").equals(expectedValue);
    }

    public static Condition exactValue(String value) {
        return attribute("value", value);
    }

    public static Condition name(String name) {
        return attribute("name", name);
    }

    public static Condition type(String type) {
        return attribute("type", type);
    }
    public static Condition clazz(String className) {
        return condition("element has %no% 'class=" + className + "' attribute",
            el -> el.hasClass(className));
    }

    public static Condition id(String id) {
        return attribute("id", id);
    }

    public static final Condition empty =
            condition("element is %not% empty", el -> el.core().text().equals(""));

    public static Condition matchesText(String text) {
        return matchText(text);
    }

    public static Condition matchText(String regex) {
        return condition("element text %not% matches '" + regex + "'",
            el -> el.core().getText().matches(regex));
    }

    public static Condition text(String text) {
        return condition("element %no% text='" + text + "'",
            el -> el.core().getText().equals(text));
    }

    public static Condition cssClass(String cssClass) {
        return condition("element has %no% css class '" + cssClass + "'",
            el -> isNotBlank(el.css(cssClass)));
    }
    public static Condition cssValue(String name, String value) {
        return condition("element has %no% style '" + name + "=" + value + "'",
                el -> el.css(name).equals(value));
    }

    public static final Condition image = condition("element has %no% image",
        el -> el.core().jsExecute("tagName.toLowerCase() === 'img' && " +
            "arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && " +
            "arguments[0].naturalWidth > 0").equals("true"));

    public static final Condition focused = condition("element is %not% in focus",
        el -> {
            WebElement element = (WebElement)el.core().js().executeScript("return document.activeElement");
            return element != null && element.equals(el.core().getWebElement());
        });

    public static final Condition enabled =
        condition("element is %not% enabled", el -> el.isEnabled());

    public static final Condition disabled = not(enabled);

    public static final Condition selected =
        condition("element is %not% selected", el -> el.core().isSelected());

    public static final Condition checked = selected;

    public static Condition not(final Condition condition) {
        return condition(getNotName(condition), el -> !condition.execute(el));
    }
    private static String getNotName(Condition condition) {
        String name = condition.getName();
        if (name.contains("%not%")) {
            return name.replace("%not%", "not");
        }
        if (name.contains("%no%")) {
            return name.replace("%no%", "no");
        }
        return name;
    }
    public static Condition condition(String name, Condition condition) {
        if (isBlank(condition.getName()))
            return condition.setName(name);
        return condition(name, condition::execute);
    }
    public static Condition be(Condition condition) {
        return condition;
    }
    public static Condition become(Condition condition) {
        return condition;
    }
    public static Condition and(Condition condition) {
        return condition;
    }
    public static Condition have(Condition condition) {
        return condition;
    }
    public static Condition waitFor(Condition condition) {
        return condition;
    }
}
