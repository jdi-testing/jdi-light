package com.epam.jdi.light.mobile.elements.base;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.mobile.CoordinateConversionHelper;
import com.epam.jdi.light.mobile.MobileContextHolder;
import com.epam.jdi.light.mobile.MobileUtils;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class MobileUIElement extends UIElement {

    public void tap() {
//        String initialContext = MobileContextHolder.getContext();
//        MobileContextHolder.setContext("NATIVE_APP");
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(CoordinateConversionHelper.getAbsoluteCoordinates(getCenter()))))
                .perform();
//        MobileContextHolder.setContext(initialContext);
    }
    public void doubleTap() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions()
                        .withTapsCount(2)
                        .withPosition(PointOption.point(getLocation())))
                .perform();
    }
    public void longPress() {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(getLocation())))
                .perform();
    }
    public void longPress(int seconds) {
        new TouchAction<>((PerformsTouchActions) getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withPosition(PointOption.point(getLocation()))
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

    public Point getCenter() {
        Rectangle rect = getRect();
        return new Point(rect.x, rect.y).moveBy(rect.width / 2, rect.height / 2);
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
