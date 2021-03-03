package org.jdiai.jsdriver;

import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.jdiai.jsdriver.jsbuilder.IJSBuilder;
import org.jdiai.tools.locators.ByFrame;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static java.lang.String.format;
import static java.util.Arrays.stream;
import static org.jdiai.jsdriver.jsbuilder.JSTemplates.XPATH_FUNC;
import static org.jdiai.jsdriver.jsbuilder.JSTemplates.XPATH_LIST_FUNC;
import static org.openqa.selenium.support.How.*;
import static org.openqa.selenium.support.ui.Quotes.escape;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class WebDriverByUtils {

    private WebDriverByUtils() { }

    public static Function<String, By> getByFunc(By by) {
        return first(getMapByTypes(), key -> by.toString().contains(key));
    }
    private static String getBadLocatorMsg(String byLocator, Object... args) {
        return "Bad locator template '" + byLocator + "'. Args: " + print(select(args, Object::toString), ", ", "'%s'") + ".";
    }
    public static By fillByTemplate(By by, Object... args) {
        String byLocator = getByLocator(by);
        if (!byLocator.contains("%"))
            throw new RuntimeException(getBadLocatorMsg(byLocator, args));
        try {
            byLocator = format(byLocator, args);
        } catch (Exception ex) {
            throw new RuntimeException(getBadLocatorMsg(byLocator, args));
        }
        return getByFunc(by).apply(byLocator);
    }
    public static By fillByMsgTemplate(By by, Object... args) {
        String byLocator = getByLocator(by);
        try {
            byLocator = MessageFormat.format(byLocator, args);
        } catch (Exception ex) {
            throw new RuntimeException(getBadLocatorMsg(byLocator, args));
        }
        return getByFunc(by).apply(byLocator);
    }
    public static By copyBy(By by) {
        String byLocator = getByLocator(by);
        return getByFunc(by).apply(byLocator);
    }
    public static boolean isIFrame(By by) {
        if (by == null) return false;
        return isClass(by.getClass(), ByFrame.class);
    }
    public static String getByLocator(By by) {
        if (by == null) return null;
        if (isIFrame(by)) return ((ByFrame) by).locator;
        String byAsString = by.toString();
        int index = byAsString.indexOf(": ") + 2;
        return byAsString.substring(index);
    }
    private static MapArray<String, String> byReplace = new MapArray<>(new Object[][] {
        {"cssSelector", "css"},
        {"tagName", "tag"},
        {"className", "class"}
    });
    public static String getByType(By by) {
        if (isIFrame(by)) return "frame";
        Matcher m = Pattern.compile("By\\.(?<locator>[a-zA-Z]+):.*").matcher(by.toString());
        if (m.find()) {
            String result = m.group("locator");
            return byReplace.has(result) ? byReplace.get(result) : result;
        }
        throw new RuntimeException("Can't get By name for: " + by);
    }

    public static By correctXPaths(By byValue) {
        return byValue.toString().contains("By.xpath: //")
            ? getByFunc(byValue).apply(getByLocator(byValue)
            .replaceFirst("/", "./"))
            : byValue;
    }
    public static String shortBy(By by) {
        return shortBy(by, () -> "No locator");
    }

    private static String shortBy(By by, JFunc<String> noLocator) {
        return (by == null
                ? noLocator.execute()
                : format("%s='%s'", getByType(by), getByLocator(by)));
    }

    private static Map<String, Function<String, By>> getMapByTypes() {
        Map<String, Function<String, By>> map = new HashMap<>();
        map.put("By.cssSelector", By::cssSelector);
        map.put("By.className", By::className);
        map.put("By.id", By::id);
        map.put("By.linkText", By::linkText);
        map.put("By.name", By::name);
        map.put("By.partialLinkText", By::partialLinkText);
        map.put("By.tagName", By::tagName);
        map.put("By.xpath", By::xpath);
        return map;
    }

    public static String asTextLocator(String text) {
        return format(".//*/text()[normalize-space(.) = %s]/parent::*", escape(text));
    }
    public static String asContainsTextLocator(String text) {
        return format(".//*/text()[contains(normalize-space(.), %s)]/parent::*", escape(text));
    }
    public static By byText(String text) {
        return By.xpath(asTextLocator(text));
    }
    public static By withText(String text) {
        return By.xpath(asContainsTextLocator(text));
    }

    public static String selector(By locator, IJSBuilder builder) {
        String selector = getByLocator(locator).replaceAll("'", "\"");
        if (getByType(locator).equals("xpath"))
            builder.registerFunction("xpath", XPATH_FUNC);
        return selector;
    }
    public static String selectorAll(By locator, IJSBuilder builder) {
        String selector = getByLocator(locator).replaceAll("'", "\"");
        if (getByType(locator).equals("xpath"))
            builder.registerFunction("xpathList", XPATH_LIST_FUNC);
        return selector;
    }

    public static By[] locatorsToBy(String... locators) {
        return stream(locators).map(NAME_TO_LOCATOR).toArray(By[]::new);
    }
    public static JFunc1<String, By> NAME_TO_LOCATOR = WebDriverByUtils::defineLocator;
    public static By defineLocator(String locator) {
        if (locator.contains("//"))
            return By.xpath(locator);
        if (locator.contains("frame:#"))
            return ByFrame.id(locator.substring(7));
        if (locator.contains("frame:"))
            return ByFrame.css(locator.substring(6));
        return locator.contains("//")
            ? By.xpath(locator)
            : By.cssSelector(locator);
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
}
