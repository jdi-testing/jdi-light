package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.rules.InitRule;
import com.epam.jdi.light.elements.init.rules.SetupRule;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.*;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
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
import static com.epam.jdi.tools.switcher.SwitchActions.Case;
import static com.epam.jdi.tools.switcher.SwitchActions.Default;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class InitActions {
    public static JFunc1<SiteInfo, Object> SETUP_SECTION_ON_SITE = info -> {
        info.instance = initElement(info);
        initElements(info);
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
            info.instance = info.field.getType().newInstance();
        } catch (Exception ignore) {
            try {
                info.instance = info.field.getType().getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
            } catch (Exception ex) {
                throw exception("Can't initialize Page Object '%s'. Exception: %s", info.field.getName(), ex.getMessage());
            }
        }
        initElements(info);
        return info.instance;
    };

    public static MapArray<String, InitRule> INIT_RULES = map(
        $("Selector", iRule(f -> isClass(f, Selector.class),
            info -> new Selector())),
        $("UIElement", iRule(f -> isInterface(f, WebElement.class),
            info -> new UIElement())),
        $("WebList", iRule(f -> isClass(f, WebList.class) || isList(f, WebElement.class),
            info -> new WebList())),
        $("UIList", iRule(f -> isInterface(f, List.class) && isPageObject(getGenericType(f)),
            InitActions::initUIList)),
        $("PageObject", iRule(f -> isPageObject(f.getType()),
            InitActions::initSection)),
        $("Default", iRule(f -> isClass(f, DriverBase.class),
            info -> info.field.getType().newInstance()))
    );

    public static MapArray<String, SetupRule> SETUP_RULES = map(
        $("Element", sRule(info -> isClass(info.instance.getClass(), JDIBase.class),
            InitActions::defaultSetup)),
        $("ISetup", sRule(info -> isInterface(info.field, ISetup.class),
            info -> ((ISetup)info.instance).setup(info.field))),
        $("PageObject", sRule(info -> isPageObject(info.instance.getClass()),
                PageFactory::initElements))
    );

    private static void defaultSetup(SiteInfo info) {
        String parentName = Switch(info).get(
            Case(i-> i.parent != null,
                i -> i.parent.getClass().getSimpleName()),
            Case(i-> i.parentClass != null,
                i -> i.parentClass.getSimpleName()),
            Default(null)
        );
        Class<?> type = info.instance.getClass();
        JDIBase jdi = (JDIBase) info.instance;
        By locator = getLocatorFromField(info.field);
        if (locator != null ) jdi.setLocator(locator);
        if (hasAnnotation(info.field, Frame.class))
            jdi.setFrame(getFrame(info.field.getAnnotation(Frame.class)));
        jdi.setName(info.field.getName(), parentName);
        jdi.setTypeName(type.getName());
        jdi.parent = info.parent;
        jdi.driverName = isBlank(info.driverName) ? DRIVER_NAME : info.driverName;
        info.instance = jdi;
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
    public static <T> T initSection(SiteInfo info) {
        try {
            return (T) info.fieldType().newInstance();
        } catch (Exception ex) {
            throw exception("Can't instantiate Section field '%s' on page '%s'", info.field.getName(), info.parentName());
        }
    }
    public static UIList initUIList(SiteInfo info) {
        Class<?> genericType = null;
        try {
            genericType = getGenericType(info.field);
            return new UIList(genericType);
        } catch (Exception ex) {
            throw exception("Can't instantiate List<%s> field '%s' on page '%s'", genericType == null
                    ? "UNKNOWN" : genericType.getSimpleName(), info.field.getName(), info.parentName());
        }
    }
    public static boolean isJDIField(Field field) {
        return isInterface(field, WebElement.class) ||
                isInterface(field, BaseElement.class) ||
                isClass(field, DriverBase.class) ||
                isList(field, WebElement.class) ||
                isList(field, DriverBase.class)||
                isList(field, BaseElement.class);
    }
    public static boolean isPageObject(Class<?> type) {
        return isClass(type, Section.class) || isClass(type, WebPage.class) ||
            LinqUtils.any(type.getFields(), InitActions::isJDIField);
    }
    public static boolean isList(Field field, Class<?> type) {
        return isInterface(field, List.class)
                && isInterface(getGenericType(field), type);
    }
    public static Class<?> getGenericType(Field field) {
        try {
            return (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
        } catch (Exception ex) {
            throw exception(field.getName() + " is List but has no Generic type");
        }
    }
}
