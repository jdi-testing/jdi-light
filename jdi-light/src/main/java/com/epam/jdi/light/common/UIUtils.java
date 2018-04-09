package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.namesEqual;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static java.lang.reflect.Array.get;
import static java.lang.reflect.Array.getLength;

public final class UIUtils {
    private UIUtils() {
    }
    public static MapArray<String, String> getMapFromObject(Object obj) {
        if (obj == null)
            return new MapArray<>();
        return new MapArray<>(getFields(obj, Object.class), UIUtils::getElementName,
            field -> {
                Object value = getValueField(field, obj);
                if (value == null)
                    return null;
                if (isClass(value.getClass(), String.class, Integer.class, Boolean.class))
                    return value.toString();
                if (isClass(value.getClass(), Enum.class))
                    return getEnumValue((Enum) value);
                return null;
            });
    }
    public static String getElementName(Field field) {
        if (field.isAnnotationPresent(Name.class))
            return field.getAnnotation(Name.class).value();
        if (field.getType().isAnnotationPresent(Name.class))
            return field.getType().getAnnotation(Name.class).value();
        return splitCamelCase(field.getName());
    }

    public static String printObjectAsArray(Object array) {
        List<String> elements = new ArrayList<>();
        for (int i = 0; i <= getLength(array); i++)
            elements.add(get(array, i).toString());
        return print(elements);
    }
    public static UIElement getButton(Object obj, String buttonName) {
        List<Field> fields = getFields(obj, WebElement.class);
        switch (fields.size()) {
            case 0:
                throw exception("Can't find any buttons on form '%s.", obj);
            case 1:
                return (UIElement) getValueField(fields.get(0), obj);
            default:
                Collection<UIElement> buttons = select(fields, f -> (UIElement) getValueField(f, obj));
                UIElement button = first(buttons, b -> namesEqual(toButton(b.getName()), toButton(buttonName)));
                if (button == null)
                    throw exception("Can't find button '%s' for Element '%s'", buttonName, obj);
                return button;
        }
    }

    private static String toButton(String buttonName) {
        return buttonName.toLowerCase().contains("button") ? buttonName : buttonName + "button";
    }
}