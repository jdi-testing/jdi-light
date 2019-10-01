package com.epam.jdi.light.common;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.util.Arrays.asList;
import static java.util.Collections.reverse;

public class Marvin {
    private static Robot robot;
    public static Robot marvin() {
        if (robot == null)
            try {
                robot = new Robot();
            } catch (Exception ex) {
                throw exception("Can't create new Robot. Exception: %s", safeException(ex));
            }
        return robot;
    }
    public static void pressKeys(int... keys) {
        for (int key : keys)
            marvin().keyPress(key);
        reverse(asList(keys));
        for (int key : keys)
            marvin().keyRelease(key);
    }
    public static void setClipboard(String path) {
        StringSelection ss = new StringSelection(path);
        getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }
}
