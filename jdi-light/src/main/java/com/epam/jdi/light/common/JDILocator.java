package com.epam.jdi.light.common;

import com.epam.jdi.light.driver.WebDriverByUtils;
import com.epam.jdi.light.elements.base.JDIBase;
import org.openqa.selenium.By;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.*;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.WebSettings.printSmartLocators;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
        // if (byLocator.toString().contains("By.cssSelector"))
        //     byLocator = defineLocator(getByLocator(byLocator));
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
            ? "../*["+index+"]"
            : format("(%s)[%s]", getByLocator(byLocator), index);
    }
    public String addText(String text) {
        return format("(%s)[.='%s']", getByLocator(byLocator), text);
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
        return toString().replaceAll("\\{\\{VALUE}}", "%s");
    }
    @Override
    public String toString() {
        try {
            By locator = getLocator(args);
            if (locator == null && element != null)
                return isNotBlank(ELEMENT.smartTemplate)
                        ? printSmartLocators(element)
                        : "";
            String hasFrame = "";
            if (hasFrame())
                hasFrame = "Frame: " + print(map(frames, WebDriverByUtils::shortBy));
            return hasFrame + shortBy(locator, element).replaceAll("%s", "{{VALUE}}");
        } catch (Exception ex) { return "Can't print locator"; }
    }
}
