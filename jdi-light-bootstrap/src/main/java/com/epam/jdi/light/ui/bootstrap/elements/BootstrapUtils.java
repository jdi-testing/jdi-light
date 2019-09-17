package com.epam.jdi.light.ui.bootstrap.elements;

import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.exception;
import static java.lang.Integer.parseInt;

public class BootstrapUtils {
    public static int getInt(String attr, WebElement el) {
        String value = el.getAttribute(attr);
        try {
            return parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse attribute '%s=%s' to Integer", attr, value); }
    }
    public static int asInt(String value) {
        try {
            return parseInt(value);
        } catch (Exception ex) { throw exception("Can't parse value %s to Integer", value); }
    }
}
