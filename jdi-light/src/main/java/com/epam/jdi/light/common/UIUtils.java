package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
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
                if (isClassOr(value.getClass(), String.class, Integer.class, Boolean.class))
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

    public static JFunc2<Object, String, IClickable> GET_DEFAULT_BUTTON =
        (obj, buttonName) -> $("[type=submit]", obj).setName(buttonName);

    public static JFunc2<Object, String, IClickable> GET_BUTTON = (obj, buttonName) -> {
        List<Field> fields = getFields(obj, IsButton.class);
        if (fields.size() == 0)
            fields = getFieldsExact(obj, WebElement.class, UIElement.class);
        if (fields.size() > 1) {
            fields = filter(fields, f ->
                isInterfaceAnd(getValueField(f, obj).getClass(), IClickable.class, INamed.class));
            if (fields.size() >= 1) {
                Collection<IClickable> buttons = select(fields,
                    f -> (IClickable) getValueField(f, obj));
                IClickable button = first(buttons, b -> namesEqual(toButton(((INamed) b).getName()), toButton(buttonName)));
                if (button != null)
                    return button;
            }
        }
        if (fields.size() == 1) {
            Field field = fields.get(0);
            Object btnObj = getValueField(field, obj);
            if (isInterface(btnObj.getClass(), IClickable.class))
                return (IClickable) btnObj;
        }
        return GET_DEFAULT_BUTTON.execute(obj, buttonName);
    };

    private static String toButton(String buttonName) {
        return buttonName.toLowerCase().contains("button") ? buttonName : buttonName + "button";
    }

    public static <T> T asEntity(Object obj, Class<T> entityClass) {
        try {
            T data = create(entityClass);
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
    private static <T> T csInit(Constructor<?> cs, Object... params) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        cs.setAccessible(true);
        return (T) cs.newInstance(params);
    }
    public static <T> T create(Class<?> cs) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (cs == null)
            throw exception("Can't init class. Class Type is null.");
        Constructor<?>[] constructors = cs.getDeclaredConstructors();
        Constructor<?> constructor = first(constructors, c -> c.getParameterCount() == 0);
        if (constructor != null)
            return csInit(constructor);
        throw exception("%s has no empty constructors", cs.getSimpleName());
    }
    public static <T> T create(Class<?> cs, Object... params) {
        if (cs == null)
            throw exception("Can't init class. Class Type is null.");
        Constructor<?>[] constructors = cs.getDeclaredConstructors();
        List<Constructor<?>> listConst = filter(constructors, c -> c.getParameterCount() == params.length);
        if (listConst.size() == 0)
            throw exception("%s has no constructor with %s params", cs.getSimpleName(), params.length);
        for(Constructor<?> cnst : listConst) {
            try {
                return csInit(cnst, params);
            } catch (Exception ignore) { }
        }
        throw exception("%s has no appropriate constructors", cs.getSimpleName());
    }
}