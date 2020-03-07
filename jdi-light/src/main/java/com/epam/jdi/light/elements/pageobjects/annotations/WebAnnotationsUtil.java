package com.epam.jdi.light.elements.pageobjects.annotations;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.settings.WebSettings;
import org.openqa.selenium.By;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.StringUtils.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.openqa.selenium.support.How.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebAnnotationsUtil {

    public static boolean hasAnnotation(Field field, Class<? extends Annotation> annotation) {
        return field.isAnnotationPresent(annotation)
                || field.getType().isAnnotationPresent(annotation);
    }
    public static <T extends Annotation> T getAnnotation(Field field, Class<T> annotation) {
        T result = field.getAnnotation(annotation);
        return result == null
            ? field.getType().getAnnotation(annotation)
            : result;
    }
    public static String getElementName(Field field) {
        if (hasAnnotation(field, Name.class))
            return field.getAnnotation(Name.class).value();
        if (field.getType().isAnnotationPresent(Name.class))
            return field.getType().getAnnotation(Name.class).value();
        return splitCamelCase(field.getName());
    }

    public static void setDomain(Class<?> siteClass) {
        if (siteClass != null) {
            APP_NAME = siteClass.getSimpleName();
            if (siteClass.isAnnotationPresent(JSite.class)) {
                String siteDomain = siteClass.getAnnotation(JSite.class).value();
                if (!isBlank(siteDomain))
                    WebSettings.setDomain(siteDomain);
            }
        }
    }
    public static String getUrlFromUri(String uri) {
        if (isBlank(uri)) return getDomain();
        return getDomain().replaceAll("/*$", "") + "/" + uri.replaceAll("^/*", "");
    }

    public static List<By> getFrames(Frame frames) {
        if (frames == null) return null;
        List<By> result = new ArrayList<>();
        for (String frame : frames.value())
            result.add(defineLocator(frame));
        return result;
    }

    public static By findByToBy(org.openqa.selenium.support.FindBy locator) {
        if (locator == null) return null;
        if (!locator.id().isEmpty())
            return By.id(locator.id());
        if (!locator.className().isEmpty())
            return By.className(locator.className());
        if (!locator.xpath().isEmpty())
            return By.xpath(locator.xpath());
        if (!locator.css().isEmpty())
            return By.cssSelector(locator.css());
        if (!locator.linkText().isEmpty())
            return By.linkText(locator.linkText());
        if (!locator.name().isEmpty())
            return By.name(locator.name());
        if (!locator.partialLinkText().isEmpty())
            return By.partialLinkText(locator.partialLinkText());
        if (!locator.tagName().isEmpty())
            return By.tagName(locator.tagName());
        if (locator.how() != UNSET)
            return getHowLocator(locator);
        return null;
    }
    private static By getHowLocator(org.openqa.selenium.support.FindBy locator) {
        if (locator.how() == ID)
            return By.id(locator.using());
        if (locator.how() == CLASS_NAME)
            return By.className(locator.using());
        if (locator.how() == XPATH)
            return By.xpath(locator.using());
        if (locator.how() == CSS)
            return By.cssSelector(locator.using());
        if (locator.how() == LINK_TEXT)
            return By.linkText(locator.using());
        if (locator.how() == NAME)
            return By.name(locator.using());
        if (locator.how() == PARTIAL_LINK_TEXT)
            return By.partialLinkText(locator.using());
        if (locator.how() == TAG_NAME)
            return By.tagName(locator.using());
        return null;
    }

    public static By findByToBy(FindBy locator) {
        if (locator == null) return null;

        if (!"".equals(locator.xpath()))
            return By.xpath(locator.xpath());
        if (!"".equals(locator.css()))
            return By.cssSelector(locator.css());
        if (!"".equals(locator.linkText()))
            return By.linkText(locator.linkText());
        if (!"".equals(locator.partialLinkText()))
            return By.partialLinkText(locator.partialLinkText());
        if (!"".equals(locator.tagName()))
            return By.tagName(locator.tagName());
        if (!"".equals(locator.text()))
            return byText(locator.text());
        if (!"".equals(locator.containsText()))
            return withText(locator.containsText());
        if (!"".equals(locator.id()))
            return By.id(locator.id());
        if (!"".equals(locator.className()))
            return By.className(locator.className());
        if (!"".equals(locator.name()))
            return By.name(locator.name());

        return null;
    }

    public static By findByToBy(Css locator){
        if (locator == null) return null;
        return By.cssSelector(locator.value());
    }
    public static By findByToBy(XPath locator){
        if (locator == null) return null;
        return By.xpath(locator.value());
    }
    public static By findByToBy(UI locator){
        if (locator == null) return null;
        return defineLocator(locator.value());
    }
    public static By findByToBy(ByText locator){
        if (locator == null) return null;
        return byText(locator.value());
    }
    public static By findByToBy(WithText locator){
        if (locator == null) return null;
        return withText(locator.value());
    }

}