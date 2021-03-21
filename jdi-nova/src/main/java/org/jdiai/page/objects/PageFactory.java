package org.jdiai.page.objects;

import com.epam.jdi.tools.func.JAction2;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.jdiai.HasCore;
import org.jdiai.JS;
import org.jdiai.JSTalk;
import org.jdiai.WebPage;
import org.jdiai.annotations.Site;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static java.lang.reflect.Modifier.isStatic;
import static java.util.Map.of;
import static org.jdiai.JSTalk.DOMAIN;
import static org.jdiai.page.objects.PageFactoryUtils.createInstance;
import static org.jdiai.page.objects.PageFactoryUtils.setFieldValue;

public class PageFactory {
    public static JFunc1<Class<?>, Object> CREATE_PAGE =
        PageFactoryUtils::createInstance;
    public static JFunc2<Class<?>, Field, Object> CREATE_WEB_PAGE =
        PageFactoryUtils::createWebPage;
    public static JFunc1<Field, Boolean> JS_FIELDS =
            f -> isInterface(f.getType(), WebElement.class) || isClass(f, HasCore.class);
    public static JFunc1<Field, Boolean> IS_UI_OBJECT = f -> any(f.getType().getDeclaredFields(), JS_FIELDS);
    public static JFunc1<Field, Boolean> FIELDS_FILTER =
            f -> JS_FIELDS.execute(f) || IS_UI_OBJECT.execute(f);
    public static JFunc1<Field, Boolean> PAGES_FILTER =
        f -> isStatic(f.getModifiers()) && (isClass(f.getType(), WebPage.class)
            || IS_UI_OBJECT.execute(f));
    public static JFunc1<Field, String> GET_NAME =
        PageFactoryUtils::getFieldName;
    public static JFunc1<Field, By> GET_LOCATOR =
        PageFactoryUtils::getLocatorFromField;
    public static Map<String, JAction2<Field, JS>> SETUP_RULES =
        new HashMap<>(of("Name", (field, instance) -> {
            String name = GET_NAME.execute(field);
            instance.setName(name);
        }));


    public static void openSite(Class<?> cl) {
        if (cl.isAnnotationPresent(Site.class)) {
            DOMAIN = cl.getAnnotation(Site.class).value();
        }
        List<Field> pages = filter(cl.getDeclaredFields(), PAGES_FILTER);
        for (Field field : pages) {
            Class<?> fieldClass = field.getType();
            Object page = isClass(fieldClass, WebPage.class)
                ? CREATE_WEB_PAGE.execute(fieldClass, field)
                : initElements(fieldClass);
            setFieldValue(field, null, page);
        }
        if (DOMAIN != null) {
            JSTalk.openSite();
        }
    }
    public static <T> T initElements(Class<T> cl) {
        Object page = CREATE_PAGE.execute(cl);
        initPageElements(page);
        return (T) page;
    }
    public static void initPageElements(Object page) {
        List<Field> jsFields = filter(page.getClass().getDeclaredFields(), FIELDS_FILTER);
        for (Field field : jsFields) {
            Object fieldValue = getValueField(field, page);
            Object instance = fieldValue != null
                ? fieldValue
                : createInstance(field.getType());
            if (isInterface(field.getType(), HasCore.class)) {
                JS core = initJSElement(fieldValue, field, page);
                ((HasCore) instance).setCore(core);
            }
            if (IS_UI_OBJECT.execute(field)) {
                initPageElements(instance);
            }
            setFieldValue(field, page, instance);
        }
    }

    private static JS initJSElement(Object fieldValue, Field field, Object parent) {
        JS instance = fieldValue != null
            ? (JS) fieldValue
            : new JS(JSTalk::driver, GET_LOCATOR.execute(field), parent);
        for (Map.Entry<String, JAction2<Field, JS>> entry : SETUP_RULES.entrySet()) {
            entry.getValue().execute(field, instance);
        }
        return instance;
    }
}
