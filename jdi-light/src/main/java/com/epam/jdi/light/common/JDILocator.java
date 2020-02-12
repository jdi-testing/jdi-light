package com.epam.jdi.light.common;

import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.base.JDIBase;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class JDILocator {
    public JDILocator() {}
    public JDILocator(JDIBase element) { this.element = element; }
    public JDILocator copy() {
        JDILocator locator = new JDILocator();
        locator.byLocator = byLocator;
        locator.isRoot = isRoot;
        locator.element = element;
        locator.frames = frames;
        return locator;
    }

    private By byLocator;
    private List<By> frames;
    public boolean isRoot = false;
    private JDIBase element;
    private Object[] args = new Object[]{};

    public By getLocator() { return byLocator; }
    public List<By> getFrames() { return frames; }
    public By getLocator(Object... args) {
        this.args = args;
        if (args.length == 0) return byLocator;
        return args.length == 1
                ? fillByTemplate(byLocator, args)
                : fillByMsgTemplate(byLocator, args);
    }
    public boolean isEmpty() {
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
        this.element = element;
    }
    public void add(List<By> frames, JDIBase element) {
        this.frames = frames;
        this.element = element;
    }
    public boolean isTemplate() {
        return byLocator != null && byLocator.toString().contains("%s");
    }
    public boolean isXPath() { return byLocator != null && byLocator.toString().contains("xpath"); }
    public String addIndex(int index) {
        String locator = getByLocator(byLocator);
        return locator.equals("..")
            ? "../*["+index+1+"]"
            : format("(%s)[%s]", getByLocator(byLocator), index+1);
    }
    public String addText(String text) {
        return format("(%s)[.='%s']", getByLocator(byLocator), text);
    }
    public int argsCount() {
        return byLocator != null
            ? org.apache.commons.lang3.StringUtils.countMatches(byLocator.toString(), "%s")
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
    @Override
    public String toString() {
        try {
            By locator = getLocator(args);
            if ((locator == null || !hasDomain() && !hasFrame()) && element != null)
                return SMART_SEARCH_LOCATORS.size() > 0
                    ? print(select(SMART_SEARCH_LOCATORS, l -> format(l, SMART_SEARCH_NAME.execute(element.name))), " or ")
                    : "";
            String hasFrame = "";
            if (hasFrame())
                hasFrame = "Frame: " + print(map(frames, WebDriverByUtils::shortBy));
            return hasFrame + shortBy(locator).replaceAll("%s", "{{VALUE}}");
        } catch (Exception ex) { return "Can't print locator"; }
    }
}
