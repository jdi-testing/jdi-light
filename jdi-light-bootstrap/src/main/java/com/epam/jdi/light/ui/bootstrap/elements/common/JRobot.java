package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.tools.Timer;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.settings.WebSettings.logger;

public final class JRobot {
    private JRobot() {
    }

    public static void pasteText(CharSequence text) {
        try {
            Robot robot;
            try {
                robot = new Robot();
            }  catch (Exception ex) {
               logger.error("Can't instantiate Robot" + safeException(ex));
               throw ex;
            }

            StringSelection stringSelection = new StringSelection(text.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, (clipboard1, contents) -> {
            });
            Timer.sleep(1000L);
            robot.keyPress(17);
            robot.keyPress(86);
            robot.keyRelease(17);
            robot.keyPress(10);
            robot.keyRelease(10);
        } catch (Exception ex) {
            logger.error("Robot Input exception" + safeException(ex));
        }
    }
}