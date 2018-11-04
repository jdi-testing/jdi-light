package com.epam.jdi.light.ui.html.utils;

import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.exception;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class HtmlUtils {
    public static int getInt(String attr, WebElement el) {
        String value = el.getAttribute(attr);
        try {
            return parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Integer", attr, value); }
    }
    public static double getDouble(String attr, WebElement el) {
        String value = el.getAttribute(attr);
        try {
            return parseDouble(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Double", attr, value); }
    }
}
