package com.jdiai;

import com.epam.jdi.tools.func.JAction;
import com.jdiai.asserts.Condition;
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
import static com.jdiai.asserts.Conditions.*;
import static com.jdiai.asserts.ElementFilters.isDisplayed;
import static com.jdiai.asserts.ElementFilters.isVisible;
import static com.jdiai.jsdriver.JSDriverUtils.getByLocator;
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
    protected void init() {
        // setCondition("visible", isVisible);
        setFilter(isDisplayed);
    }

    protected void stableAction(JAction action, Condition... conditions) {
        try {
            action.execute();
        } catch (Exception ignore) {
            waitForConditions(conditions);
            action.execute();
        }
    }
    protected <T> T stableFunction(Supplier<T> func, Condition... conditions) {
        try {
            return func.get();
        } catch (Exception ignore) {
            waitForConditions(conditions);
            return func.get();
        }
    }

    protected void waitForConditions(Condition... conditions) {
        try {
            shouldBe(exist);
        } catch (Exception ex) {
            throw new JDINovaException("Failed to find element: " + toString());
        }
        shouldBe(conditions);
    }

    @Override
    public JS setOption(String option) {
        return stableFunction(() -> super.setOption(option));
    }

    @Override
    public JS selectByName(String name) {
        return stableFunction(() -> super.selectByName(name));
    }

    @Override
    public String selectedValueOption() {
        return stableFunction(super::selectedValueOption);
    }

    @Override
    public String selectedOption() {
        return stableFunction(super::selectedOption);
    }

    @Override
    public void click() {
        stableAction(super::click, visible, enabled);
    }

    @Override
    public JS clickCenter() {
        stableAction(super::clickCenter, visible);
        return this;
    }

    @Override
    public JS click(int x, int y) {
        stableAction(() -> super.click(x, y), visible);
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

        stableAction(builder::executeQuery);
        return this;
    }

    @Override
    public JS check(boolean value) {
        stableAction(() -> super.check(value), visible);
        return this;
    }

    @Override
    public JS rightClick() {
        stableAction(super::rightClick, visible);
        return this;
    }

    @Override
    public JS doubleClick() {
        stableAction(super::doubleClick, visible);
        return this;
    }

    @Override
    public JS hover() {
        stableAction(super::hover, visible);
        return this;
    }

    @Override
    public JS dragAndDropTo(int x, int y) {
        stableAction(() -> super.dragAndDropTo(x, y), visible);
        return this;
    }

    @Override
    public void sendKeys(CharSequence... value) {
        if (value == null) {
            return;
        }
        stableAction(() -> super.sendKeys(value), visible);
    }

    @Override
    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        stableAction(() -> super.set("setAttribute('value', '');\nelement.value='" + charToString(value) +
            "';\nelement.dispatchEvent(new Event('input'));"), visible);
        return this;
    }

    @Override
    public void clear() {
        stableAction(super::clear, visible);
    }

    @Override
    public String getTagName() {
        return stableFunction(super::getTagName);
    }

    @Override
    public String getAttribute(String attrName) {
        return stableFunction(() -> super.getAttribute(attrName));
    }

    @Override
    public String getProperty(String property) {
        return stableFunction(() -> super.getProperty(property));
    }

    @Override
    public List<String> getAttributesAsList(String attr) {
        return stableFunction(() -> super.getAttributesAsList(attr));
    }

    @Override
    public List<Json> getAttributesAsList(String... attributes) {
        return stableFunction(() -> super.getAttributesAsList(attributes));
    }

    @Override
    public List<String> allClasses() {
        return stableFunction(super::allClasses);
    }

    @Override
    public boolean hasClass(String className) {
        return stableFunction(() -> super.hasClass(className));
    }

    @Override
    public boolean hasAttribute(String attrName) {
        return stableFunction(() -> super.hasAttribute(attrName));
    }

    @Override
    public Json allAttributes() {
        return stableFunction(super::allAttributes);
    }

    @Override
    public JS show() {
        stableAction(super::show);
        return this;
    }

    @Override
    public String cssStyle(String style) {
        return stableFunction(() -> super.cssStyle(style));
    }

    @Override
    public Json cssStyles(String... styles) {
        return stableFunction(() -> super.cssStyles(styles));
    }

    @Override
    public Json allCssStyles() {
        return stableFunction(super::allCssStyles);
    }

    @Override
    public boolean isSelected() {
        return stableFunction(super::isSelected);
    }

    @Override
    public boolean isEnabled() {
        return stableFunction(super::isEnabled);
    }

    @Override
    public String getText() {
        return stableFunction(super::getText);
    }

    @Override
    public String getText(GetTextTypes textType) {
        return stableFunction(() -> super.getText(textType));
    }

    @Override
    public String getCssValue(String style) {
        should(exist);
        return super.getCssValue(style);
    }

    @Override
    public JS uploadFile(String filePath) {
        shouldBe(visible);
        return super.uploadFile(filePath);
    }

    @Override
    public String fontColor() {
        should(exist);
        return super.fontColor();
    }

    @Override
    public String bgColor() {
        should(exist);
        return super.bgColor();
    }

    @Override
    public JS visualValidation() {
        shouldBe(visible);
        return super.visualValidation();
    }

    @Override
    public JS visualValidation(String tag) {
        shouldBe(visible);
        return super.visualValidation(tag);
    }

    @Override
    public JS visualCompareWith(JS element) {
        shouldBe(visible);
        element.shouldBe(visible);
        return super.visualCompareWith(element);
    }

    @Override
    public Direction getDirectionTo(WebElement element) {
        shouldBe(visible);
        return super.getDirectionTo(element);
    }
}
