package org.jdiai.page.objects;

import org.jdiai.DataList;
import org.jdiai.WebPage;
import org.jdiai.annotations.Title;
import org.jdiai.annotations.UI;
import org.jdiai.annotations.Url;
import org.jdiai.jsdriver.JSException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.ReflectionUtils.create;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.jdiai.JSTalk.driver;
import static org.jdiai.tools.JSTalkUtils.findByToBy;
import static org.jdiai.tools.JSTalkUtils.uiToBy;
import static org.jdiai.tools.TestIDLocators.getSmartLocator;

public class PageFactoryUtils {
    public static String getFieldName(Field field) {
        return splitCamelCase(field.getName());
    }
    public static By getLocatorFromField(Field field) {
        if (field.isAnnotationPresent(FindBy.class)) {
            FindBy findBy = field.getAnnotation(FindBy.class);
            return findByToBy(findBy);
        }
        By locator = null;
        if (field.isAnnotationPresent(UI.class)) {
            UI findBy = field.getAnnotation(UI.class);
            locator = uiToBy(findBy);
        }
        return locator != null
            ? locator
            : getSmartLocator().execute(field.getName());
    }
    public static Object createWebPage(Class<?> cl, Field field) {
        try {
            return ((WebPage) create(cl)).setup(getPageUrl(cl, field), getPageTitle(cl, field));
        } catch (Exception ex) {
            throw new JSException(ex, "Failed to createWebPage: " + cl.getSimpleName());
        }
    }
    private static String getPageUrl(Class<?> cl, Field field) {
        if (field != null && field.isAnnotationPresent(Url.class)) {
            return field.getAnnotation(Url.class).value();
        }
        if (cl.isAnnotationPresent(Url.class)) {
            return cl.getAnnotation(Url.class).value();
        }
        return null;
    }
    private static String getPageTitle(Class<?> cl, Field field) {
        if (field != null && field.isAnnotationPresent(Title.class)) {
            return field.getAnnotation(Title.class).value();
        }
        if (cl.isAnnotationPresent(Title.class)) {
            return cl.getAnnotation(Title.class).value();
        }
        return null;
    }
    static <T> T createInstance(Class<T> cs) {
        if (cs == null)
            throw new JSException("Can't init class. Class Type is null.");
        if (cs.isInterface()) {
            return (T) new DataList();
        }
        try {
            Constructor<?>[] constructors = cs.getDeclaredConstructors();
            Constructor<?> constructor = first(constructors, c -> c.getParameterCount() == 0);
            if (constructor != null) {
                constructor.setAccessible(true);
                return (T) constructor.newInstance();
            }
            List<Constructor<?>> listConst = filter(constructors, c -> c.getParameterCount() == 1);
            if (isEmpty(listConst))
                throw new JSException(format("%s has no constructor with %s params", cs.getSimpleName(), 1));
            for (Constructor<?> cnst : listConst) {
                try {
                    cnst.setAccessible(true);
                    return (T) cnst.newInstance(driver());
                } catch (Exception ignore) {
                }
            }
        } catch (Exception ex) {
            throw new JSException(ex, format("%s has no appropriate constructors", cs.getSimpleName()));
        }
        throw new JSException(format("%s has no appropriate constructors", cs.getSimpleName()));
    }
    public static void setFieldValue(Field field, Object page, Object instance) {
        try {
            field.set(page, instance);
        } catch (Exception ex) {
            throw new JSException(ex, "Failed to set value to field ", getClassName(field));
        }
    }
    private static String getClassName(Field field) {
        try {
            return field.getType().getSuperclass().getSimpleName() + "." + field.getType();
        } catch (Exception ex) {
            return "NULL FIELD";
        }
    }
}
