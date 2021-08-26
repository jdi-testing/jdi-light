package com.jdiai.locators;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

import static com.jdiai.tools.StringUtils.format;
import static org.openqa.selenium.support.ui.Quotes.escape;

public class By extends org.openqa.selenium.By {
    public static org.openqa.selenium.By id(String id) {
        return org.openqa.selenium.By.id(id);
    }
    public static org.openqa.selenium.By css(String css) {
        return org.openqa.selenium.By.cssSelector(css);
    }
    public static org.openqa.selenium.By tag(String tagName) {
        return org.openqa.selenium.By.tagName(tagName);
    }
    public static org.openqa.selenium.By xpath(String xpath) {
        return org.openqa.selenium.By.xpath(xpath);
    }

    public List<WebElement> findElements(SearchContext searchContext) {
        return new ByChained().findElements(searchContext);
    }

    public static org.openqa.selenium.By name(String name) {
        return org.openqa.selenium.By.name(name);
    }
    public static org.openqa.selenium.By clazz(String className) {
        return org.openqa.selenium.By.className(className);
    }
    public static org.openqa.selenium.By text(String text) {
        return org.openqa.selenium.By.xpath(format(".//*/text()[normalize-space(.) = %s]/parent::*", escape(text)));
    }
    public static org.openqa.selenium.By hasText(String text) {
        return org.openqa.selenium.By.xpath(format(".//*/text()[contains(normalize-space(.), %s)]/parent::*", escape(text)));
    }
    public static org.openqa.selenium.By label(String label) {
        return org.openqa.selenium.By.cssSelector("[label=" + label + "]");
    }
    public static org.openqa.selenium.By alt(String label) {
        return org.openqa.selenium.By.cssSelector("[alt=" + label + "]");
    }
    public static org.openqa.selenium.By value(String value) {
        return org.openqa.selenium.By.cssSelector("[value=" + value + "]");
    }
    public static org.openqa.selenium.By link(String link) {
        return org.openqa.selenium.By.linkText(link);
    }
    public static org.openqa.selenium.By hasLink(String link) {
        return org.openqa.selenium.By.partialLinkText(link);
    }
    public static ByFrame frame(String frameId) {
        return ByFrame.id(frameId);
    }
}
