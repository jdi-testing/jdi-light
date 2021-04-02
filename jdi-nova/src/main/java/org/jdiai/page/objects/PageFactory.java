package org.jdiai.page.objects;

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.jdiai.JSTalk;
import org.jdiai.Section;
import org.jdiai.WebPage;
import org.jdiai.annotations.Site;
import org.jdiai.interfaces.HasCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.reflect.Modifier.isStatic;
import static org.jdiai.JSTalk.DOMAIN;
import static org.jdiai.jsbuilder.QueryLogger.logger;
import static org.jdiai.page.objects.PageFactoryUtils.setFieldValue;
import static org.jdiai.page.objects.Rules.SETUP_RULES;

public class PageFactory {
    public static JFunc1<Class<?>, Object> CREATE_PAGE =
        PageFactoryUtils::createPageObject;
    public static JFunc2<Class<?>, Field, Object> CREATE_WEB_PAGE =
        PageFactoryUtils::createWebPage;
    public static JFunc1<Field, Boolean> JS_FIELD =
        f -> isInterface(f.getType(), WebElement.class) || isInterface(f.getType(), HasCore.class)
            || isInterface(f.getType(), List.class);
    public static JFunc1<Field, Boolean> IS_UI_OBJECT =
        field -> any(field.getType().getDeclaredFields(),
            f -> isInterface(field.getType(), HasCore.class)
                ? isClass(field.getType(), Section.class)
                : JS_FIELD.execute(f));

    public static JFunc1<Field, Boolean> FIELDS_FILTER =
        f -> JS_FIELD.execute(f) || IS_UI_OBJECT.execute(f);
    public static JFunc1<Field, Boolean> PAGES_FILTER =
        f -> isStatic(f.getModifiers()) && (isClass(f.getType(), WebPage.class)
            || IS_UI_OBJECT.execute(f));
    public static JFunc1<Field, String> GET_NAME =
        PageFactoryUtils::getFieldName;
    public static JFunc1<Field, By> GET_LOCATOR =
        PageFactoryUtils::getLocatorFromField;

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
            InitInfo info = new InitInfo(page, field);
            MapArray<String, SetupRule> rules = SETUP_RULES.filter(
                rule -> rule.condition.execute(info));
            for (Pair<String, SetupRule> rule : rules) {
                logger.debug("Setup rule '%s' for field %s", rule.key, field.getName());
                rule.value.action.execute(info);
            }
            setFieldValue(field, page, info.instance);
        }
    }
}
