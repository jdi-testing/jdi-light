package com.epam.jdi.light.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static java.lang.Math.round;

public class CoordinateConversionHelper {

    private static JavascriptExecutor js = (JavascriptExecutor) getDriver();
    private static Function<WebDriver, Rectangle> TOOLBAR;
    private static Function<WebDriver, Rectangle> WEBVIEW;
    private static final String androidToolbarId = "com.android.chrome:id/toolbar";
    private static final String iosToolbarXpath = "//XCUIElementTypeOther[@name='topBrowserBar']";
    private static final String iosToolbarAccessibilityId = "topBrowserBar";
    private static final String androidWebviewXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView";
    private static final String androidWebviewShortXpath = "//android.webkit.WebView";
    private static final String iosBottomToolbarAccessibilityId = "BottomBrowserToolbar";
    private static final String iosBottomToolbarXpath = "//XCUIElementTypeToolbar[@name='BottomBrowserToolbar']";
    private static double xRatio;
    private static double yRatio;

    static {
        if (getDriver() instanceof AndroidDriver) {
            TOOLBAR = d -> ((AndroidDriver) d).findElementById(androidToolbarId).getRect();
            WEBVIEW = d -> {
                // TODO: fix this awful approach
                try {
                    return ((AndroidDriver) d).findElementByClassName("android.webkit.WebView").getRect();
                } catch (NoSuchElementException ex) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                    }
                    return ((AndroidDriver) d).findElementByClassName("android.webkit.WebView").getRect();
                }
            };
        } else if (getDriver() instanceof IOSDriver) {
            TOOLBAR = d -> ((IOSDriver) d).findElementByAccessibilityId(iosToolbarAccessibilityId).getRect();
            WEBVIEW = d -> {
                Rectangle topToolbar = ((IOSDriver) d).findElementByAccessibilityId(iosToolbarAccessibilityId).getRect();
                Rectangle bottomToolbar = ((IOSDriver) d).findElementByAccessibilityId(iosBottomToolbarAccessibilityId).getRect();
                return new Rectangle(topToolbar.x, topToolbar.y + topToolbar.height, bottomToolbar.y - topToolbar.y - topToolbar.height, topToolbar.width);
            };
        }
    }

    private static Rectangle toolbar() {
        String initialContext = MobileContextHolder.getContext();
        MobileContextHolder.setContext("NATIVE_APP");
        Rectangle toolbarRect = TOOLBAR.apply(getDriver());
        MobileContextHolder.setContext(initialContext);
        return toolbarRect;
    }
    private static Rectangle webview() {
        String initialContext = MobileContextHolder.getContext();
        MobileContextHolder.setContext("NATIVE_APP");
        Rectangle webviewRect = WEBVIEW.apply(getDriver());
        MobileContextHolder.setContext(initialContext);
        return webviewRect;
    }

    public static Point getCoordinatesOnWebPage(int x, int y) {
        int xOffset = (int) js.executeScript("return window.pageXOffset;");
        int yOffset = (int) js.executeScript("return window.pageYOffset;");
        return getCoordinatesInViewport(x, y).moveBy(xOffset, yOffset);
    }
    public static Point getCoordinatesOnWebPage(Point point) {
        return getCoordinatesOnWebPage(point.x, point.y);
    }

    public static Point getCoordinatesInViewport(int x, int y) {
        Rectangle webviewRect = webview();
        prepareForConversion(webviewRect);
        x -= webviewRect.x;
        y -= webviewRect.y;
        return new Point((int) round(x / xRatio), (int) round(y / yRatio));
    }
    public static Point getCoordinatesInViewport(Point point) {
        return getCoordinatesInViewport(point.x, point.y);
    }

    /**
     * The next two methods need to be used with the viewport coordinates only
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
     */
    private static void prepareForConversion(Rectangle webviewRect) {
        double screenWebViewWidth = ((Long) js.executeScript("return window.innerWidth")).doubleValue();
        double screenWebViewHeight = ((Long) js.executeScript("return window.innerHeight")).doubleValue();
        xRatio = webviewRect.width / screenWebViewWidth;
        yRatio = webviewRect.height / screenWebViewHeight;
    }
}
