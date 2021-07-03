package com.jdiai.tools;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.ReflectionUtils;
import com.epam.jdi.tools.Timer;
import com.jdiai.jsdriver.JSException;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.first;
import static com.jdiai.jswraper.driver.GetDriverUtilities.getOs;
import static java.lang.reflect.Modifier.isStatic;

/**
 * Created by Roman Iovlev on 06.05.2021
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Keyboard {
    static Robot robot;

    static Robot getRobot() {
        if (robot == null) {
            try {
                robot = new Robot();
            } catch (Exception ex) {
                throw new JSException(ex, "Can't instantiate Robot");
            }
        }
        return robot;
    }

    public static int waitBeforePasteTextMs = 500;

    public static void pasteText(CharSequence text) {
        pasteText(text, waitBeforePasteTextMs);
    }

    public static void pasteText(CharSequence text, long timeToWaitMSec) {
        try {
            StringSelection stringSelection = new StringSelection(text.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, (clipboard1, contents) -> { });
            Timer.sleep(timeToWaitMSec);
            switch (getOs()) {
                case MAC:
                    commands("Meta+Tab", "Meta+Shift+G", "Meta+V", "Enter", "Enter");
                    break;
                case WIN:
                    commands("Ctrl+V", "Enter");
                    break;
            }
        } catch (Exception ex) {
            throw new JSException(ex, "Past text '%s' failed with exception", text);
        }
    }

    public static int waitBetweenCommandsMs = 300;

    public static void commands(String... commands) {
        for (String keyGroup : commands) {
            String[] keys = keyGroup.split("\\+");
            for (String key : keys) {
                getRobot().keyPress(getKeyCode(key));
            }
            ArrayUtils.reverse(keys);
            for (String key : keys) {
                getRobot().keyRelease(getKeyCode(key));
            }
            Timer.sleep(waitBetweenCommandsMs);
        }
    }

    public static void command(String sequence) {
        commands(sequence.replace(" ", "").split(","));
    }

    private static int getKeyCode(String key) {
        List<Field> keys = getKeys();
        String keyName = key.replace(" ", "").replace("_", "");
        Field keyField = first(keys, f -> getKeyName(f).equalsIgnoreCase(keyName));
        if (keyField != null) {
            return (int) ReflectionUtils.getValueField(keyField, null);
        }
        throw new JSException("Unknown key '%s'", key);
    }

    private static String getKeyName(Field field) {
        int underscore = field.getName().indexOf('_');
        String key = field.getName().substring(underscore + 1)
            .toLowerCase()
            .replace(" ", "")
            .replace("_", "");
        switch (key) {
            case "control":
                return "ctrl";
            case "escape":
                return "esc";
            default:
                return key;
        }
    }

    private static List<Field> getKeys() {
        return LinqUtils.filter(KeyEvent.class.getDeclaredFields(),
            f -> isStatic(f.getModifiers()) && f.getName().startsWith("VK_"));
    }

    public static void press(String key) {
        press(getKeyCode(key));
    }

    public static void press(int key) {
        getRobot().keyPress(key);
        getRobot().keyRelease(key);
    }

    public static void press(Keys key) {
        List<Field> keys = getKeys();
        String keyName = key.name().replace(" ", "").replace("_", "");
        Field keyField = first(keys, f -> getKeyName(f).equalsIgnoreCase(keyName));
        if (keyField == null) {
            throw new JSException("Unknown key '%s'", key);
        }
        int keyCode = (int) ReflectionUtils.getValueField(keyField, null);
        press(keyCode);
    }
}
