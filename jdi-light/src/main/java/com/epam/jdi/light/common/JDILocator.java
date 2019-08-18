package com.epam.jdi.light.common;

import com.epam.jdi.light.elements.base.JDIBase;
import org.openqa.selenium.By;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.LocatorType.DEFAULT;
import static com.epam.jdi.light.common.LocatorType.FRAME;
import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static com.epam.jdi.light.settings.WebSettings.hasDomain;
import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.splitHyphen;
import static java.lang.String.format;

public class JDILocator {
    private LocatorType locatorType = DEFAULT;
    private By byLocator;
    public boolean isRoot = false;
    private JDIBase element;
    private Object[] args = new Object[]{};

    public By getLocator() { return byLocator; }
    public By getLocator(Object... args) {
        this.args = args;
        if (args.length == 0) return byLocator;
        return args.length == 1
                ? fillByTemplate(byLocator, args)
                : fillByMsgTemplate(byLocator, args);
    }
    public boolean isEmpty() {
        return byLocator == null || locatorType == FRAME;
    }
    public boolean isFrame() {
        return locatorType == FRAME;
    }
    public By getFrame() { return locatorType == FRAME ? byLocator : null; }
    public By getFrame(Object... args) { return locatorType == FRAME ? getLocator(args) : null; }

    public boolean isRoot() {
        return isRoot;
    }

    public JDILocator() {
    }
    public JDILocator(By locator, JDIBase element) {
        this(locator, DEFAULT, element);
    }
    public JDILocator(By locator, LocatorType type, JDIBase element) {
        locatorType = type;
        byLocator = setRootLocator(locator)
                ? trimRoot(locator)
                : locator;
        this.element = element;
    }
    public boolean isTemplate() {
        return byLocator != null && byLocator.toString().contains("%s");
    }
    private boolean setRootLocator(By locator) {
        if (containsRoot(locator))
            isRoot = true;
        return isRoot;
    }

    private boolean containsRoot(By by) {
        return by != null && by.toString().contains(": *root*");
    }
    private By trimRoot(By by) {
        String byLocator = getByLocator(by).replace("*root*", " ").trim();
        return getByFunc(by).apply(byLocator);
    }
    @Override
    public String toString() {
        try {
            By locator = getLocator(args);
            if (locator == null || !hasDomain() && locatorType == DEFAULT)
                return "";
            String isFrame = "";
            if (locatorType == FRAME) {
                isFrame = "Frame: ";
                locator = getFrame();
            }
            String shortLocator = locator != null
                    ? shortBy(locator)
                    : print(select(SMART_SEARCH_LOCATORS, l -> format(l, splitHyphen(element.name))), " or ");
            return isFrame + shortLocator.replaceAll("%s", "{{VALUE}}");
        } catch (Exception ex) { throw exception("Can't print locator: " + safeException(ex)); }
    }
}
