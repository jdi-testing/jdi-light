package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.CoordinateConversionHelper.getCoordinatesOnScreen;

public class MobileUIElement extends UIElement {

    @JDIAction("Perform tap on '{name}'")
    public void tap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(getCenterOnScreen())))
                .perform();
    }
    @JDIAction("Perform double tap on '{name}'")
    public void doubleTap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withTapsCount(2)
                        .withPosition(PointOption.point(getCenterOnScreen())))
                .perform();
    }
    @JDIAction("Perform long press on '{name}'")
    public void longPress() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(getCenterOnScreen())))
                .perform();
    }
    @JDIAction("Perform long press on '{name}' with duration of {0} seconds")
    public void longPress(int seconds) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withPosition(PointOption.point(getCenterOnScreen()))
                        .withDuration(Duration.ofSeconds(seconds)))
                .perform();
    }
    @Override
    @JDIAction("Drag '{name}' and drop it to coordinates: (x:{0}, y:{1})")
    public void dragAndDropTo(int xOffset, int yOffset) {
        Point location = getCenterOnScreen();
//        show();
        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(PointOption.point(location))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(location.moveBy(xOffset, yOffset)))
                .release().perform();
    }

    /*This is needed for W3C compatibility*/
    @Override
    public Point getLocation() {
        Rectangle rect = getRect();
        return new Point(rect.x, rect.y);
    }
    public Point getCenter() {
        Rectangle rect = getRect();
        return new Point(rect.x, rect.y).moveBy(rect.width / 2, rect.height / 2);
    }

    public Point getLocationInViewport() {
        Rectangle rect = getPosition();
        return new Point(rect.x, rect.y);
    }
    public Point getCenterInViewport() {
        Rectangle rect = getPosition();
        return new Point(rect.x, rect.y).moveBy(rect.width / 2, rect.height / 2);
    }
    public Point getLocationOnScreen() {
        return getCoordinatesOnScreen(getLocationInViewport());
    }
    public Point getCenterOnScreen() {
        return getCoordinatesOnScreen(getCenterInViewport());
    }

    @Override
    protected SearchContext getDefaultContext() {
        return driver();
    }

    @Override
    protected boolean enabled() {
        if (hasClass("active") || hasAttribute("enabled"))
            return true;
        if (hasClass("disabled"))
            return false;
        return getWebElement().isEnabled();
    }
}
