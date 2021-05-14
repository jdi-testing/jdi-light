package com.jditest.page.objects;

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.jditest.Section;
import com.jditest.WebPage;
import com.jditest.interfaces.HasCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.reflect.Modifier.isStatic;

public class PageFactoryRules {
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
}
