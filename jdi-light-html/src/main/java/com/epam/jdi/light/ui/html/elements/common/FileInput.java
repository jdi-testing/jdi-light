package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.tools.Timer;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class FileInput extends UIBaseElement<TextAssert> implements HasLabel, IsText, SetValue {
    // region Actions
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        uiElement.sendKeys(path);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        uploadFile(value);
    }

    @JDIAction("Get '{name}' file name ")
    @Override
    public String text() {
        return uiElement.text(VALUE);
    }

    public String getValue() {
        return text();
    }

    // endregion
    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }

    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFileRobot(String path, long mSec) {

        uiElement.click(ElementArea.ACTION_CLICK);
        pasteText(path, mSec);

        if (isDisabled()) {
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        }
    }

    public static void pasteText(CharSequence path, long timeToWaitMSec) {
        try {
            Robot robot;
            try {
                robot = new Robot();
            } catch (Exception ex) {
                logger.error("Can't instantiate Robot" + safeException(ex));
                throw ex;
            }

            StringSelection stringSelection = new StringSelection(path.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, (clipboard1, contents) -> {
            });
            Timer.sleep(timeToWaitMSec);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception ex) {
            logger.error("Robot Input exception" + safeException(ex));
        }
    }
}
