package com.jdiai.page.objects;

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.jdiai.DataList;
import com.jdiai.JDI;
import com.jdiai.JS;
import com.jdiai.WebPage;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.interfaces.ISetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.jdiai.page.objects.CreateRule.cRule;
import static com.jdiai.page.objects.PageFactory.initPageElements;
import static com.jdiai.page.objects.SetupRule.sRule;
import static java.lang.reflect.Modifier.isStatic;

public class JDIPageFactory {
    public static JFunc1<Class<?>, Object> CREATE_PAGE =
        PageFactoryUtils::createPageObject;

    public static JFunc1<Field, Boolean> JS_FIELD =
        f -> isInterface(f.getType(), WebElement.class) || isInterface(f.getType(), HasCore.class)
            || isInterface(f.getType(), List.class);

    public static JFunc1<Field, Boolean> IS_UI_OBJECT = field -> {
        if (field.getName().equals("core")) {
            return false;
        }
        return any(field.getType().getDeclaredFields(),
            f -> !f.getName().equals("core") && JS_FIELD.execute(f));
    };

    public static JFunc1<Field, Boolean> FIELDS_FILTER =
        f -> JS_FIELD.execute(f) || IS_UI_OBJECT.execute(f);

    public static JFunc1<Field, Boolean> PAGES_FILTER =
        f -> isStatic(f.getModifiers()) && (isClass(f.getType(), WebPage.class) || IS_UI_OBJECT.execute(f) || JS_FIELD.execute(f));

    public static JFunc1<Field, String> GET_NAME = PageFactoryUtils::getFieldName;

    public static JFunc1<Field, By> GET_LOCATOR = PageFactoryUtils::getLocatorFromField;

    public static MapArray<String, CreateRule> CREATE_RULES = map(
            $("WebElement", cRule(WebElement.class, cl -> new JS())),
            $("List", cRule(List.class, cl -> new DataList<>()))
    );

    public static MapArray<String, SetupRule> SETUP_RULES = map(
            $("JSElement", sRule(HasCore.class, info -> {
                By locator = GET_LOCATOR.execute(info.field);
                JS core = locator != null
                    ? new JS(JDI::driver, locator, info.parent)
                    : new JS();
                ((HasCore) info.instance).setCore(core);
            })),
            $("Name", sRule(HasName.class,
                    info -> ((HasName) info.instance).setName(GET_NAME.execute(info.field)))),
            $("UI Object", sRule(info -> IS_UI_OBJECT.execute(info.field),
                    info -> initPageElements(info.instance))),
            $("Setup", sRule(ISetup.class, info -> ((ISetup)info.instance).setup(info.field)))
    );
}
