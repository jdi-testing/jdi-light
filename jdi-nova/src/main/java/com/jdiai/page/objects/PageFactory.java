package com.jdiai.page.objects;

import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import com.jdiai.annotations.Site;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.filter;
import static com.jdiai.JDI.domain;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.page.objects.JDIPageFactory.*;
import static com.jdiai.page.objects.PageFactoryUtils.getJSFields;
import static com.jdiai.page.objects.PageFactoryUtils.setFieldValue;

public class PageFactory {
    public static <T> T initElements(Class<T> cl) {
        Object page = CREATE_PAGE.apply(cl);
        initPageElements(page);
        return (T) page;
    }

    public static void initPageElements(Object page) {
        List<Field> jsFields = filter(getJSFields(page.getClass()), FIELDS_FILTER);
        for (Field field : jsFields) {
            createAndSetupField(page, field);
        }
    }
    private static void createAndSetupField(Object page, Field field) {
        InitInfo info = new InitInfo(page, field);
        MapArray<String, SetupRule> rules = SETUP_RULES.filter(
            rule -> rule.condition.execute(info));
        for (Pair<String, SetupRule> rule : rules) {
            logger.debug("Setup rule '%s' for field %s", rule.key, field.getName());
            rule.value.action.execute(info);
        }
        setFieldValue(field, page, info.instance);
    }

    public static void initSite(Class<?> cl) {
        if (cl.isAnnotationPresent(Site.class)) {
            domain = cl.getAnnotation(Site.class).value();
        }
        List<Field> pages = filter(cl.getDeclaredFields(), PAGES_FILTER);
        for (Field field : pages) {
            createAndSetupField(null, field);
        }
    }
}
