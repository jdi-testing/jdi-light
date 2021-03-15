package com.epam.jdi.light.mobile.elements.composite;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.MobileContextHolder;
import com.epam.jdi.light.mobile.elements.common.app.Button;
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
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;
import static java.lang.Math.round;
import static java.time.Duration.ofMillis;

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

    private static int getHeight() {
        Dimension dimension = getScreenSize();
        return dimension.getHeight();
    }

    @JDIAction
    private static void scroll(Point startingPoint, int xOffset, int yOffset) {
        executeDriverMethod(PerformsTouchActions.class, (PerformsTouchActions driver) -> {
            new TouchAction<>(driver)
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
            scroll(screenCenter, Integer.signum(offset) * (width / 2 - 1), 0);
        }
        scroll(screenCenter, offset % (width / 2), 0);
    }

    @JDIAction("Scroll up by {0} px")
    public static void scrollUp(int offset) {
        scrollVertically(offset);
    }

    @JDIAction("Scroll down by {0} px")
    public static void scrollDown(int offset) {
        scrollVertically(-offset);
    }

    @JDIAction("Scroll right by {0} px")
    public static void scrollRight(int offset) {
        scrollHorizontally(-offset);
    }

    @JDIAction("Scroll left by {0} px")
    public static void scrollLeft(int offset) {
        scrollHorizontally(offset);
    }

    //Android
    public static void swipeToElement(WebElement startElement, WebElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        executeDriverMethod(PerformsTouchActions.class, (PerformsTouchActions driver) -> {
            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(300)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        });
    }

    //Works only if sought element exists.
    public static void scrollDownToXpath(String xpath) {
        int scrollDivider = 3;
        int height = getHeight();
        while (true) {
            List<WebElement> soughtElement = getDriver().findElements(By.xpath(xpath));
            if (!soughtElement.isEmpty()) {
                return;
            }
            scrollDown(height / scrollDivider);
        }
    }

    public static UIAssert scrollToElementInList(Button element) {
        int shift = getHeight()/2-1;
        String oldPage = getDriver().getPageSource();
        while (true) {
            try {
                element.isEnabled();
                return new UIAssert().set(element);
            } catch (RuntimeException e) {
                MobileScreen.scrollDown(shift);
                String newPage = getDriver().getPageSource();
                if (oldPage.equals(newPage)) {
                    return new UIAssert().set(element);
                }
                oldPage = newPage;
            }
        }
    }

    public static void scrollToTop() {
        int shift = 1000;
        String oldPage = getDriver().getPageSource();
        while (true) {
            MobileScreen.scrollDown(-shift);
            String newPage = getDriver().getPageSource();
            if (oldPage.equals(newPage)) {
                return;
            }
            oldPage = newPage;
        }
    }

    public static void scrollToBottom() {
        int shift = 1000;
        String oldPage = getDriver().getPageSource();
        while (true) {
            MobileScreen.scrollDown(shift);
            String newPage = getDriver().getPageSource();
            if (oldPage.equals(newPage)) {
                return;
            }
            oldPage = newPage;
        }
    }

    private static void pinch(Point startPoint1, Point startPoint2, Point endPoint1, Point endPoint2) {
        executeDriverMethod(PerformsTouchActions.class, (PerformsTouchActions driver) -> {
            TouchAction<?> ta1 = new TouchAction<>(driver)
                    .press(PointOption.point(startPoint1))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endPoint1))
                    .release();
            TouchAction<?> ta2 = new TouchAction<>(driver)
                    .press(PointOption.point(startPoint2))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endPoint2))
                    .release();
            new MultiTouchAction(driver).add(ta1).add(ta2).perform();
        });
    }

    @JDIAction("Zoom in")
    public static void zoomIn() {
        Dimension dimension = getScreenSize();
        pinch(screenCenter.moveBy(1, 1), screenCenter,
                new Point(dimension.width - 1, dimension.height - 1), new Point(0, 0));
    }

    @JDIAction("Zoom out")
    public static void zoomOut() {
        Dimension dimension = getScreenSize();
        pinch(new Point(dimension.width - 1, dimension.height - 1), new Point(0, 0),
                screenCenter, screenCenter);
    }

    @JDIAction("Zoom in by {0}")
    public static void zoomIn(double ratio) {
        if ((ratio < 0) || (ratio > 1)) {
            throw exception("The zoom ratio needs to be between 0 and 1");
        } else {
            Dimension dimension = getScreenSize();
            pinch(screenCenter.moveBy(1, 1), screenCenter,
                    screenCenter.moveBy((int) round(ratio * dimension.width / 2), (int) round(ratio * dimension.height / 2)),
                    screenCenter.moveBy(-(int) round(ratio * dimension.width / 2), -(int) round(ratio * dimension.height / 2)));
        }
    }

    @JDIAction("Zoom out by {0}")
    public static void zoomOut(double ratio) {
        if ((ratio < 0) || (ratio > 1)) {
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

    public static <T extends BaseStartScreenRecordingOptions<?>> String startRecordingScreen(T options) {
        return executeDriverMethod(CanRecordScreen.class,
                (CanRecordScreen driver) -> driver.startRecordingScreen(options));
    }

    public static String stopRecordingScreen() {
        return executeDriverMethod(CanRecordScreen.class,
                (Function<CanRecordScreen, String>) CanRecordScreen::stopRecordingScreen);
    }

    public static <T extends BaseStopScreenRecordingOptions<?>> String stopRecordingScreen(T options) {
        return executeDriverMethod(CanRecordScreen.class,
                (CanRecordScreen driver) -> driver.stopRecordingScreen(options));
    }
}
