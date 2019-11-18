package com.epam.jdi.light.ui.bootstrap.elements.common.fileinput;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.FileInput;
import org.openqa.selenium.interactions.Actions;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.ui.bootstrap.elements.common.fileinput.JRobot.pasteText;

public class FileInputBs extends FileInput {
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path, long mSec)  {

            Actions builder = new Actions(uiElement.driver());
            builder.moveToElement(uiElement.getWebElement()).click().build().perform();
            pasteText(path, mSec);

        if (isDisabled()) {
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        }
    }
}
