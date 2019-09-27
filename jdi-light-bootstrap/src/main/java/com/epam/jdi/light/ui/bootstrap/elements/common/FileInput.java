package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.VALUE;

public class FileInput extends UIBaseElement<TextAssert> implements HasLabel, IsText, SetValue{
    // region Actions
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) throws AWTException {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        //uiElement.sendKeys(path);

        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        try {
            uploadFile(value);
        } catch (AWTException e) {
            e.printStackTrace();
        }
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
