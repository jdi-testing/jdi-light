package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.common.JDIAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileAppUIElement extends MobileUIElement {

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
    public boolean isVisible() {
        return getWebElement().isDisplayed();
    }
}
