package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.HasUIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
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
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Field;
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
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.reflect.Modifier.isStatic;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class PageFactory {

    public static JAction PRE_INIT = WebSettings::init;
    public static void initSite(Class<?> site) {
        PRE_INIT.execute();
        SiteInfo info = new SiteInfo(DRIVER_NAME);
        initialize(site, info);
    }
    public static void initSite(Class<?> site, String driverName) {
        PRE_INIT.execute();
        SiteInfo info = new SiteInfo(driverName);
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
        if (isClass(info.type(), WebPage.class))
            instance = SETUP_WEBPAGE_ON_SITE.execute(info);
        else {
            if (isPageObject(info.type()))
                instance = isClass(info.type(), DriverBase.class)
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
                !asList(HasUIElement.class, Object.class).contains(t),
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

    public static <T> T initFieldUsingRules(SiteInfo info) {
        if (!info.type().isInterface())
            try {
                return (T)(info.instance = create(info.type()));
            } catch (Exception ex) {
                throw exception("Can't create field '%s' instance of type '%s'. %sException: %s",
                        info.name(), info.type(), LINE_BREAK, ex.getMessage());
            }
        else {
            Pair<String, InitRule> firstRule = INIT_RULES.first((k,r) ->
                    r.condition.execute(info.type()));
            if (firstRule != null)
                try {
                    return (T)(info.instance = firstRule.value.func.execute(info));
                } catch (Exception ex) {
                    throw exception("Init rule '%s' failed. Can't init field '%s' on page '%s'.%s Exception: %s",
                            firstRule.key, info.name(), info.parentName(), LINE_BREAK, ex.getMessage());
                }
            else
                throw exception("No init rules found for '%s' (you can add appropriate rule in InitActions.INIT_RULES).",
                        info.name());
        }
    }

    public static void setupFieldUsingRules(SiteInfo info) {
        MapArray<String, SetupRule> setupRules = SETUP_RULES.filter((k, r) ->
                r.condition.execute(info));
        String ruleName = "UNDEFINED";
        if (isEmpty(setupRules))
            throw exception("No setup rules found for '%s' (you can add appropriate rule in InitActions.SETUP_RULES).",
                info.name());
        try {
            for(Pair<String, SetupRule> rule : setupRules) {
                ruleName = rule.key;
                rule.value.action.execute(info);
            }
        } catch (Exception ex) {
            throw exception("Setup rule '%s' failed. Can't setup field '%s' on page '%s'.%sException: %s",
                ruleName, info.name(), info.parentName(), LINE_BREAK, ex.getMessage());
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
            SiteInfo info = new SiteInfo(DRIVER_NAME);
            info.instance = obj;
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
            page = create(pageClassToProxy, driver);
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