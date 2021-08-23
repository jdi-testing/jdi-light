package com.jdiai.jswraper;

import com.jdiai.jswraper.interfaces.GetValue;
import com.jdiai.jswraper.interfaces.SetValue;
import com.jdiai.locators.ByFrame;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.function.Function;
import java.util.regex.Matcher;

import static java.lang.Boolean.TYPE;
import static java.util.Arrays.stream;
import static java.util.regex.Pattern.compile;

public class JSWrappersUtils {
    public static Function<String, By> NAME_TO_LOCATOR = JSWrappersUtils::defineLocator;

    public static By defineLocator(String locator) {
        Matcher matcher = compile("^#([a-zA-Z][a-zA-Z0-9]*([-_:][a-zA-Z0-9]+)*)$").matcher(locator);
        if (matcher.matches()) {
            return By.id(matcher.group(1));
        }
        if (locator.contains("//")) {
            return By.xpath(locator);
        }
        if (locator.contains("frame:#")) {
            return ByFrame.id(locator.substring(7));
        }
        if (locator.contains("frame:")) {
            return ByFrame.css(locator.substring(6));
        }
        return locator.contains("//")
            ? By.xpath(locator)
            : By.cssSelector(locator);
    }

    public static By[] locatorsToBy(String... locators) {
        return stream(locators).map(NAME_TO_LOCATOR).toArray(By[]::new);
    }

    public static String getValueType(Field field, String element) {
        String value = field.isAnnotationPresent(GetValue.class)
            ? field.getAnnotation(GetValue.class).value()
            : "innerText";
        return setStringAction(element, value);
    }
    public static String setValueType(Field field, String element, Object value) {
        String action;
        if (field.isAnnotationPresent(SetValue.class)) {
            action = field.getAnnotation(SetValue.class).value();
        } else {
            if (value == null) {
                return null;
            }
            action = isBooleanTrue(field, value)
                ? "click();"
                : "value='" + value + "';";
        }
        return setStringAction(element, action);
    }
    private static boolean isBooleanTrue(Field field, Object value) {
        return (field.getType().equals(Boolean.class) && (Boolean) value)
            || (field.getType().equals(TYPE) && (boolean) value);
    }

    protected static String setStringAction(String element, String action) {
        boolean changed = false;
        if (action.contains("styles.")) {
            // action = action.replace("styles", "getComputedStyle(" +  element + ")");
            changed = true;
        }
        if (action.contains("{element}")) {
            action = action.replace("{element}", element);
            changed = true;
        }
        if (!changed) {
            action = element + "." + action;
        }
        return action;
    }
}
