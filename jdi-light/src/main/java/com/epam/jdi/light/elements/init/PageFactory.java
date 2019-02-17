package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.rules.InitRule;
import com.epam.jdi.light.elements.init.rules.SetupRule;
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
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.useDriver;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.composite.WebPage.addPage;
import static com.epam.jdi.light.elements.init.InitActions.*;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.setDomain;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.reflect.Modifier.isStatic;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class PageFactory {

    public static JAction PRE_INIT = WebSettings::init;

    public static void initSite(Class<?> site) {
        SiteInfo info = new SiteInfo();
        info.parentClass = site;
        info.driverName = DRIVER_NAME;
        PRE_INIT.execute();
        setDomain(site);
        Field[] pages = site.getDeclaredFields();
        List<Field> staticPages = filter(pages, p -> isStatic(p.getModifiers()));
        for (Field pageField : staticPages) {
            try {
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
            } catch (Exception ex) {
                throw exception("Can't init %s '%s' on '%s'. Exception: %s",
                    isClass(pageField.getType(), WebPage.class) ? "page" : "element",
                        pageField.getName(),
                        site.getSimpleName(),
                        ex.getMessage());
            }
        }
    }
    public static void initElements(Class<?> site) {
        initSite(site);
    }
    public static void initElements(JFunc<WebDriver> driver, Object... pages) { }

    public static void initElements(SiteInfo info) {
        List<Field> poFields = getFieldsDeep(info.instance.getClass(), Section.class, WebPage.class);
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
        String ruleName = "";
        if (info.instance == null) {
            try {
            if (!info.field.getType().isInterface())
                info.instance = info.field.getType().newInstance();
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
        if (info.instance != null) {
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
        return info.instance;
    }
    public static void initElements(Class<?>... pages) {
        for (Class<?> page : pages) {
            initElements((WebDriver) null, page);
        }
    }
    public static void initElements(Object... pages) {
        for (Object obj : pages) {
            SiteInfo info = new SiteInfo();
            info.instance = obj;
            info.driverName = DRIVER_NAME;
            PRE_INIT.execute();
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
            Constructor<T> constructor = pageClassToProxy.getConstructor(new Class[]{WebDriver.class});
            page = constructor.newInstance(new Object[]{driver});
        } catch (Exception ignore) {
            try {
                page = pageClassToProxy.newInstance();
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