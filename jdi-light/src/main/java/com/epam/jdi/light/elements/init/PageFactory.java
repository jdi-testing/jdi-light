package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.WithText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.By;
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
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.light.settings.WebSettings.TEST_GROUP;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.reflect.Modifier.isStatic;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class PageFactory {

    public static void initSite(Class<?> site) {
        SiteInfo info = new SiteInfo();
        info.parentClass = site;
        info.driverName = DRIVER_NAME;
        WebSettings.init();
        setDomain(site);
        Field[] pages = site.getDeclaredFields();
        List<Field> staticPages = filter(pages, p -> isStatic(p.getModifiers()));
        for (Field pageField : staticPages) {
            try {
                info.field = pageField;
                Object instance = Switch(info).get(
                    Case(i -> isClass(i.fieldType(), WebPage.class),
                        i-> SETUP_WEBPAGE_ON_SITE.execute(i)),
                    Case(i -> isPageObject(i.fieldType()),
                        i -> SETUP_PAGE_OBJECT_ON_SITE.execute(info)),
                    Case(i -> isJDIField(pageField), PageFactory::initElement));
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
        List<Field> fields = filter(info.instance.getClass().getDeclaredFields(),
                f -> isJDIField(f) || isPageObject(f.getType()));
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
    private static Object initElement(SiteInfo info) {
        try {
            info.instance = getValueField(info.field, info.parent);
            if (info.instance == null) {
                if (any(INIT_RULES, r -> r.key.execute(info.field)))
                    info.instance = first(INIT_RULES, r -> r.key.execute(info.field))
                        .value.execute(info);
                else throw exception("Can't init field '%s'. No init rules found (you can add appropriate rule in InitActions.INIT_RULES)");
            }
            if (info.instance != null) {
                ifDo(SETUP_RULES, rule -> rule.key.execute(info),
                    rule -> rule.value.execute(info));
            }
            return info.instance;
        } catch (Exception ex) {
            throw exception("Can't init or setup element '%s' on page '%s'", info.field.getName(), info.parentName());
        }
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

    public static By getLocatorFromField(Field field) {
        FindBy[] jfindbys = field.getAnnotationsByType(FindBy.class);
        if (jfindbys.length > 0 && any(jfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
            return findByToBy(first(jfindbys, j -> j.group().equals(TEST_GROUP)));
        if (hasAnnotation(field, org.openqa.selenium.support.FindBy.class))
            return findByToBy(field.getAnnotation(org.openqa.selenium.support.FindBy.class));
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