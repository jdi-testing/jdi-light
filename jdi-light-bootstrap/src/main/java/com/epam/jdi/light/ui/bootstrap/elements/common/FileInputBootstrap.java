package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.FileInput;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.ui.bootstrap.elements.common.JRobot.pasteText;

public class FileInputBootstrap extends FileInput {
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path)  {

            Actions builder = new Actions(uiElement.driver());
            builder.moveToElement(uiElement.getWebElement()).click().build().perform();
            pasteText(path);

        if (isDisabled()) {
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        }
    }

}
