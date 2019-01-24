package com.epam.jdi.light.ui.html.utils;

import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.exception;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class HtmlUtils {
    /**
     * Gets attribute and casts it to int
     * @param attr String - attribute to find
     * @return int attribute value
     */
    public static int getInt(String attr, HtmlElement el) {
        String value = el.getAttribute(attr);
        try {
            return parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Integer", attr, value); }
    }
    /**
     * Gets attribute and casts it to double
     * @param attr String - attribute to find
     * @return int attribute value
     */
    public static double getDouble(String attr, WebElement el) {
        String value = el.getAttribute(attr);
        try {
            return parseDouble(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Double", attr, value); }
    }
    /**
     * Gets attribute and casts it to float
     * @param attr String - attribute to find
     * @return int attribute value
     */
    public static float getFloat(String attr, WebElement el) {
        String value = el.getAttribute(attr);
        try {
            return parseFloat(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Double", attr, value); }
    }
}
