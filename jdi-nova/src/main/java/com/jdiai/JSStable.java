package com.jdiai;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JAction;
import com.jdiai.asserts.ConditionTypes;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsbuilder.QueryLogger;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jsproducer.Json;
import com.jdiai.tools.GetTextTypes;
import com.jdiai.visual.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.tools.LinqUtils.last;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.Timer.sleep;
import static com.jdiai.JDI.*;
import static com.jdiai.jsbuilder.QueryLogger.*;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class JSStable extends JSLight {
    public JSStable() {
        super();
    }
    public JSStable(Supplier<WebDriver> driver, List<By> locators) {
        super(driver, locators);
    }
    public JSStable(WebDriver driver, List<By> locators) {
        super(driver, locators);
    }
    public JSStable(Supplier<WebDriver> driver, By... locators) {
        super(driver, locators);
    }
    public JSStable(WebDriver driver, By... locators) {
        super(driver, locators);
    }
    public JSStable(Object parent, By locator) {
        super(parent, locator);
    }
    public JSStable(WebDriver driver, By locator, Object parent) {
        super(driver, locator, parent);
    }
    public JSStable(Supplier<WebDriver> driver, By locator, Object parent) {
        super(driver, locator, parent);
    }

    protected ConditionTypes elementConditions = findConditions;

    @Override
    protected void init() { }

    protected Timer startTimer() {
        return new Timer(timeout * 1000L);
    }

    protected void stableAction(String actionName, JAction action, String condition) {
        setFilter(condition);
        try {
            action.execute();
        } catch (Throwable ex) {
            waitForAction(actionName, action);
        }
    }

    protected void waitForAction(String actionName, JAction action) {
        Timer timer = startTimer();
        Throwable exception = null;
        while (timer.isRunning()) {
            sleep(100);
            try {
                action.execute();
                loggerOn();
                return;
            } catch (Throwable ex2) {
                loggerOff();
                exception = ex2;
            }
        }
        loggerOn();
        if (exception == null || exception.getMessage().contains("Failed to find element")) {
            throw new JDINovaException("Failed to find element by locator: " + this);
        } else {
            throw new JDINovaException(exception, "Failed to execute action '%s' for element '%s'", actionName, this);
        }
    }

    protected <T> T stableFunction(String actionName, Supplier<T> func, String condition) {
        setFilter(condition);
        try {
            return func.get();
        } catch (Throwable ex) {
            return waitForResult(actionName, func);
        }
    }

    protected <T> T waitForResult(String actionName, Supplier<T> func) {
        Timer timer = startTimer();
        Throwable exception = null;
        while (timer.isRunning()) {
            sleep(100);
            try {
                T result = func.get();
                loggerOn();
                return result;
            } catch (Throwable ex2) {
                loggerOff();
                exception = ex2;
            }
        }
        loggerOn();
        if (exception == null || exception.getMessage().contains("Failed to find element")) {
            throw new JDINovaException("Failed to find element by locator: " + this);
        } else {
            throw new JDINovaException(exception, "Failed to execute action '%s' for element '%s'", actionName, this);
        }
    }

    @Override
    public JS setOption(String option) {
        return stableFunction("setOption(" + option + ")", () -> super.setOption(option), null);
    }

    @Override
    public JS selectByName(String name) {
        return stableFunction("selectByName(" + name + ")", () -> super.selectByName(name), null);
    }

    @Override
    public String selectedValueOption() {
        return stableFunction("selectedValueOption()", super::selectedValueOption, null);
    }

    @Override
    public String selectedOption() {
        return stableFunction("selectedOption()", super::selectedOption, null);
    }

    @Override
    public void click() {
        stableAction("click()", super::click, elementConditions.isVisible);
    }

    @Override
    public JS clickCenter() {
        stableAction("clickCenter()", super::clickCenter, elementConditions.isVisible);
        return this;
    }

    @Override
    public JS click(int x, int y) {
        stableAction(format("click(%s,%s)", x, y) , () -> super.click(x, y), elementConditions.isVisible);
        return this;
    }

    @Override
    public JS select(String... values) {
        if (isEmpty(values) || isEmpty(locators())) {
            throw new JDINovaException("Can't execute select for empty values or locators");
        }
        IJSBuilder builder = last(locators()).toString().contains("%s")
            ? getTemplateScriptForSelect(values)
            : getScriptForSelect(values);

        stableAction("select(" + print(values) + ")", builder::executeQuery, elementConditions.isVisible);
        return this;
    }

    @Override
    public JS check(boolean value) {
        stableAction("check(" + value + ")", () -> super.check(value), elementConditions.isVisible);
        return this;
    }

    @Override
    public JS rightClick() {
        stableAction("rightClick()", super::rightClick, elementConditions.isVisible);
        return this;
    }

    @Override
    public JS doubleClick() {
        stableAction("doubleClick()", super::doubleClick, elementConditions.isVisible);
        return this;
    }

    @Override
    public JS hover() {
        stableAction("hover()", super::hover, elementConditions.isVisible);
        return this;
    }

    @Override
    public JS dragAndDropTo(int x, int y) {
        stableAction(format("dragAndDropTo(%s,%s)", x, y), () -> super.dragAndDropTo(x, y), elementConditions.isVisible);
        return this;
    }

    @Override
    public void sendKeys(CharSequence... value) {
        if (value == null) {
            return;
        }
        stableAction("sendKeys(" + print(asList(value), Object::toString) + ")", () -> super.sendKeys(value), elementConditions.isVisible);
    }

    @Override
    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        stableAction("input(" + value + ")", () -> super.set("setAttribute('value', '');\nelement.value='" + charToString(value) +
            "';\nelement.dispatchEvent(new Event('input'));"), elementConditions.isVisible);
        return this;
    }

    @Override
    public void clear() {
        stableAction("clear()", super::clear, elementConditions.isVisible);
    }

    @Override
    public String getTagName() {
        return stableFunction("getTagName()", super::getTagName, null);
    }

    @Override
    public String getAttribute(String attrName) {
        return stableFunction("getAttribute(" + attrName + ")", () -> super.getAttribute(attrName), null);
    }

    @Override
    public String getProperty(String property) {
        return stableFunction("getProperty(" + property + ")", () -> super.getProperty(property), null);
    }

    @Override
    public List<String> getAttributesAsList(String attr) {
        return stableFunction("getAttributesAsList(" + attr + ")", () -> super.getAttributesAsList(attr), null);
    }

    @Override
    public List<Json> getAttributesAsList(String... attributes) {
        return stableFunction("getAttributesAsList(" + print(attributes) + ")", () -> super.getAttributesAsList(attributes), null);
    }

    @Override
    public List<String> allClasses() {
        return stableFunction("allClasses()", super::allClasses, null);
    }

    @Override
    public boolean hasClass(String className) {
        return stableFunction("hasClass(" + className + ")", () -> super.hasClass(className), null);
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return stableFunction("hasAttribute(" + attrName + ")", () -> super.hasAttribute(attrName), null);
    }

    @Override
    public Json allAttributes() {
        return stableFunction("allAttributes()", super::allAttributes, null);
    }

    @Override
    public JS show() {
        stableAction("show()", super::show, null);
        return this;
    }

    @Override
    public String cssStyle(String style) {
        return stableFunction("cssStyle(" + style + ")", () -> super.cssStyle(style), null);
    }

    @Override
    public Json cssStyles(String... styles) {
        return stableFunction("cssStyles(" + print(styles) + ")", () -> super.cssStyles(styles), null);
    }

    @Override
    public Json allCssStyles() {
        return stableFunction("allCssStyles()", super::allCssStyles, null);
    }

    @Override
    public boolean isSelected() {
        return stableFunction("isSelected()", super::isSelected, null);
    }

    @Override
    public boolean isEnabled() {
        return stableFunction("isEnabled()", super::isEnabled, null);
    }

    @Override
    public String getText() {
        return stableFunction("getText()", super::getText, elementConditions.isVisible);
    }

    @Override
    public String getText(GetTextTypes textType) {
        return stableFunction("getText(" + textType + ")", () -> super.getText(textType), null);
    }

    @Override
    public String getCssValue(String style) {
        return stableFunction("getCssValue(" + style + ")", () -> super.getCssValue(style), null);
    }

    @Override
    public JS uploadFile(String filePath) {
        return stableFunction("uploadFile(" + filePath + ")", () -> super.uploadFile(filePath), null);
    }

    @Override
    public String fontColor() {
        return stableFunction("fontColor()", super::fontColor, null);
    }

    @Override
    public String bgColor() {
        return stableFunction("bgColor()", super::bgColor, null);
    }

    @Override
    public JS visualValidation() {
        return stableFunction("visualValidation()", super::visualValidation, elementConditions.isVisible);
    }

    @Override
    public JS visualValidation(String tag) {
        return stableFunction("visualValidation(" + tag + ")", () -> super.visualValidation(tag), elementConditions.isVisible);
    }

    @Override
    public JS visualCompareWith(JS element) {
        return stableFunction("visualCompareWith(" + element + ")", () -> super.visualCompareWith(element), elementConditions.isVisible);
    }

    @Override
    public Direction getDirectionTo(WebElement element) {
        return stableFunction("getDirectionTo(" + element + ")", () -> super.getDirectionTo(element), elementConditions.isVisible);
    }

    public void setFilters(ConditionTypes filters) {
        if (filters == null) {
            return;
        }
        if (!isBlank(filters.isExist)) {
            elementConditions.isExist = filters.isExist;
        }
        if (!isBlank(filters.isDisplayed)) {
            elementConditions.isDisplayed = filters.isDisplayed;
        }
        if (!isBlank(filters.isEnabled)) {
            elementConditions.isEnabled = filters.isEnabled;
        }
        if (!isBlank(filters.isVisible)) {
            elementConditions.isVisible = filters.isVisible;
        }
    }
}
