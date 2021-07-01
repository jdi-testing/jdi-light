package com.epam.jdi.light.elements.base;

import org.openqa.selenium.WebElement;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class Conditions {
    public static Condition visible = condition("%element% is %not% visible",  el -> {
        if (el.isHidden()) {
            return false;
        }
        el.show();
        return el.isVisible();
    });

    public static Condition displayed = condition("%element% is %not% displayed",  el -> el.isDisplayed());

    public static Condition exist = condition("%element% is exist on page", el -> el.isExist());

    public static Condition hidden = not(displayed);

    public static Condition appear = condition("%element% is %not% appear",  displayed);

    public static Condition disappear = not(appear);

    public static Condition readonly = attribute("readonly");

    public static Condition attribute(String attributeName) {
        return condition("%element% has %no% '" + attributeName + "' attribute",
                el -> el.hasAttribute(attributeName));
    }

    public static Condition attribute(String attributeName, String value) {
        return condition("%element% has %no% '" + attributeName + "=" + value + "' attribute",
                el -> el.attr(attributeName).equals(value));
    }

    public static Condition containsAttribute(String attributeName, String value) {
        return condition("%element% has %no% '" + attributeName + " that contains " + value + "' attribute",
                el -> el.attr(attributeName).contains(value));
    }

    public static Condition matchAttribute(String attributeName, String regEx) {
        return condition("%element% has %no% '" + attributeName + " matches " + regEx + "' attribute",
                el -> el.attr(attributeName).matches(regEx));
    }

    public static Condition href(String href) {
        return attribute("href", href);
    }
    public static Condition containsHref(String href) {
        return containsAttribute("href", href);
    }
    public static Condition matchHref(String href) {
        return matchAttribute("href", href);
    }

    public static Condition value(String value) {
        return attribute("value", value);
    }
    public static Condition containsValue(String value) {
        return containsAttribute("value", value);
    }
    public static Condition matchValue(String value) {
        return matchAttribute("value", value);
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
        return condition("%element% has %no% 'class=" + className + "' attribute",
            el -> el.hasClass(className));
    }

    public static Condition id(String id) {
        return attribute("id", id);
    }

    public static Condition empty =
            condition("%element% is %not% empty", el -> el.core().text().equals(""));

    public static Condition matchesText(String text) {
        return matchText(text);
    }

    public static Condition matchText(String regex) {
        return condition("%element% text %not% matches '" + regex + "'",
                el -> el.core().getText().matches(regex));
    }

    public static Condition text(String text) {
        return condition("%element% has %no% text='" + text + "'",
                el -> el.core().getText().equals(text));
    }
    public static Condition containsText(String text) {
        return condition("%element% contains %no% text='" + text + "'",
                el -> el.core().getText().contains(text));
    }

    public static Condition cssClass(String cssClass) {
        return condition("%element% has %no% css class '" + cssClass + "'",
                el -> isNotBlank(el.css(cssClass)));
    }
    public static Condition cssValue(String name, String value) {
        return condition("%element% has %no% style '" + name + "=" + value + "'",
                el -> el.css(name).equals(value));
    }

    public static Condition image = condition("%element% has %no% image",
            el -> el.core().jsExecute("tagName.toLowerCase() === 'img' && " +
                    "arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && " +
                    "arguments[0].naturalWidth > 0").equals("true"));

    public static Condition focused = condition("%element% is %not% in focus",
            el -> {
                WebElement element = (WebElement)el.core().js().executeScript("return document.activeElement");
                return element != null && element.equals(el.core().getWebElement());
            });

    public static Condition enabled =
            condition("%element% is %not% enabled", el -> el.isEnabled());

    public static Condition disabled = not(enabled);

    public static Condition selected =
            condition("%element% is %not% selected", el -> el.core().isSelected());

    public static Condition checked = selected;

    public static Condition not(Condition condition) {
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
