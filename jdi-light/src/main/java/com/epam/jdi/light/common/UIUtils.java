package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.*;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.tools.EnumUtils.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;

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
        List<Field> withOrder = filter(notNullFields, f -> f.getAnnotation(Order.class) != null);
        List<Field> ordered = new ArrayList<>();
        if (withOrder.size() > 0) {
            MultiMap<Integer, Field> orderMap = new MultiMap<>(withOrder,
                k -> k.getAnnotation(Order.class).value(), v -> v).ignoreKeyCase();
            orderMap.pairs.sort((d1, d2) -> d2.key - d1.key);
            for (Pair<Integer, Field> pairs : orderMap.pairs)
                ordered.add(pairs.value);
            ordered.addAll(filter(notNullFields, f -> f.getAnnotation(Order.class) == null));
        } else ordered = notNullFields;
        return new MapArray<>(ordered, UIUtils::getElementName,
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
                    setPrimitiveField(field, data, ((HasValue) getValueField(item, obj)).getValue());
                } catch (Exception ignore) { }
            });
            return data;
        } catch (Exception ex) {
            throw exception(ex, "Can't get entity from '" + getName(obj) + "' for class: " + entityClass);
        }
    }
    public static <T extends IBaseElement> T initT(UIElement el, IBaseElement parent, Class<?> initClass) {
        try {
            if (initClass == null)
                throw exception("Can't init List of UI Elements. Class Type is null");
            SiteInfo info = new SiteInfo(parent.base().driverName).set(s -> {
                s.cl = initClass;
                s.name = el.getName();
                s.parent = el.parent;
            });
            initJdiField(info);
            if (info.instance != null)
                setupFieldUsingRules(info);
            T t = (T) info.instance;
            t.base().setCore(el);
            t.base().searchRules = parent.base().searchRules;
            initElements(t);
            return t;
        } catch (Exception ex) { throw exception(ex, "Can't init new element for list"); }
    }

    private static String getName(Object obj) {
        return isInterface(obj.getClass(), INamed.class)
            ? ((INamed)obj).getName()
            : obj.getClass().getSimpleName();
    }
}