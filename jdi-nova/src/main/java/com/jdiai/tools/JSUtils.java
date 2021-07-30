package com.jdiai.tools;

import com.jdiai.annotations.UI;
import com.jdiai.interfaces.HasLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.copyList;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.openqa.selenium.support.How.*;
import static org.openqa.selenium.support.ui.Quotes.escape;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class JSUtils {
     public static By uiToBy(UI locator) {
         if (locator == null) return null;
         if (!locator.value().isEmpty()) {
             return NAME_TO_LOCATOR.apply(locator.value());
         }
         if (!locator.id().isEmpty()) {
             return By.id(locator.id());
         }
         if (!locator.clazz().isEmpty()) {
             return By.className(locator.clazz());
         }
         if (!locator.xpath().isEmpty()) {
             return By.xpath(locator.xpath());
         }
         if (!locator.css().isEmpty()) {
             return By.cssSelector(locator.css());
         }
         if (!locator.text().isEmpty()) {
             return By.xpath(format(".//*/text()[normalize-space(.) = %s]/parent::*", escape(locator.text())));
         }
         if (!locator.hasText().isEmpty()) {
             return By.xpath(format(".//*/text()[contains(normalize-space(.), %s)]/parent::*", escape(locator.hasText())));
         }
         if (!locator.tag().isEmpty()) {
             return By.tagName(locator.tag());
         }
         if (!locator.label().isEmpty()) {
             return By.cssSelector("[label=" + locator.label() + "]");
         }
         if (!locator.alt().isEmpty()) {
             return By.cssSelector("[alt=" + locator.alt() + "]");
         }
         if (!locator.hasValue().isEmpty()) {
             return By.cssSelector("[value=" + locator.hasValue() + "]");
         }
         return null;
     }

     public static By findByToBy(FindBy locator) {
         if (locator == null) {
             return null;
         }
         if (!locator.id().isEmpty()) {
             return By.id(locator.id());
         }
         if (!locator.className().isEmpty()) {
             return By.className(locator.className());
         }
         if (!locator.xpath().isEmpty()) {
             return By.xpath(locator.xpath());
         }
         if (!locator.css().isEmpty()) {
             return By.cssSelector(locator.css());
         }
         if (!locator.linkText().isEmpty()) {
             return By.linkText(locator.linkText());
         }
         if (!locator.name().isEmpty()) {
             return By.name(locator.name());
         }
         if (!locator.partialLinkText().isEmpty()) {
             return By.partialLinkText(locator.partialLinkText());
         }
         if (!locator.tagName().isEmpty()) {
             return By.tagName(locator.tagName());
         }
         if (locator.how() != UNSET) {
             return getHowLocator(locator);
         }
         return null;
     }
     private static By getHowLocator(FindBy locator) {
         if (locator.how() == ID) {
             return By.id(locator.using());
         }
         if (locator.how() == CLASS_NAME) {
             return By.className(locator.using());
         }
         if (locator.how() == XPATH) {
             return By.xpath(locator.using());
         }
         if (locator.how() == CSS) {
             return By.cssSelector(locator.using());
         }
         if (locator.how() == LINK_TEXT) {
             return By.linkText(locator.using());
         }
         if (locator.how() == NAME) {
             return By.name(locator.using());
         }
         if (locator.how() == PARTIAL_LINK_TEXT) {
             return By.partialLinkText(locator.using());
         }
         if (locator.how() == TAG_NAME) {
             return By.tagName(locator.using());
         }
         return null;
     }

     public static List<By> getLocators(Object parent) {
         List<By> locators = new ArrayList<>();
         if (parent != null && isInterface(parent.getClass(), HasLocators.class)) {
             List<By> pLocators = ((HasLocators) parent).locators();
             if (isNotEmpty(pLocators)) {
                 locators.addAll(copyList(pLocators));
             }
         }
         return locators;
     }
    public static List<By> getLocators(By locator, Object parent) {
        List<By> locators = getLocators(parent);
        locators.add(locator);
        return locators;
    }
}
