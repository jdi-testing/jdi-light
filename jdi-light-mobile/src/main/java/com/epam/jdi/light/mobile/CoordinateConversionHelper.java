package com.epam.jdi.light.mobile;

import com.epam.jdi.light.common.JDIAction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;

import java.util.function.Function;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static java.lang.Math.round;

/**
 * This is a helper class that performs the coordinate transformation.
 * All touch actions work with the absolute screen coordinates, whereas
 * most of the methods return the browser coordinates. This transformation
 * is invoked when the touch actions are used
 */
public class CoordinateConversionHelper {

    private static JavascriptExecutor js = (JavascriptExecutor) getDriver();

    //CHECKSTYLE:OFF
    private static Function<WebDriver, Rectangle> TOOLBAR;
    private static Function<WebDriver, Rectangle> WEBVIEW;
    private static final String androidToolbarId = "com.android.chrome:id/toolbar";
    private static final String iosToolbarXpath = "//XCUIElementTypeOther[@name='topBrowserBar']";
    private static final String iosToolbarAccessibilityId = "topBrowserBar";
    private static final String androidWebviewClassName = "android.webkit.WebView";
    private static final String iosBottomToolbarAccessibilityId = "BottomBrowserToolbar";
    private static final String iosBottomToolbarXpath = "//XCUIElementTypeToolbar[@name='BottomBrowserToolbar']";
    //CHECKSTYLE:ON

    private static double xRatio;
    private static double yRatio;

    static {
        WebDriver driver = getDriver();
        if (driver instanceof AndroidDriver) {
            TOOLBAR = d -> d.findElement(AppiumBy.id(androidToolbarId)).getRect();
            WEBVIEW = d -> d.findElement(AppiumBy.className(androidWebviewClassName)).getRect();
        } else if (driver instanceof IOSDriver) {
            TOOLBAR = d -> d.findElement(AppiumBy.accessibilityId(iosToolbarAccessibilityId)).getRect();
            WEBVIEW = d -> {
                Rectangle topToolbar = d.findElement(AppiumBy.accessibilityId(iosToolbarAccessibilityId)).getRect();
                Rectangle bottomToolbar = d.findElement(AppiumBy.accessibilityId(iosBottomToolbarAccessibilityId)).getRect();
                return new Rectangle(topToolbar.x, topToolbar.y + topToolbar.height, bottomToolbar.y - topToolbar.y - topToolbar.height, topToolbar.width);
            };
        }
    }

    @JDIAction(timeout = 5)
    private static Rectangle toolbar() {
        String initialContext = MobileContextHolder.getContext();
        MobileContextHolder.setContext("NATIVE_APP");
        Rectangle toolbarRect = TOOLBAR.apply(getDriver());
        MobileContextHolder.setContext(initialContext);
        return toolbarRect;
    }
    @JDIAction(timeout = 5)
    private static Rectangle webview() {
        String initialContext = MobileContextHolder.getContext();
        MobileContextHolder.setContext("NATIVE_APP");
        Rectangle webviewRect = WEBVIEW.apply(getDriver());
        MobileContextHolder.setContext(initialContext);
        return webviewRect;
    }

    /**
     * The next two methods convert screen coordinates to absolute browser coordinates
     *
     * @param x screen x coordinate
     * @param y screen y coordinate
     *
     * @return Point with absolute coordinates
     */
    public static Point getCoordinatesOnWebPage(int x, int y) {
        int xOffset = (int) js.executeScript("return window.pageXOffset;");
        int yOffset = (int) js.executeScript("return window.pageYOffset;");
        return getCoordinatesInViewport(x, y).moveBy(xOffset, yOffset);
    }
    public static Point getCoordinatesOnWebPage(Point point) {
        return getCoordinatesOnWebPage(point.x, point.y);
    }

    /**
     * The next two methods convert screen coordinates to viewport coordinates
     *
     * @param x screen x coordinate
     * @param y screen y coordinate
     *
     * @return Point with coordinates on viewport
     */
    public static Point getCoordinatesInViewport(int x, int y) {
        int localX = x;
        int localY = y;
        Rectangle webviewRect = webview();
        prepareForConversion(webviewRect);
        localX -= webviewRect.x;
        localY -= webviewRect.y;
        return new Point((int) round(localX / xRatio), (int) round(localY / yRatio));
    }
    public static Point getCoordinatesInViewport(Point point) {
        return getCoordinatesInViewport(point.x, point.y);
    }

    /**
     * Convert viewport coordinates to screen coordinates
     * @param x viewport x coordinate
     * @param y viewport y coordinate
     *
     * @return Point with screen coordiantes
     */
    public static Point getCoordinatesOnScreen(int x, int y) {
        Rectangle webviewRect = webview();
        prepareForConversion(webviewRect);
        return new Point((int) round(x * xRatio), (int) round(y * yRatio))
                .moveBy(webviewRect.x, webviewRect.y);
    }
    public static Point getCoordinatesOnScreen(Point point) {
        return getCoordinatesOnScreen(point.x, point.y);
    }

    /**
     * This method needs to be fired each time the conversion takes place
     * because the toolbar (and therefore the webview) can change its size after scrolling
     * @param webviewRect WebView rectangle
     */
    private static void prepareForConversion(Rectangle webviewRect) {
        double screenWebViewWidth = ((Long) js.executeScript("return window.innerWidth")).doubleValue();
        double screenWebViewHeight = ((Long) js.executeScript("return window.innerHeight")).doubleValue();
        xRatio = webviewRect.width / screenWebViewWidth;
        yRatio = webviewRect.height / screenWebViewHeight;
    }
}
