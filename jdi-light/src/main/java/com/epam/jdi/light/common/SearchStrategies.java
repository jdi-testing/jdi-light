package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static com.epam.jdi.light.common.ElementArea.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static com.epam.jdi.light.settings.JDISettings.*;

public class SearchStrategies {
    public static JFunc1<WebElement, Boolean> ANY_ELEMENT = Objects::nonNull;
    public static JFunc1<WebElement, Boolean> VISIBLE_ELEMENT = WebElement::isDisplayed;
    public static JFunc1<WebElement, Boolean> ENABLED_ELEMENT = el ->
            el != null && el.isDisplayed() && el.isEnabled();
    public static JFunc1<WebElement, Boolean> ELEMENT_IN_VIEW = el ->
            el != null && el.isDisplayed() && $(el).isClickable();

    public static void setSearchRule(String name, JFunc1<WebElement, Boolean> rule) {
        ELEMENT.searchRule = Pair.$(name, rule);
    }
    public static void noValidation() {
        ELEMENT.searchRule = Pair.$("Any", ANY_ELEMENT);
        ELEMENT.clickType = CENTER;
    }
    public static void onlyVisible() {
        ELEMENT.searchRule = Pair.$("Visible", VISIBLE_ELEMENT);
    }
    public static void visibleEnabled() {
        ELEMENT.searchRule = Pair.$("Enabled", ENABLED_ELEMENT);
    }
    public static void inView() {
        ELEMENT.searchRule = Pair.$("Element in view", ELEMENT_IN_VIEW);
        ELEMENT.beforeSearch = UIElement::show;
    }
}
