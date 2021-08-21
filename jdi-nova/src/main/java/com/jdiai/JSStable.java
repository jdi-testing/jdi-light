package com.jdiai;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JAction;
import com.jdiai.jsbuilder.IJSBuilder;
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
import static com.jdiai.asserts.Conditions.visible;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

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

    @Override
    protected void init() {}

    @Override
    public JSStable copy() {
        JSStable js = new JSStable();
        js.setCore(core());
        return js;
    }

    protected Timer startTimer() {
        return new Timer(timeout * 1000L);
    }

    protected void stableAction(String actionName, JAction action) {
        setFilter(null);
        try {
            action.execute();
        } catch (Throwable ex) {
            waitForAction(actionName, action, startTimer());
        }
    }
    
    protected void stableFilterAction(String actionName, JAction action) {
        Timer timer = startTimer();
        try {
            setFilter(findFilters.isDisplayed);
            action.execute();
        } catch (Throwable ex) {
            shouldBe(visible);
            waitForAction(actionName, action, timer);
        }
    }

    protected void waitForAction(String actionName, JAction action, Timer timer) {
        Throwable exception = null;
        while (timer.isRunning()) {
            sleep(100);
            try {
                setFilter(findFilters.isDisplayed);
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
            throw new JDINovaException("Failed to find element by locator: %s (in %s seconds)", this, timer.timePassedInMSec() / 1000);
        } else {
            throw new JDINovaException(exception, "Failed to execute '%s' for element '%s' (in %s seconds)", actionName, this, timer.timePassedInMSec() / 1000);
        }
    }
    protected <T> T stableFunction(String actionName, Supplier<T> func) {
        setFilter(null);
        try {
            return func.get();
        } catch (Throwable ex) {
            return waitForResult(actionName, func, startTimer());
        }
    }

    protected <T> T stableFilterFunction(String actionName, Supplier<T> func) {
        Timer timer = startTimer();
        setFilter(findFilters.isDisplayed);
        try {
            return func.get();
        } catch (Throwable ex) {
            shouldBe(visible);
            return waitForResult(actionName, func, timer);
        }
    }

    protected <T> T waitForResult(String actionName, Supplier<T> func, Timer timer) {
        Throwable exception = null;
        while (timer.isRunning()) {
            sleep(100);
            try {
                setFilter(findFilters.isDisplayed);
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
            throw new JDINovaException("Failed to find element by locator: %s (in %s seconds)", this, timer.timePassedInMSec() / 1000);
        } else {
            throw new JDINovaException(exception, "Failed to execute '%s' for element '%s' (in %s seconds)", actionName, this, timer.timePassedInMSec() / 1000);
        }
    }

    @Override
    public JS setOption(String option) {
        return stableFunction("setOption(" + option + ")", () -> super.setOption(option));
    }

    @Override
    public JS selectByName(String name) {
        return stableFunction("selectByName(" + name + ")", () -> super.selectByName(name));
    }

    @Override
    public String selectedValueOption() {
        return stableFunction("selectedValueOption()", super::selectedValueOption);
    }

    @Override
    public String selectedOption() {
        return stableFunction("selectedOption()", super::selectedOption);
    }

    @Override
    public void click() {
        stableFilterAction("click()", super::click);
    }

    @Override
    public JS clickCenter() {
        stableFilterAction("clickCenter()", super::clickCenter);
        return this;
    }

    @Override
    public JS click(int x, int y) {
        stableFilterAction(format("click(%s,%s)", x, y) , () -> super.click(x, y));
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

        stableFilterAction("select(" + print(values) + ")", builder::executeQuery);
        return this;
    }

    @Override
    public JS check(boolean value) {
        stableFilterAction("check(" + value + ")", () -> super.check(value));
        return this;
    }

    @Override
    public WebElement we() {
        return stableFunction("we()", super::rawWe);
    }

    @Override
    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        stableFilterAction("input(" + value + ")", 
            () -> super.set("setAttribute('value', '');\nelement.value='" + charToString(value) +
            "';\nelement.dispatchEvent(new Event('input'));"));
        return this;
    }

    @Override
    public void clear() {
        stableFilterAction("clear()", super::clear);
    }

    @Override
    public String getTagName() {
        return stableFunction("getTagName()", super::getTagName);
    }

    @Override
    public String getAttribute(String attrName) {
        return stableFunction("getAttribute(" + attrName + ")", () -> super.getAttribute(attrName));
    }

    @Override
    public String getProperty(String property) {
        return stableFunction("getProperty(" + property + ")", () -> super.getProperty(property));
    }

    @Override
    public List<String> getAttributesAsList(String attr) {
        return stableFunction("getAttributesAsList(" + attr + ")", () -> super.getAttributesAsList(attr));
    }

    @Override
    public List<Json> getAttributesAsList(String... attributes) {
        return stableFunction("getAttributesAsList(" + print(attributes) + ")", () -> super.getAttributesAsList(attributes));
    }

    @Override
    public List<String> allClasses() {
        return stableFunction("allClasses()", super::allClasses);
    }

    @Override
    public boolean hasClass(String className) {
        return stableFunction("hasClass(" + className + ")", () -> super.hasClass(className));
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return stableFunction("hasAttribute(" + attrName + ")", () -> super.hasAttribute(attrName));
    }

    @Override
    public Json allAttributes() {
        return stableFunction("allAttributes()", super::allAttributes);
    }

    @Override
    public JS show() {
        stableAction("show()", super::show);
        return this;
    }

    @Override
    public String cssStyle(String style) {
        return stableFunction("cssStyle(" + style + ")", () -> super.cssStyle(style));
    }

    @Override
    public Json cssStyles(String... styles) {
        return stableFunction("cssStyles(" + print(styles) + ")", () -> super.cssStyles(styles));
    }

    @Override
    public Json allCssStyles() {
        return stableFunction("allCssStyles()", super::allCssStyles);
    }

    @Override
    public boolean isSelected() {
        return stableFunction("isSelected()", super::isSelected);
    }

    @Override
    public boolean isEnabled() {
        return stableFunction("isEnabled()", super::isEnabled);
    }

    @Override
    public boolean isDisplayed() {
        return stableFunction("isDisplayed()", super::isDisplayed);
    }

    @Override
    public String getText() {
        return stableFilterFunction("getText()", super::getText);
    }

    @Override
    public String getText(GetTextTypes textType) {
        return stableFunction("getText(" + textType + ")", () -> super.getText(textType));
    }

    @Override
    public String getCssValue(String style) {
        return stableFunction("getCssValue(" + style + ")", () -> super.getCssValue(style));
    }

    @Override
    public JS uploadFile(String filePath) {
        return stableFunction("uploadFile(" + filePath + ")", () -> super.uploadFile(filePath));
    }

    @Override
    public String fontColor() {
        return stableFunction("fontColor()", super::fontColor);
    }

    @Override
    public String bgColor() {
        return stableFunction("bgColor()", super::bgColor);
    }

    @Override
    public JS visualValidation() {
        return stableFilterFunction("visualValidation()", super::visualValidation);
    }

    @Override
    public JS visualValidation(String tag) {
        return stableFilterFunction("visualValidation(" + tag + ")", () -> super.visualValidation(tag));
    }

    @Override
    public JS visualCompareWith(JS element) {
        return stableFilterFunction("visualCompareWith(" + element + ")", () -> super.visualCompareWith(element));
    }

    @Override
    public Direction getDirectionTo(WebElement element) {
        return stableFilterFunction("getDirectionTo(" + element + ")", () -> super.getDirectionTo(element));
    }

}
