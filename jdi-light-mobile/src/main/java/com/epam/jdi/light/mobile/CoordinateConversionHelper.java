package com.epam.jdi.light.mobile;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;

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
    private static Dimension screenSize = MobileScreen.getScreenSize();

    static {
        if (getDriver() instanceof AndroidDriver) {
            TOOLBAR = d -> ((AndroidDriver) d).findElementById(androidToolbarId).getRect();
            WEBVIEW = d -> ((AndroidDriver) d).findElementByXPath(androidWebviewShortXpath).getRect();
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

    public static Point getBrowserCoordinates(int x, int y) {
        return getBrowserCoordinates(new Point(x, y));
    }
    public static Point getBrowserCoordinates(Point point) {
        return point.moveBy(0, - toolbar().y - toolbar().height / 2);
    }
    public static Point getAbsoluteCoordinates(int x, int y) {
        Rectangle webviewRect = webview();
        prepareForConversion(webviewRect);
        return new Point((int) round(x * xRatio), (int) round(y * yRatio))
                .moveBy(webviewRect.x, webviewRect.y);
    }
    public static Point getAbsoluteCoordinates(Point point) {
        return getAbsoluteCoordinates(point.x, point.y);
    }

    /** This method needs to be fired each time the conversion takes place
     *  because the toolbar (and therefore the webview) can change its size after scrolling
     */
    private static void prepareForConversion(Rectangle webviewRect) {
        double screenWebViewWidth = ((Long) js.executeScript("return window.innerWidth")).doubleValue();
        double screenWebViewHeight = ((Long) js.executeScript("return window.innerHeight")).doubleValue();
        xRatio = webviewRect.width / screenWebViewWidth;
        yRatio = webviewRect.height / screenWebViewHeight;
    }
}
