package com.jdiai.page.objects;

import com.epam.jdi.tools.ReflectionUtils;
import com.epam.jdi.tools.map.MapArray;
import com.jdiai.*;
import com.jdiai.annotations.UI;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.interfaces.ISetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.jdiai.page.objects.CreateRule.cRule;
import static com.jdiai.page.objects.PageFactory.initPageElements;
import static com.jdiai.page.objects.SetupRule.sRule;
import static com.jdiai.tools.JSTalkUtils.findByToBy;
import static com.jdiai.tools.JSTalkUtils.uiToBy;
import static com.jdiai.tools.TestIDLocators.getSmartLocator;
import static java.lang.reflect.Modifier.isStatic;
import static java.util.Arrays.asList;

public class JDIPageFactory {
    public static Function<Class<?>, Object> CREATE_PAGE =
        PageFactoryUtils::createPageObject;

    public static Function<Field, Boolean> JS_FIELD =
        f -> isInterface(f.getType(), WebElement.class) || isInterface(f.getType(), HasCore.class)
            || isInterface(f.getType(), List.class);

    public static Function<Field, Boolean> IS_UI_OBJECT = field -> {
        if (field.getName().equals("core") || field.getType().isAssignableFrom(JS.class)) {
            return false;
        }
        List<Field> fields = // field.getType().getDeclaredFields()
        ReflectionUtils.recursion(field.getType(), t -> t != null && !t.equals(Object.class), s -> asList(s.getDeclaredFields()));
        return any(fields, f ->
                !f.getName().equals("core") && JS_FIELD.apply(f));
    };

    public static Function<Field, Boolean> FIELDS_FILTER =
        f -> JS_FIELD.apply(f) || IS_UI_OBJECT.apply(f);

    public static Function<Field, Boolean> PAGES_FILTER =
        f -> isStatic(f.getModifiers()) && (isClass(f.getType(), WebPage.class) || IS_UI_OBJECT.apply(f) || JS_FIELD.apply(f));

    public static Function<Field, String> GET_NAME = PageFactoryUtils::getFieldName;

    public static Function<Field, By> GET_LOCATOR = PageFactoryUtils::getLocatorFromField;

    public static MapArray<String, CreateRule> CREATE_RULES = map(
            $("WebElement", cRule(WebElement.class, cl -> new JS())),
            $("List", cRule(List.class, cl -> new DataList<>()))
    );

    public static MapArray<String, SetupRule> SETUP_RULES = map(
            $("JSElement", sRule(HasCore.class, info -> {
                By locator = GET_LOCATOR.apply(info.field);
                JS core = locator != null
                    ? new JS(JDI::driver, locator, info.parent)
                    : new JS();
                ((HasCore) info.instance).setCore(core);
            })),
            $("Name", sRule(HasName.class,
                    info -> ((HasName) info.instance).setName(GET_NAME.apply(info.field)))),
            $("UI Object", sRule(info -> IS_UI_OBJECT.apply(info.field),
                    info -> initPageElements(info.instance))),
            $("Setup", sRule(ISetup.class, info -> ((ISetup)info.instance).setup(info.field)))
    );

    public static boolean useSmartLocatorsWithoutUI = false;

    public static Function<Field, By> LOCATOR_FROM_FIELD = field -> {
        if (field.isAnnotationPresent(FindBy.class)) {
            FindBy findBy = field.getAnnotation(FindBy.class);
            return findByToBy(findBy);
        }
        if (field.isAnnotationPresent(UI.class)) {
            UI ui = field.getAnnotation(UI.class);
            By locator = uiToBy(ui);
            if (locator == null) {
                locator = getSmartLocator().execute(field.getName());
            }
            return locator;
        }
        return useSmartLocatorsWithoutUI && !isClass(field, Section.class) && (isInterface(field, HasCore.class) || isInterface(field, WebElement.class))
            ? getSmartLocator().execute(field.getName())
            : null;
    };
}
