package com.epam.jdi.light.mobile.elements.common;

import com.epam.jdi.light.elements.common.Keyboard;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.HidesKeyboardWithKeyName;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileKeyboard extends Keyboard {
    public static boolean isKeyboardShown() {
        return executeDriverMethod(HasOnScreenKeyboard.class, HasOnScreenKeyboard::isKeyboardShown);
    }
    public static void hideKeyboard() {
        executeDriverMethod(HidesKeyboard.class, HidesKeyboard::hideKeyboard);
    }

    // next two methods are for IosDriver only
    public static void hideKeyboard(String keyName) {
        executeDriverMethod(HidesKeyboardWithKeyName.class,
                (HidesKeyboardWithKeyName driver) -> driver.hideKeyboard(keyName));
    }
    public static void hideKeyboard(String strategy, String keyName) {
        executeDriverMethod(HidesKeyboardWithKeyName.class,
                (HidesKeyboardWithKeyName driver) -> driver.hideKeyboard(strategy, keyName));
    }

    // next two methods are for AndroidDriver only
    public static void pressKey(AndroidKey key) {
        KeyEvent keyEvent = new KeyEvent(key);
        executeDriverMethod(PressesKey.class,
                (PressesKey driver) -> driver.pressKey(keyEvent));
    }
    public static void longPressKey(AndroidKey key) {
        KeyEvent keyEvent = new KeyEvent(key);
        executeDriverMethod(PressesKey.class,
                (PressesKey driver) -> driver.longPressKey(keyEvent));
    }
}
