package com.epam.jdi.light.mobile.elements.composite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.HasAndroidDeviceDetails;

import java.awt.*;
import java.util.Map;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class AndroidScreen extends MobileScreen {
    public static Long getDisplayDensity() {
        return executeDriverMethod(HasAndroidDeviceDetails.class,
                HasAndroidDeviceDetails::getDisplayDensity);
    }
    public static Map<String, Map<String, Object>> getSystemBars() {
        return executeDriverMethod(HasAndroidDeviceDetails.class,
                HasAndroidDeviceDetails::getSystemBars);
    }
    public static void printSystemBars() {
        getSystemBars().keySet().forEach(key -> {
            System.out.println("\n" + key + ": ");
            AndroidScreen.getSystemBars().get(key).forEach((k, v) -> System.out.println("-- " + k + ": " + v));
        });
    }
    public static SystemBarInfo getNavigationBarInfo() {
        Map<String, Object> bar = getSystemBars().get("navigationBar");
        return new SystemBarInfo().setVisible((boolean) bar.get("visible"))
                .setRect(new Rectangle((int) bar.get("x"), (int) bar.get("y"), (int) bar.get("width"), (int) bar.get("height")));
    }
    public static SystemBarInfo getStatusBarInfo() {
        Map<String, Object> bar = getSystemBars().get("statusBar");
        return new SystemBarInfo().setVisible((boolean) bar.get("visible"))
                .setRect(new Rectangle((int) bar.get("x"), (int) bar.get("y"), (int) bar.get("width"), (int) bar.get("height")));
    }

    public static class SystemBarInfo {
        private boolean visible;
        private Rectangle rect;
        public SystemBarInfo setVisible(boolean visible) {
            this.visible = visible;
            return this;
        }
        public SystemBarInfo setRect(Rectangle rect) {
            this.rect = rect;
            return this;
        }
    }

    public static void openNotificationPanel() {
        executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.openNotifications());
    }

    public static void closeNotificationPanel() {
        executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.navigate().back());
    }

}
