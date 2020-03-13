package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.elements.common.UIElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileElement extends UIElement {
    public void tap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(this)))
                .perform();
    }
    public void doubleTap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withTapsCount(2)
                        .withElement(ElementOption.element(this)))
                .perform();
    }
    public void longPress() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(this)))
                .perform();
    }
    public void longPress(int seconds) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(this))
                        .withDuration(Duration.ofSeconds(seconds)))
                .perform();
    }
    @Override
    public void dragAndDropTo(int xOffset, int yOffset) {
        Point location = getLocation();
//        show();
        new TouchAction((PerformsTouchActions) getDriver())
                .press(PointOption.point(location))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(location.moveBy(xOffset, yOffset)))
                .release().perform();
    }
    @Override
    public void show() {

    }

    /*This is needed for W3C compatibility*/
    @Override
    public Point getLocation() {
        Rectangle rect = getRect();
        return new Point(rect.x, rect.y);
    }
}
