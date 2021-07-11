package com.jdiai.asserts;

import com.jdiai.interfaces.HasCore;
import com.jdiai.jsdriver.JDINovaException;

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
        return el.show().isVisible();
    });

    public static Condition displayed = condition("%element% is %not% displayed", HasCore::isDisplayed);

    public static Condition exist = condition("%element% is exist on page", HasCore::isExist);

    public static Condition hidden = not(displayed);

    public static Condition inView = condition("%element% is %not% in view screen", HasCore::isInView);

    public static Condition outOfView = not(inView);

    public static Condition appear = condition("%element% is %not% appear",  displayed);

    public static Condition disappear = not(appear);

    public static Condition readonly = attribute("readonly");

    public static Condition above(HasCore element) {
        return condition("%element% is %not% on the Top of '" + element.core().getFullName() + "'",
            el -> HIGHER.apply(element.getDirectionTo(el.core())));
    }
    public static Condition below(HasCore element) {
        return condition("%element% is %not% Below '" + element.core().getFullName() + "'",
            el -> LOWER.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onLeftOf(HasCore element) {
        return condition("%element% is %not% on the Left of '" + element.core().getFullName() + "'",
            el -> LEFT.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onRightOf(HasCore element) {
        return condition("%element% is %not% on the Right of '" + element.core().getFullName() + "'",
            el -> RIGHT.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onTopLeftOf(HasCore element) {
        return condition("%element% is %not% on the Top-Left of '" + element.core().getFullName() + "'",
            el -> TOP_LEFT.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onTopRightOf(HasCore element) {
        return condition("%element% is %not% on the Top-Right of '" + element.core().getFullName() + "'",
            el -> TOP_RIGHT.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onBottomLeftOf(HasCore element) {
        return condition("%element% is %not% on the Bottom-Left of '" + element.core().getFullName() + "'",
            el -> BOTTOM_LEFT.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onBottomRightOf(HasCore element) {
        return condition("%element% is %not% on the Bottom-Right of '" + element.core().getFullName() + "'",
            el -> BOTTOM_RIGHT.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onSameLine(HasCore element) {
        return condition("%element% is %not% on the same line '" + element.core().getFullName() + "'",
            el -> SAME_HORIZONTAL.apply(element.getDirectionTo(el.core())));
    }
    public static Condition onSameVerticalLine(HasCore element) {
        return condition("%element% is %not% on the same vertical line '" + element.core().getFullName() + "'",
            el -> SAME_VERTICAL.apply(element.getDirectionTo(el.core())));
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
        return el -> el.core().pseudo(pseudoName, propertyName).equals(expectedValue);
    }

    public static Condition pseudo(String pseudoElementName, String expectedValue) {
        return el -> el.core().pseudo(pseudoElementName, "content").equals(expectedValue);
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
            el -> el.core().getEntity(entity.getClass()).equals(entity));
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

    public static Condition noItems() {
        return condition("%element% has no item",
                el -> el.core().size() == 0);
    }
    public static Condition someItems() {
        return condition("%element% is not empty",
                el -> el.core().size() > 0);
    }
    public static Condition size(int size) {
        return condition("%element% has '" + size + "' elements",
                el -> el.core().size() == size);
    }
    public static Condition size(Function<Integer, Boolean> sizeFunc) {
        return condition("%element% has expected amount of elements",
            el -> sizeFunc.apply(el.core().size()));
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
            el -> isNotBlank(el.core().cssStyle(cssClass)));
    }
    public static Condition cssValue(String name, String value) {
        return condition("%element% has %no% style '" + name + "=" + value + "'",
            el -> el.core().cssStyle(name).equals(value));
    }

    public static Condition focused = condition("%element% is %not% in focus", el -> el.core().focused());

    public static Condition enabled = condition("%element% is %not% enabled", HasCore::isEnabled);

    public static Condition disabled = not(enabled);

    public static Condition selected = condition("%element% is %not% selected", el -> el.core().isSelected());

    public static Condition checked = selected;

    public static Condition no(Condition condition) {
        return not(condition);
    }
    public static Condition not(Condition condition) {
        return condition(getNotName(condition), el -> !condition.apply(el));
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
            throw new JDINovaException("Should have validation require at least one element");
        }
        return condition("%element% have %no% [" + print(singletonList(entities), Object::toString) + "]",
            el -> compareTwoLists(el.core(), checkSize, sameOrder, entities));
    }

    private static <T> boolean compareTwoLists(HasCore el, boolean checkSize, boolean sameOrder, List<T> entities) {
        Class<T> cl = (Class<T>) entities.get(0).getClass();
        List<T> list = cl.isAssignableFrom(String.class)
            ? (List<T>) el.core().values()
            : el.core().getEntityList((Class<T>) entities.get(0).getClass());
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
