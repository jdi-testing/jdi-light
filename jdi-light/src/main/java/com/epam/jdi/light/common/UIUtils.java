package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.interfaces.INamed;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.hasAnnotation;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.*;
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
        List<Field> notNullFields = filter(getFields(obj, Object.class),
            f -> getValueField(f, obj) != null);
        return new MapArray<>(notNullFields, UIUtils::getElementName,
            field -> {
                Object value = getValueField(field, obj);
                if (isClass(value.getClass(), String.class, Integer.class, Boolean.class))
                    return value.toString();
                if (isClass(value.getClass(), Enum.class))
                    return getEnumValue((Enum) value);
                return null;
            });
    }
    public static String getElementName(Field field) {
        if (hasAnnotation(field, Name.class))
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

    public static JFunc1<String, UIElement> GET_DEFAULT_BUTTON = (buttonName) -> $("[type=submit]");

    public static JFunc2<Object, String, BaseUIElement> GET_BUTTON = (obj, buttonName) -> {
        List<Field> fields = getFields(obj, WebElement.class);
        switch (fields.size()) {
            case 0:
                if (obj.getClass().getSimpleName().equals("Form"))
                    return GET_DEFAULT_BUTTON.execute(buttonName);
                throw exception("Can't find any buttons on form '%s'.", obj);
            case 1:
                return (BaseUIElement) getValueField(fields.get(0), obj);
            default:
                Collection<BaseUIElement> buttons = select(fields, f -> (BaseUIElement) getValueField(f, obj));
                BaseUIElement button = first(buttons, b -> namesEqual(toButton(b.getName()), toButton(buttonName)));
                if (button == null)
                    throw exception("Can't find button '%s' for Element '%s'", buttonName, obj);
                return button;
        }
    };

    public static UIElement getButtonByName(List<Field> fields, Object obj, String buttonName) {
        Collection<UIElement> buttons = select(fields, f -> (UIElement) getValueField(f, obj));
        UIElement button = first(buttons, b -> namesEqual(toButton(b.getName()), toButton(buttonName)));
        if (button == null)
            throw exception("Can't find button '%s' for Element '%s'", buttonName, obj);
        return button;
    }
    private static String toButton(String buttonName) {
        return buttonName.toLowerCase().contains("button") ? buttonName : buttonName + "button";
    }

    public static <T> T asEntity(Object obj, Class<T> entityClass) {
        try {
            T data = newEntity(entityClass);
            List<Field> dataFields = getFields(data, String.class);
            foreach(getFields(obj, HasValue.class), item -> {
                Field field = first(dataFields, f ->
                        namesEqual(f.getName(), item.getName()));
                if (field == null)
                    return;
                try {
                    field.set(data, ((HasValue) getValueField(item, obj)).getValue());
                } catch (Exception ignore) { }
            });
            return data;
        } catch (Exception ex) {
            throw exception("Can't get entity from '" + getName(obj) + "' for class: " + entityClass.getClass());
        }
    }
    private static String getName(Object obj) {
        return isInterface(obj.getClass(), INamed.class)
            ? ((INamed)obj).getName()
            : obj.getClass().getSimpleName();
    }
}