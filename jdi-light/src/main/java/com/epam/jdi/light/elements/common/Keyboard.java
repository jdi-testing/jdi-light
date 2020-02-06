package com.epam.jdi.light.elements.common;

import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.ReflectionUtils;
import com.epam.jdi.tools.Timer;
import org.apache.commons.lang3.ArrayUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.first;
import static java.awt.event.KeyEvent.*;
import static java.lang.reflect.Modifier.isStatic;

public class Keyboard {
    static Robot robot;
    static Robot getRobot() {
        if (robot == null)
            try {
                robot = new Robot();
            } catch (Exception ex) {
                throw exception(ex, "Can't instantiate Robot");
            }
        return robot;
    }
    public static void pasteText(CharSequence path, long timeToWaitMSec) {
        try {
            StringSelection stringSelection = new StringSelection(path.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, (clipboard1, contents) -> { });
            Timer.sleep(timeToWaitMSec);
            commands("Ctrl+V", "Enter");
        } catch (Exception ex) {
            throw exception(ex, "Input file "+path+" failed with exception");
        }
    }
    public static void keyPress(String key) {
        keyPress(getKeyCode(key));
    }
    public static void keyPress(int key) {
        getRobot().keyPress(key);
        getRobot().keyRelease(key);
    }
    public static void commands(String... commands) {
        for (String keyGroup : commands) {
            String[] keys = keyGroup.split("\\+");
            for (String key : keys)
                getRobot().keyPress(getKeyCode(key));
            ArrayUtils.reverse(keys);
            for (String key : keys)
                getRobot().keyRelease(getKeyCode(key));
        }
    }
    public static void command(String command) {
        commands(command.replace(" ", "").split(","));
    }
    private static int getKeyCode(String key) {
        List<Field> keys = getKeys();
        Field keyField = first(keys, f -> getKeyName(f).equals(key.toLowerCase()));
        if (keyField != null)
            return (int) ReflectionUtils.getValueField(keyField, null);
        throw exception("Unknown key '%s'", key);
    }
    private static String getKeyName(Field field) {
        int underscore = field.getName().indexOf('_');
        return field.getName().substring(underscore+1).toLowerCase();
    }
    private static List<Field> getKeys() {
        return LinqUtils.filter(KeyEvent.class.getDeclaredFields(),
                f -> isStatic(f.getModifiers()) && f.getName().startsWith("VK_"));
    }
}