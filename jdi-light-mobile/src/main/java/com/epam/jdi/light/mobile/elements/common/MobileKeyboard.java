package com.epam.jdi.light.mobile.elements.common;

import com.epam.jdi.light.elements.common.Keyboard;
import com.epam.jdi.tools.Timer;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.HidesKeyboardWithKeyName;
import io.appium.java_client.android.nativekey.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileKeyboard extends Keyboard {
    public static boolean isKeyboardShown() {
        return executeDriverMethod(HasOnScreenKeyboard.class, HasOnScreenKeyboard::isKeyboardShown);
    }
    public static void waitIsVisible(int timeout) {
        new Timer(timeout * 1000L)
                .wait(() -> isKeyboardShown());
    }

    public static void hideKeyboard() {
        executeDriverMethod(HidesKeyboard.class, HidesKeyboard::hideKeyboard);
    }
    public static void waitIsHidden(int timeout) {
        new Timer(timeout * 1000L)
                .wait(() -> !isKeyboardShown());
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

    // next methods are for AndroidDriver only
    private static Map<Character, AndroidSymbol> symbolsMap;

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

    public static void pressKey(AndroidKey key,
                                List<KeyEventFlag> flags,
                                List<KeyEventMetaModifier> modifiers) {
        KeyEvent keyEvent = new KeyEvent(key);
        if (flags != null && !flags.isEmpty()) {
            flags.forEach(f -> keyEvent.withFlag(f));
        }
        if (modifiers != null && !modifiers.isEmpty()) {
            modifiers.forEach(m -> keyEvent.withMetaModifier(m));
        }
        executeDriverMethod(PressesKey.class,
                (PressesKey driver) -> driver.pressKey(keyEvent));
    }

    public static void sendKeys(String text) {
        if (symbolsMap == null) {
            symbolsMap = fillSymbols();
        }
        text.chars().forEachOrdered(i -> {
            symbolsMap.get((char)i).sendKey();
        });
    }


    private static Map<Character, AndroidSymbol> fillSymbols() {
        return new HashMap<Character, AndroidSymbol>() {
            private static final long serialVersionUID = 1L;
            {
                put('\n', new AndroidSymbol(AndroidKey.ENTER, false));
                put('\t', new AndroidSymbol(AndroidKey.TAB, false));
                put('\r', new AndroidSymbol(AndroidKey.HOME, false));
                put(' ', new AndroidSymbol(AndroidKey.SPACE, false));
                put('!', new AndroidSymbol(AndroidKey.DIGIT_1, true));
                put('"', new AndroidSymbol(AndroidKey.APOSTROPHE, true));
                put('#', new AndroidSymbol(AndroidKey.DIGIT_3, true));
                put('$', new AndroidSymbol(AndroidKey.DIGIT_4, true));
                put('%', new AndroidSymbol(AndroidKey.DIGIT_5, true));
                put('&', new AndroidSymbol(AndroidKey.DIGIT_7, true));
                put('\'', new AndroidSymbol(AndroidKey.APOSTROPHE, false));
                put('(', new AndroidSymbol(AndroidKey.LEFT_BRACKET, true));
                put(')', new AndroidSymbol(AndroidKey.RIGHT_BRACKET, true));
                put('*', new AndroidSymbol(AndroidKey.STAR, true));
                put('+', new AndroidSymbol(AndroidKey.PLUS, true));
                put(',', new AndroidSymbol(AndroidKey.COMMA, false));
                put('-', new AndroidSymbol(AndroidKey.MINUS, false));
                put('.', new AndroidSymbol(AndroidKey.PERIOD, false));
                put('/', new AndroidSymbol(AndroidKey.SLASH, false));
                for (int i = (int) '0'; i <= (int) '9'; i++) {
                    put((char) i, new AndroidSymbol(AndroidKey.valueOf("DIGIT_" + (char) i), false));
                }
                put(':', new AndroidSymbol(AndroidKey.SEMICOLON, true));
                put(';', new AndroidSymbol(AndroidKey.SEMICOLON, false));
                put('<', new AndroidSymbol(AndroidKey.APOSTROPHE, true));
                put('=', new AndroidSymbol(AndroidKey.EQUALS, false));
                put('>', new AndroidSymbol(AndroidKey.PERIOD, true));
                put('?', new AndroidSymbol(AndroidKey.SLASH, true));
                put('@', new AndroidSymbol(AndroidKey.AT, true));
                for (char i = 'A'; i <= 'Z'; i++) {
                    put(i, new AndroidSymbol(AndroidKey.valueOf(Character.toString(i)), true));
                    put(Character.toLowerCase(i), new AndroidSymbol(AndroidKey.valueOf(Character.toString(i)), false));
                }
                put('[', new AndroidSymbol(AndroidKey.LEFT_BRACKET, false));
                put('\\', new AndroidSymbol(AndroidKey.BACKSLASH, false));
                put(']', new AndroidSymbol(AndroidKey.RIGHT_BRACKET, false));
                put('^', new AndroidSymbol(AndroidKey.DIGIT_6, true));
                put('_', new AndroidSymbol(AndroidKey.MINUS, true));
                put('`', new AndroidSymbol(AndroidKey.APOSTROPHE, false));
                put('{', new AndroidSymbol(AndroidKey.LEFT_BRACKET, true));
                put('|', new AndroidSymbol(AndroidKey.BACKSLASH, true));
                put('}', new AndroidSymbol(AndroidKey.RIGHT_BRACKET, true));
                put('~', new AndroidSymbol(AndroidKey.APOSTROPHE, true));
            }
        };
    }

    private static class AndroidSymbol {
        AndroidKey key;
        boolean isShifted;
        List<KeyEventMetaModifier> shiftModifier = Collections.singletonList(KeyEventMetaModifier.SHIFT_MASK);
        
        public AndroidSymbol(AndroidKey keyCode, boolean shift){
            key = keyCode;
            isShifted = shift;
        }

        public void sendKey() {
            pressKey(key, null, isShifted? shiftModifier: null);
        }
    }
}
