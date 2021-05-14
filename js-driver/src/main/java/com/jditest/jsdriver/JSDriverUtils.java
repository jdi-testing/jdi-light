package com.jditest.jsdriver;

import com.epam.jdi.tools.map.MapArray;
import com.jditest.jsbuilder.IJSBuilder;
import com.jditest.locators.ByFrame;
import org.openqa.selenium.By;

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
import static com.jditest.jsbuilder.JSTemplates.XPATH_FUNC;
import static com.jditest.jsbuilder.JSTemplates.XPATH_LIST_FUNC;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public final class JSDriverUtils {
    private JSDriverUtils() { }

    public static String selector(By by, IJSBuilder builder) {
        String locator = getByLocator(by);
        if (locator == null) {
            throw new JSException("Failed to build selector. Locator is null");
        }
        String selector = locator.replace("'", "\"");
        if (getByType(by).equals("xpath")) {
            builder.registerFunction("xpath", XPATH_FUNC);
        }
        return selector;
    }
    public static String selectorAll(By by, IJSBuilder builder) {
        String locator = getByLocator(by);
        if (locator == null) {
            throw new JSException("Failed to build selector. Locator is null");
        }
        String selector = locator.replace("'", "\"");
        if (getByType(by).equals("xpath"))
            builder.registerFunction("xpathList", XPATH_LIST_FUNC);
        return selector;
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
    private static final MapArray<String, String> byReplace = new MapArray<>(new Object[][] {
        {"cssSelector", "css"},
        {"tagName", "tag"},
        {"className", "class"}
    });
    public static String getByType(By by) {
        if (isIFrame(by)) return "frame";
        if (by == null)
            return "";
        Matcher m = Pattern.compile("By\\.(?<locator>[a-zA-Z]+):.*").matcher(by.toString());
        if (m.find()) {
            String result = m.group("locator");
            return byReplace.has(result) ? byReplace.get(result) : result;
        }
        throw new RuntimeException("Can't get By name for: " + by);
    }
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
}
