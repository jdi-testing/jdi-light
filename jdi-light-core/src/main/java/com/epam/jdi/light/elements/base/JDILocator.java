package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.driver.WebDriverByUtils;
import com.jdiai.tools.Safe;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.elements.base.JdiSettings.addTextToXPath;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.settings.WebSettings.printSmartLocators;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.format;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JDILocator {
    private By byLocator;
    private List<By> frames;
    public boolean isRoot = false;
    private Safe<JDIBase> element;
    private Object[] args = new Object[]{};

    public JDILocator(JDIBase base) { this.element = new Safe<>(() -> base); }
    public JDILocator copy() {
        JDIBase base = element.get();
        JDILocator locator = new JDILocator(base);
        locator.byLocator = byLocator;
        locator.isRoot = isRoot;
        locator.element = new Safe<>(() -> base);
        locator.frames = frames;
        return locator;
    }

    public By getLocator() { return byLocator; }
    public List<By> getFrames() { return frames; }
    public By getLocator(Object... args) {
        this.args = args;
        if (args.length == 0) {
            return byLocator;
        }
        return args.length == 1
            ? fillByTemplate(byLocator, args)
            : fillByMsgTemplate(byLocator, args);
    }
    public boolean isNull() {
        return byLocator == null;
    }
    public boolean hasFrame() {
        return frames != null && frames.size() > 0;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void add(By locator, JDIBase element) {
        byLocator = setRootLocator(locator)
            ? trimRoot(locator)
            : locator;
        this.element = new Safe<>(() -> element);
    }
    public void add(List<By> frames, JDIBase element) {
        this.frames = frames;
        this.element = new Safe<>(() -> element);
    }
    public boolean isTemplate() {
        return byLocator != null && byLocator.toString().contains("%s");
    }
    public boolean isXPath() { return byLocator != null && byLocator.toString().contains("xpath"); }
    public String addIndex(int index) {
        String locator = getByLocator(byLocator);
        return locator.equals("..")
            ? "../*["+index+"]"
            : format("(%s)[%s]", getByLocator(byLocator), index);
    }
    public String addText(String text) {
        return addTextToXPath(byLocator, text);
    }
    public int argsCount() {
        return byLocator != null
            ? countMatches(byLocator.toString(), "%s")
            : 0;
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
    public String printLocator() {
        return toString().replace("{{VALUE}}", "%s");
    }
    @Override
    public String toString() {
        try {
            By locator = getLocator(args);
            String hasFrame = "";
            if (hasFrame())
                hasFrame = "Frame: " + print(map(frames, WebDriverByUtils::shortBy));
            JDIBase element = this.element.get();
            if (locator == null && isBlank(hasFrame) && element != null) {
                if (element.webElement.hasValue() || element.webElements.hasValue())
                    return element.printWebElement();
                if (isNotBlank(ELEMENT.smartTemplate))
                    return printSmartLocators(element);
                return "";
            }
            String locatorString = locator != null
                    ? shortBy(locator, element).replaceAll("%s", "{{VALUE}}")
                    : "";
            if (isBlank(hasFrame))
                return locatorString;
            return isBlank(locatorString) ? hasFrame : hasFrame + ">" + locatorString;
        } catch (Exception ex) {
            logger.error("Error on get locator value %s", ex);
            return "Can't print locator";
        }
    }
}
