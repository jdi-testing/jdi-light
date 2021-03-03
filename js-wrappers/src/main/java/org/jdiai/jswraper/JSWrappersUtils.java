package org.jdiai.jswraper;

import com.epam.jdi.tools.func.JFunc1;
import org.jdiai.jswraper.interfaces.GetValue;
import org.jdiai.locators.ByFrame;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

import static java.util.Arrays.stream;

public class JSWrappersUtils {
    public static JFunc1<String, By> NAME_TO_LOCATOR = JSWrappersUtils::defineLocator;

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

    public static By[] locatorsToBy(String... locators) {
        return stream(locators).map(NAME_TO_LOCATOR).toArray(By[]::new);
    }

    public static String getValueType(Field field, String element) {
        String value = field.isAnnotationPresent(GetValue.class)
                ? field.getAnnotation(GetValue.class).value()
                : "innerText";
        if (value.contains("style.")) {
            return value.replace("style", "getComputedStyle(" +  element + ")");
        } else if (value.contains("{element}")) {
            return value.replace("{element}", element);
        }
        return element + "." + value;
    }
}
