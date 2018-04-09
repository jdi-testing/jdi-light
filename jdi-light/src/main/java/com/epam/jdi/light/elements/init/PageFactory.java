package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.UIElements;
import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.interfaces.IComposite;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.*;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.tools.func.JFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.epam.jdi.light.common.CheckTypes.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.DRIVER_NAME;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.*;
import static com.epam.jdi.light.settings.WebSettings.SEARCH_CONDITION;
import static com.epam.jdi.light.settings.WebSettings.TEST_GROUP;
import static com.epam.jdi.tools.LinqUtils.Switch;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.Switch.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class PageFactory {

    public static void initSite(Class<?> site) {
        Field[] pages = site.getDeclaredFields();
        for (Field pageField : pages) {
            try {
                Class type = pageField.getType();
                if (isClass(type, JDIBase.class))
                    initElement(pageField, false, site, DRIVER_NAME);
                if (isClass(type, WebPage.class)) {
                    WebPage page = (WebPage) newInstance(pageField, site.getSimpleName());
                    page.driverName = DRIVER_NAME;
                    page.setName(pageField.getName(), site.getSimpleName());
                    if (hasAnnotation(pageField, JPage.class))
                        fillPageFromAnnotaiton(page, getAnnotation(pageField, JPage.class), site);
                    if (hasAnnotation(pageField, UrlContains.class))
                        page.setCheckUrl(getAnnotation(pageField, UrlContains.class).value(), CONTAINS);
                    if (hasAnnotation(pageField, UrlMatch.class))
                        page.setCheckUrl(getAnnotation(pageField, UrlMatch.class).value(), MATCH);
                    if (hasAnnotation(pageField, TitleContains.class))
                        page.setCheckTitle(getAnnotation(pageField, TitleContains.class).value(), CONTAINS);
                    if (hasAnnotation(pageField, TitleMatch.class))
                        page.setCheckTitle(getAnnotation(pageField, TitleMatch.class).value(), MATCH);
                    initElements(page, DRIVER_NAME);
                    pageField.set(null, page);
                }
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

    public static void initElements(Object section, String driverName) {
        boolean isClass = section.getClass().isAssignableFrom(Class.class);
        Class<?> type = isClass ? (Class)section : section.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            initElement(field, isClass, section, driverName);
        }
    }
    private static void initElement(Field field, boolean isClass, Object section, String driverName) {
        String sectionName = section == null ? null : section.getClass().getSimpleName();
        try {
            Object instance = getValueField(field, section);
            if (instance == null)
                instance = newInstance(field, sectionName);
            if (instance != null) {
                Class<?> type = instance.getClass();
                if (isClass(type, JDIBase.class)) {
                    JDIBase jdi = (JDIBase) instance;
                    By locator = getLocatorFromField(field);
                    if (locator != null ) jdi.setLocator(locator);
                    if (field.isAnnotationPresent(Frame.class))
                        jdi.setFrame(getFrame(field.getAnnotation(Frame.class)));
                    jdi.setName(field.getName(), sectionName);
                    jdi.setTypeName(type.getName());
                    jdi.searchRule = SEARCH_CONDITION;
                    jdi.parent = section;
                    jdi.driverName = isBlank(driverName) ? DRIVER_NAME : driverName;
                    if (isInterface(field, ISetup.class))
                        ((ISetup)jdi).setup(field);
                }
                field.set(isClass ? null : section, instance);
                if (isInterface(type, IComposite.class))
                    initElements(instance, driverName);
            }
        } catch (Exception ex) {
            throw exception("Can't init or setup element '%s' on page '%s'", field.getName(), sectionName);
        }
    }
    private static Object newInstance(Field field, String sectionName) {
        return Switch(field).get(
            Case(f -> isInterface(f, WebElement.class),
                f -> new UIElement()),
            Case(f -> isList(f, WebElement.class) || isClass(f, UIList.class),
                f -> new UIList()),
            Case(f -> isList(f, IComposite.class),
                f -> initJElements(f, sectionName)),
            Case(f -> isInterface(f, IComposite.class),
                f -> initSection(f, sectionName)),
            Case(f -> isInterface(f, ISetup.class),
                f -> f.getType().newInstance() )
        );
    }
    private static boolean isList(Field field, Class<?> type) {
        return field.getType().isAssignableFrom(List.class)
                && isInterface(getGenericType(field), type);
    }

    private static Object initSection(Field field, String sectionName) {
        try {
            return field.getType().newInstance();
        } catch (Exception ex) {
            throw exception("Can't instantiate Section field '%s' on page '%s'", field.getName(), sectionName);
        }
    }
    private static UIElements initJElements(Field field, String sectionName) {
        Class<?> genericType = null;
        try {
            genericType = getGenericType(field);
            return new UIElements(genericType);
        } catch (Exception ex) {
            throw exception("Can't instantiate List<%s> field '%s' on page '%s'", genericType == null ? "UNKNOWN" : genericType.getSimpleName(), field.getName(), sectionName);
        }
    }
    public static void initElements(Object... pages) {
        for (Object page : pages) {
            if (isClass(page.getClass(), WebPage.class)) {
                ((WebPage)page).driverName = DRIVER_NAME;
                if (page.getClass().isAnnotationPresent(JPage.class))
                    fillPageFromAnnotaiton((WebPage) page, page.getClass().getAnnotation(JPage.class), null);
            }
            initElements(page, DRIVER_NAME);
        }
    }

    private static By getLocatorFromField(Field field) {
        FindBy[] jfindbys = field.getAnnotationsByType(FindBy.class);
        if (jfindbys.length > 0 && any(jfindbys, j -> j.group().equals("") || j.group().equals(TEST_GROUP)))
            return findByToBy(first(jfindbys, j -> j.group().equals(TEST_GROUP)));
        if (field.isAnnotationPresent(org.openqa.selenium.support.FindBy.class))
            return findByToBy(field.getAnnotation(org.openqa.selenium.support.FindBy.class));
        if (field.isAnnotationPresent(Css.class))
            return findByToBy(field.getAnnotation(Css.class));
        if (field.isAnnotationPresent(XPath.class))
            return findByToBy(field.getAnnotation(XPath.class));
        if (field.isAnnotationPresent(ByText.class))
            return findByToBy(field.getAnnotation(ByText.class));
        if (field.isAnnotationPresent(WithText.class))
            return findByToBy(field.getAnnotation(WithText.class));
        return null;
    }
    private static Class<?> getGenericType(Field field) {
        try {
            return (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
        } catch (Exception ex) {
            throw exception(field.getName() + " is List but has no Generic type");
        }
    }

    // Selenium PageFactory
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page;
        try {
            Constructor<T> constructor = pageClassToProxy.getConstructor(new Class[]{WebDriver.class});
            page = constructor.newInstance(new Object[]{driver});
        } catch (Exception ex) { throw exception(pageClassToProxy + " class should has constructor with WebDriver parameter"); }
        initElements(driver, page);
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