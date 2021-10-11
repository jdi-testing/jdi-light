package com.jdiai.tools;

import com.jdiai.annotations.UI;
import com.jdiai.interfaces.HasLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.tools.LinqUtils.copyList;
import static com.jdiai.tools.ReflectionUtils.isInterface;
import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.TestIDLocators.TEST_ID;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.openqa.selenium.support.How.*;
import static org.openqa.selenium.support.ui.Quotes.escape;

/**
 * Created by Roman Iovlev on 25.08.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public final class JSUtils {
     public static By uiToBy(UI locator) {
         if (locator == null) {
             return null;
         }
         if (isNotEmpty(locator.value())) {
             return NAME_TO_LOCATOR.apply(locator.value());
         }
         if (isNotEmpty(locator.testId())) {
             return By.cssSelector(String.format("[%s='%s']", TEST_ID, locator.testId()));
         }
         if (isNotEmpty(locator.id())) {
             return By.id(locator.id());
         }
         if (isNotEmpty(locator.clazz())) {
             return By.className(locator.clazz());
         }
         if (isNotEmpty(locator.xpath())) {
             return By.xpath(locator.xpath());
         }
         if (isNotEmpty(locator.css())) {
             return By.cssSelector(locator.css());
         }
         if (isNotEmpty(locator.text())) {
             return By.xpath(format(".//*/text()[normalize-space(.) = %s]/parent::*", escape(locator.text())));
         }
         if (isNotEmpty(locator.hasText())) {
             return By.xpath(format(".//*/text()[contains(normalize-space(.), %s)]/parent::*", escape(locator.hasText())));
         }
         if (isNotEmpty(locator.tag())) {
             return By.tagName(locator.tag());
         }
         if (isNotEmpty(locator.label())) {
             return By.cssSelector("[label=" + locator.label() + "]");
         }
         if (isNotEmpty(locator.alt())) {
             return By.cssSelector("[alt=" + locator.alt() + "]");
         }
         if (isNotEmpty(locator.hasValue())) {
             return By.cssSelector("[value=" + locator.hasValue() + "]");
         }
         return null;
     }

     public static By findByToBy(FindBy locator) {
         if (locator == null) {
             return null;
         }
         if (isNotEmpty(locator.id())) {
             return By.id(locator.id());
         }
         if (isNotEmpty(locator.className())) {
             return By.className(locator.className());
         }
         if (isNotEmpty(locator.xpath())) {
             return By.xpath(locator.xpath());
         }
         if (isNotEmpty(locator.css())) {
             return By.cssSelector(locator.css());
         }
         if (isNotEmpty(locator.linkText())) {
             return By.linkText(locator.linkText());
         }
         if (isNotEmpty(locator.name())) {
             return By.name(locator.name());
         }
         if (isNotEmpty(locator.partialLinkText())) {
             return By.partialLinkText(locator.partialLinkText());
         }
         if (isNotEmpty(locator.tagName())) {
             return By.tagName(locator.tagName());
         }
         if (locator.how() != UNSET) {
             return getHowLocator(locator);
         }
         return null;
     }
     private static By getHowLocator(FindBy locator) {
         if (locator == null) {
             return By.cssSelector("");
         }
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
