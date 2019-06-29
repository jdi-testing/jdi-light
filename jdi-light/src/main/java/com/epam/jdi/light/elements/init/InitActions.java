package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.*;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.rules.InitRule;
import com.epam.jdi.light.elements.init.rules.SetupRule;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.*;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.init.PageFactory.initElement;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.rules.InitRule.iRule;
import static com.epam.jdi.light.elements.init.rules.SetupRule.sRule;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.light.settings.WebSettings.TEST_GROUP;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class InitActions {
    public static void init() {}
    public static JFunc1<SiteInfo, Object> SETUP_SECTION_ON_SITE = info -> {
        info.instance = initElement(info);
        return info.instance;
    };
    public static JFunc1<SiteInfo, WebPage> SETUP_WEBPAGE_ON_SITE = info -> {
        WebPage page = (WebPage) SETUP_SECTION_ON_SITE.execute(info);
        page.updatePageData(
            valueOrDefault(getAnnotation(info.field, Url.class),
                page.getClass().getAnnotation(Url.class)),
            valueOrDefault(getAnnotation(info.field, Title.class),
                page.getClass().getAnnotation(Title.class))
        );
        return page;
    };

    public static JFunc1<SiteInfo, Object> SETUP_PAGE_OBJECT_ON_SITE = info -> {
        try {
            info.instance = create(info.field.getType());
        } catch (Exception ignore) {
            try {
                info.instance = create(info.field.getType(), getDriver());
            } catch (Exception ex) {
                throw exception("Can't initialize Page Object '%s'. Exception: %s", info.field.getName(), ex.getMessage());
            }
        }
        initElements(info);
        return info.instance;
    };

    public static MapArray<String, InitRule> INIT_RULES = map(
        $("UIElement", iRule(WebElement.class, info -> new UIElement())),
        $("WebList", iRule(cl -> isList(cl, WebElement.class), info -> new WebList())),
        $("DataList", iRule(cl -> isList(cl, InitActions::isPageObject),
            info -> new DataList())),
        $("JList", iRule(cl -> cl == List.class && isInterface(getGenericType(cl), IBaseElement.class),
            info -> new JList()))
    );

    public static MapArray<String, SetupRule> SETUP_RULES = map(
        $("Element", sRule(info -> isInterface(info.instance.getClass(), HasUIElement.class),
            InitActions::elementSetup)),
        $("ISetup", sRule(InitActions::isSetupValue, info -> ((ISetup)info.instance).setup(info.field))),
        $("Page", sRule(info -> isClass(info.instance.getClass(), WebPage.class),
                info -> defaultSetup(info, (WebPage) info.instance))),
        $("PageObject", sRule(info -> isPageObject(info.instance.getClass()),
            PageFactory::initElements))
    );

    private static boolean isSetupValue(SiteInfo info) {
        try {
            if (isInterface(info.instance.getClass(), ISetup.class))
                return true;
            Object value = info.field.get(info.parent);
            if (value == null) return false;
            return isInterface(value.getClass(), ISetup.class);
        } catch (Exception ex) {return false; }
    }
    private static DriverBase asUIBase(SiteInfo info) {
        if (isClass(info.instance.getClass(), DriverBase.class))
            return (DriverBase) info.instance;
        if (isInterface(info.instance.getClass(), HasUIElement.class))
            return  ((HasUIElement) info.instance).core();
        throw exception("Can't setup '%s'. Instance should implement HasUIElement interface", info.name());
    }

    public static DriverBase defaultSetup(SiteInfo info, DriverBase jdi) {
        jdi.setName(info.field, info.parentName());
        jdi.setParent(info.parent);
        jdi.driverName = isBlank(info.driverName) ? DRIVER_NAME : info.driverName;
        return jdi;
    }

    public static HasUIElement elementSetup(SiteInfo info) {
        HasUIElement jdi = (HasUIElement) info.instance;
        defaultSetup(info, jdi.core());
        By locator = getLocatorFromField(info.field);
        if (locator != null)
            jdi.core().setLocator(locator);
        if (info.field.getAnnotation(Root.class) != null)
            jdi.core().locator.isRoot = true;
        if (hasAnnotation(info.field, Frame.class))
            jdi.core().setFrame(getFrame(info.field.getAnnotation(Frame.class)));
        info.instance = jdi;
        return jdi;
    }

    private static By getLocatorFromField(Field field) {
        if (hasAnnotation(field, org.openqa.selenium.support.FindBy.class))
            return findByToBy(field.getAnnotation(org.openqa.selenium.support.FindBy.class));
        UI[] uis = field.getAnnotationsByType(UI.class);
        if (uis.length > 0 && any(uis, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
            return findByToBy(first(uis, j -> j.group().equals(TEST_GROUP)));
        FindBy[] jfindbys = field.getAnnotationsByType(FindBy.class);
        if (jfindbys.length > 0 && any(jfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
            return findByToBy(first(jfindbys, j -> j.group().equals(TEST_GROUP)));
        if (hasAnnotation(field, Css.class))
            return findByToBy(field.getAnnotation(Css.class));
        if (hasAnnotation(field, XPath.class))
            return findByToBy(field.getAnnotation(XPath.class));
        if (hasAnnotation(field, ByText.class))
            return findByToBy(field.getAnnotation(ByText.class));
        if (hasAnnotation(field, WithText.class))
            return findByToBy(field.getAnnotation(WithText.class));
        return null;
    }
    public static boolean isJDIField(Field field) {
        return isInterface(field, WebElement.class) ||
            isInterface(field, JDIElement.class) ||
            isListOf(field.getType(), WebElement.class) ||
            isListOf(field.getType(), JDIElement.class) ||
            isListOf(field.getType(), Section.class);
    }
    public static boolean isPageObject(Class<?> type) {
        return isClass(type, Section.class) || isClass(type, WebPage.class) ||
            LinqUtils.any(type.getDeclaredFields(), InitActions::isJDIField);
    }
    public static boolean isList(Class<?> clazz, JFunc1<Class<?>, Boolean> func) {
        try {
            return clazz == List.class && func.execute(getGenericType(clazz));
        } catch (Exception ex) { return false; }
    }
    public static boolean isList(Class<?> clazz, Class<?> type) {
        return isList(clazz, g -> g == type);
    }
    public static boolean isListOf(Class<?> clazz, Class<?> type) {
        return isList(clazz, g -> isClass(g, type) || isInterface(g, type));
    }
    public static Type[] getGenericTypes(Field field) {
        try {
            return ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        } catch (Exception ex) {
            throw exception( "'%s' is List but has no Generic types", field.getName());
        }
    }
    public static Class<?> getGenericType(Class<?> clazz) {
        try {
            return (Class<?>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception ex) {
            throw exception("'%s' is List but has no Generic type", clazz.getName());
        }
    }
}
