package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.rules.InitRule;
import com.epam.jdi.light.elements.init.rules.SetupRule;
import com.epam.jdi.light.elements.interfaces.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.create;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.useDriver;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.composite.WebPage.addPage;
import static com.epam.jdi.light.elements.init.InitActions.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.setDomain;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.reflect.Modifier.isStatic;
import static java.util.Arrays.asList;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class PageFactory {

    public static JAction PRE_INIT = WebSettings::init;
    public static void initSite(Class<?> site) {
        PRE_INIT.execute();
        SiteInfo info = new SiteInfo();
        info.driverName = DRIVER_NAME;
        initialize(site, info);
    }
    public static void initSite(Class<?> site, String driverName) {
        PRE_INIT.execute();
        SiteInfo info = new SiteInfo();
        info.driverName = driverName;
        initialize(site, info);
    }
    private static void initialize(Class<?> site, SiteInfo info) {
        info.parentClass = site;
        setDomain(site);
        Field[] pages = site.getDeclaredFields();
        List<Field> staticPages = filter(pages, p -> isStatic(p.getModifiers()));
        for (Field pageField : staticPages) {
            try {
                initPageFields(info, pageField);
            } catch (Exception ex) {
                throw exception("Can't init %s '%s' on '%s'. Exception: %s",
                        isClass(pageField.getType(), WebPage.class) ? "page" : "element",
                        pageField.getName(),
                        site.getSimpleName(),
                        ex.getMessage());
            }
        }
    }
    private static void initPageFields(SiteInfo info, Field pageField) throws IllegalAccessException {
        info.field = pageField;
        Object instance = null;
        if (isClass(info.fieldType(), WebPage.class))
            instance = SETUP_WEBPAGE_ON_SITE.execute(info);
        else {
            if (isPageObject(info.fieldType()))
                instance = isClass(info.fieldType(), DriverBase.class)
                    ? SETUP_SECTION_ON_SITE.execute(info)
                    : SETUP_PAGE_OBJECT_ON_SITE.execute(info);
            else if(isJDIField(pageField))
                instance = PageFactory.initElement(info);
        }
        if (instance != null)
            pageField.set(null, instance);
    }
    public static void initElements(Class<?> site) {
        initSite(site);
    }
    public static void initElements(JFunc<WebDriver> driver, Object... pages) {
        useDriver(driver);
        initElements(pages);
    }

    public static void initElements(SiteInfo info) {
        List<Field> poFields = recursion(
            t -> isInterface(t, PageObject.class) &&
                !asList(WebPage.class, Section.class, Form.class).contains(t) ||
                !isInterface(t, PageObject.class) &&
                !asList(UIElement.class, BaseUIElement.class, JDIBase.class, Object.class).contains(t),
            info.instance.getClass(),
            t -> asList(t.getDeclaredFields()));
        List<Field> fields = filter(poFields, f -> isJDIField(f) || isPageObject(f.getType()));
        SiteInfo pageInfo = new SiteInfo(info);
        pageInfo.parent = info.instance;
        for (Field field : fields) {
            pageInfo.field = field;
            try {
                Object obj = isStatic(field.getModifiers()) ? null : info.instance;
                field.set(obj, initElement(pageInfo));
            } catch (Exception ex) {
                throw exception("Can't init %s '%s' on '%s'. Exception: %s",
                    isClass(pageInfo.field.getType(), WebPage.class) ? "page" : "element",
                    pageInfo.field.getName(),
                    info.field.getType().getSimpleName(),
                    ex.getMessage());
            }
        }
    }
    public static Object initElement(SiteInfo info) {
        info.instance = getValueField(info.field, info.parent);
        if (info.instance == null)
            initFieldUsingRules(info);
        if (info.instance != null)
            setupFieldUsingRules(info);
        return info.instance;
    }

    private static void initFieldUsingRules(SiteInfo info) {
        String ruleName = "";
        try {
            if (!info.field.getType().isInterface())
                info.instance = create(info.field.getType());
            else {
                for (Pair<String, InitRule> rule : INIT_RULES) {
                    ruleName = rule.key;
                    if (rule.value.condition.execute(info.field)) {
                        ruleName = "Init:" + ruleName;
                        info.instance = rule.value.func.execute(info);
                        break;
                    }
                }
                if (!ruleName.contains("Init:")) throw exception("");
            }
        } catch (Exception ex) {
            throw exception("Init rule '%s' failed. Can't init field '%s' on page '%s'. No init rules found (you can add appropriate rule in InitActions.INIT_RULES).%s Exception: " + ex.getMessage(),
                    ruleName, info.field.getName(), info.parentName(), LINE_BREAK);
        }
    }

    private static void setupFieldUsingRules(SiteInfo info) {
        String ruleName = "";
        try {
            for(Pair<String, SetupRule> rule : SETUP_RULES) {
                ruleName = rule.key;
                if (rule.value.condition.execute(info)) {
                    ruleName = "Setup:"+ruleName;
                    rule.value.action.execute(info);
                }
            }
        } catch (Exception ex) {
            throw exception("Setup rule '%s' failed. Can't setup field '%s' on page '%s'. No setup rules found (you can add appropriate rule in InitActions.SETUP_RULES).%s Exception: " + ex.getMessage(),
                    ruleName, info.field.getName(), info.parentName(), LINE_BREAK);
        }
    }

    public static void initElements(Class<?>... pages) {
        PRE_INIT.execute();
        for (Class<?> page : pages) {
            initElements(getDriver(), page);
        }
    }
    public static void initElements(Object... pages) {
        PRE_INIT.execute();
        for (Object obj : pages) {
            SiteInfo info = new SiteInfo();
            info.instance = obj;
            info.driverName = DRIVER_NAME;
            if (isClass(obj.getClass(), WebPage.class)) {
                WebPage page = (WebPage) obj;
                page.driverName = DRIVER_NAME;
                page.updatePageData(page.getClass().getAnnotation(Url.class),
                        page.getClass().getAnnotation(Title.class));
                addPage(page);
            }
            initElements(info);
        }
    }

    // Selenium PageFactory
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page;
        useDriver(() -> driver);
        try {
            page = create(pageClassToProxy,driver);
        } catch (Exception ignore) {
            try {
                page = create(pageClassToProxy);
            } catch (Exception ex) { throw exception(pageClassToProxy + " class should has constructor with WebDriver parameter"); }
        }
        initElements(page);
        return page;
    }
    public static void initElements(WebDriver driver, Object page) {
        initElements(page);
    }
    public static void initElements(ElementLocatorFactory factory, Object page) {
        initElements(page);
    }
    public static void initElements(FieldDecorator decorator, Object page) {
        initElements(page);
    }
}