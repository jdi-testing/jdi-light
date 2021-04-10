package org.jdiai.page.objects;

import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.jdiai.JDI;
import org.jdiai.WebPage;
import org.jdiai.annotations.Site;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static org.jdiai.JDI.DOMAIN;
import static org.jdiai.jsbuilder.QueryLogger.logger;
import static org.jdiai.page.objects.PageFactoryRules.*;
import static org.jdiai.page.objects.PageFactoryUtils.setFieldValue;
import static org.jdiai.page.objects.Rules.SETUP_RULES;

public class PageFactory {
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

    public static void initSite(Class<?> cl) {
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
    }
    public static void openSite(Class<?> cl) {
        initSite(cl);
        if (DOMAIN != null) {
            JDI.openSite();
        }
    }
}
