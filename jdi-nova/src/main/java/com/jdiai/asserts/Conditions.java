package com.jdiai.asserts;

import com.jdiai.JS;
import com.jdiai.jsdriver.JSException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.visual.Directions.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
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

    public static Condition displayed = condition("%element% is %not% displayed", JS::isDisplayed);

    public static Condition exist = condition("%element% is exist on page", JS::isExist);

    public static Condition hidden = not(displayed);

    public static Condition inView = condition("%element% is %not% in view screen", JS::isInView);

    public static Condition outOfView = not(inView);

    public static Condition appear = condition("%element% is %not% appear",  displayed);

    public static Condition disappear = not(appear);

    public static Condition readonly = attribute("readonly");

    public static Condition onTopOf(JS element) {
        return condition("%element% is %not% on the Top of '" + element.getFullName() + "'",
            el -> HIGHER.execute(element.getDirectionTo(el)));
    }
    public static Condition below(JS element) {
        return condition("%element% is %not% Below '" + element.getFullName() + "'",
            el -> LOWER.execute(element.getDirectionTo(el)));
    }
    public static Condition onLeftOf(JS element) {
        return condition("%element% is %not% on the Left of '" + element.getFullName() + "'",
            el -> LEFT.execute(element.getDirectionTo(el)));
    }
    public static Condition onRightOf(JS element) {
        return condition("%element% is %not% on the Right of '" + element.getFullName() + "'",
            el -> RIGHT.execute(element.getDirectionTo(el)));
    }
    public static Condition onTopLeftOf(JS element) {
        return condition("%element% is %not% on the Top-Left of '" + element.getFullName() + "'",
            el -> TOP_LEFT.execute(element.getDirectionTo(el)));
    }
    public static Condition onTopRightOf(JS element) {
        return condition("%element% is %not% on the Top-Right of '" + element.getFullName() + "'",
            el -> TOP_RIGHT.execute(element.getDirectionTo(el)));
    }
    public static Condition onBottomLeftOf(JS element) {
        return condition("%element% is %not% on the Bottom-Left of '" + element.getFullName() + "'",
            el -> BOTTOM_LEFT.execute(element.getDirectionTo(el)));
    }
    public static Condition onBottomRightOf(JS element) {
        return condition("%element% is %not% on the Bottom-Right of '" + element.getFullName() + "'",
            el -> BOTTOM_RIGHT.execute(element.getDirectionTo(el)));
    }
    public static Condition onTheSameLine(JS element) {
        return condition("%element% is %not% on the same line '" + element.getFullName() + "'",
            el -> SAME_HORIZONTAL.execute(element.getDirectionTo(el)));
    }
    public static Condition onTheSameVertical(JS element) {
        return condition("%element% is %not% on the same vertical line '" + element.getFullName() + "'",
            el -> SAME_VERTICAL.execute(element.getDirectionTo(el)));
    }

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

    public static Condition empty = condition("%element% is %not% empty", el -> el.getText().equals(""));

    public static Condition matchesText(String text) {
        return matchText(text);
    }

    public static Condition matchText(String regex) {
        return condition("%element% text %not% matches '" + regex + "'",
            el -> el.getText().matches(regex));
    }

    public static Condition be(Object entity) {
        return condition("%element% is %no% '" + entity.toString() + "'",
            el -> el.getEntity(entity.getClass()).equals(entity));
    }
    public static <T> Condition be(List<T> entities) {
        return haveCondition(true, true, entities);
    }
    public static <T> Condition be(T... entities) {
        return haveCondition(true, true, asList(entities));
    }
    public static <T> Condition have(List<T> entities) {
        return haveCondition(false, false, entities);
    }
    public static <T> Condition have(T... entities) {
        return haveCondition(false, false, asList(entities));
    }
    public static <T> Condition haveAll(List<T> entities) {
        return haveCondition(true, false, entities);
    }
    public static <T> Condition haveAll(T... entities) {
        return haveCondition(true, false, asList(entities));
    }
    public static Condition size(int size) {
        return condition("%element% have '" + size + "' elements",
                el -> el.size() == size);
    }
    public static Condition size(Function<Integer, Boolean> sizeFunc) {
        return condition("%element% have expected amount of elements",
                el -> sizeFunc.apply(el.size()));
    }
    public static Condition text(String text) {
        return condition("%element% has %no% text='" + text + "'",
            el -> el.getText().equals(text));
    }
    public static Condition containsText(String text) {
        return condition("%element% contains %no% text='" + text + "'",
            el -> el.getText().contains(text));
    }
    public static Condition cssClass(String cssClass) {
        return condition("%element% has %no% css class '" + cssClass + "'",
            el -> isNotBlank(el.cssStyle(cssClass)));
    }
    public static Condition cssValue(String name, String value) {
        return condition("%element% has %no% style '" + name + "=" + value + "'",
            el -> el.cssStyle(name).equals(value));
    }

    public static Condition focused = condition("%element% is %not% in focus", JS::focused);

    public static Condition enabled = condition("%element% is %not% enabled", JS::isEnabled);

    public static Condition disabled = not(enabled);

    public static Condition selected = condition("%element% is %not% selected", JS::isSelected);

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
        return isBlank(condition.getName())
            ? condition.setName(name)
            : condition(name, condition::execute);
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

    private static <T> Condition haveCondition(boolean checkSize, boolean sameOrder, List<T> entities) {
        if (isEmpty(entities)) {
            throw new JSException("Should have validation require at least one element");
        }
        return condition("%element% have %no% [" + print(singletonList(entities), Object::toString) + "]",
                el -> compareTwoLists(el, checkSize, sameOrder, entities));
    }

    private static <T> boolean compareTwoLists(JS el, boolean checkSize, boolean sameOrder, List<T> entities) {
        Class<T> cl = (Class<T>) entities.get(0).getClass();
        List<T> list = cl.isAssignableFrom(String.class)
            ? (List<T>) el.values()
            : el.getEntityList((Class<T>) entities.get(0).getClass());
        if (checkSize && list.size() != entities.size()) {
            logger.error("Expected size: %s, but found: %s", entities.size(), list.size());
            return false;
        }
        List<T> listOfFails = new ArrayList<>();
        int i = 0;
        for (T entity : entities) {
            if (sameOrder && !entity.equals(list.get(i++)) || !sameOrder && !list.contains(entity)) {
                listOfFails.add(entity);
            }
        }
        if (isNotEmpty(listOfFails)) {
            logger.error("Failed to find following entities: \n%s\nActual values:\n%s",
                print(listOfFails, Object::toString, "\n"),
                print(list, Object::toString, "\n")
            );
            return false;
        }
        return true;
    }
}
