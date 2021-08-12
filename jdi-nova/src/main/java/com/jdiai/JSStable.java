package com.jdiai;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JAction;
import com.jdiai.asserts.ConditionTypes;
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
import static com.jdiai.JDI.findConditions;
import static com.jdiai.JDI.timeout;
import static com.jdiai.jsdriver.JSDriverUtils.getByLocator;
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

    protected void stableAction(String actionName, JAction action, String cName, String condition) {
        setCondition(cName, condition);
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
                return;
            } catch (Throwable ex2) {
                exception = ex2;
            }
        }
        if (exception == null || exception.getMessage().contains("Failed to find element")) {
            throw new JDINovaException("Failed to find element by locator: " + this);
        } else {
            throw new JDINovaException(exception, "Failed to execute action '%s' for element '%s'", actionName, this);
        }
    }

    protected <T> T stableFunction(String actionName, Supplier<T> func, String cName, String condition) {
        setCondition(cName, condition);
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
                return func.get();
            } catch (Throwable ex2) {
                exception = ex2;
            }
        }
        if (exception == null || exception.getMessage().contains("Failed to find element")) {
            throw new JDINovaException("Failed to find element by locator: " + this);
        } else {
            throw new JDINovaException(exception, "Failed to execute action '%s' for element '%s'", actionName, this);
        }
    }

    @Override
    public JS setOption(String option) {
        return stableFunction("setOption(" + option + ")", () -> super.setOption(option), "exist", elementConditions.isExist);
    }

    @Override
    public JS selectByName(String name) {
        return stableFunction("selectByName(" + name + ")", () -> super.selectByName(name), "exist", elementConditions.isExist);
    }

    @Override
    public String selectedValueOption() {
        return stableFunction("selectedValueOption()", super::selectedValueOption, "exist", elementConditions.isExist);
    }

    @Override
    public String selectedOption() {
        return stableFunction("selectedOption()", super::selectedOption, "exist", elementConditions.isExist);
    }

    @Override
    public void click() {
        stableAction("click()", super::click, "visible", elementConditions.isVisible);
    }

    @Override
    public JS clickCenter() {
        stableAction("clickCenter()", super::clickCenter, "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS click(int x, int y) {
        stableAction(format("click(%s,%s)", x, y) , () -> super.click(x, y), "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS select(String... values) {
        if (isEmpty(values) || isEmpty(locators())) {
            throw new JDINovaException("Can't execute select for empty values or locators");
        }
        By locator = last(locators());
        IJSBuilder builder = getByLocator(locator).contains("%s")
            ? getTemplateScriptForSelect(locator, values)
            : getScriptForSelect(values);

        stableAction("select(" + print(values) + ")", builder::executeQuery, "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS check(boolean value) {
        stableAction("check(" + value + ")", () -> super.check(value), "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS rightClick() {
        stableAction("rightClick()", super::rightClick, "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS doubleClick() {
        stableAction("doubleClick()", super::doubleClick, "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS hover() {
        stableAction("hover()", super::hover, "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public JS dragAndDropTo(int x, int y) {
        stableAction(format("dragAndDropTo(%s,%s)", x, y), () -> super.dragAndDropTo(x, y), "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public void sendKeys(CharSequence... value) {
        if (value == null) {
            return;
        }
        stableAction("sendKeys(" + print(asList(value), Object::toString) + ")", () -> super.sendKeys(value), "visible", elementConditions.isVisible);
    }

    @Override
    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        stableAction("input(" + value + ")", () -> super.set("setAttribute('value', '');\nelement.value='" + charToString(value) +
            "';\nelement.dispatchEvent(new Event('input'));"), "visible", elementConditions.isVisible);
        return this;
    }

    @Override
    public void clear() {
        stableAction("clear()", super::clear, "visible", elementConditions.isVisible);
    }

    @Override
    public String getTagName() {
        return stableFunction("getTagName()", super::getTagName, "exist", elementConditions.isExist);
    }

    @Override
    public String getAttribute(String attrName) {
        return stableFunction("getAttribute(" + attrName + ")", () -> super.getAttribute(attrName), "exist", elementConditions.isExist);
    }

    @Override
    public String getProperty(String property) {
        return stableFunction("getProperty(" + property + ")", () -> super.getProperty(property), "exist", elementConditions.isExist);
    }

    @Override
    public List<String> getAttributesAsList(String attr) {
        return stableFunction("getAttributesAsList(" + attr + ")", () -> super.getAttributesAsList(attr), "exist", elementConditions.isExist);
    }

    @Override
    public List<Json> getAttributesAsList(String... attributes) {
        return stableFunction("getAttributesAsList(" + print(attributes) + ")", () -> super.getAttributesAsList(attributes), "exist", elementConditions.isExist);
    }

    @Override
    public List<String> allClasses() {
        return stableFunction("allClasses()", super::allClasses, "exist", elementConditions.isExist);
    }

    @Override
    public boolean hasClass(String className) {
        return stableFunction("hasClass(" + className + ")", () -> super.hasClass(className), "exist", elementConditions.isExist);
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return stableFunction("hasAttribute(" + attrName + ")", () -> super.hasAttribute(attrName), "exist", elementConditions.isExist);
    }

    @Override
    public Json allAttributes() {
        return stableFunction("allAttributes()", super::allAttributes, "exist", elementConditions.isExist);
    }

    @Override
    public JS show() {
        stableAction("show()", super::show, "exist", elementConditions.isExist);
        return this;
    }

    @Override
    public String cssStyle(String style) {
        return stableFunction("cssStyle(" + style + ")", () -> super.cssStyle(style), "exist", elementConditions.isExist);
    }

    @Override
    public Json cssStyles(String... styles) {
        return stableFunction("cssStyles(" + print(styles) + ")", () -> super.cssStyles(styles), "exist", elementConditions.isExist);
    }

    @Override
    public Json allCssStyles() {
        return stableFunction("allCssStyles()", super::allCssStyles, "exist", elementConditions.isExist);
    }

    @Override
    public boolean isSelected() {
        return stableFunction("isSelected()", super::isSelected, "exist", elementConditions.isExist);
    }

    @Override
    public boolean isEnabled() {
        return stableFunction("isEnabled()", super::isEnabled, "exist", elementConditions.isExist);
    }

    @Override
    public String getText() {
        return stableFunction("getText()", super::getText, "visible", elementConditions.isVisible);
    }

    @Override
    public String getText(GetTextTypes textType) {
        return stableFunction("getText(" + textType + ")", () -> super.getText(textType), "exist", elementConditions.isExist);
    }

    @Override
    public String getCssValue(String style) {
        return stableFunction("getCssValue(" + style + ")", () -> super.getCssValue(style), "exist", elementConditions.isExist);
    }

    @Override
    public JS uploadFile(String filePath) {
        return stableFunction("uploadFile(" + filePath + ")", () -> super.uploadFile(filePath), "exist", elementConditions.isExist);
    }

    @Override
    public String fontColor() {
        return stableFunction("fontColor()", super::fontColor, "exist", elementConditions.isExist);
    }

    @Override
    public String bgColor() {
        return stableFunction("bgColor()", super::bgColor, "exist", elementConditions.isExist);
    }

    @Override
    public JS visualValidation() {
        return stableFunction("visualValidation()", super::visualValidation, "visible", elementConditions.isVisible);
    }

    @Override
    public JS visualValidation(String tag) {
        return stableFunction("visualValidation(" + tag + ")", () -> super.visualValidation(tag), "visible", elementConditions.isVisible);
    }

    @Override
    public JS visualCompareWith(JS element) {
        return stableFunction("visualCompareWith(" + element + ")", () -> super.visualCompareWith(element), "visible", elementConditions.isVisible);
    }

    @Override
    public Direction getDirectionTo(WebElement element) {
        return stableFunction("getDirectionTo(" + element + ")", () -> super.getDirectionTo(element), "visible", elementConditions.isVisible);
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
