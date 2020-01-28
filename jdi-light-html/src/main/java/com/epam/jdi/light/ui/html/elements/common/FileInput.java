package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
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

import static com.epam.jdi.light.common.ElementArea.JS;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.VALUE;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FileInput extends UIBaseElement<TextAssert> implements HasLabel, IsText, SetValue {
    // region Actions
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        uiElement.sendKeys(path);
    }

    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFileWithRobot(String path, long mSec) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        uiElement.click(JS);
        pasteText(path, mSec);
    }
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
    static void pasteText(CharSequence path, long timeToWaitMSec) {
        try {
            StringSelection stringSelection = new StringSelection(path.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, (clipboard1, contents) -> { });
            Timer.sleep(timeToWaitMSec);
            getRobot().keyPress(KeyEvent.VK_CONTROL);
            getRobot().keyPress(KeyEvent.VK_V);
            getRobot().keyRelease(KeyEvent.VK_CONTROL);
            getRobot().keyPress(KeyEvent.VK_ENTER);
            getRobot().keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception ex) {
            throw exception(ex, "Input file "+path+" failed with exception");
        }
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        uploadFile(value);
    }
    @JDIAction("Get '{name}' file name ") @Override
    public String text() {
        return uiElement.text(VALUE);
    }
    public String getValue() {
        return text();
    }
    // endregion
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
