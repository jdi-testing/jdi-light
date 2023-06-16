package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AuthenticatesByFinger;
import io.appium.java_client.android.HasSupportedPerformanceDataType;
import io.appium.java_client.battery.BatteryInfo;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.PerformsTouchID;
import io.appium.java_client.ios.ShakesDevice;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.Location;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileDevice {
    public static void rotate(DeviceRotation rotation) {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.rotate(rotation));
        } else {
            executeDriverMethod(IOSDriver.class, (IOSDriver driver) -> driver.rotate(rotation));
        }
    }

    public static DeviceRotation getRotation() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class,
                    AndroidDriver::rotation);
        } else {
            return executeDriverMethod(IOSDriver.class,
                    IOSDriver::rotation);
        }

    }

    public static void rotate(ScreenOrientation orientation) {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.rotate(orientation));
        } else {
            executeDriverMethod(IOSDriver.class, (IOSDriver driver) -> driver.rotate(orientation));
        }
    }

    public static ScreenOrientation getOrientation() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class,
                    AndroidDriver::getOrientation);
        } else {
            return executeDriverMethod(IOSDriver.class,
                    IOSDriver::getOrientation);
        }
    }

    public static void lockDevice() {
        executeDriverMethod(LocksDevice.class, (Consumer<LocksDevice>) LocksDevice::lockDevice);
    }

    public static void lockDevice(Duration duration) {
        executeDriverMethod(LocksDevice.class, (LocksDevice driver) -> driver.lockDevice(duration));
    }

    public static void unlockDevice() {
        executeDriverMethod(LocksDevice.class, LocksDevice::unlockDevice);
    }

    public static boolean isLocked() {
        return executeDriverMethod(LocksDevice.class, LocksDevice::isDeviceLocked);
    }

    public static BatteryInfo getBatteryInfo() {
        WebDriver driver = getDriver();
        if (driver instanceof IOSDriver) {
            return ((IOSDriver) driver).getBatteryInfo();
        } else if (driver instanceof AndroidDriver) {
            return ((AndroidDriver) driver).getBatteryInfo();
        } else {
            throw runtimeException("This method is not supported by the driver. The driver needs to be the instance of either Ios or Android driver");
        }
    }

    public static Location getLocation() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class, AndroidDriver::location);
        } else {
            return executeDriverMethod(IOSDriver.class, IOSDriver::location);
        }
    }

    public static void setLocation(Location location) {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.setLocation(location));
        } else {
            executeDriverMethod(IOSDriver.class, (IOSDriver driver) -> driver.setLocation(location));
        }
    }

    public static String getDeviceTime() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class, (Function<AndroidDriver, String>) AndroidDriver::getDeviceTime);
        } else {
            return executeDriverMethod(IOSDriver.class, (Function<IOSDriver, String>) IOSDriver::getDeviceTime);
        }
    }

    public static String getDeviceTime(String format) {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.getDeviceTime(format));
        } else {
            return executeDriverMethod(IOSDriver.class, (IOSDriver driver) -> driver.getDeviceTime(format));
        }
    }

    // the next methods are for IOS only
    public static void shake() {
        executeDriverMethod(ShakesDevice.class, ShakesDevice::shake);
    }

    public static void performTouchId(boolean match) {
        executeDriverMethod(PerformsTouchID.class, (PerformsTouchID driver) -> driver.performTouchID(match));
    }

    public static void toggleTouchIDEnrollment(boolean enabled) {
        executeDriverMethod(PerformsTouchID.class, (PerformsTouchID driver) -> driver.toggleTouchIDEnrollment(enabled));
    }

    // the next methods are for Android only
    public static void fingerPrint(int fingerPrintId) {
        executeDriverMethod(AuthenticatesByFinger.class, (AuthenticatesByFinger driver) -> driver.fingerPrint(fingerPrintId));
    }

    // this method is for Android only
    public static void setClipBoardText(String text) {
        executeDriverMethod(AppiumDriver.class,
                (AppiumDriver driver) -> (HasClipboard) driver).setClipboardText(text);
    }
    // this method is for Android only
    public static String getClipBoardText() {
        return executeDriverMethod(AppiumDriver.class,
                (AppiumDriver driver) -> (HasClipboard) driver).getClipboardText();
    }

    public static List<String> getPerformanceDataTypes() {
        return executeDriverMethod(HasSupportedPerformanceDataType.class, HasSupportedPerformanceDataType::getSupportedPerformanceDataTypes);
    }

    public static List<List<Object>> getPerformanceData(String packageName, String dataType, int dataReadTimeout) {
        return executeDriverMethod(HasSupportedPerformanceDataType.class, (HasSupportedPerformanceDataType driver) -> driver.getPerformanceData(packageName, dataType, dataReadTimeout));
    }

    public static void sendSMS(String phoneNumber, String smsText) {
        executeDriverMethod(AndroidDriver.class,
                (AndroidDriver driver) -> driver.sendSMS(phoneNumber, smsText));
    }
}
