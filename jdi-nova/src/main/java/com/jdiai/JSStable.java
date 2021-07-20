package com.jdiai;

import com.jdiai.jsproducer.Json;
import com.jdiai.tools.GetTextTypes;
import com.jdiai.visual.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Supplier;

import static com.jdiai.asserts.Conditions.*;

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
    public JS setOption(String option) {
        if (option == null) {
            return this;
        }
        should(exist);
        return doAction("option.value = " + option + ";\nelement.dispatchEvent(new Event('change'));");
    }

    @Override
    public JS selectByName(String name) {
        if (name == null) {
            return this;
        }
        should(exist);
        return doAction("dispatchEvent(new Event('change'));\n" +
            "element.selectedIndex = [...element.options]" +
            ".findIndex(option => option.text === '" + name + "');\n" +
            "element.dispatchEvent(new Event('change'));");
    }

    @Override
    public String selectedValueOption() {
        should(exist);
        return super.selectedValueOption();
    }

    @Override
    public String selectedOption() {
        should(exist);
        return super.selectedOption();
    }

    @Override
    public void click() {
        shouldBe(visible, enabled);
        super.click();
    }

    @Override
    public JS clickCenter() {
        should(exist);
        return super.clickCenter();
    }

    @Override
    public JS click(int x, int y) {
        should(exist);
        return super.click(x, y);
    }

    @Override
    public JS select(String... values) {
        should(exist);
        return super.select(values);
    }

    @Override
    public JS check(boolean value) {
        shouldBe(visible);
        return super.check(value);
    }

    @Override
    public JS rightClick() {
        shouldBe(visible);
        return super.rightClick();
    }

    @Override
    public JS doubleClick() {
        shouldBe(visible);
        return super.doubleClick();
    }

    @Override
    public JS hover() {
        shouldBe(visible);
        return super.hover();
    }

    @Override
    public JS dragAndDropTo(int x, int y) {
        shouldBe(visible);
        return super.dragAndDropTo(x, y);
    }

    @Override
    public void sendKeys(CharSequence... value) {
        if (value == null) {
            return;
        }
        shouldBe(visible);
        we().sendKeys(value);
    }

    @Override
    public JS input(CharSequence... value) {
        if (value == null) {
            return this;
        }
        shouldBe(visible);
        return set("setAttribute('value', '');\nelement.value='" + charToString(value) + "';\nelement.dispatchEvent(new Event('input'));");
    }

    @Override
    public void clear() {
        shouldBe(visible);
        super.clear();
    }

    @Override
    public String getTagName() {
        should(exist);
        return super.getTagName();
    }

    @Override
    public String getAttribute(String attrName) {
        should(exist);
        return super.getAttribute(attrName);
    }

    @Override
    public String getProperty(String property) {
        should(exist);
        return super.getProperty(property);
    }

    @Override
    public List<String> getAttributesAsList(String attr) {
        should(exist);
        return super.getAttributesAsList(attr);
    }

    @Override
    public List<Json> getAttributesAsList(String... attributes) {
        should(exist);
        return super.getAttributesAsList(attributes);
    }

    @Override
    public List<String> allClasses() {
        should(exist);
        return super.allClasses();
    }

    @Override
    public boolean hasClass(String className) {
        should(exist);
        return super.hasClass(className);
    }

    @Override
    public boolean hasAttribute(String attrName) {
        should(exist);
        return super.hasClass(attrName);
    }

    @Override
    public Json allAttributes() {
        should(exist);
        return super.allAttributes();
    }

    @Override
    public JS show() {
        should(exist);
        return super.show();
    }

    @Override
    public String cssStyle(String style) {
        should(exist);
        return super.cssStyle(style);
    }

    @Override
    public Json cssStyles(String... styles) {
        should(exist);
        return super.cssStyles(styles);
    }

    @Override
    public Json allCssStyles() {
        should(exist);
        return super.allCssStyles();
    }

    @Override
    public boolean isSelected() {
        should(exist);
        return super.isSelected();
    }

    @Override
    public boolean isEnabled() {
        should(exist);
        return super.isEnabled();
    }

    @Override
    public String getText() {
        shouldBe(visible);
        return super.getText();
    }

    @Override
    public String getText(GetTextTypes textType) {
        shouldBe(visible);
        return super.getText(textType);
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
