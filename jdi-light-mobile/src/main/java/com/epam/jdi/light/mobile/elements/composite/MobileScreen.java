package com.epam.jdi.light.mobile.elements.composite;

import com.epam.jdi.light.mobile.MobileContextHolder;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseStopScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;
import static java.lang.Math.round;

public class MobileScreen {

    private static Dimension screenSize = null;
    private static Point screenCenter = null;

    // Android devices can provide the dimensions only in NATIVE_APP context
    public static Dimension getScreenSize() {
        if (screenSize == null) {
            WebDriver driver = getDriver();
            if (driver instanceof IOSDriver) {
                screenSize = driver.manage().window().getSize();
            } else if (driver instanceof AndroidDriver) {
                String initialContext = MobileContextHolder.getContext();
                MobileContextHolder.setContext("NATIVE_APP");
                screenSize = getDriver().manage().window().getSize();
                MobileContextHolder.setContext(initialContext);
            } else {
                throw exception("Cannot use this method. The driver needs to extend/implement the AppiumDriver class");
            }
            screenCenter = new Point(screenSize.width / 2, screenSize.height / 2);
        }
        return screenSize;
    }
    private static void scroll(Point startingPoint, int xOffset, int yOffset) {
        executeDriverMethod(PerformsTouchActions.class, (PerformsTouchActions driver) -> {
            new TouchAction(driver)
                    .press(PointOption.point(startingPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(startingPoint.moveBy(xOffset, yOffset)))
                    .release().perform();
        });
    }
    private static void scrollVertically(int offset) {
        Dimension dimension = getScreenSize();
        int height = dimension.getHeight();
        for (int i = 0; i < Math.abs(offset) / (height / 2); i++) {
            scroll(screenCenter, 0, Integer.signum(offset) * (height / 2 - 1));
        }
        scroll(screenCenter, 0, offset % (height / 2));
    }
    private static void scrollHorizontally(int offset) {
        Dimension dimension = getScreenSize();
        int width = dimension.getWidth();
        for (int i = 0; i < Math.abs(offset) / (width / 2); i++) {
            scroll(screenCenter, Integer.signum(offset) * ( width / 2 - 1), 0);
        }
        scroll(screenCenter, offset % (width / 2), 0);
    }

    public static void scrollUp(int offset) {
        scrollVertically(offset);
    }
    public static void scrollDown(int offset) {
        scrollVertically(-offset);
    }
    public static void scrollRight(int offset) {
        scrollHorizontally(-offset);
    }
    public static void scrollLeft(int offset) {
        scrollHorizontally(offset);
    }

    public static void scrollToTop() {
        throw new NotImplementedException("Not implemented yet");
    }
    public static void scrollToBottom() {
        throw new NotImplementedException("Not implemented yet");
    }

    private static void pinch(Point startPoint1, Point startPoint2, Point endPoint1, Point endPoint2) {
        executeDriverMethod(PerformsTouchActions.class, (PerformsTouchActions driver) -> {
            TouchAction ta1 = new TouchAction(driver)
                    .press(PointOption.point(startPoint1))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endPoint1))
                    .release();
            TouchAction ta2 = new TouchAction(driver)
                    .press(PointOption.point(startPoint2))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endPoint2))
                    .release();
            new MultiTouchAction(driver).add(ta1).add(ta2).perform();
        });
    }
    public static void zoomIn() {
        Dimension dimension = getScreenSize();
        pinch(screenCenter.moveBy(1, 1), screenCenter,
                new Point(dimension.width - 1, dimension.height - 1), new Point(0, 0));
    }
    public static void zoomOut() {
        Dimension dimension = getScreenSize();
        pinch(new Point(dimension.width - 1, dimension.height - 1), new Point(0, 0),
                screenCenter, screenCenter);
    }
    public static void zoomIn(double ratio) {
        if ((ratio < 0 ) || (ratio > 1)) {
            throw exception("The zoom ratio needs to be between 0 and 1");
        } else {
            Dimension dimension = getScreenSize();
            pinch(screenCenter.moveBy(1, 1), screenCenter,
                    screenCenter.moveBy((int) round(ratio * dimension.width / 2), (int) round(ratio * dimension.height / 2)),
                    screenCenter.moveBy(-(int) round(ratio * dimension.width / 2), -(int) round(ratio * dimension.height / 2)));
        }
    }
    public static void zoomOut(double ratio) {
        if ((ratio < 0 ) || (ratio > 1)) {
            throw exception("The zoom ratio needs to be between 0 and 1");
        } else {
            Dimension dimension = getScreenSize();
            pinch(screenCenter.moveBy((int) round(ratio * dimension.width / 2), (int) round(ratio * dimension.height / 2)),
                    screenCenter.moveBy(-(int) round(ratio * dimension.width / 2), -(int) round(ratio * dimension.height / 2)),
                    screenCenter, screenCenter);
        }
    }

    public static String startRecordingScreen() {
        return executeDriverMethod(CanRecordScreen.class,
                (Function<CanRecordScreen, String>) CanRecordScreen::startRecordingScreen);
    }
    public static <T extends BaseStartScreenRecordingOptions> String startRecordingScreen(T options) {
        return executeDriverMethod(CanRecordScreen.class,
                (CanRecordScreen driver) ->  driver.startRecordingScreen(options));
    }
    public static String stopRecordingScreen() {
        return executeDriverMethod(CanRecordScreen.class,
                (Function<CanRecordScreen, String>) CanRecordScreen::stopRecordingScreen);
    }
    public static <T extends BaseStopScreenRecordingOptions> String stopRecordingScreen(T options) {
        return executeDriverMethod(CanRecordScreen.class,
                (CanRecordScreen driver) ->  driver.stopRecordingScreen(options));
    }
}
