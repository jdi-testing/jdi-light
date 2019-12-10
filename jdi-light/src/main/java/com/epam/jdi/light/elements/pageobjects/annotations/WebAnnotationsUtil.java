package com.epam.jdi.light.elements.pageobjects.annotations;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.WithText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.epam.jdi.light.driver.WebDriverByUtils.byText;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.driver.WebDriverByUtils.withText;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.How.LINK_TEXT;
import static org.openqa.selenium.support.How.NAME;
import static org.openqa.selenium.support.How.PARTIAL_LINK_TEXT;
import static org.openqa.selenium.support.How.TAG_NAME;
import static org.openqa.selenium.support.How.UNSET;
import static org.openqa.selenium.support.How.XPATH;

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

    public static void setDomain(Class<?> parentClass) {
        if (parentClass != null && parentClass.isAnnotationPresent(JSite.class)) {
            String siteDomain = parentClass.getAnnotation(JSite.class).value();
            if (!isBlank(siteDomain))
                DOMAIN = siteDomain;
        }
    }
    public static String getUrlFromUri(String uri) {
        if (isBlank(uri)) return DOMAIN;
        return DOMAIN.replaceAll("/*$", "") + "/" + uri.replaceAll("^/*", "");
    }

    public static By getFrame(Frame frame) {
        if (frame == null) {
            return null;
        }

        List<Pair<Supplier<String>, Function<String,By>>> remap = new ArrayList<>();
        remap.add(map(frame::value, By::id));
        remap.add(map(frame::xpath, By::xpath));
        remap.add(map(frame::css, By::cssSelector));
        remap.add(map(frame::linkText, By::linkText));
        remap.add(map(frame::partialLinkText, By::partialLinkText));
        remap.add(map(frame::tagName, By::tagName));
        remap.add(map(frame::text,
                t -> By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(t) + "]/parent::*")));
        remap.add(map(frame::id, By::id));
        remap.add(map(frame::className, By::className));
        remap.add(map(frame::name, By::name));

        return getMappedBy(remap);
    }

    public static By findByToBy(org.openqa.selenium.support.FindBy locator) {
        if (locator == null) {
            return null;
        }

        if (locator.how() != UNSET) {
            return getHowLocator(locator);
        }

        List<Pair<Supplier<String>, Function<String,By>>> remap = new ArrayList<>();
        remap.add(map(locator::id, By::id));
        remap.add(map(locator::className, By::className));
        remap.add(map(locator::xpath, By::xpath));
        remap.add(map(locator::css, By::cssSelector));
        remap.add(map(locator::linkText, By::linkText));
        remap.add(map(locator::name, By::name));
        remap.add(map(locator::partialLinkText, By::partialLinkText));
        remap.add(map(locator::tagName, By::tagName));

        return getMappedBy(remap);
    }

    public static By findByToBy(FindBy locator) {
        if (locator == null) {
            return null;
        }

        List<Pair<Supplier<String>, Function<String,By>>> remap = new ArrayList<>();
        remap.add(map(locator::xpath, By::xpath));
        remap.add(map(locator::css, By::cssSelector));
        remap.add(map(locator::linkText, By::linkText));
        remap.add(map(locator::partialLinkText, By::partialLinkText));
        remap.add(map(locator::tagName, By::tagName));
        remap.add(map(locator::text, (t) -> By.xpath(".//*/text()[normalize-space(.) = " +
                Quotes.escape(t) + "]/parent::*")));
        remap.add(map(locator::id, By::id));
        remap.add(map(locator::className, By::className));
        remap.add(map(locator::name, By::name));

        return getMappedBy(remap);
    }

    private static Pair<Supplier<String>, Function<String,By>> map(Supplier<String> textKey,  Function<String,By> byValue) {
        return new Pair<> (textKey, byValue);
    }

    private static By getMappedBy(List<Pair<Supplier<String>, Function<String,By>>> remap) {
        for(Pair<Supplier<String>, Function<String,By>> rule : remap) {
            String frameKey = rule.key.get();
            if(!frameKey.isEmpty()) {
                return rule.value.apply(frameKey);
            }
        }

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

}