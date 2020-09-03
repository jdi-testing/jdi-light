package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.epam.jdi.light.common.TextTypes.*;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class MobileAppUIElement extends MobileUIElement {

    //region Constructors
    public MobileAppUIElement() { }
    public MobileAppUIElement(WebElement el) { setWebElement(el); }
    public MobileAppUIElement(List<WebElement> els) { setWebElements(els); }
    public MobileAppUIElement(@MarkupLocator By locator) { setLocator(locator); }
    public MobileAppUIElement(JDIBase base) {
        super(base);
    }
    public MobileAppUIElement(JDIBase base, String locator, String name, Object parent) {
        super(base);
        setLocator(locator);
        setName(name);
        setParent(parent);
    }
    public MobileAppUIElement(JDIBase base, By locator, String name) {
        super(base);
        setLocator(locator);
        setName(name);
    }
    public MobileAppUIElement(JDIBase base, WebElement el, JFunc<WebElement> func) {
        super(base);
        setWebElement(el);
        setGetFunc(func);
    }
    //endregion

    //region Core
    public MobileAppUIElement core() { return this; }
    public MobileAppUIElement setup(JAction1<JDIBase> setup) {
        return setup(MobileAppUIElement.class, setup);
    }
    @Override
    public MobileAppUIElement setCore(JDIBase base) {
        super.setCore(base);
        return this;
    }
    @Override
    public MobileAppUIElement setName(String name) {
        super.setName(name);
        return this;
    }
    @Override
    public MobileAppUIElement waitSec(int timeout) {
        super.waitSec(timeout);
        return this;
    }
    @Override
    public MobileAppUIElement noWait() {
        super.noWait();
        return this;
    }

    @Override
    @JDIAction("Perform tap on '{name}'")
    public void tap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(getWebElement())))
                .perform();
    }

    @Override
    @JDIAction("Perform double tap on '{name}'")
    public void doubleTap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withTapsCount(2)
                        .withElement(ElementOption.element(getWebElement())))
                .perform();
    }

    @Override
    @JDIAction("Perform long press on '{name}'")
    public void longPress() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(getWebElement())))
                .release()
                .perform();
    }

    @Override
    @JDIAction("Perform long press on '{name}' with duration of {0} seconds")
    public void longPress(int seconds) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(getWebElement()))
                        .withDuration(Duration.ofSeconds(seconds)))
                .release()
                .perform();
    }

    @Override
    protected boolean enabled() {
        if (hasAttribute("enabled"))
            return true;
        if (hasAttribute("disabled"))
            return false;
        return getWebElement().isEnabled();
    }

    @Override
    public  boolean isVisible() {
        return getWebElement().isDisplayed();
    }

    @Override
    public boolean isNotVisible() {
        return !getWebElement().isDisplayed();
    }

    public static JFunc1<MobileAppUIElement, String> MOBILE_SMART_LIST_TEXT = mobile -> {
        String text = mobile.text(TEXT);
        if (isNotBlank(text))
            return text;
        text = mobile.text(INNER);
        if (isNotBlank(text))
            return text;
        String id = mobile.attr("id");
        if (isNotBlank(id)) {
            MobileAppUIElement label = (MobileAppUIElement) $(By.cssSelector("[for=" + id + "]"));
            label.waitSec(0);
            try {
                text = label.getText();
            } catch (Throwable ignore) { }
        }
        return isNotBlank(text) ? text : mobile.text(VALUE);
    };

}
