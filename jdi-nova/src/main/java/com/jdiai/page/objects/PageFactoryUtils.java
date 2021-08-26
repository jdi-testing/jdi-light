package com.jdiai.page.objects;

import com.jdiai.JS;
import com.jdiai.annotations.Title;
import com.jdiai.annotations.Url;
import com.jdiai.interfaces.HasCore;
import com.jdiai.jsdriver.JDINovaException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

import static com.jdiai.JDI.driver;
import static com.jdiai.JDI.initJSFunc;
import static com.jdiai.page.objects.JDIPageFactory.LOCATOR_FROM_FIELD;
import static com.jdiai.page.objects.PageFactory.getFactory;
import static com.jdiai.tools.LinqUtils.*;
import static com.jdiai.tools.ReflectionUtils.getFieldsDeep;
import static com.jdiai.tools.ReflectionUtils.isInterface;
import static com.jdiai.tools.StringUtils.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class PageFactoryUtils {
    public static By getLocatorFromField(Field field) {
        return LOCATOR_FROM_FIELD.apply(field);
    }

    public static String getPageUrl(Class<?> cl, Field field) {
        if (field != null && field.isAnnotationPresent(Url.class)) {
            return field.getAnnotation(Url.class).value();
        }
        if (cl.isAnnotationPresent(Url.class)) {
            return cl.getAnnotation(Url.class).value();
        }
        return null;
    }

    public static String getPageTitle(Class<?> cl, Field field) {
        if (field != null && field.isAnnotationPresent(Title.class)) {
            return field.getAnnotation(Title.class).value();
        }
        if (cl.isAnnotationPresent(Title.class)) {
            return cl.getAnnotation(Title.class).value();
        }
        return null;
    }
    static void setupCoreElement(InitInfo info) {
        By locator = LOCATOR_FROM_FIELD.apply(info.field);
        JS core = initJSFunc.apply(null);
        core.setParent(info.parent);
        if (locator != null) {
            core.jsDriver().addLocator(locator);
        }
        core.setVarName(info.field);
        ((HasCore) info.instance).setCore(core);
    }
    static boolean isUIObject(Field field) {
        if (field.getName().equals("core") || isInterface(field.getType(), JS.class)) {
            return false;
        }
        List<Field> fields = getFieldsDeep(field);
        return any(fields, f -> !f.getName().equals("core") && getFactory().isUIElementField.apply(f));
    }

    static <T> T createWithConstructor(Class<?> fieldClass) {
        Constructor<?>[] constructors = fieldClass.getDeclaredConstructors();
        List<Constructor<?>> filtered = filter(constructors, c -> c.getParameterCount() == 0
            || c.getParameterCount() == 1 && isInterface((Class<?>)c.getGenericParameterTypes()[0], WebDriver.class));
        if (isEmpty(filtered)) {
            throw new JDINovaException(format("%s has no empty constructors", fieldClass.getSimpleName()));
        }
        Constructor<?> cs = filtered.size() == 1
            ? filtered.get(0)
            : first(constructors, c -> c.getParameterCount() == 0);
        return cs.getParameterCount() == 0
            ? initWithEmptyConstructor(cs, fieldClass)
            : initWebDriverConstructor(cs, fieldClass);
    }

    static <T> T initWebDriverConstructor(Constructor<?> constructor, Class<?> fieldClass) {
        try {
            constructor.setAccessible(true);
            return (T) constructor.newInstance(driver());
        } catch (Exception ex) {
            throw new JDINovaException(ex, format("%s failed to init using empty constructors", fieldClass.getSimpleName()));
        }
    }
    static <T> T initWithEmptyConstructor(Constructor<?> constructor, Class<?> fieldClass) {
        try {
            constructor.setAccessible(true);
            return (T) constructor.newInstance();
        } catch (Exception ex) {
            throw new JDINovaException(ex, format("%s failed to init using empty constructors", fieldClass.getSimpleName()));
        }
    }

}
