package org.jdiai.tools;

import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;

import static com.epam.jdi.tools.StringUtils.toKebabCase;
import static org.openqa.selenium.By.*;

public class TestIDLocators {
    public static final JFunc1<String, By> DATA_TEST_ID = fieldName ->
        cssSelector("[data-testid='" + toKebabCase(fieldName) + "']");
    public static final JFunc1<String, By> ID_LOCATOR = fieldName ->
        id(toKebabCase(fieldName));
    public static final JFunc1<String, By> CLASS_LOCATOR = fieldName ->
        className(toKebabCase(fieldName));
    public static final JFunc1<String, By> NAME_LOCATOR = fieldName ->
        name(toKebabCase(fieldName));

    public static JFunc1<String, By> SMART_LOCATOR = DATA_TEST_ID;

    public static JFunc1<String, By> getSmartLocator() {
        return SMART_LOCATOR;
    }

}
