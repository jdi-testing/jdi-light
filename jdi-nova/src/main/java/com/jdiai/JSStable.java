package com.jdiai;

import com.google.gson.JsonObject;
import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jsproducer.Json;
import com.jdiai.tools.Timer;
import com.jdiai.tools.func.JAction;
import com.jdiai.visual.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Supplier;

import static com.jdiai.JDI.*;
import static com.jdiai.JDIEvents.*;
import static com.jdiai.asserts.Conditions.visible;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.Timer.sleep;
import static org.openqa.selenium.Keys.BACK_SPACE;

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
        js.updateFrom(core());
        return js;
    }

    protected Timer startTimer() {
        return new Timer(elementTimeout() * 1000L);
    }

    protected void stableAction(String actionName, String step, JAction action) {
        fireEvent(BEFORE_ACTION_EVENT, actionName, step, this);
        try {
            withFilter(null);
            try {
                action.execute();
                fireEvent(AFTER_SUCCESS_ACTION_EVENT, actionName, this, null);
            } catch (Throwable ex) {
                waitForAction(step, action, startTimer());
            }
        } catch (Throwable failException) {
            fireEvent(AFTER_ACTION_FAIL_EVENT, actionName, this, failException);
        } finally {
            fireEvent(AFTER_ACTION_EVENT, actionName, this);
        }
    }

    protected void stableFilterAction(String actionName, String step, JAction action) {
        fireEvent(BEFORE_ACTION_EVENT, actionName, step, this);
        try {
            Timer timer = startTimer();
            try {
                withFilter(findFilters.isDisplayed);
                action.execute();
                fireEvent(AFTER_SUCCESS_ACTION_EVENT, actionName, this, null);
            } catch (Throwable ex) {
                shouldBe(visible);
                waitForAction(actionName, action, timer);
            }
        } catch (Throwable failException) {
            fireEvent(AFTER_ACTION_FAIL_EVENT, actionName, this, failException);
        } finally {
            fireEvent(AFTER_ACTION_EVENT, actionName, this);
        }
    }

    protected void waitForAction(String actionName, JAction action, Timer timer) {
        Throwable exception = null;
        while (timer.isRunning()) {
            sleep(100);
            try {
                withFilter(findFilters.isDisplayed);
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

    protected <T> T stableFunction(String actionName, String step, Supplier<T> func) {
        fireEvent(BEFORE_ACTION_EVENT, actionName, step, this);
        try {
            withFilter(null);
            try {
                T result = func.get();
                fireEvent(AFTER_SUCCESS_ACTION_EVENT, actionName, this, result);
                return result;
            } catch (Throwable ex) {
                return waitForResult(actionName, func, startTimer());
            }
        } catch (Throwable failException) {
            fireEvent(AFTER_ACTION_FAIL_EVENT, actionName, this, failException);
            return null;
        } finally {
            fireEvent(AFTER_ACTION_EVENT, actionName, this);
        }
    }

    protected <T> T stableFilterFunction(String actionName, String step, Supplier<T> func) {
        fireEvent(BEFORE_ACTION_EVENT, actionName, step, this);
        try {
            Timer timer = startTimer();
            withFilter(findFilters.isDisplayed);
            try {
                T result = func.get();
                fireEvent(AFTER_SUCCESS_ACTION_EVENT, actionName, step, this, result);
                return result;
            } catch (Throwable ex) {
                shouldBe(visible);
                return waitForResult(actionName, func, timer);
            }
        } catch (Throwable failException) {
            fireEvent(AFTER_ACTION_FAIL_EVENT, actionName, step, this, failException);
            return null;
        } finally {
            fireEvent(AFTER_ACTION_EVENT, actionName, step, this);
        }
    }

    protected <T> T waitForResult(String actionName, Supplier<T> func, Timer timer) {
        Throwable exception = null;
        while (timer.isRunning()) {
            sleep(100);
            try {
                withFilter(findFilters.isDisplayed);
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
            throw new JDINovaException("Failed to find element: %s (in %s seconds)", this, timer.timePassedInMSec() / 1000);
        } else {
            throw new JDINovaException(exception, "Failed to execute '%s' for element '%s' (in %s seconds)", actionName, this, timer.timePassedInMSec() / 1000);
        }
    }

    @Override
    public JS setOption(String option) {
        return stableFunction("setOption(" + option + ")", "Select '" + option + "' in {{name}}", () -> super.setOption(option));
    }

    @Override
    public JS selectByName(String name) {
        return stableFunction("selectByName(" + name + ")", "Select '" + name + "' in {{name}}", () -> super.selectByName(name));
    }

    @Override
    public String selectedValueOption() {
        return stableFunction("selectedValueOption()", null, super::selectedValueOption);
    }

    @Override
    public String selectedOption() {
        return stableFunction("selectedOption()", null, super::selectedOption);
    }

    @Override
    public void click() {
        stableFilterAction("click()", "Click on {{name}}", () -> {
            if (jsDriver().hasJSRules()) {
                super.click();
            } else  {
                we().click();
            }
        });
    }

    @Override
    public JS clickCenter() {
        stableFilterAction("clickCenter()", "Click on {{name}}", super::clickCenter);
        return this;
    }

    @Override
    public JS click(int x, int y) {
        stableFilterAction(format("click(%s,%s)", x, y), "Click on {{name}}" , () -> super.click(x, y));
        return this;
    }

    @Override
    public JS check(boolean value) {
        stableFilterAction("check(" + value + ")",
        (value ? "Check" : "Uncheck") + " {{name}}", () -> super.check(value));
        return this;
    }

    @Override
    public WebElement we() {
        return stableFunction("we()", null, super::rawWe);
    }

    @Override
    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        stableFilterAction("input(" + value + ")",
        "Input '" + value + " to {{name}}",
            () -> {
                we().clear();
                fixedSendKeys(value);
            });
        return this;
    }
    @Override
    public void sendKeys(CharSequence... value) {
        if (value == null) {
            return ;
        }
        stableFilterAction("input(" + value + ")", "Input '" + value + " to {{name}}",
            () -> fixedSendKeys(value));
    }
    private void fixedSendKeys(CharSequence... value) {
        if (value.length == 1 && value[0].equals("\n")) {
            we().sendKeys("\n " + BACK_SPACE);
        } else {
            we().sendKeys(value);
        }
    }

    @Override
    public void clear() {
        stableFilterAction("clear()", "Clear {{name}} field" , () -> we().clear());
    }

    @Override
    public String getTagName() {
        return stableFunction("getTagName()", null, super::getTagName);
    }

    @Override
    public String getAttribute(String attrName) {
        return stableFunction("getAttribute(" + attrName + ")", null, () -> super.getAttribute(attrName));
    }

    @Override
    public String getProperty(String property) {
        return stableFunction("getProperty(" + property + ")", null, () -> super.getProperty(property));
    }

    @Override
    public List<String> getAttributesAsList(String attr) {
        return stableFunction("getAttributesAsList(" + attr + ")", null, () -> super.getAttributesAsList(attr));
    }

    @Override
    public List<Json> getAttributesAsList(String... attributes) {
        return stableFunction("getAttributesAsList(" + print(attributes) + ")", null, () -> super.getAttributesAsList(attributes));
    }

    @Override
    public List<String> allClasses() {
        return stableFunction("allClasses()", null, super::allClasses);
    }

    @Override
    public boolean hasClass(String className) {
        return stableFunction("hasClass(" + className + ")", null, () -> super.hasClass(className));
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return stableFunction("hasAttribute(" + attrName + ")", null, () -> super.hasAttribute(attrName));
    }

    @Override
    public Json allAttributes() {
        return stableFunction("allAttributes()", null, super::allAttributes);
    }

    @Override
    public JS showIfNotInView() {
        stableAction("showIfNotInView()", "Show {{name}}", super::showIfNotInView);
        return this;
    }

    @Override
    public JS show() {
        stableAction("show()", "Show {{name}}", super::show);
        return this;
    }

    @Override
    public String cssStyle(String style) {
        return stableFunction("cssStyle(" + style + ")", null, () -> super.cssStyle(style));
    }

    @Override
    public Json cssStyles(String... styles) {
        return stableFunction("cssStyles(" + print(styles) + ")", null, () -> super.cssStyles(styles));
    }

    @Override
    public Json allCssStyles() {
        return stableFunction("allCssStyles()", null, super::allCssStyles);
    }

    @Override
    public boolean isSelected() {
        return stableFunction("isSelected()", null, super::isSelected);
    }

    @Override
    public boolean isEnabled() {
        return stableFunction("isEnabled()", null, super::isEnabled);
    }

    @Override
    public boolean isDisplayed() {
        return stableFunction("isDisplayed()", null, super::isDisplayed);
    }

    @Override
    public String getText() {
        return stableFilterFunction("getText()",
            "Get {{name}} text", super::getText);
    }

    @Override
    public String getText(String textType) {
        return stableFunction("getText(" + textType + ")",
            "Get {{name}} text", () -> super.getText(textType));
    }

    @Override
    public String getCssValue(String style) {
        return stableFunction("getCssValue(" + style + ")", null, () -> super.getCssValue(style));
    }

    @Override
    public JS uploadFile(String filePath) {
        return stableFunction("uploadFile(" + filePath + ")",
            "Upload file to {{name}}", () -> super.uploadFile(filePath));
    }

    @Override
    public String fontColor() {
        return stableFunction("fontColor()", null, super::fontColor);
    }

    @Override
    public String bgColor() {
        return stableFunction("bgColor()", null, super::bgColor);
    }

    @Override
    public JS visualValidation() {
        return stableFilterFunction("visualValidation()",
            "Check {{name}} view", super::visualValidation);
    }

    @Override
    public JS visualValidation(String tag) {
        return stableFilterFunction("visualValidation(" + tag + ")",
            "Check {{name}} view", () -> super.visualValidation(tag));
    }

    @Override
    public JS visualCompareWith(JS element) {
        return stableFilterFunction("visualCompareWith(" + element + ")",
            "Check " + element.toString() + " looks the same as {{name}}", () -> super.visualCompareWith(element));
    }

    @Override
    public Direction getDirectionTo(WebElement element) {
        return stableFunction("getDirectionTo(" + element + ")", null,
            () -> super.getDirectionTo(element));
    }

    @Override
    public JsonObject getJSObject(String json) {
        return stableFunction("getJSObject(" + json+ ")", null,
                () -> super.getJSObject(json));
    }

    @Override
    public <T> T getEntity(Class<T> cl) {
        return stableFunction("getEntity(" + cl.getSimpleName()+ ")", "Get '" + cl.getSimpleName() + "' data",
                () -> super.getEntity(cl));
    }

    @Override
    public <T> T getEntity() {
        return stableFunction("getEntity()", "Get '" + engine().getEntityName() + "' data", super::getEntity);
    }

    @Override
    public <T> T getEntity(String objectMap, Class<?> cl) {
        return stableFunction("getEntity(" + cl.getSimpleName()+ ")",
        "Get '" + cl.getSimpleName() + "' data",
            () -> super.getEntity(objectMap, cl));
    }

    @Override
    public void setEntity(String objectMap) {
        stableAction("setEntity(objectMap)", null, () -> super.setEntity(objectMap));
    }

}
